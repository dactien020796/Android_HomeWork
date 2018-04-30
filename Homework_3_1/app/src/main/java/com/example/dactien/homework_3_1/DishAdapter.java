package com.example.dactien.homework_3_1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by DacTien on 4/30/2018.
 */

public class DishAdapter extends ArrayAdapter<Item> {

    List<Item> lishItem;
    Context mContext;
    int mResource;

    public DishAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        lishItem = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvTittle = (TextView) convertView.findViewById(R.id.tvTittle);
            viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
            viewHolder.linearLayout = convertView.findViewById(R.id.linearLayout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTittle.setText(lishItem.get(position).getTitle());
        Picasso.with(mContext)
                .load(lishItem.get(position).getLink_img())
                .resize(90, 90)
                .centerCrop()
                .error(R.drawable.none)
                .into(viewHolder.imgIcon);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(lishItem.get(position).getLink()));
                mContext.startActivity(implicit);
            }
        });

        return convertView;
    }

    class ViewHolder {
        ImageView imgIcon;
        TextView tvTittle;
        LinearLayout linearLayout;
    }
}
