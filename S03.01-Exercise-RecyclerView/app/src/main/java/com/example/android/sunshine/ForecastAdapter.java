package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tml on 2/2/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;


    public ForecastAdapter(){
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        public final TextView mWeatherTextView;


        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

    }


    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        // xx - check for bounds
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {
        if(mWeatherData == null){
            return 0;
        }
        return mWeatherData.length;
    }

    public void setWeatherData(String[] data){
        mWeatherData = data;
        notifyDataSetChanged();
    }
}
