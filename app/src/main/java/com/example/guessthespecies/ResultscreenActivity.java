package com.example.guessthespecies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ResultscreenActivity extends AppCompatActivity {


    DBHandler db;
    ListView listView;
    TextView textView;
    Button btngit, btnshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);


        db = new DBHandler(this);
        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.textView);
        btngit= findViewById(R.id.gitbutton);
        btnshare= findViewById(R.id.sharebutton);
        RefreshGrid();

        Intent intent = getIntent();
        String num = intent.getStringExtra("key");
        Log.d(num, "gotstr: ");
        textView.setText(num);




        btngit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://github.com/Ravian001/GuessTheSpeices/commits/master");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });



        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, num);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



    }


    public void RefreshGrid() {
        List<quizResult> students = db.selectAllresults();

        ArrayAdapter<quizResult> arrayAdapter = new ArrayAdapter<>(ResultscreenActivity.this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(arrayAdapter);
    }




}