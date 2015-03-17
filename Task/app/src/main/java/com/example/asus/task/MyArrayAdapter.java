package com.example.asus.task;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asus on 17.03.2015.
 */
public class MyArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public MyArrayAdapter(Context context, String[] values) {
        super(context, R.layout.item_numbers,values);
        this.context=context;
        this.values=values;

    }

    static class ViewHolder {
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemLayout = inflater.inflate(R.layout.item_numbers, parent, false);
        if (position % 2 == 0)
            itemLayout.setBackgroundColor(Color.GRAY);

        ViewHolder holder = new ViewHolder();
        holder.textView = (TextView) itemLayout.findViewById(R.id.number_text);
        holder.textView.setText(values[position]);

        return itemLayout;
    }

}
