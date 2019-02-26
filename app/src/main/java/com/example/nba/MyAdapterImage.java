package com.example.nba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyAdapterImage extends BaseAdapter {

    private Context mContext;

    public MyAdapterImage(Context c) {
        mContext = c;
    }
    public int getCount() {
        return thumbImages.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(thumbImages[position]);
        return imageView;
    }
    // Add all our images to arraylist
    private Integer[] thumbImages = {
            R.drawable.logo1, R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6,
            R.drawable.logo7, R.drawable.logo8,
            R.drawable.logo9, R.drawable.logo10,
            R.drawable.logo11, R.drawable.logo12,
            R.drawable.logo13, R.drawable.logo14,
            R.drawable.logo15, R.drawable.logo16,
            R.drawable.logo2, R.drawable.logo3,
    };
}
