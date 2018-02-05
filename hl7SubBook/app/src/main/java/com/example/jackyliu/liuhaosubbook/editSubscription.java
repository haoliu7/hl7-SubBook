/*
 * editSubscription
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

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.example.jackyliu.liuhaosubbook.addsubscription.SubscriptionList;

/**
 * Represent a  View edit or delete a selected subscription
 * @author hl7
 * @version 1.5
 */

public class editSubscription extends AppCompatActivity {


    private EditText existName;
    private EditText existDate;
    private EditText existCharge;
    private EditText existCommnt;
    private Button addButton3;
    private Button deleteButton;





    //public static ArrayList<Subscription> SubscriptionList = new ArrayList<Subscription>();
    //private ArrayAdapter<Subscription> adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subscription);








        existName = (EditText) findViewById(R.id.update_name);
        existDate = (EditText) findViewById(R.id.update_date);
        existCharge = (EditText) findViewById(R.id.update_charge);
        existCommnt = (EditText) findViewById(R.id.update_comment);
        addButton3 = (Button) findViewById(R.id.add_subscription);
        deleteButton = (Button) findViewById(R.id.delete_subscription);


        Intent intent = getIntent();
        String curName = intent.getStringExtra(MainActivity.NAME);
        String curDate = intent.getStringExtra(MainActivity.DATE);
        String curCharge = intent.getStringExtra(MainActivity.CHARGE);
        String curComment = intent.getStringExtra(MainActivity.COMMENT);

        final Integer position = intent.getIntExtra(MainActivity.POSITION,0);

        existName.setText(curName);
        existDate.setText(curDate);
        existCharge.setText(curCharge);
        existCommnt.setText(curComment);

        addButton3.setOnClickListener(new View.OnClickListener() {

            /** when savebutton is clicked,save new information and transfer to main view,then jump
             * to main view.
             * but is buttun did not work after click it
             * @param view
             */
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                String name = existName.getText().toString();
                String date = existDate.getText().toString();
                String charge = existCharge.getText().toString();
                Float charge_true = Float.parseFloat(charge);
                String comment = existCommnt.getText().toString();


                Subscription newSubscription = new Subscription(name, date, charge_true, comment);

                SubscriptionList.set(position, newSubscription);

                //adapter.notifyDataSetChanged();



                Intent intent = new Intent(editSubscription.this, MainActivity.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            /**when deleteButton is clicked, delete current subscription, and jump to main view
             * but this buttun did work afer click it
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                //setResult(RESULT_OK);

                //Subscription asub = SubscriptionList.get(position);

                SubscriptionList.remove(SubscriptionList.get(position));

                //adapter.notifyDataSetChanged();



                Intent intent = new Intent(editSubscription.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }




}
