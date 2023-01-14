package com.example.guessthespecies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ResultscreenActivity extends AppCompatActivity {


    DBHandler db;
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);


        db = new DBHandler(this);
        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.textView);
        RefreshGrid();
        MainActivity ma = new MainActivity();
        int s= ma.Score();
        String N = Integer.toString(s);
        textView.setText("Score="+N);



    }


    public void RefreshGrid() {
        List<quizResult> students = db.selectAllresults();

        ArrayAdapter<quizResult> arrayAdapter = new ArrayAdapter<>(ResultscreenActivity.this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(arrayAdapter);
    }

}