package sg.edu.rp.c346.id20037987.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText mobileNo;
    EditText numPax;
    DatePicker dateP;
    TimePicker timeP;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    Button reserveBtn;
    Button resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editTextName);
        mobileNo = findViewById(R.id.editTextMobile);
        numPax = findViewById(R.id.editTextNumPax);
        dateP = findViewById(R.id.datePicker);
        timeP = findViewById(R.id.timePicker);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        reserveBtn = findViewById(R.id.button1);
        resetBtn = findViewById(R.id.button2);

        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String name = " ";
                String mobile = " ";
                String numofPax = " ";
                String msg = " ";
                String userLocation = " ";
                String minLatest = " ";

                int day = 0;
                int month = 0;
                int year = 0;

                if(TextUtils.isEmpty(editName.getText()) || TextUtils.isEmpty(mobileNo.getText()) || TextUtils.isEmpty(numPax.getText())) {
                    Toast.makeText(MainActivity.this, "Please fill ALL the fields!", Toast.LENGTH_LONG).show();
                } else {
                    name = editName.getText().toString();
                    mobile = mobileNo.getText().toString();
                    numofPax = numPax.getText().toString();
                }

                if (dateP.getYear() == 2020 && dateP.getMonth() >= 5 && dateP.getDayOfMonth() >= 1 || dateP.getYear() > 2020 && dateP.getMonth() > 0){
                    day = dateP.getDayOfMonth();
                    month = dateP.getMonth();
                    year = dateP.getYear();
                } else {
                    Toast.makeText(MainActivity.this, "Please select date after 1 June 2020", Toast.LENGTH_LONG).show();
                }

                int hour = timeP.getCurrentHour();
                int min = timeP.getCurrentMinute();

                if (hour >= 0 && hour <= 8) {
                    Toast.makeText(MainActivity.this, "We are opened from 9am onwards", Toast.LENGTH_LONG).show();
                }

                if (min < 10) {
                    minLatest = hour + ":0" + min;
                } else {
                    minLatest = hour + ":" + min;
                }


                if(rb1.isChecked()) {
                    userLocation = "Indoor";
                } else if (rb2.isChecked()) {
                    userLocation = "Outdoor";
                } else {
                    userLocation = "Smoking Area";
                }

                msg = name + ", " + mobile + " have made reservations for " + numofPax + " pax on " + day + "/" + (month+1) + "/" + year + " at " + minLatest + " ," + userLocation;

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editName.setText(" ");
                mobileNo.setText(" ");
                numPax.setText(" ");
                dateP.updateDate(2020, 5, 1);
                timeP.setCurrentHour(19);
                timeP.setCurrentMinute(30);
                rb1.isChecked();



            }
        });

    }
}