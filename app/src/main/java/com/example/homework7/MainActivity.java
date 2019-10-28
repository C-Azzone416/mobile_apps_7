package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PERSON_CODE = "person name";
    public static final String PHONE_CODE = "Phone number";
    public static final String EMAIL_CODE = "Email address";
    public static final String ADDRESS_CODE = "Physical address";
    public static final String WEBPAGE_CODE = "Website";

    EditText firstNameET;
    EditText lastNameET;
    EditText addressET;
    EditText phoneET;
    EditText webPageET;
    EditText emailET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameET = findViewById(R.id.first_name_entry);
        lastNameET = findViewById(R.id.last_name_entry);
        phoneET = findViewById(R.id.phone_entry);
        addressET = findViewById(R.id.address_entry);
        webPageET = findViewById(R.id.website_entry);
        emailET = findViewById(R.id.email_entry);

    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ContactLayout.class);

        Bundle contact = new Bundle();

        contact.putString(ADDRESS_CODE, addressET.getText().toString());
        contact.putString(PHONE_CODE, phoneET.getText().toString());
        contact.putString(EMAIL_CODE, emailET.getText().toString());
        contact.putString(WEBPAGE_CODE, webPageET.getText().toString());

        Person p = new Person(firstNameET.getText().toString(), lastNameET.getText().toString());
        contact.putParcelable(PERSON_CODE, p);

        intent.putExtras(contact);

        startActivity(intent);
    }
}
