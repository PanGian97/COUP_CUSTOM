package thanos.skoulopoulos.gr.coappproject;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import static thanos.skoulopoulos.gr.coappproject.MainActivity.TAG;

public class Methods {

    public static double dateFactor(boolean calSelection, boolean calSelection2, double factorC, int month, int month2) {
        if (calSelection == true && calSelection2 == true) {

//            Log.d(TAG, "Departure: %day: " + day + " month: " + month + " year " + year);
//            Log.d(TAG, "Arrival: %day2: " + day2 + " month2: " + month2 + " year2 " + year2);
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

    public static double passengers(double factorP, EditText passNumber) {
        String value = passNumber.getText().toString();
        int passengerValue = Integer.parseInt(value);

        if (passengerValue <= 1) {
            factorP = 1.0;
        } else if (passengerValue <= 5) {
            factorP = 0.85;
        } else if (passengerValue <= 50) {
            factorP = 0.7;
        }//It can be abjusted...Not more than airplane seats!
        //else {}
            return factorP;
    }

    public static double multiplication(double finalFactor, double factorA, double factorC, double factorS) {
        Log.d(TAG, "multiplication: ----> FACTOR A " + factorA);
        Log.d(TAG, "multiplication: ----> FACTOR C " + factorC);
        Log.d(TAG, "multiplication: ----> FACTOR S " + factorS);
        finalFactor = factorA * factorC * factorS;

           return finalFactor;
    }
}