package com.example.dactien.homework_4_1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by DacTien on 5/5/2018.
 */

public class DiaDiemAdapter extends ArrayAdapter<DiaDiem> {

    List<DiaDiem> lishDiaDiem;
    Context mContext;
    int mResource;

    public DiaDiemAdapter(@NonNull Context context, int resource, @NonNull List<DiaDiem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        lishDiaDiem = objects;
    }

    public boolean kiemTraKetNoiInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.btMap = (Button) convertView.findViewById(R.id.btMap);
            viewHolder.btInfo = (Button) convertView.findViewById(R.id.btInfo);
            viewHolder.linearLayout = (LinearLayout) convertView.findViewById(R.id.linearLayout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(lishDiaDiem.get(position).getTen());

        viewHolder.btInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (kiemTraKetNoiInternet()) {
                    Uri uri = Uri.parse(lishDiaDiem.get(position).getLink());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(intent);
                }
                else {
                    Toast.makeText(mContext, "Thiết bị chưa kết nối Internet", Toast.LENGTH_LONG).show();
                }

            }
        });

        viewHolder.btMap.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemTraKetNoiInternet()) {
                    DiaDiem diaDiem = lishDiaDiem.get(position);
                    Intent i = new Intent(mContext, MapActivity.class);
                    i.putExtra("DIADIEM", diaDiem);
                    mContext.startActivity(i);
                }
                else {
                    Toast.makeText(mContext, "Thiết bị chưa kết nối Internet", Toast.LENGTH_LONG).show();
                }

            }
        });

        return convertView;
    }

    class ViewHolder {
        TextView tvName;
        Button btMap;
        Button btInfo;
        LinearLayout linearLayout;
    }
}
