package com.example.ritu.myapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Logger;


public class Register extends ActionBarActivity {

    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
      final  String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        EditText editEmail=(EditText)findViewById(R.id.editEmail);

        editEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                   EditText editEmail=(EditText)v;
                    if (!(editEmail.getText().toString().matches(emailPattern) && editEmail.getText().toString().length() > 0)) {

                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
     /*   editEmail .addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (!(s.toString().matches(emailPattern) && s.length() > 0)) {

                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // other stuffs
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // other stuffs
            }
        });*/


    final    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
EditText editDOB=(EditText)findViewById(R.id.editDOB);
        editDOB.setOnTouchListener(new View.OnTouchListener() {
     
            /**
             * Called when a touch event is dispatched to a view. This allows listeners to
             * get a chance to respond before the target view.
             *
             * @param v     The view the touch event has been dispatched to.
             * @param event The MotionEvent object containing full information about
             *              the event.
             * @return True if the listener has consumed the event, false otherwise.
             */
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP==event.getAction()) {
                    new DatePickerDialog(Register.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
                return true;
            }
        });


        Button button = (Button) findViewById(R.id.btnOK);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
try {
    // Do something in response to button click
    RadioButton rdnGender = (RadioButton) findViewById(((RadioGroup) findViewById(R.id.rdnGRpGender)).getCheckedRadioButtonId());
    String data = "entry.1722392132=" + URLEncoder.encode(((EditText) findViewById(R.id.editName)).getText().toString()) + "&" +
            "entry.643021367=" + URLEncoder.encode(((EditText) findViewById(R.id.editEmail)).getText().toString()) + "&" +
            "entry.1698971865=" + URLEncoder.encode(((EditText) findViewById(R.id.editMobNumber)).getText().toString()) + "&" +
            "entry.460325435=" + URLEncoder.encode(((EditText) findViewById(R.id.editDOB)).getText().toString()) + "&" +
            "entry.274282895=" + URLEncoder.encode(rdnGender.getText().toString()) + "&" +
            "entry.143204472=" + URLEncoder.encode(((Spinner) findViewById(R.id.bloodgrpSpinner)).getSelectedItem().toString());


    new BTCRegisterTask().execute(data);
    Intent submit =new Intent(Register.this,Submit.class);
    startActivity(submit);
}
catch(Exception ex)
{
    Context context = getApplicationContext();
    CharSequence text = "Unexpected error occurred.Please try later";
    int duration = Toast.LENGTH_SHORT;

    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
}

               // postData(data);
            }
        });

        Button btnCancel = (Button) findViewById(R.id.btnBack);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {Intent cancle =new Intent(Register.this,HomeActivity.class);
                startActivity(cancle);}});
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        ((EditText) findViewById(R.id.editDOB)).setText(sdf.format(myCalendar.getTime()));
    }


}
