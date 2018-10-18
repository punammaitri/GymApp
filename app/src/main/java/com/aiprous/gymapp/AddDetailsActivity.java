package com.aiprous.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddDetailsActivity extends AppCompatActivity {

    @BindView(R.id.spinner_select_goal)
    Spinner spinner_select_goal;
    @BindView(R.id.spinner_select_gender)
    Spinner spinner_select_gender;
    @BindView(R.id.spinner_physical_activity)
    Spinner spinner_physical_activity;
    @BindView(R.id.spinner_access_gym)
    Spinner spinner_access_gym;
    @BindView(R.id.spinner_session)
    Spinner spinner_session;
    @BindView(R.id.spinner_training)
    Spinner spinner_training;


    ArrayAdapter<String> mAdapterGoal, mAdapterGender, mAdapterPhysicalActivity, mAdapterGym, mAdapterSession, mAdapterTrainingHr;
    @BindView(R.id.btnCreateAccount)
    Button btnCreateAccount;
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

        mAdapterGym = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.access_to));
        mAdapterGym.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_access_gym.setAdapter(mAdapterGym);

        mAdapterSession = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.session_per_week));
        mAdapterSession.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_session.setAdapter(mAdapterSession);

        mAdapterTrainingHr = new ArrayAdapter<String>(this, R.layout.spiner_add_user_item, getResources().getStringArray(R.array.select_goal));
        mAdapterTrainingHr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_training.setAdapter(mAdapterTrainingHr);

    }

    @OnClick(R.id.btnCreateAccount)
    public void onViewClicked() {
        startActivity(new Intent(AddDetailsActivity.this,HomeActivity.class));

    }
}
