package com.example.dactien.homework_4_1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * Created by DacTien on 5/5/2018.
 */

public class MyAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<DiaDiem> diaDiemList;

    public MyAdapter(Context context, List<DiaDiem> diaDiemList) {
        this.context = context;
        this.diaDiemList = diaDiemList;
    }

    @Override
    public int getGroupCount() {
        return diaDiemList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return diaDiemList.get(groupPosition);
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup viewGroup) {
        String ten = ((DiaDiem) getGroup(groupPosition)).getTen();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expand_header, null);
        }

        TextView header_name = (TextView) convertView.findViewById(R.id.header_name);
        header_name.setText(ten);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expand_item, null);
        }

        Button btn_map = convertView.findViewById(R.id.btn_map);
        Button btn_info = convertView.findViewById(R.id.btn_info);

        btn_info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (kiemTraKetNoiInternet()) {
                    Uri uri = Uri.parse(diaDiemList.get(groupPosition).getLink());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                }
                else {
                    Toast.makeText(context, "Thiết bị chưa kết nối Internet", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn_map.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemTraKetNoiInternet()) {
                    DiaDiem diaDiem = diaDiemList.get(groupPosition);
                    Intent i = new Intent(context, MapActivity.class);
                    i.putExtra("DIADIEM", diaDiem);
                    context.startActivity(i);
                }
                else {
                    Toast.makeText(context, "Thiết bị chưa kết nối Internet", Toast.LENGTH_LONG).show();
                }

            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public boolean kiemTraKetNoiInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
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
}
