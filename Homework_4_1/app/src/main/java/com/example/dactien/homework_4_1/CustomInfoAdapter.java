package com.example.dactien.homework_4_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by DacTien on 5/5/2018.
 */

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter {

    Context context;
    DiaDiem diaDiem;

    public CustomInfoAdapter(Context context, DiaDiem diaDiem) {
        this.context = context;
        this.diaDiem = diaDiem;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.map_item, null);
        TextView tvTen = (TextView) v.findViewById(R.id.tvTen);

        tvTen.setText(diaDiem.getTen());
        return v;
    }
}

