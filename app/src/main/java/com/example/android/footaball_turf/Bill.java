package com.example.android.footaball_turf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Bill extends AppCompatActivity {
    String emailcontent="";
    String email;
    String amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        emailcontent = "YOUR BILL SUMMARY IS\n";

        String name = getIntent().getStringExtra("name key");

        email = getIntent().getStringExtra("email key");

        amt = getIntent().getStringExtra("amt key");


        TextView nameTextView = (TextView) findViewById(R.id.name);

        nameTextView.setText(name);


        TextView nemailTextView = (TextView) findViewById(R.id.email);

        nemailTextView.setText(email);


        TextView amountTextView = (TextView) findViewById(R.id.amount_bill);

        amountTextView.setText(amt);
    }

    public void composeemail(View view) {
        emailcontent = emailcontent + "Amount=" + amt;
        composeEmail(email, "Bill SUMMARY", emailcontent);
    }


    public void composeEmail(String addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_CC, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
