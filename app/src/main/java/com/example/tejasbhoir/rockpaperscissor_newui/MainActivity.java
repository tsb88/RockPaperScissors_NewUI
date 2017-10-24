package com.example.tejasbhoir.rockpaperscissor_newui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //rock = 0;
    //paper = 1;
    //scissor = 2;

    private int randNumber = 0;
    private int winCount = 0;
    private int lossCount = 0;
    private int drawCount = 0;
    ImageView image;
    Intent intent;
    Spinner spinner;

    public void setNumbers() {
        Random rand = new Random();
        randNumber = rand.nextInt(3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);

        spinner = (Spinner) findViewById(R.id.item_choice);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void resetScore (View view) {
        winCount = 0;
        lossCount = 0;
        drawCount = 0;
    }

    public void checkScore (View view) {
        intent = new Intent(this, Main2Activity.class);
        intent.putExtra("winCount", winCount);
        intent.putExtra("lossCount", lossCount);
        intent.putExtra("drawCount", drawCount);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setNumbers();
        String item = parent.getItemAtPosition(position).toString();
        TextView yourChoice = (TextView) findViewById(R.id.your_choice);
        yourChoice.setText(item);

        if(position == 1)
        {
            if (randNumber == 2)
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Scissor");
                image.setImageResource(R.drawable.scissors);
                Toast.makeText(this,"You Win!", LENGTH_SHORT).show();
                winCount++;
            }
            else if (randNumber == 0)
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Rock");
                image.setImageResource(R.drawable.rock);
                Toast.makeText(this,"Draw!", LENGTH_SHORT).show();
                drawCount++;
            }
            else
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Paper");
                image.setImageResource(R.drawable.paper);
                Toast.makeText(this,"You Lose!", LENGTH_SHORT).show();
                lossCount++;
            }
        }
        else if (position == 2)
        {
            if (randNumber == 0)
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Rock");
                image.setImageResource(R.drawable.rock);
                Toast.makeText(this,"You Win!", LENGTH_SHORT).show();
                winCount++;
            }
            else if (randNumber == 1)
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Paper");
                image.setImageResource(R.drawable.paper);
                Toast.makeText(this,"Draw!", LENGTH_SHORT).show();
                drawCount++;
            }
            else
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Scissor");
                image.setImageResource(R.drawable.scissors);
                Toast.makeText(this,"You Lose!", LENGTH_SHORT).show();
                lossCount++;
            }
        }
        else if (position == 3)
        {
            if (randNumber == 1)
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Paper");
                image.setImageResource(R.drawable.paper);
                Toast.makeText(this,"You Win!", LENGTH_SHORT).show();
                winCount++;
            }
            else if (randNumber == 2)
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Scissor");
                image.setImageResource(R.drawable.scissors);
                Toast.makeText(this,"Draw!", LENGTH_SHORT).show();
                drawCount++;
            }
            else
            {
                TextView ai_choice = (TextView) findViewById(R.id.AI_choice);
                ai_choice.setText("Rock");
                image.setImageResource(R.drawable.rock);
                Toast.makeText(this,"You Lose!", LENGTH_SHORT).show();
                lossCount++;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> empty) {

    }
}
