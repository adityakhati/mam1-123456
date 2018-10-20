package com.example.android.footaball_turf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        final ArrayList<Shop> shop = new ArrayList<Shop>();

        shop.add(new Shop("jersey", "100",R.drawable.jersey1));
        shop.add(new Shop("two", "otiiko",R.drawable.ic_launcher_background));
        shop.add(new Shop("three", "tolookosu",R.drawable.ic_launcher_background));
        shop.add(new Shop("four", "oyyisa",R.drawable.ic_launcher_background));
        shop.add(new Shop("five", "massokka",R.drawable.ic_launcher_background));
        shop.add(new Shop("six", "temmokka",R.drawable.ic_launcher_background));
       /* shop.add(new Shop("seven", "kenekaku", seven, seven));
        shop.add(new Shop("eight", "kawinta", eight, eight));
        shop.add(new Shop("nine", "wo’e", nine, nine));
        shop.add(new Shop("ten", "na’aacha", ten, ten));*/

        ShopAdapter adapter = new ShopAdapter(this, shop, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list_shopping);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shop s = shop.get(i);
            }
        });
    }
}
