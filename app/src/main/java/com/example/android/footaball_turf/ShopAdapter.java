package com.example.android.footaball_turf;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShopAdapter extends ArrayAdapter<Shop> {



    public ShopAdapter(Activity context, ArrayList<Shop> word, int Colorresourceid) {
        super(context, 0, word);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Shop currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getmName());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        numberTextView.setText(currentWord.getmDetail());

        ImageView numberImageView = (ImageView) listItemView.findViewById(R.id.image);


            numberImageView.setImageResource(currentWord.getimage());
            numberImageView.setVisibility(View.VISIBLE);



        return listItemView;
    }

}
