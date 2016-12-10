package com.androidlokomedia.k;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    private EditText judul, keterangan;
    private ImageView imageView;
    private AlertDialog kategoriDialogObjek;
    private Tulis.Kategori spnGmbKategori;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentLayout =  inflater.inflate(R.layout.fragment_edit, container, false);
        judul = (EditText) fragmentLayout.findViewById(R.id.editKJudul);
        keterangan = (EditText)fragmentLayout.findViewById(R.id.editKketerangan);
        imageView = (ImageView)fragmentLayout.findViewById(R.id.editKicon);

        Button btn = (Button)fragmentLayout.findViewById(R.id.simpanK);

        Intent intent = getActivity().getIntent();
        judul.setText(intent.getExtras().getString(MainActivity.K_JUDUL_EXTRA));
        keterangan.setText(intent.getExtras().getString(MainActivity.K_KETERANGAN_EXTRA));

        Tulis.Kategori kategori = (Tulis.Kategori)intent.getSerializableExtra(MainActivity.K_KATEGORI_EXTRA);
        imageView.setImageResource(Tulis.kategoriToGambar(kategori));

        buildKategoriDialog();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategoriDialogObjek.show();
            }
        });
        return fragmentLayout;
    }

    private void buildKategoriDialog(){
        final String[] kategories = new String[]{"JALAN, TIDUR, NONTON, KODING"};
        AlertDialog.Builder kategoriBuilder = new AlertDialog.Builder(getActivity());
        kategoriBuilder.setMultiChoiceItems(kategories, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                kategoriDialogObjek.cancel();
                switch (i) {
                    case 0:
                        spnGmbKategori = Tulis.Kategori.JALAN;
                        imageView.setImageResource(R.drawable.j);
                        break;
                    case 1:
                        spnGmbKategori = Tulis.Kategori.TIDUR;
                        imageView.setImageResource(R.drawable.t);
                        break;
                    case 2:
                        spnGmbKategori = Tulis.Kategori.NONTON;
                        imageView.setImageResource(R.drawable.n);
                        break;
                    case 3:
                        spnGmbKategori = Tulis.Kategori.KODING;
                        imageView.setImageResource(R.drawable.k);
                        break;
                }
            }
        });
        kategoriDialogObjek = kategoriBuilder.create();
    }

}
