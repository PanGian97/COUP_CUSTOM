package thanos.skoulopoulos.gr.coappproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.provider.Settings.System.getString;

public class CalendarPicker {
    DatePickerDialog.OnDateSetListener dateSetListener;
    private static final String TAG = "CalendarPicker";


    public CalendarPicker(DatePickerDialog.OnDateSetListener dateSetListener) {
        this.dateSetListener = dateSetListener;
    }

    public void setDate(Context context) {


        Calendar calendarDeparture = Calendar.getInstance();
        int year = calendarDeparture.get(Calendar.YEAR);
        int month = calendarDeparture.get(Calendar.MONTH);
        int day = calendarDeparture.get(Calendar.DAY_OF_MONTH);



        DatePickerDialog datePickerDialog = new DatePickerDialog(context, R.style.Theme_AppCompat_Light_Dialog, dateSetListener, year, month, day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        datePickerDialog.show();




    }

}