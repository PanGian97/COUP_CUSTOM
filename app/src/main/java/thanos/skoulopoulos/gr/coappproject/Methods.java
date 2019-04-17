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



    public static double childPassengers( EditText childNum) {
        double factorPc=0.0;
        int children=0;
        String childrenString = childNum.getText().toString();
         children = Integer.parseInt(childrenString);
        if(children>0){
            factorPc =0.6;}else{factorPc=0;}
        return factorPc;
        }
    public static double adultPassengers( EditText adultNum) {
        double factorPa=0.0;
        int adults=0;
        String adultsString = adultNum.getText().toString();
         adults = Integer.parseInt(adultsString);
        if(adults>0 )
        { factorPa =1;}
            else{factorPa=0;}
        return factorPa;
    }
    public static double elderPassengers( EditText elderNum) {
        double factorPe=0.0;
        int elders=0;
        String eldersString = elderNum.getText().toString();
         elders = Integer.parseInt(eldersString);
        if(elders>0 ){
            factorPe =0.85;}else{factorPe=0;}
        return factorPe;
    }

public static Integer peopleNumbersLimiter(String peopleType,int maxPeople, int maxAvailableSeats){
  switch (peopleType){
      case "Individual":
          maxPeople = maxAvailableSeats;
          break;
      case "Family":
           maxPeople = 8;
          break;
      case "Group":
          maxPeople = maxAvailableSeats/2;// its up to airline
          break;

  }
     return maxPeople;
}

public static int sumPeople( EditText childNum,EditText adultNum,EditText elderNum){
    String childrenString = childNum.getText().toString();
    int children = Integer.parseInt(childrenString);
    String adultsString = adultNum.getText().toString();
    int adults = Integer.parseInt(adultsString);
    String eldersString = elderNum.getText().toString();
    int elders = Integer.parseInt(eldersString);
    int sum = children+adults+elders;

return sum;
}

public static boolean verification(boolean calSelection,boolean calSelection2,int maxPeople,int registeredPeople){
        boolean value=false;
        if(calSelection==true && calSelection2 == true){
           if(registeredPeople>0 && registeredPeople<=maxPeople)
         value= true;
        }else{

            value=false;
        }
return value;
}
//could have been only one method...I made 3 for felxibility (cause you have other parameters for each type of passenger
    public static double multiplicationC(double factorA, double factorC, double factorS,double factorPc) {
        double finalFactorC;
        Log.d(TAG, "multiplication: ----> FACTOR A " + factorA);
        Log.d(TAG, "multiplication: ----> FACTOR C " + factorC);
        Log.d(TAG, "multiplication: ----> FACTOR S " + factorS);
        Log.d(TAG, "multiplication: ----> FACTOR Pc " + factorPc);
        finalFactorC = factorA * factorC * factorS * factorPc;
           return finalFactorC;
    }
    public static double multiplicationA(double factorA, double factorC, double factorS,double factorPa) {
        double finalFactorA;
        Log.d(TAG, "multiplication: ----> FACTOR A " + factorA);
        Log.d(TAG, "multiplication: ----> FACTOR C " + factorC);
        Log.d(TAG, "multiplication: ----> FACTOR Pa " + factorPa);
        finalFactorA = factorA * factorC * factorS * factorPa;
        return finalFactorA;
    }
    public static double multiplicationE(double factorA, double factorC, double factorS,double factorPe) {
        double finalFactorE;
        Log.d(TAG, "multiplication: ----> FACTOR A " + factorA);
        Log.d(TAG, "multiplication: ----> FACTOR C " + factorC);
        Log.d(TAG, "multiplication: ----> FACTOR Pe " + factorPe);
        finalFactorE = factorA * factorC * factorS * factorPe;
        return finalFactorE;
    }
}