package com.example.nba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyAdapterImage extends BaseAdapter {

    private Context mContext;

    private Integer[] logo = {
            R.drawable.logo1,R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6,
            R.drawable.logo7, R.drawable.logo8,
            R.drawable.logo9, R.drawable.logo10,
            R.drawable.logo11, R.drawable.logo12,
            R.drawable.logo13, R.drawable.logo14,
            R.drawable.logo15, R.drawable.logo16,
    };

    public MyAdapterImage(Context c) {
        mContext = c;
    }

    public int getCount() {
        return logo.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(logo[position]);
        return imageView;
    }
}
