package com.example.android.footaball_turf;

import android.content.Intent;
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
        shop.add(new Shop("two", "150",R.drawable.jersey3));
        shop.add(new Shop("three", "125",R.drawable.jersey4));
        shop.add(new Shop("four", "180",R.drawable.jersey5));
        shop.add(new Shop("five", "200",R.drawable.jersey2));
        shop.add(new Shop("six", "250",R.drawable.jersey6));
        shop.add(new Shop("seven", "175",R.drawable.jersey7));

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

    public void onbuy(View view)
    {

        Intent intentRegister = new Intent(Shopping.this, Buying_activity.class);
        startActivity(intentRegister);    }
}
