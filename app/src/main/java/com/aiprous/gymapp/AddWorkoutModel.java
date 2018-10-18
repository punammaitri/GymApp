package com.aiprous.gymapp;

public class AddWorkoutModel {


    public String no_of_days;
    public String exercise_name;
    public String weight_range;
    public String reps;


    public AddWorkoutModel(String no_of_days, String exercise_name, String weight_range, String reps) {
        this.no_of_days = no_of_days;
        this.exercise_name = exercise_name;
        this.weight_range = weight_range;
        this.reps = reps;
    }


    public String getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(String no_of_days) {
        this.no_of_days = no_of_days;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getWeight_range() {
        return weight_range;
    }

    public void setWeight_range(String weight_range) {
        this.weight_range = weight_range;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }
}
