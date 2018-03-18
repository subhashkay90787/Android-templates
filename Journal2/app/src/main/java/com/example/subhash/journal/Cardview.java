package com.example.subhash.journal;

/**
 * Created by Subhash on 02/02/2018.
 */

public class Cardview {
    private static String date,tie,data;
    public  Cardview(String date,String tie,String data){
        this.date=date;
        this.tie=tie;
        this.data=data;
    }
    public static String getdate(){
        return date;
    }
    public static String gettime(){
        return tie;
    }
    public static String getdata(){
        return data;
    }
}
