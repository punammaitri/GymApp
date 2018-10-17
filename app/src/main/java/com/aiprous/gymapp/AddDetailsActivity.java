package com.aiprous.gymapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddDetailsActivity extends AppCompatActivity {

    @BindView(R.id.spinner_select_goal)
    Spinner spinner_select_goal;
    @BindView(R.id.spinner_select_gender)
    Spinner spinner_select_gender;
    @BindView(R.id.spinner_physical_activity)
    Spinner spinner_physical_activity;

    ArrayAdapter<String> mAdapterGoal, mAdapterGender, mAdapterPhysicalActivity;
    private String mGoalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        mAdapterGoal = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.goal));
        mAdapterGoal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select_goal.setAdapter(mAdapterGoal);

        spinner_select_goal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                mGoalName = adapter.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        mAdapterGender = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.gender));
        mAdapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select_gender.setAdapter(mAdapterGender);

        mAdapterPhysicalActivity = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.physical_activity));
        mAdapterPhysicalActivity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_physical_activity.setAdapter(mAdapterPhysicalActivity);

    }
}
