package com.example.oriaso.kidsnest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class KidsNestDetailActivity extends AppCompatActivity {

    TextView textViewShowKidsNestName, textViewShowKidsNestEmail, textViewShowKidsNestPhone, textViewShowKidsNestContactPerson, textViewShowKidsNestContactEmail, textViewShowKidsNestContactPhone;
    String name, email, imageUrl, id, phone, contact_person, contact_email, contact_phone;
    ImageView imageViewShowKidsNestLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_nest_detail);

        textViewShowKidsNestName = (TextView) findViewById(R.id.textViewShowKidsNestName);
        textViewShowKidsNestEmail = (TextView) findViewById(R.id.textViewShowKidsNestEmail);
        textViewShowKidsNestPhone = (TextView) findViewById(R.id.textViewShowKidsNestPhone);
        textViewShowKidsNestContactPerson = (TextView) findViewById(R.id.textViewShowKidsNestContactPerson);
        textViewShowKidsNestContactEmail = (TextView) findViewById(R.id.textViewShowKidsNestContactEmail);
        textViewShowKidsNestContactPhone = (TextView) findViewById(R.id.textViewShowKidsNestContactPhone);
        imageViewShowKidsNestLogo = (ImageView) findViewById(R.id.imageViewShowKidsNestLogo);


        Intent i = getIntent();
        name = i.getStringExtra("nameKey");
        id = i.getStringExtra("idKey");
        email = i.getStringExtra("emailKey");
        phone = i.getStringExtra("phoneKey");
        contact_person = i.getStringExtra("contactPersonKey");
        contact_email = i.getStringExtra("contactEmailKey");
        contact_phone = i.getStringExtra("contactPhoneKey");
        imageUrl = i.getStringExtra("imageKey");

        getSupportActionBar().setTitle(name);
        textViewShowKidsNestName.setText(name);
        textViewShowKidsNestEmail.setText(email);
        textViewShowKidsNestPhone.setText(phone);
        textViewShowKidsNestContactPerson.setText(contact_person);
        textViewShowKidsNestContactEmail.setText(contact_email);
        textViewShowKidsNestContactPhone.setText(contact_phone);
        Picasso.with(getApplicationContext()).load(imageUrl).into(imageViewShowKidsNestLogo);
    }
}
