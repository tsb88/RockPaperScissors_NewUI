package com.example.tejasbhoir.rockpaperscissor_newui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int z = 0; int x = 0; int y = 0;
        int lossCount = intent.getIntExtra("lossCount", y);
        int winCount = intent.getIntExtra("winCount", x);
        int drawCount = intent.getIntExtra("drawCount", z);
        int netScoreInt = winCount - lossCount;

        TextView winCounter = (TextView) findViewById(R.id.winCounter);
        TextView lossCounter = (TextView) findViewById(R.id.lossCounter);
        TextView drawCounter = (TextView) findViewById(R.id.drawCounter);
        TextView netScore = (TextView) findViewById(R.id.netScore);
        winCounter.setText(winCount + "");
        lossCounter.setText(lossCount + "");
        drawCounter.setText(drawCount + "");
        netScore.setText(netScoreInt + "");
    }

    public void done(View view) {
        finish();
    }
}
