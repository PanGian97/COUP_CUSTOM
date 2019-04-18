package thanos.skoulopoulos.gr.coappproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {
    Context context;


    List<ScreenItem> listScreen;;

    public IntroViewPagerAdapter(Context context, List<ScreenItem> listScreen) {
        this.context = context;
        this.listScreen = listScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View layoutScreen = inflater.inflate(R.layout.screen_layout,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView title = layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.intro_desc);
        EditText cardNumber = layoutScreen. findViewById(R.id.card_number);
        TextView cardNumberText = layoutScreen.findViewById(R.id.card_number_text);
         TextView cashDescription = layoutScreen.findViewById(R.id.cash_description);
        ImageView airportImg=layoutScreen.findViewById(R.id.imageView3);

        title.setText(listScreen.get(position).getTitle());
        description.setText(listScreen.get(position).getDescription());
        imgSlide.setImageResource(listScreen.get(position).getScreenimg());
        cardNumberText.setText(listScreen.get(position).getCardNumberT());
        cardNumber.setText(listScreen.get(position).getCardNumber());
        cashDescription.setText(listScreen.get(position).getCashDesc());
        airportImg.setImageResource(listScreen.get(position).getAirportImg());
        container.addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return listScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((View)object);
    }

}
