package com.androidlokomedia.k;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class KlistFragment extends ListFragment {

    private ArrayList<Tulis> tulises;
    private Kadapter kadapter;


    public KlistFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tulises = new ArrayList<Tulis>();
        tulises.add(new Tulis("ini judul kegiatan","ini keterangan kegiatan", Tulis.Kategori.JALAN));

        kadapter = new Kadapter(getActivity(), tulises);
        setListAdapter(kadapter);

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        launchDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int rowposisi = info.position;
        switch (item.getItemId()) {
            case R.id.edit:
                Log.d("Tag", "onContextItemSelected: ");
                launchDetailActivity(MainActivity.FragmentToLaunch.EDIT,rowposisi);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void launchDetailActivity(MainActivity.FragmentToLaunch ftl, int posisi){
        Tulis tulis = (Tulis) getListAdapter().getItem(posisi);
        Intent intent = new Intent(getActivity(), KdetailActivity.class);
        intent.putExtra(MainActivity.K_JUDUL_EXTRA, tulis.getJudul());
        intent.putExtra(MainActivity.K_KETERANGAN_EXTRA, tulis.getKeterangan());
        intent.putExtra(MainActivity.K_KATEGORI_EXTRA, tulis.getKategori());
        intent.putExtra(MainActivity.K_ID_EXTRA, tulis.getId());

        switch (ftl){
            case VIEW:
                intent.putExtra(MainActivity.K_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(MainActivity.K_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT);
                break;
        }

        startActivity(intent);
    }
}
