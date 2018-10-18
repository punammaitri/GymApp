package com.aiprous.gymapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.llBlogs)
    LinearLayout llBlogs;
    @BindView(R.id.llNutrition)
    LinearLayout llNutrition;
    @BindView(R.id.llProfile)
    LinearLayout llProfile;
    @BindView(R.id.llWorkout)
    LinearLayout llWorkout;
    @BindView(R.id.llSetting)
    LinearLayout llSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.llBlogs, R.id.llNutrition, R.id.llProfile, R.id.llWorkout, R.id.llSetting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llBlogs:
                break;
            case R.id.llNutrition:
                break;
            case R.id.llProfile:
                startActivity(new Intent(this, AddDetailsActivity.class));
                break;
            case R.id.llWorkout:
                break;
            case R.id.llSetting:
                break;
        }
    }
}
