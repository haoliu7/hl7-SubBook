/*
 * Subscription
 *
 * Version 1.0
 *
 *
 * February 04 2018
 *
 *
 * Copyright @ 2018 Team X, COMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under teams and conditions of the Code of
 *    Student Behavior at Univertity of Alberta.
 * You can find a cope of the license in this porject. Otherwise please contact contact@abc.ca.
 */






package com.example.jackyliu.liuhaosubbook;

/**
 * Represent a subscrition，and the idea is from  my another project "lonelytwitter"
 * @author hl7
 * @version 1.5
 */

public class Subscription {
    private String name;
    private String date;
    private Float charge;
    private  String comment;


    public Subscription(String name, String date, Float charge, String comment){
        this.name = name;
        this.date = date;
        this.charge = charge;
        this.comment = comment;
    }


    public String getName() {return name;}
    public void setName(String name) { this.name = name; }


    public String getDate(){return date;}
    public void setDate(String date) { this.date = date; }


    public Float getCharge() {return  charge;}
    public void setCharge(Float charge) {this.charge = charge; }


    public String getComment() { return  comment; }
    public void setComment(String comment) { this.comment = comment; }



    @Override
    public String toString() {
        return "Name:" + this.name + " \n " +
                "Date" + this.date + "\n " +
                "Monyhly Charge"+this.charge+"\n";
    }

}
