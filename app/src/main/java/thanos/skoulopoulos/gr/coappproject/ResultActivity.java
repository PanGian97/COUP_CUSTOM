package thanos.skoulopoulos.gr.coappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {


    TextView resultText;
    double totalMoney=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultText=(TextView)findViewById(R.id.total_cash_result);

        String totalMoneyString= getIntent().getStringExtra("EXTRA_SESSION_ID");
       // totalMoney=Double.parseDouble(totalMoneyString);

        resultText.setText(totalMoneyString);
        Toast.makeText(ResultActivity.this, "MONEY=  "+totalMoneyString, Toast.LENGTH_LONG).show();
    }
}
