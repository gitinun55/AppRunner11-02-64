package com.example.apprunner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Event_profile_organizerFragment extends Fragment {

    String first_name, last_name, type;
    int id_user;
    RecyclerView recycleview_profile_organizer;

    public Event_profile_organizerFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentHandle = inflater.inflate(R.layout.fragment_event_profile_organizer, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            id_user = getArguments().getInt("id_user");
            first_name = getArguments().getString("first_name");
            last_name = getArguments().getString("last_name");
            type = getArguments().getString("type");
            String email = getArguments().getString("email");
            String password = getArguments().getString("password");
            Refresh();
            Event_profile();
        }
        return fragmentHandle;
    }

    private void Refresh() {
    }

    private void Event_profile() {
        MainFragment mainFragment = new MainFragment();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mainFragment.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OrganizerAPI services = retrofit.create(OrganizerAPI.class);
        Call<List<ResultQuery>> call = services.event_organizer(id_user);
        call.enqueue(new Callback<List<ResultQuery>>() {
            @Override
            public void onResponse(Call<List<ResultQuery>> call, Response<List<ResultQuery>> response) {
                List<ResultQuery> resultQueries = (List<ResultQuery>) response.body();
                recycleview_profile_organizer = (RecyclerView) getView().findViewById(R.id.recycler_view_profile_organizer);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
                recycleview_profile_organizer.setLayoutManager(layoutManager);
                Event_profileAdapter adapter = new Event_profileAdapter(requireContext(), resultQueries);
                recycleview_profile_organizer.setAdapter(adapter);
                Toast.makeText(requireActivity(),"งานวิ่งของคุณ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ResultQuery>> call, Throwable t) {
                Toast.makeText(requireContext(),"ไม่พบงานวิ่งของคุณ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}