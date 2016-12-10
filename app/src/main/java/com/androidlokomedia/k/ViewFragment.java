package com.androidlokomedia.k;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {


    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentLayout = inflater.inflate(R.layout.fragment_view, container, false);
        TextView judul = (TextView)fragmentLayout.findViewById(R.id.viewKjudul);
        TextView keterangan = (TextView)fragmentLayout.findViewById(R.id.viewKketerangan);
        ImageView kIcon = (ImageView)fragmentLayout.findViewById(R.id.viewKicon);

        Intent i = getActivity().getIntent();
        judul.setText(i.getExtras().getString(MainActivity.K_JUDUL_EXTRA));
        keterangan.setText(i.getExtras().getString(MainActivity.K_KETERANGAN_EXTRA));

        Tulis.Kategori ktgIcon = (Tulis.Kategori)i.getSerializableExtra(MainActivity.K_KATEGORI_EXTRA);
        kIcon.setImageResource(Tulis.kategoriToGambar(ktgIcon));
        // Inflate the layout for this fragment
        return fragmentLayout;
    }

}
