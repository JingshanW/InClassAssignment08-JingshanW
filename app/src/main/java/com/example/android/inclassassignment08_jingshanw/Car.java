package com.example.android.inclassassignment08_jingshanw;

/**
 * Created by Jing on 3/28/17.
 */

public class Car
{
    private String brand;
    private int price;
    private boolean suv;

    public Car(String brand, boolean suv, int price) {
        this.brand = brand;
        this.suv = suv;
        this.price = price;
    }
    public Car(){}



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSuv() {
        return suv;
    }

    public void setSuv(boolean suv) {
        this.suv = suv;
    }

    @Override
    public String toString() {
        return brand +" "+price+" "+suv;
    }
}
