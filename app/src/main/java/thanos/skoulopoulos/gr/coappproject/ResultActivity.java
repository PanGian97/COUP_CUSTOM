package thanos.skoulopoulos.gr.coappproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;

    TextView resultChildText;
    TextView resultAdultText;
    TextView resultElderText;
    double totalMoney=0;
    String totalChildMoneyString="";
    String totalAdultMoneyString="";
    String totalElderMoneyString="";

    List<ScreenItem> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        resultList.add(new ScreenItem("Credit Card"," ",R.drawable.card,"Credit card number"," ","",R.drawable.airport));
        resultList.add(new ScreenItem("Money"," ",R.drawable.money," ",null,"You will pay on airport",R.drawable.card16));
        resultList.add(new ScreenItem("Bitcoin"," ",R.drawable.bitcoin,"",null,"Coming soon...",R.drawable.bitcoin_pay));


        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter  = new IntroViewPagerAdapter(this,resultList);
        screenPager.setAdapter(introViewPagerAdapter);

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
            resultChildText.setText("Child Ticket price"+totalChildMoneyString+" Euro");
        }
        resultAdultText.setText("Adult Ticket price"+totalAdultMoneyString+" Euro");
        resultElderText.setText("Elder Ticket price"+totalElderMoneyString+" Euro");
       // Toast.makeText(ResultActivity.this, "MONEY=  "+totalMoneyString, Toast.LENGTH_LONG).show();
    }

}
