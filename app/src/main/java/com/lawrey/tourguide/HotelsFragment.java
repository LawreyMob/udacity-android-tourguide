package com.lawrey.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    private static double hotel1Lat = 1.2741325;
    private static double hotel1Lng = 103.8447375;

    private static double hotel2Lat = 1.2555754;
    private static double hotel2Lng = 103.8171963;

    private static double hotel3Lat = 1.2577218;
    private static double hotel3Lng = 103.8146218;

    private static double hotel4Lat = 1.2562989;
    private static double hotel4Lng = 103.8167958;

    private static double hotel5Lat = 1.3313702;
    private static double hotel5Lng = 103.7372501;

    private static double hotel6Lat = 1.2577967;
    private static double hotel6Lng = 103.8167159;

    private static double hotel7Lat = 1.2547078;
    private static double hotel7Lng = 103.8179523;

    private static double hotel8Lat = 1.2547292;
    private static double hotel8Lng = 103.8179523;

    private static double hotel9Lat = 1.2547399;
    private static double hotel9Lng = 103.8179523;

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<TGItem> tgItems = new ArrayList<TGItem>();
        tgItems.add(new TGItem(getString(R.string.hotel1Title), getString(R.string.hotel1Description), R.drawable.hotel1, hotel1Lat, hotel1Lng));
        tgItems.add(new TGItem(getString(R.string.hotel2Title), getString(R.string.hotel2Description), R.drawable.hotel2, hotel2Lat, hotel2Lng));
        tgItems.add(new TGItem(getString(R.string.hotel3Title), getString(R.string.hotel3Description), R.drawable.hotel3, hotel3Lat, hotel3Lng));
        tgItems.add(new TGItem(getString(R.string.hotel4Title), getString(R.string.hotel4Description), R.drawable.hotel4, hotel4Lat, hotel4Lng));
        tgItems.add(new TGItem(getString(R.string.hotel5Title), getString(R.string.hotel5Description), R.drawable.hotel5, hotel5Lat, hotel5Lng));
        tgItems.add(new TGItem(getString(R.string.hotel6Title), getString(R.string.hotel6Description), R.drawable.hotel6, hotel6Lat, hotel6Lng));
        tgItems.add(new TGItem(getString(R.string.hotel7Title), getString(R.string.hotel7Description), R.drawable.hotel7, hotel7Lat, hotel7Lng));
        tgItems.add(new TGItem(getString(R.string.hotel8Title), getString(R.string.hotel8Description), R.drawable.hotel8, hotel8Lat, hotel8Lng));
        tgItems.add(new TGItem(getString(R.string.hotel9Title), getString(R.string.hotel9Description), R.drawable.hotel9, hotel9Lat, hotel9Lng));

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
