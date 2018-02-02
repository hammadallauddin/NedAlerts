package com.appdroid.nedians;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hammad Allauddin on 4/22/2017.
 */

public class EventAdapter extends BaseAdapter {

    private Context mContaxt;
    private ArrayList<String> mData;
    private ArrayList<String> mData2;
    private static LayoutInflater inflater = null;

    public EventAdapter(Context context, ArrayList<String> data, ArrayList<String> data2){
        mContaxt = context;
        mData = data;
        mData2 = data2;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final EventAdapter.ViewHolder mHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.event_list_items,null);
            mHolder = new EventAdapter.ViewHolder();
            mHolder.t1 = (TextView) convertView.findViewById(R.id.text1);
            mHolder.t2 = (TextView) convertView.findViewById(R.id.text2);
            convertView.setTag(mHolder);
        }
        else {
            mHolder = (EventAdapter.ViewHolder) convertView.getTag();
        }
        if(mData.isEmpty() == false || mData.isEmpty() == false){
            mHolder.t1.setText(mData.get(position));
            mHolder.t2.setText(mData2.get(position));
        }
        return convertView;
    }
    private class ViewHolder {
        TextView t1;
        TextView  t2;

    }
}
