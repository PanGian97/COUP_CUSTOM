package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static thanos.skoulopoulos.gr.coappproject.Methods.adultPassengers;
import static thanos.skoulopoulos.gr.coappproject.Methods.childPassengers;
import static thanos.skoulopoulos.gr.coappproject.Methods.dateFactor;
import static thanos.skoulopoulos.gr.coappproject.Methods.elderPassengers;
import static thanos.skoulopoulos.gr.coappproject.Methods.passengers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    public TextView departureDate;
    public TextView arrivalDate;
    public EditText passNumber;
    public Button proceedButton;
    public DatePickerDialog.OnDateSetListener dateSetListener;
    public static final String TAG = "MainActivity";
    public int selection = 0;
    boolean calSelection=false;
     boolean calSelection2=false;
    String stringDate = "";
    String stringDate2 = "";
    String stringCurrDate="";
    String finalFactorAsString="";

    int day;
    int month;
    int year;
    int day2;
    int month2;
    int year2;

    double factorA = 0.0;
    double factorS = 0.0;
    double factorPc = 0.0;
    double factorPa = 0.0;
    double factorPe = 0.0;
    double factorC = 0.0;
    double finalFactorC=0.0;
    double finalFactorA=0.0;
    double finalFactorE=0.0;
//
    TextView childViewText ;
    TextView adultViewText ;
    TextView elderViewText;
     EditText childNum;
     EditText adultNum;
     EditText elderNum;
    //

    private Spinner ageSpinner;
    private static final String[] agePaths = {"Individual", "Family", "Group"};
    private Spinner seatSpinner;
    private static final String[] seatPaths = {"basic", "premium", "platinum"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //
        final TextView tvTypeOfFlight = findViewById(R.id.tv_type_of_flight);

        final Switch layoutSwitch = (Switch) findViewById(R.id.switch1);
        //
        //passNumber =(EditText)findViewById(R.id.pass_number);
         childViewText = (TextView)findViewById(R.id.tv_children_text);
         adultViewText = (TextView)findViewById(R.id.tv_adult_text);
         elderViewText = (TextView)findViewById(R.id.tv_elder_text);
        childNum = (EditText) findViewById(R.id.tv_children);
        adultNum = (EditText) findViewById(R.id.tv_adult);
        elderNum = (EditText)findViewById(R.id.tv_elder);

        proceedButton=(Button)findViewById(R.id.tv_proceed_button);
        departureDate = findViewById(R.id.tv_departure_date);
        departureDate.setOnClickListener(this);
        arrivalDate = findViewById(R.id.tv_arrival_date);
        arrivalDate.setOnClickListener(this);
        proceedButton.setOnClickListener(this);


        ageSpinner = (Spinner) findViewById(R.id.spinner_travel_as);
        seatSpinner = (Spinner) findViewById(R.id.spinner_membership);


        ArrayAdapter<String>adapterA = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,agePaths);

        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(adapterA);

        ArrayAdapter<String>adapterS = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,seatPaths);

        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seatSpinner.setAdapter(adapterS);


        ageSpinner.setOnItemSelectedListener(spinListener);
        seatSpinner.setOnItemSelectedListener(spinListener);



        layoutSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    layoutSwitch.setTextOn("Πτηση Εξωτερικού");
                    String switchOn = layoutSwitch.getTextOn().toString();
                    tvTypeOfFlight.setText(switchOn);

                } else {
                    layoutSwitch.setTextOff("Πτήση Εσωτερικού");
                    String switchOff = layoutSwitch.getTextOff().toString();
                    tvTypeOfFlight.setText(switchOff);
                }
            }
        });
    }

    OnItemSelectedListener spinListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()) {
                case R.id.spinner_travel_as:
                    Toast.makeText(MainActivity.this, "Spinner Age", Toast.LENGTH_SHORT).show();
                    switch (position) {
                        case 0: factorA=1;
                            Log.d(TAG, "onItemSelected: Individual");
                            adultNum.setVisibility(View.VISIBLE);
                            elderNum.setVisibility(View.VISIBLE);
                            break;
                        case 1:factorA=0.9;
                            Log.d(TAG, "onItemSelected: Family");
                            childNum.setVisibility(View.VISIBLE);
                            adultNum.setVisibility(View.VISIBLE);
                            elderNum.setVisibility(View.VISIBLE);
                            break;
                        case 2:factorA=0.8;
                            Log.d(TAG, "onItemSelected: Group");
                            childNum.setVisibility(View.VISIBLE);
                            adultNum.setVisibility(View.VISIBLE);
                            elderNum.setVisibility(View.VISIBLE);
                            break;

                    }
                    break;
                case R.id.spinner_membership:
                    Toast.makeText(MainActivity.this, "Spinner Seat", Toast.LENGTH_SHORT).show();
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

               case R.id.tv_proceed_button:
                       try {
                           factorC = dateFactor(stringDate,stringDate2,month,month2,year,year2,day,day2);
                       } catch (ParseException e) {
                           e.printStackTrace();
                       }

                   factorPc=childPassengers(childNum);
                   factorPa=adultPassengers(adultNum);
                   factorPe=elderPassengers(adultNum);
                 finalFactorC= Methods.multiplicationC(factorA,factorC,factorS,factorPc);
                   finalFactorA= Methods.multiplicationA(factorA,factorC,factorS,factorPa);
                   finalFactorE= Methods.multiplicationE(factorA,factorC,factorS,factorPe);
                   Log.d(TAG, "onClick: $$MONEY= "+finalFactor);
                   finalFactorAsString = Double.toString(finalFactor);
                   Intent intent = new Intent(this,ResultActivity.class);
                   intent.putExtra("total_money",finalFactorAsString);
                   startActivity(intent);

                break;

        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int day, int month, int year)  {
     month++;
        switch (selection){
            case 1 :

        stringDate = day + "/" + month +"/" + year;

        departureDate.setText("Departure Date: " + stringDate);
               this.day = day;
                this.month = month;
                this.year = year;
                break;
            case 2 :
                stringDate2 = day + "/" + month +"/" + year;
                arrivalDate.setText("Arrival Date: " + stringDate2);
                day2 = day;
                month2 = month;
                year2 = year;
                break;
    }


}




}

