package com.aiprous.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddWorkoutPlannerActivity extends AppCompatActivity {

    @BindView(R.id.spinner_select_day)
    Spinner spinnerSelectDay;
    ArrayAdapter<String> mAdapterGoal;
    @BindView(R.id.edt_exercise_name)
    EditText edtExerciseName;
    @BindView(R.id.edt_weight)
    EditText edtWeight;
    @BindView(R.id.edt_reps)
    EditText edtReps;
    @BindView(R.id.btnAddExercise)
    Button btnAddExercise;

    public static ArrayList<AddWorkoutModel> mWorkoutModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_planner);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        mAdapterGoal = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.select_day));
        mAdapterGoal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSelectDay.setAdapter(mAdapterGoal);

        Log.e("size", "" + mWorkoutModels.size());
    }

    @OnClick(R.id.btnAddExercise)
    public void onViewClicked() {

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

    }
}
