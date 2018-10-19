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

public class NutitionDietAdapter extends RecyclerView.Adapter<NutitionDietAdapter.ViewHolder> {

    private ArrayList<AddNutritionModel> myOrdersArrayList;
    private Context mContext;

    public NutitionDietAdapter(Context mContext, ArrayList<AddNutritionModel> myOrdersArrayList) {
        this.mContext = mContext;
        this.myOrdersArrayList = myOrdersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_nutrition_planner_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        holder.txtDay.setText(myOrdersArrayList.get(position).getNo_of_days());
        holder.txtTime.setText(myOrdersArrayList.get(position).getTime());
        holder.txtMeal.setText(myOrdersArrayList.get(position).getMeal());
        holder.txtName.setText(myOrdersArrayList.get(position).getName());
        holder.txtQty.setText(myOrdersArrayList.get(position).getQuantity());

        holder.cardmain.setOnClickListener(new View.OnClickListener() {
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

        @BindView(R.id.txtDay)
        TextView txtDay;
        @BindView(R.id.txtTime)
        TextView txtTime;
        @BindView(R.id.txtMeal)
        TextView txtMeal;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtQty)
        TextView txtQty;
        @BindView(R.id.cardmain)
        CardView cardmain;

        ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
