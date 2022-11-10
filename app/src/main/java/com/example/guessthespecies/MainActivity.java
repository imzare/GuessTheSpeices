package com.example.guessthespecies;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] animals = {"Lion","Panda","Giraffe","Dog","Cheetah","Elephant","Snake"};
    String [] birds = {"Parrot","Eagle","Vulture","penguin","Hawk","Turkey","Hen","Quail","Raven","Duck"};
    String [] insects = {"Ant","Cockroach","Mantis","Housefly","Bee"};
    Button btnOfAnimal, btnOfBird, btnOfInsect;
    TextView textView, textViewAnswer, textViewAnimalInformation,
            TextViewBirdInformation, TextViewInsectInformation;
    int catagory = 0, index=0, animalCorrectCount, animalWrongCount,
            birdCorrectCount, birdWrongCount, insectCorrectCount, insectWrongCount;
    String answer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.organismName);
        btnOfAnimal = findViewById(R.id.btnAnimal);
        btnOfAnimal.setOnClickListener(this);
        btnOfBird = findViewById(R.id.btnBird);
        btnOfBird.setOnClickListener(this);
        btnOfInsect = findViewById(R.id.btnInsect);
        btnOfInsect.setOnClickListener(this);
        textViewAnswer = findViewById(R.id.textViewResult);
        textViewAnimalInformation = findViewById(R.id.textViewResultAnimal);
        TextViewBirdInformation = findViewById(R.id.textViewResultBird);
        TextViewInsectInformation = findViewById(R.id.textViewResultInsect);

        GenerateSpecie();


    }

    private void GenerateSpecie() {
        Random rnd = new Random();
        catagory = rnd.nextInt(3);
        if (catagory ==0){
            index = rnd.nextInt(animals.length);
            textView.setText(animals[index]);
            answer = "animals";
        } else if (catagory ==1){
            index = rnd.nextInt(birds.length);
            textView.setText(birds[index]);
            answer = "birds";
        }else if (catagory ==2){
            index = rnd.nextInt(insects.length);
            textView.setText(insects[index]);
            answer = "insects";
        }
    }



}

