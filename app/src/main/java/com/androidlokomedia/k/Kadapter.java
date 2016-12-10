package com.androidlokomedia.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmad on 09/12/2016.
 */
public class Kadapter extends ArrayAdapter<Tulis> {

//    private Tulis tulis;

    public static class ViewHolder{
        TextView judul;
        TextView ketereangan;
        ImageView kIcon;
    }
    public Kadapter(Context context, ArrayList<Tulis> tulises) {
        super(context, 0, tulises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tulis tulis = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
            viewHolder.judul = (TextView)convertView.findViewById(R.id.listKjudul);
            viewHolder.ketereangan = (TextView)convertView.findViewById(R.id.listKketerangan);
            viewHolder.kIcon = (ImageView) convertView.findViewById(R.id.listKicon);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.judul.setText(tulis.getJudul());
        viewHolder.ketereangan.setText(tulis.getKeterangan());
        viewHolder.kIcon.setImageResource(tulis.getAssosiasiGambar());

        return convertView;
    }
}
