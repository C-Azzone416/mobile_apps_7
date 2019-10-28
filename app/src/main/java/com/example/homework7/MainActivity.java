package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    String firstName;
    String lastName;
    String address;
    String phone;
    String webpage;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* firstNameET = findViewById(R.id.first_name_entry);
        firstNameET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                firstName = firstNameET.getText().toString();
                return false;
            }
        });

        lastNameET = findViewById(R.id.last_name_entry);
        lastNameET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                lastName = lastNameET.getText().toString();
                return false;
            }
        });

        phoneET = findViewById(R.id.phone_entry);
        phoneET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                phone = phoneET.getText().toString();
                return false;
            }
        });

        addressET = findViewById(R.id.address_entry);
        addressET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                address = addressET.getText().toString();
                return false;
            }
        });

        webPageET = findViewById(R.id.website_entry);
        webPageET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                webpage = webPageET.getText().toString();
                return false;
            }
        });*/

        emailET = findViewById(R.id.email_entry);
        emailET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                email = emailET.getText().toString();
                return false;
            }
        });

    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ContactLayout.class);

        Bundle contact = new Bundle();

        contact.putString(ADDRESS_CODE, address);
        contact.putString(PHONE_CODE, phone);
        contact.putString(EMAIL_CODE, email);
        contact.putString(WEBPAGE_CODE, webpage);

        Person p = new Person(firstName, lastName);
        contact.putParcelable(PERSON_CODE, p);

        intent.putExtras(contact);

        startActivity(intent);
    }
}
