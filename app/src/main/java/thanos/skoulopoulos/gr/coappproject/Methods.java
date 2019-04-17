package thanos.skoulopoulos.gr.coappproject;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static thanos.skoulopoulos.gr.coappproject.MainActivity.TAG;

public class Methods {

    public static String currentDate(){
        String stringCurrDate="";
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int dayCurrent = calendar.get(calendar.DAY_OF_MONTH);
        int monthCurrent = calendar.get(calendar.MONTH);
        int yearCurrent = calendar.get(calendar.YEAR);

        return  stringCurrDate = dayCurrent + "/" + monthCurrent +"/" + yearCurrent;
    }



    public static double dateFactor(String stringDate,String stringDate2,int month, int month2,int year,int year2,int day,int day2) throws ParseException {
        double factorC =0.0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        Date date = sdf.parse(stringDate);
        Date date2 = sdf.parse(stringDate2);
        Date dateCurrent = sdf.parse(currentDate());


        Log.d(TAG, "Departure:----------"+date);
        Log.d(TAG, "Arrival:========="+date2);
        Log.d(TAG, "------TODAY DATE:------"+dateCurrent);
        if(date.after(date2) ){
            Log.d(TAG, "dateFactor: WRONG DATE!!!!!!!!!!!");
        }

        else {



            if ((month >= 3 && month <= 9) && (month2 >= 3 && month2 <= 9)) {
                Log.d(TAG, "SUMMER$%^");
                factorC = 1.2;
            } else {
                Log.d(TAG, "WINTER)))))");
                factorC = 1.0;
            }
        }
        return factorC;

    }



    public static double passengers( EditText childNum,) {
        double factorP=0.0;
        String value = passNumber.getText().toString();
        int passengerValue = Integer.parseInt(value);

        if (passengerValue <= 1) {
            factorP = 1.0;
        } else if (passengerValue <= 5) {
            factorP = 0.85;
        } else if (passengerValue <= 50) {
            factorP = 0.7;
        }//It can be abjusted...Not more than airplane seats!
            return factorP;
    }

    public static double multiplication(double factorA, double factorC, double factorS) {
        double finalFactor;
        Log.d(TAG, "multiplication: ----> FACTOR A " + factorA);
        Log.d(TAG, "multiplication: ----> FACTOR C " + factorC);
        Log.d(TAG, "multiplication: ----> FACTOR S " + factorS);
        finalFactor = factorA * factorC * factorS;

           return finalFactor;
    }
}