package thanos.skoulopoulos.gr.coappproject;

import android.graphics.drawable.Drawable;

public class ScreenItem {


    String Title,Description;

    public int getScreenimg() {
        return Screenimg;
    }

    public void setScreenimg(int screenimg) {
        Screenimg = screenimg;
    }

    int Screenimg;


    public ScreenItem(String title, String description, int screenimg) {
        Title = title;
        Description = description;
        Screenimg = screenimg;
    }
    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }



}
