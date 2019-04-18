package thanos.skoulopoulos.gr.coappproject;

import android.graphics.drawable.Drawable;

public class ScreenItem {


    String Title,Description,CardNumberT,CardNumber,CashDesc;
    int Screenimg,AirportImg;

    public String getCardNumberT() {
        return CardNumberT;
    }

    public void setCardNumberT(String cardNumberT) {
        CardNumberT = cardNumberT;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCashDesc() {
        return CashDesc;
    }

    public void setCashDesc(String cashDesc) {
        CashDesc = cashDesc;
    }

    public int getAirportImg() {
        return AirportImg;
    }

    public void setAirportImg(int airportImg) {
        AirportImg = airportImg;
    }

    public int getScreenimg() {
        return Screenimg;
    }

    public void setScreenimg(int screenimg) {
        Screenimg = screenimg;
    }




    public ScreenItem(String title, String description, int screenimg,String cardNumberT,String cardNumber,String cashDesc ,int airportImg) {
        Title = title;
        Description = description;
        Screenimg = screenimg;
        CardNumber = cardNumber;
        CardNumberT = cardNumberT;
        CashDesc = cashDesc;
        AirportImg = airportImg;
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
