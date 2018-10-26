package com.example.android.footaball_turf;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Buying_activity extends AppCompatActivity {

    public EditText mNameEditText;
    public EditText mcardnumEditText;
    public EditText mcvvEditText;
    public EditText mdoeEditText;
    public EditText memailEditText;

    String nameString;
    String card_num_String;
    String emailString;
    String cvvString;
    String dateString;

    private TextView mDisplaydate;
    private DatePickerDialog.OnDateSetListener mDate;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying_activity);

        mDisplaydate=(TextView) findViewById(R.id.dateofexpiry);

        mDisplaydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(Buying_activity.this,
                        R.style.AppTheme,mDate,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.CYAN));
                dialog.show();
            }
        });

        mDate =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateString=dayOfMonth+"/"+month+"/"+year;

                mDisplaydate.setText(dateString);
            }
        };

    }

    public void onbuyactivity(View view) {
        mNameEditText = (EditText) findViewById(R.id.holder_name);
        mcardnumEditText = (EditText) findViewById(R.id.card_num);

        mcvvEditText = (EditText) findViewById(R.id.cvv);


        memailEditText = (EditText) findViewById(R.id.email_buy);

         nameString = mNameEditText.getText().toString().trim();
         emailString = memailEditText.getText().toString().trim();
         card_num_String = memailEditText.getText().toString().trim();
         cvvString = mcvvEditText.getText().toString().trim();

        if (mNameEditText.getText().toString().matches("")) {
            mNameEditText.setError("Email is empty");
        }
        else if (mcvvEditText.getText().toString().matches("")) {
            mcvvEditText.setError("Email is empty");
        }
        else if (memailEditText.getText().toString().matches("")) {
            memailEditText.setError("Email is empty");
        }
        else if (mcardnumEditText.getText().toString().matches("")) {
            mcardnumEditText.setError("Email is empty");
        }
        else if (dateString.matches("")) {
            Toast.makeText(this, "Date missing.", Toast.LENGTH_SHORT).show();

        }
        else
        {
        TextView t_view=(TextView) findViewById(R.id.textview_name);

        t_view.setText(nameString);

        //composeEmail(emailString,"Bill recepit","100");

        Intent intentRegister = new Intent(Buying_activity.this, Bill.class);
        intentRegister.putExtra("name key",nameString);

        intentRegister.putExtra("email key",emailString);

        intentRegister.putExtra("amt key","100");

        startActivity(intentRegister);

        }
    }


}
