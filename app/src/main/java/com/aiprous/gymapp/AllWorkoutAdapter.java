package com.aiprous.gymapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllWorkoutAdapter extends RecyclerView.Adapter<AllWorkoutAdapter.ViewHolder> {


    private ArrayList<AddWorkoutModel> myOrdersArrayList;
    private Context mContext;

    public AllWorkoutAdapter(Context mContext, ArrayList<AddWorkoutModel> myOrdersArrayList) {
        this.mContext = mContext;
        this.myOrdersArrayList = myOrdersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_workout_planner_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        holder.txtDays.setText(myOrdersArrayList.get(position).getNo_of_days());
        holder.txtExerciseName.setText(myOrdersArrayList.get(position).getExercise_name());
        holder.txtWeightRange.setText(myOrdersArrayList.get(position).getWeight_range());
        holder.txtReps.setText(myOrdersArrayList.get(position).getReps());

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, AddWorkoutPlannerActivity.class));
                ((Activity) mContext).finish();
            }
        });

    }


    @Override
    public int getItemCount() {
        return (myOrdersArrayList == null) ? 0 : myOrdersArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtDays)
        TextView txtDays;
        @BindView(R.id.txtExerciseName)
        TextView txtExerciseName;
        @BindView(R.id.txtWeightRange)
        TextView txtWeightRange;
        @BindView(R.id.txtReps)
        TextView txtReps;
        @BindView(R.id.llMain)
        LinearLayout llMain;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
