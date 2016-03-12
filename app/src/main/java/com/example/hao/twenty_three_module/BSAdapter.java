package com.example.hao.twenty_three_module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by hao on 2016/3/5.
 */
public class BSAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView =  View.inflate(parent.getContext(),R.layout.layout_text,null);
        }

        return convertView;
    }
}
