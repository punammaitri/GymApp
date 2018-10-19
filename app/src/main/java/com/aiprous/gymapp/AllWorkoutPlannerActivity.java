package com.aiprous.gymapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.aiprous.gymapp.AddWorkoutPlannerActivity.mWorkoutModels;

public class AllWorkoutPlannerActivity extends AppCompatActivity {

    @BindView(R.id.rv_show_all_exercise)
    RecyclerView rv_show_all_exercise;
    @BindView(R.id.txtEmpty)
    TextView txtEmpty;


    RecyclerView.LayoutManager layoutManager;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_workout_plan);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        if (!(mWorkoutModels.size() == 0)) {
            layoutManager = new LinearLayoutManager(mContext);
            rv_show_all_exercise.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rv_show_all_exercise.setHasFixedSize(true);
            rv_show_all_exercise.setAdapter(new AllWorkoutAdapter(mContext, mWorkoutModels));
        } else {
            rv_show_all_exercise.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.txtEmpty)
    public void onViewClicked() {
        startActivity(new Intent(this, AddWorkoutPlannerActivity.class)
                .putExtra("flag", "" + 2));
        finish();
    }
}
