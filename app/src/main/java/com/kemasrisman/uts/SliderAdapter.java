package com.kemasrisman.uts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


//Tanggal : 11 mei 2020
// NIM    : 10117112
// Nama   : Faksi Kilat Buana Arifin Putra
// Kelas  : IF-3


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.list,
            R.drawable.data,
            R.drawable.project
    };


    public String[] slide_headings = {
        "UTS AKB",
        "FUNGSI",
        "LET'S START"
    };

    public String[] slide_descs = {
            "Aplikasi ini dibuat untuk memenuhi tugas mata kuliah Aplikasi Komputer Bergerak",
            "Fungsi Utama dari aplikasi ini adalah untuk menampilkan profil dan kontak teman dengan menggunakan data dummy",
            ""
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);


    }
}
