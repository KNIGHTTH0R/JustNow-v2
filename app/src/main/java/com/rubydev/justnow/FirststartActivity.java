package com.rubydev.justnow;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirststartActivity extends AppCompatActivity {
    TextView tvBBCnews, tvBBCsport, tvBI, tvFortune, tvMashable, tvCNN, tvNatgeo, tvTC;
    int sButton; // counter untuk memastikan bahwa ada 1 news provider yang terpilih
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firststart);
        sButton = 0;
        findViewById();
    }

    void findViewById() {
        tvBBCnews = (TextView) findViewById(R.id.tvBBCnews);
        tvBBCnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBBCnews.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvBBCnews.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvBBCnews.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvBBCnews.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvBBCnews.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvBBCsport = (TextView) findViewById(R.id.tvBBCsport);
        tvBBCsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBBCsport.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvBBCsport.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvBBCsport.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvBBCsport.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvBBCsport.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvBI = (TextView) findViewById(R.id.tvBI);
        tvBI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBI.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvBI.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvBI.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvBI.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvBI.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }
                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvFortune = (TextView) findViewById(R.id.tvFortune);
        tvFortune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvFortune.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvFortune.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvFortune.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvFortune.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvFortune.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvMashable = (TextView) findViewById(R.id.tvMashable);
        tvMashable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvMashable.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvMashable.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvMashable.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvMashable.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvMashable.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvCNN = (TextView) findViewById(R.id.tvCNN);
        tvCNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvCNN.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvCNN.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvCNN.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvCNN.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvCNN.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvNatgeo = (TextView) findViewById(R.id.tvNatgeo);
        tvNatgeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvNatgeo.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvNatgeo.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvNatgeo.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvNatgeo.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvNatgeo.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvTC = (TextView) findViewById(R.id.tvTechCrunch);
        tvTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvTC.getCurrentTextColor() == (ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite))) {
                    tvTC.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorBlack));
                    tvTC.setBackgroundResource(R.drawable.checkboxbg_clicked);
                    sButton++;
                } else {
                    tvTC.setTextColor(ContextCompat.getColor(FirststartActivity.this, R.color.colorWhite));
                    tvTC.setBackgroundResource(R.drawable.checkboxbg);
                    sButton--;
                }

                if (sButton > 0) {
                    btnFinish.setVisibility(View.VISIBLE);
                } else {
                    btnFinish.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
