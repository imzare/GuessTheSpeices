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
    Button btngit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);


        db = new DBHandler(this);
        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.textView);
        btngit= findViewById(R.id.gitbutton);
        RefreshGrid();

        Intent intent = getIntent();
        String num = intent.getStringExtra("key");
        Log.d(num, "gotstr: ");
        textView.setText(num);








    }


    public void RefreshGrid() {
        List<quizResult> students = db.selectAllresults();

        ArrayAdapter<quizResult> arrayAdapter = new ArrayAdapter<>(ResultscreenActivity.this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(arrayAdapter);
    }




}