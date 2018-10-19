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

import static com.aiprous.gymapp.AddWorkoutPlannerActivity.mNutritionModels;
import static com.aiprous.gymapp.AddWorkoutPlannerActivity.mWorkoutModels;

public class NutritionDietActivity extends AppCompatActivity {
    @BindView(R.id.rv_nutrition_diet)
    RecyclerView rv_nutrition_diet;
    @BindView(R.id.txtEmpty)
    TextView txtEmpty;


    private RecyclerView.LayoutManager layoutManager;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_diet);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

        if (!(mNutritionModels.size() == 0)) {
            layoutManager = new LinearLayoutManager(mContext);
            rv_nutrition_diet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rv_nutrition_diet.setHasFixedSize(true);
            rv_nutrition_diet.setAdapter(new NutitionDietAdapter(mContext, mNutritionModels));
        } else {
            rv_nutrition_diet.setVisibility(View.GONE);
            txtEmpty.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.txtEmpty)
    public void onViewClicked() {
        startActivity(new Intent(this, AddWorkoutPlannerActivity.class)
                .putExtra("flag", "" + 1));
        finish();
    }


}
