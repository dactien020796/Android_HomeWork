package com.example.administrator.homework_4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

/**
 * Created by DacTien on 3/31/2018.
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
