package com.kemasrisman.uts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


//Tanggal : 11 mei 2020
// NIM    : 10117112
// Nama   : Faksi Kilat Buana Arifin Putra
// Kelas  : IF-3

public class Main2Activity extends AppCompatActivity {

    private String phone = "+6289686050582";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new MeFragment()).commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_me:
                    selectedFragment = new MeFragment();
                    break;
                case R.id.nav_information:
                    selectedFragment = new InfoFragment();
                    break;
                case R.id.nav_contact:
                    selectedFragment = new ContactFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }
    };



    public void telepon (View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }

    public void email (View view){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:kemasrisman17@gmail.com"));
        startActivity(Intent.createChooser(emailIntent, "Send feedback"));
    }

    public void instagram (View view){
        Uri uri = Uri.parse("http://instagram.com/_u/kemasrismaan");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/kemasrismaan")));
        }
    }




}
