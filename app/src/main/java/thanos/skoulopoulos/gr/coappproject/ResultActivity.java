package thanos.skoulopoulos.gr.coappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";

    TextView resultChildText;
    TextView resultAdultText;
    TextView resultElderText;
    double totalMoney=0;
    String totalChildMoneyString="";
    String totalAdultMoneyString="";
    String totalElderMoneyString="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultChildText=(TextView)findViewById(R.id.total_child_cash_result);
        resultAdultText=(TextView)findViewById(R.id.total_adult_cash_result);
        resultElderText=(TextView)findViewById(R.id.total_elder_cash_result);

         totalChildMoneyString= getIntent().getStringExtra("total_money_child");

         totalAdultMoneyString=getIntent().getStringExtra("total_money_adult");
        totalElderMoneyString=getIntent().getStringExtra("total_money_elder");

        Log.d(TAG, "onCreate: $$$$total CHILD money======="+totalChildMoneyString);
        Log.d(TAG, "onCreate: $$$$total ADULT money======="+totalAdultMoneyString);
        Log.d(TAG, "onCreate: $$$$total ELDER money======="+totalElderMoneyString);
        if (totalChildMoneyString != null) {
            resultChildText.setText(totalChildMoneyString+" Euro");
        }
        resultAdultText.setText(totalAdultMoneyString+" Euro");
        resultElderText.setText(totalElderMoneyString+" Euro");
       // Toast.makeText(ResultActivity.this, "MONEY=  "+totalMoneyString, Toast.LENGTH_LONG).show();
    }
}
