
//TANGGAL PENGERJAAN
//MINGGU 19 MEI 2019, 10116313, KEMAS RISMAN FAUZAN, IF-7

package com.kemasrisman.uts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//Tanggal : 11 mei 2020
// NIM    : 10117112
// Nama   : Faksi Kilat Buana Arifin Putra
// Kelas  : IF-3

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}