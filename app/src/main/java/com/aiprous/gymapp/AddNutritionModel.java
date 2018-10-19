package com.aiprous.gymapp;

public class AddNutritionModel {

    public String no_of_days;
    public String time;
    public String meal;
    public String name;
    public String quantity;


    public AddNutritionModel(String no_of_days, String time, String meal, String name, String quantity) {
        this.no_of_days = no_of_days;
        this.time = time;
        this.meal = meal;
        this.name = name;
        this.quantity = quantity;
    }


    public String getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(String no_of_days) {
        this.no_of_days = no_of_days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
