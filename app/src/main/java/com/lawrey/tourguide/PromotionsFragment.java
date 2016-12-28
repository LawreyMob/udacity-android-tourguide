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
public class PromotionsFragment extends Fragment {

    private static String PROMOTION1_URL = "http://www.rwsentosa.com/language/en-US/Homepage/Promotions#";
    private static String PROMOTION2_URL = "http://www.rwsentosa.com/LinkClick.aspx?link=https%3a%2f%2freservations.rwsentosa.com%2fPageParser.aspx%3ftype%3d4%26pc%3dPMCACWAUG%26lang%3den-US%26utm_source%3drws_promo_EN%26utm_medium%3drws_web_promo%26utm_campaign%3dattractions_acw_mcq3%26utm_nooverride%3d1&tabid=1298&mid=10535&language=en-US";
    private static String PROMOTION3_URL = "http://www.rwsentosa.com/LinkClick.aspx?link=https%3a%2f%2freservations.rwsentosa.com%2fPageParser.aspx%3ftype%3d4%26pc%3dPMCSEAAUG%26lang%3den-US%26utm_source%3drws_promo_EN%26utm_medium%3drws_web_promo%26utm_campaign%3dattractions_seaa_mcq3%26utm_nooverride%3d1&tabid=1298&mid=10535&language=en-US";
    private static String PROMOTION4_URL = "https://reservations.rwsentosa.com/PageParser.aspx?type=4&pc=PMCUSSAUGA&lang=en-US&utm_source=rws_promo_EN&utm_medium=rws_web_promo&utm_campaign=attractions_uss_mcq3&utm_nooverride=1";
    private static String PROMOTION5_URL = "https://reservations.rwsentosa.com/PageParser.aspx?type=4&pc=PMCUSSAUUS&lang=en-US&utm_source=rws_promo_EN&utm_medium=rws_web_promo&utm_campaign=attractions_uss_mc2q3&utm_nooverride=1";
    private static String PROMOTION6_URL = "http://www.rwsentosa.com/LinkClick.aspx?link=http%3a%2f%2fshows.rwsentosa.com%2fRWSWebApp%2fBooking.do%3fcontentCode%3dmulan1216%26utm_source%3drws_mulan_promopg_EN%26utm_medium%3dwebpage%26utm_campaign%3dentertainment_show_mulan%26utm_nooverride%3d1&tabid=1298&mid=10535&language=en-US";

    public PromotionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);

        ArrayList<TGItem> tgItems = new ArrayList<TGItem>();
        tgItems.add(new TGItem(getString(R.string.promotion1Title), getString(R.string.promotion1Description), R.drawable.promotion1, PROMOTION1_URL));
        tgItems.add(new TGItem(getString(R.string.promotion2Title), getString(R.string.promotion2Description), R.drawable.promotion2, PROMOTION2_URL));
        tgItems.add(new TGItem(getString(R.string.promotion3Title), getString(R.string.promotion3Description), R.drawable.promotion3, PROMOTION3_URL));
        tgItems.add(new TGItem(getString(R.string.promotion4Title), getString(R.string.promotion4Description), R.drawable.promotion4, PROMOTION4_URL));
        tgItems.add(new TGItem(getString(R.string.promotion5Title), getString(R.string.promotion5Description), R.drawable.promotion4, PROMOTION5_URL));
        tgItems.add(new TGItem(getString(R.string.promotion6Title), getString(R.string.promotion6Description), R.drawable.promotion5, PROMOTION6_URL));

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
