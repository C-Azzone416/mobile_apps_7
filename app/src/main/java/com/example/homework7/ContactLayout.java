package com.example.homework7;

import android.app.SearchManager;
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

    String phoneNumber;
    String address;
    String email;
    String webpage;


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

        phoneNumber = dataBundle.getString(MainActivity.PHONE_CODE);
        address = dataBundle.getString(MainActivity.ADDRESS_CODE);
        webpage = dataBundle.getString(MainActivity.WEBPAGE_CODE);
        email = dataBundle.getString(MainActivity.EMAIL_CODE);

        Person person = dataBundle.getParcelable(MainActivity.PERSON_CODE);
        String name = person.getFullName();

        fullNameTV.setText(name);
        addressTV.setText(address);
        phoneTV.setText(phoneNumber);
        webPageTV.setText(webpage);
        emailTV.setText(email);
    }

    public void onCallButtonClick(View view) {
        String phoneNumberURI = "tel:" + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumberURI));
        startActivity(intent);
    }
    public void onSMSButtonClick(View view) {
        String phoneNumberURI = "smsto:" + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(phoneNumberURI));
        startActivity(intent);
    }
    public void onEmailButtonClick(View view) {
        String emailReceiverList[] = {email};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);
        startActivity(Intent.createChooser(intent, "Select one:"));
    }

    public void onWebButtonClick(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, webpage);
        startActivity(intent);

    }

    public void onMapButtonClick(View view) {
        String placeUri = String.format("geo:0,0?q=(%s)", address);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(placeUri));
        startActivity(intent);
    }
}

