package com.androidlokomedia.k;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class KdetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kdetail);
        buatDanTambahFragment();
    }

    public void buatDanTambahFragment(){
        Intent intent = getIntent();
        MainActivity.FragmentToLaunch fragmentToLaunch = (MainActivity.FragmentToLaunch)intent.getSerializableExtra(MainActivity.K_FRAGMENT_TO_LOAD_EXTRA);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (fragmentToLaunch) {
            case EDIT:
                EditFragment editFragment = new EditFragment();
                setTitle("Edit K");
                fragmentTransaction.add(R.id.k_kontaianer, editFragment, "K_EDIT_FRAGMENT");
                break;
            case VIEW:
                ViewFragment viewFragment = new ViewFragment();
                setTitle(R.string.viewDetailFragment);
                fragmentTransaction.add(R.id.k_kontaianer, viewFragment, "K_view_fragment");
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }
}
