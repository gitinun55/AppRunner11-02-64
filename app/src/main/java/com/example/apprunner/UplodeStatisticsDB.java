package com.example.apprunner;

public class UplodeStatisticsDB {

    private String date;
    private Float distance;
    private String cal;
    private int id_user;
    private int id_add;

    public UplodeStatisticsDB(int id_user,int id_add,String date,Float distance,String cal){
        this.id_user = id_user;
        this.id_add = id_add;
        this.date = date;
        this.distance = distance;
        this.cal = cal;
    }

}
