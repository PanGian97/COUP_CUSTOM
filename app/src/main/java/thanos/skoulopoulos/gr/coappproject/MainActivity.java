package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    public TextView departureDate;
    public TextView arrivalDate;
    public EditText passNumber;
    public Button proceedButton;
    public DatePickerDialog.OnDateSetListener dateSetListener;
    public static final String TAG = "MainActivity";
    public int selection = 0;
    public boolean calSelection=false;
    public boolean calSelection2=false;
    String date = "";
    String date2 = "";
    int day;
    int month;
    int year;
    int day2;
    int month2;
    int year2;
    int day1;
    int month1;
    int year1;
    double factorD = 0.0;
    double factorA = 0.0;
    double factorS = 0.0;
    double factorP = 0.0;
    double factorC = 0.0;
    double finalFactor=0.0;
   // double factorT = 0.0;
    private Spinner ageSpinner;
    private static final String[] agePaths = {"child", "adult", "senior"};
    private Spinner seatSpinner;
    private static final String[] seatPaths = {"basic", "premium", "platinum"};
    //private Spinner paySpinner;
    //private static final String[] payPaths = {"Domestic, wire transfer, credit-card"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        passNumber =(EditText)findViewById(R.id.pass_number);
        proceedButton=(Button)findViewById(R.id.proceed_button);
        departureDate = findViewById(R.id.tv_departure_date);
        departureDate.setOnClickListener(this);
        arrivalDate = findViewById(R.id.tv_arrival_date);
        arrivalDate.setOnClickListener(this);
        proceedButton.setOnClickListener(this);


        ageSpinner = (Spinner) findViewById(R.id.spinner_travel_as);
        seatSpinner = (Spinner) findViewById(R.id.spinner_seat);
        //paySpinner= (Spinner) findViewById(R.id.spinner_pay);

        ArrayAdapter<String>adapterA = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,agePaths);

        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapterA);

        ArrayAdapter<String>adapterS = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,seatPaths);

        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seatSpinner.setAdapter(adapterS);

//        ArrayAdapter<String>adapterP = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_spinner_item,payPaths);
//
//        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        paySpinner.setAdapter(adapterP);

        ageSpinner.setOnItemSelectedListener(spinListener);
        seatSpinner.setOnItemSelectedListener(spinListener);
        //paySpinner.setOnItemSelectedListener(spinListener);



    }

    OnItemSelectedListener spinListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()) {
                case R.id.spinner_travel_as:
                    Toast.makeText(MainActivity.this, "Spinner Age", Toast.LENGTH_LONG).show();
                    switch (position) {
                        case 0: factorA=0.7;
                            Log.d(TAG, "onItemSelected: Child");
                            break;
                        case 1:factorA=1;
                            Log.d(TAG, "onItemSelected: Adult");
                            break;
                        case 2:factorA=0.8;
                            Log.d(TAG, "onItemSelected: Elder");
                            break;

                    }
                    break;
                case R.id.spinner_seat:
                    Toast.makeText(MainActivity.this, "Spinner Seat", Toast.LENGTH_LONG).show();
                    switch (position) {
                        case 0: factorS=300;
                            Log.d(TAG, "onItemSelected: Normal");
                            break;
                        case 1: factorS=500;
                            Log.d(TAG, "onItemSelected: Premium");
                            break;
                        case 2: factorS=1000;
                            Log.d(TAG, "onItemSelected: Leftas");

                            break;

                    }
                    break;
//
           }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_departure_date:

                CalendarPicker calendarPicker = new CalendarPicker(((MainActivity)view.getContext()));
                calendarPicker.setDate(view.getContext());
                selection=1;
                calSelection=true;

                break;

                case R.id.tv_arrival_date:

                CalendarPicker calendarPickerA = new CalendarPicker(((MainActivity)view.getContext()));
                calendarPickerA.setDate(view.getContext());
                selection=2;
                calSelection2=true;

                break;

               case R.id.proceed_button:

                   passengers();
                  multiplication();
                   Log.d(TAG, "onClick: $$MONEY= "+finalFactor);
//                   Intent intent = new Intent(this,ResultActivity.class);
//                   intent.putExtra("total_money",finalFactor);
//                   startActivity(intent);

                break;

        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year) {



        switch (selection){

            case 1 :
        date = day + "/" + month +"/" + year;
        departureDate.setText("Departure Date: " + date);
               this.day = day;
                this.month = month;
                this.year = year;
                dateFactor();
                break;
            case 2 :
                date2 = day + "/" + month +"/" + year;
                arrivalDate.setText("Arrival Date: " + date2);
                day2 = day;
                month2 = month;
                year2 = year;
               dateFactor();

                break;
    }

}
public void dateFactor() {
    if (calSelection == true && calSelection2 == true) {

        //ONION TREE :(
        if (day2 <= day1) {
            if (month2 <= month1) {
                if (year2 <= year1) {
                    Log.d(TAG, "dateFactor: NO VALID DATES!");
                } else {
                    Log.d(TAG, "Departure: %day: " + day1 + " month: " + month1 + " year " + year1);
                    Log.d(TAG, "Arrival: %day2: " + day2 + " month2: " + month2 + " year2 " + year2);


                    if ((month >= 3 && month <= 9) &&(month2 >= 3 && month2 <= 9)) {
                        Log.d(TAG, "SUMMER$%^");
                        factorC = 1.2;
                    } else {
                        Log.d(TAG, "WINTER)))))");
                        factorC = 1.0;
                    }
                }

            }
        }
    }
}
public void passengers(){
         String value= passNumber.getText().toString();
         int passengerValue=Integer.parseInt(value);

         if(passengerValue<=1){factorP=1.0;}
         else if(passengerValue<=5){factorP=0.85;}
         else if(passengerValue<=50){factorP=0.7;}//It can be abjusted...Not more than airplane seats!
    else{Toast.makeText(MainActivity.this, "WRONG PASSENGER NUMBER", Toast.LENGTH_SHORT).show();}
}

public void multiplication(){
    Log.d(TAG, "multiplication: ----> FACTOR A "+factorA);
    Log.d(TAG, "multiplication: ----> FACTOR C "+factorC);
    Log.d(TAG, "multiplication: ----> FACTOR S "+factorS);
        finalFactor=factorA*factorC*factorS;

}



}

