package com.lawrey.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ItemDetailsActivity extends AppCompatActivity {

    private TGItem selectedTGItem;

    private static String googleBaseUrl = "http://maps.google.com/maps";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
    }

    @Override
    protected void onResume() {
        super.onResume();

        selectedTGItem = (TGItem) getIntent().getSerializableExtra("TGItem");

        TextView titleTextView = (TextView) findViewById(R.id.itemDetailsTitle_text_view);
        titleTextView.setText(selectedTGItem.getmTitle());

        TextView descriptionTextView = (TextView) findViewById(R.id.itemDetailsDescription_text_view);
        descriptionTextView.setText(selectedTGItem.getmDescription());

        ImageView imageView = (ImageView) findViewById(R.id.itemDetails_image_view);
        imageView.setImageResource(selectedTGItem.getmImageResourceID());

        if(selectedTGItem.getLongitude() == 0.0) {
            Button btn_action = (Button) findViewById(R.id.btn_action);
            btn_action.setText("Book Now");
        }
    }

    public void onClickGetDirections(View view) {

        if(selectedTGItem.getLongitude() != 0.0) {
            String daddrParam = "?daddr="
                    + selectedTGItem.getLatitude()
                    + ","
                    + selectedTGItem.getLongitude();

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse(googleBaseUrl + daddrParam));
            startActivity(intent);
        }else{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(selectedTGItem.getUrl()));
            startActivity(i);
        }
    }
}
