/*
 * addsubscription
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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Represent a  View for add a new subscription
 * @author hl7
 * @version 1.5
 */


public class addsubscription extends AppCompatActivity {

    private EditText input_name;
    private EditText input_date;
    private EditText input_charge;
    private EditText input_comment;
    private Button addButton2;



    public static ArrayList<Subscription> SubscriptionList = new ArrayList<Subscription>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubscription);

        input_name = (EditText) findViewById(R.id.addname);
        input_date = (EditText) findViewById(R.id.adddate);
        input_charge =(EditText) findViewById(R.id.addcharge);
        input_comment =(EditText) findViewById(R.id.addcomment);
        addButton2 = (Button) findViewById(R.id.Done);

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**when save button is clicked jump from add view to main view
                 *
                 */


                String name = input_name.getText().toString();
                String date = input_date.getText().toString();
                String charge = input_charge.getText().toString();
                Float charge_true = Float.parseFloat(charge);
                String comment = input_comment.getText().toString();


                Subscription newSubscription = new Subscription(name, date, charge_true, comment);

                SubscriptionList.add(newSubscription);





                Intent intent = new Intent(addsubscription.this, MainActivity.class);
                startActivity(intent);



            }
        });






    }















}
