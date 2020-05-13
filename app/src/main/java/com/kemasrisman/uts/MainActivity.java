package com.kemasrisman.uts;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//Tanggal : 11 mei 2020
// NIM    : 10117112
// Nama   : Faksi Kilat Buana Arifin Putra
// Kelas  : IF-3
public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button  mNextBtn;
    private  Button mBackBtn;
    private Button mFinishBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mFinishBtn = (Button) findViewById(R.id.finishBtn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //OnClick
        mNextBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        }));

        mBackBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        }));

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWizardActivity = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.finish();
                startActivity(intentWizardActivity);
            }
        });


    }

//    TANGGAL PENGERJAAN
//    SELASA 21 MEI 2019, 10116313, KEMAS RISMAN FAUZAN, IF-7
    public void addDotsIndicator(int position){

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i< mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage = i;

            if(i == 0){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mFinishBtn.setEnabled(false);

                mBackBtn.setVisibility(View.INVISIBLE);
                mFinishBtn.setVisibility(View.GONE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");

            }else if(i == mDots.length-1){

                mNextBtn.setEnabled(false);
                mBackBtn.setEnabled(true);
                mFinishBtn.setEnabled(true);

                mBackBtn.setVisibility(View.VISIBLE);
                mFinishBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.GONE);

                mBackBtn.setText("Back");

            }
            else {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mFinishBtn.setEnabled(false);

                mBackBtn.setVisibility(View.VISIBLE);
                mFinishBtn.setVisibility(View.GONE);
                mNextBtn.setVisibility(View.VISIBLE);


                mNextBtn.setText("Next");
                mBackBtn.setText("Back");

            }



        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}
