package sg.edu.rp.c346.p04_ps;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etname, etdate, ettime;
    EditText etnumber;
    EditText etpeople;
    RadioButton rbsmoke;
    RadioButton nonsmoke;
    Button btnsubmit;
    Button btnreset;

    TextView tvdate, tvtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etname = findViewById(R.id.name);
        etnumber = findViewById(R.id.number);
        etpeople = findViewById(R.id.numberofpeople);
        rbsmoke = findViewById(R.id.rbsmoke);
        nonsmoke = findViewById(R.id.rbnonsmoker);
        btnsubmit = findViewById(R.id.submit);
        btnreset = findViewById(R.id.reset);
        tvdate = findViewById(R.id.textViewdate);
        tvtime = findViewById(R.id.textViewtime);
        ettime = findViewById(R.id.editTexttime);
        etdate = findViewById(R.id.editTextdate);


        btnreset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                etname.setText("");
                etnumber.setText("");
                etpeople.setText("");
                etdate.setText("");
                ettime.setText("");


            }
        });
//        btnsubmit.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Submmitting your reservation", Toast.LENGTH_LONG).show();
//
//            }
//        });
     


        etdate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfyear, int dayOfmonth) {

                        etdate.setText("Date: " + year + "/" + (monthOfyear + 1) + "/" + dayOfmonth);

                    }
                };
                Calendar C = Calendar.getInstance();
                int year = C.get(Calendar.YEAR);
                int monthOfYear = C.get(Calendar.MONTH);
                int dayOfMonth = C.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, monthOfYear, dayOfMonth);
                myDateDialog.show();

            }
        });
        ettime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {

                        ettime.setText("Time: " + hourofDay + ":" + minute);
                    }
                };
                Calendar calendar = Calendar.getInstance();
                int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hourOfDay, minute, true);
                myTimeDialog.show();

            }

        });
        btnsubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Confirm your order");
                ;
                String message = etname.getText().toString();
                Integer message2 =Integer.parseInt(etnumber.getText().toString());
                Integer message3 = Integer.parseInt(etpeople.getText().toString());
                String message4 = rbsmoke.getText().toString();
                Calendar C = Calendar.getInstance();
                String c = etdate.getText().toString();
                String time = ettime.getText().toString();
                int year = C.get(Calendar.YEAR);
                int monthOfYear = C.get(Calendar.MONTH);
                int dayOfMonth = C.get(Calendar.DAY_OF_MONTH);


                myBuilder.setMessage("new reservation" + "\n" + "Name: " + message + "\n" + "smoking: " + message4 + "\n" + "Size: " + message3 + "\n" +  c + "\n" +  time  );

                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });
                myBuilder.setNegativeButton("Cancel", null);




                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }

        });

    }
}
