package com.lawrey.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lawrey on 28/12/16.
 */

public class TGItemAdapter extends ArrayAdapter<TGItem> {

    public TGItemAdapter(Context context, ArrayList<TGItem> tgItems) {
        super(context, 0, tgItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TGItem currentTGItem = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.itemtitle_text_view);
        titleTextView.setText(currentTGItem.getmTitle());

        TextView subTitleTextView = (TextView) listItemView.findViewById(R.id.itemdescription_text_view);
        subTitleTextView.setText(currentTGItem.getmDescription());

        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.icon_image_view);

        if (currentTGItem.hasImage()) {
            iconImageView.setVisibility(View.VISIBLE);
            iconImageView.setImageResource(currentTGItem.getmImageResourceID());
        }else{
            iconImageView.setVisibility(View.GONE);
        }

        return listItemView;

    }



}
