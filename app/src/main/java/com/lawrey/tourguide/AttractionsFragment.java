package com.lawrey.tourguide;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {

    private static double attraction1Lat = 1.254210;
    private static double attraction1Lng = 103.823806;

    private static double attraction2Lat = 1.258642;
    private static double attraction2Lng = 103.820711;

    private static double attraction3Lat = 1.258637;
    private static double attraction3Lng = 103.819415;

    private static double attraction4Lat = 1.256749;
    private static double attraction4Lng = 103.820413;

    private static double attraction5Lat = 1.258263;
    private static double attraction5Lng = 103.820833;

    private static double attraction6Lat = 1.256970;
    private static double attraction6Lng = 103.822667;

    private static double attraction7Lat = 1.257065;
    private static double attraction7Lng = 103.822559;

    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<TGItem> tgItems = new ArrayList<TGItem>();
        tgItems.add(new TGItem(getString(R.string.attraction1Title), getString(R.string.attraction1Description), R.drawable.attraction1, attraction1Lat, attraction1Lng));
        tgItems.add(new TGItem(getString(R.string.attraction2Title), getString(R.string.attraction2Description), R.drawable.attraction2, attraction2Lat, attraction2Lng));
        tgItems.add(new TGItem(getString(R.string.attraction3Title), getString(R.string.attraction3Description), R.drawable.attraction3, attraction3Lat, attraction3Lng));
        tgItems.add(new TGItem(getString(R.string.attraction4Title), getString(R.string.attraction4Description), R.drawable.attraction4, attraction4Lat, attraction4Lng));
        tgItems.add(new TGItem(getString(R.string.attraction5Title), getString(R.string.attraction5Description), R.drawable.attraction5, attraction5Lat, attraction5Lng));
        tgItems.add(new TGItem(getString(R.string.attraction6Title), getString(R.string.attraction6Description), R.drawable.attraction6, attraction6Lat, attraction6Lng));
        tgItems.add(new TGItem(getString(R.string.attraction7Title), getString(R.string.attraction7Description), R.drawable.attraction7, attraction7Lat, attraction7Lng));


        TGItemAdapter itemsAdapter = new TGItemAdapter(getActivity(), tgItems);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TGItem listItem = (TGItem) listView.getItemAtPosition(position);

                //Toast.makeText(getActivity(), "You've selected " + listItem.getmTitle(), Toast.LENGTH_SHORT).show();
                goToDetailsPage(listItem);
            }
        });

        return rootView;
    }

    public void goToDetailsPage(TGItem tgItem) {
        Intent intent = new Intent(getActivity(), ItemDetailsActivity.class);
        intent.putExtra("TGItem", tgItem);
        startActivity(intent);
    }

}
