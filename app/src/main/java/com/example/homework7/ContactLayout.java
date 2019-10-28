package com.example.homework7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ContactLayout extends MainActivity {

    TextView fullNameTV;
    TextView addressTV;
    TextView phoneTV;
    TextView webPageTV;
    TextView emailTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        fullNameTV = findViewById(R.id.contact_name);
        addressTV = findViewById(R.id.address_info);
        phoneTV = findViewById(R.id.phone_number);
        webPageTV = findViewById(R.id.web_into);
        emailTV = findViewById(R.id.email_info);

        getData();
    }

    public void getData() {
        Intent intent = getIntent();

        Bundle dataBundle = intent.getExtras();

        String phoneNumber = dataBundle.getString(MainActivity.PHONE_CODE);
        String address = dataBundle.getString(MainActivity.ADDRESS_CODE);
        String webpage = dataBundle.getString(MainActivity.WEBPAGE_CODE);
        String email = dataBundle.getString(MainActivity.EMAIL_CODE);

        /*Person person = dataBundle.getParcelable(MainActivity.PERSON_CODE);
        String name = person.getFullName();*/

        //fullNameTV.setText(name);
        addressTV.setText(address);
        phoneTV.setText(phoneNumber);
        webPageTV.setText(webpage);
        emailTV.setText(email);
    }

}

