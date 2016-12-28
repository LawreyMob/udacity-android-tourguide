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
public class RestaurantsFragment extends Fragment {

    private static double restaurantLat = 1.2851013;
    private static double restaurantLng= 103.8227851;

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<TGItem> tgItems = new ArrayList<TGItem>();
        tgItems.add(new TGItem(getString(R.string.restaurant1Title), getString(R.string.restaurant1Description), R.drawable.restaurant1, restaurantLat,restaurantLng));
        tgItems.add(new TGItem(getString(R.string.restaurant2Title), getString(R.string.restaurant2Description), R.drawable.restaurant2, restaurantLat,restaurantLng));
        tgItems.add(new TGItem(getString(R.string.restaurant3Title), getString(R.string.restaurant3Description), R.drawable.restaurant3, restaurantLat,restaurantLng));
        tgItems.add(new TGItem(getString(R.string.restaurant4Title), getString(R.string.restaurant4Description), R.drawable.restaurant4, restaurantLat,restaurantLng));
        tgItems.add(new TGItem(getString(R.string.restaurant5Title), getString(R.string.restaurant5Description), R.drawable.restaurant5, restaurantLat,restaurantLng));
        tgItems.add(new TGItem(getString(R.string.restaurant6Title), getString(R.string.restaurant6Description), R.drawable.restaurant6, restaurantLat,restaurantLng));

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
