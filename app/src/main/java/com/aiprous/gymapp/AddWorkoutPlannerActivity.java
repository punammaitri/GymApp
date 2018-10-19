package com.aiprous.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddWorkoutPlannerActivity extends AppCompatActivity {

    @BindView(R.id.spinner_select_day)
    Spinner spinnerSelectDay;
    @BindView(R.id.edt_exercise_name)
    EditText edtExerciseName;
    @BindView(R.id.edt_weight)
    EditText edtWeight;
    @BindView(R.id.edt_reps)
    EditText edtReps;
    @BindView(R.id.btnAddExercise)
    Button btnAddExercise;
    @BindView(R.id.card_add_exercise)
    CardView card_add_exercise;
    @BindView(R.id.spinner_select_days)
    Spinner spinnerSelectDays;
    @BindView(R.id.edt_meal)
    EditText edtMeal;
    @BindView(R.id.edt_qty)
    EditText edtQty;
    @BindView(R.id.btnAddNutrition)
    Button btnAddNutrition;
    @BindView(R.id.card_nutrition_diet)
    CardView cardNutritionDiet;
    @BindView(R.id.txtSelectDay)
    TextView txtSelectDay;
    @BindView(R.id.txtSelectDays)
    TextView txtSelectDays;
    @BindView(R.id.edt_name)
    EditText edtName;
    private String getFlag;
    ArrayAdapter<String> mAdapterGoal, mAdapterNutrition;
    public static ArrayList<AddWorkoutModel> mWorkoutModels = new ArrayList<>();
    public static ArrayList<AddNutritionModel> mNutritionModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_planner);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        //get flag using intent
        if (getIntent() != null && getIntent().hasExtra("flag")) {
            getFlag = getIntent().getStringExtra("flag");
        }

        if (getFlag.equals("1")) {
            card_add_exercise.setVisibility(View.GONE);
            cardNutritionDiet.setVisibility(View.VISIBLE);

        } else {
            card_add_exercise.setVisibility(View.VISIBLE);
            cardNutritionDiet.setVisibility(View.GONE);
        }


        mAdapterGoal = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.select_day));
        mAdapterGoal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelectDay.setAdapter(mAdapterGoal);

        mAdapterNutrition = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.select_days));
        mAdapterNutrition.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelectDays.setAdapter(mAdapterNutrition);

        Log.e("size", "" + mWorkoutModels.size());
    }


    @OnClick(R.id.btnAddExercise)
    public void onViewClicked() {


    }

    @OnClick({R.id.btnAddExercise, R.id.btnAddNutrition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAddExercise:
                String getDays = spinnerSelectDay.getSelectedItem().toString();
                String getExerciseName = edtExerciseName.getText().toString();
                String getWeight = edtWeight.getText().toString();
                String getReps = edtReps.getText().toString();

                if (spinnerSelectDay.getSelectedItem().toString().equalsIgnoreCase("Select day")) {
                    Toast.makeText(this, "Select days", Toast.LENGTH_SHORT).show();
                } else if (edtExerciseName.getText().length() < 1) {
                    edtExerciseName.setError("Please add exercise");
                } else if (edtWeight.getText().length() < 1) {
                    edtWeight.setError("Please add weight");
                } else if (edtReps.getText().length() < 1) {
                    edtReps.setError("Please add reps");
                } else {
                    AddWorkoutModel addWorkoutModel = new AddWorkoutModel(getDays, getExerciseName, getWeight, getReps);
                    addWorkoutModel.setNo_of_days(getDays);
                    addWorkoutModel.setExercise_name(getExerciseName);
                    addWorkoutModel.setWeight_range(getWeight);
                    addWorkoutModel.setReps(getReps);
                    mWorkoutModels.add(addWorkoutModel);
                    startActivity(new Intent(this, AllWorkoutPlannerActivity.class));
                    finish();
                }
                break;
            case R.id.btnAddNutrition:

                String getWeekdays = spinnerSelectDays.getSelectedItem().toString();
                String getMeal = edtMeal.getText().toString();
                String getName = edtName.getText().toString();
                String getQty = edtQty.getText().toString();


                if (spinnerSelectDays.getSelectedItem().toString().equalsIgnoreCase("Select days")) {
                    Toast.makeText(this, "Select week day", Toast.LENGTH_SHORT).show();
                } else if (edtMeal.getText().length() < 1) {
                    edtMeal.setError("Please add meal");
                } else if (edtName.getText().length() < 1) {
                    edtName.setError("Please add name");
                } else if (edtQty.getText().length() < 1) {
                    edtQty.setError("Please add quantity");
                } else {
                    AddNutritionModel addNutritionModel = new AddNutritionModel(getWeekdays, "", getMeal, getName, getQty);
                    addNutritionModel.setNo_of_days(getWeekdays);
                    addNutritionModel.setTime("");
                    addNutritionModel.setMeal(getMeal);
                    addNutritionModel.setName(getName);
                    addNutritionModel.setQuantity(getQty);
                    mNutritionModels.add(addNutritionModel);

                    startActivity(new Intent(this, NutritionDietActivity.class));
                    finish();
                }
                break;
        }
    }
}
