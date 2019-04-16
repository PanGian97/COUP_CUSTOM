package thanos.skoulopoulos.gr.coappproject;

import android.util.Log;
import android.widget.EditText;

import static thanos.skoulopoulos.gr.coappproject.MainActivity.TAG;

public class Methods {

    public static double dateFactor(int month, int month2) {
        double factorC =0.0;

//            Log.d(TAG, "Departure: %day: " + day + " month: " + month + " year " + year);
//            Log.d(TAG, "Arrival: %day2: " + day2 + " month2: " + month2 + " year2 " + year2);

        if ((month >= 3 && month <= 9) && (month2 >= 3 && month2 <= 9)) {
                Log.d(TAG, "SUMMER$%^");
                factorC = 1.2;
            } else {
                Log.d(TAG, "WINTER)))))");
                factorC = 1.0;
            }

        return factorC;

    }

    public static double passengers( EditText passNumber) {
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