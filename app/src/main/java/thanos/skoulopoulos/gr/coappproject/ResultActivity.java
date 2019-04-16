package thanos.skoulopoulos.gr.coappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";

    TextView resultText;
    double totalMoney=0;
    String totalMoneyString="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText=(TextView)findViewById(R.id.total_cash_result);

         totalMoneyString= getIntent().getStringExtra("total_money");
       // totalMoney=Double.parseDouble(totalMoneyString);
        Log.d(TAG, "onCreate: $$$$total money======="+totalMoneyString);
        resultText.setText(totalMoneyString+" Euro");
        Toast.makeText(ResultActivity.this, "MONEY=  "+totalMoneyString, Toast.LENGTH_LONG).show();
    }
}
