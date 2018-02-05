/*
 * MainActivity
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
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.example.jackyliu.liuhaosubbook.addsubscription.SubscriptionList;



/**
 * Represent a initial View
 * @author hl7
 * @version 1.5
 */

public class MainActivity extends AppCompatActivity {

    private Button addButton;



    private ListView listView;



    protected static final String NAME = "name";
    protected static final String DATE = "date";
    protected static final String CHARGE = "charge";
    protected static final String COMMENT = "comment";
    protected static final String POSITION = "position";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.SubscriptionList);
        ArrayAdapter adapter = new ArrayAdapter<Subscription>(this,android.R.layout.simple_list_item_1,SubscriptionList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setupAddButton();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long l) {

                /** Citation: https://www.quora.com/How-can-I-go-to-another-activity-when-I-click-an-item-of-ListView
                 *  when list item is clicked, jump to ediSubscription
                 * @param view main view
                 * @param position current position of subscriptionList
                 * @param l excess argument
                 */

                Subscription subscription = (Subscription)adapter.getItemAtPosition(position);
                String name = subscription.getName();
                String date = subscription.getDate();
                Float charge1 = subscription.getCharge();
                String charge = new Float(charge1).toString();

                String comment = subscription.getComment();


                Intent intent = new Intent(MainActivity.this, editSubscription.class);
                intent.putExtra(NAME, name);
                intent.putExtra(DATE, date);
                intent.putExtra(CHARGE, charge);
                intent.putExtra(COMMENT, comment);
                intent.putExtra(POSITION, position);
                startActivity(intent);


            }
        });



    }


    private void setupAddButton() {
        /** when add button is clicked jump to addsubscription View
         */

        addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,addsubscription.class);
                startActivityForResult(intent,1);


            }
        });



    }
















}
