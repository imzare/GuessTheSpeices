package com.example.guessthespecies;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] animals = {"Lion","Panda","Giraffe","Dog","Cheetah","Elephant","Snake","Fox", "Gorilla", "Wolf", "Badger", "Zebra", "Rabbit", "Koala"};
    String [] birds = {"Parrot","Eagle","Vulture","penguin","Hawk","Turkey","Hen","Quail","Raven","Duck","Crow", "Falcon", "Peacock", "Emu", "Kingfisher"};
    String [] insects = {"Ant","Cockroach","Mantis","Housefly","Bee", "Centipede", "Ladybird", "Beetle", "Lice", "Butterfly", "Cricket", "Silverfish"};
    String [] marines ={"Octopus", "Squid", "Goldfish", "Shark", "Whale", "Eel", "Shrimp", "Starfish", "Dolphin", "Sea lion", "Turtle", "Angler fish"};
    Button btnOfAnimal, btnOfBird, btnOfInsect, btnOfMarine;
    TextView textView, textViewAnswer, textViewAnimalInformation,
            TextViewBirdInformation, TextViewInsectInformation, TextViewMarineInformation, TextViewCorrect;
    int category = 0, index=0, animalCorrectCount, animalWrongCount,
            birdCorrectCount, birdWrongCount, insectCorrectCount, insectWrongCount, marineCorrectCount, marineWrongCount;
    String answer = "";
    Boolean flag = true;


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
        btnOfMarine = findViewById(R.id.btnMarine);
        btnOfMarine.setOnClickListener(this);
        textViewAnswer = findViewById(R.id.textViewResult);
        textViewAnimalInformation = findViewById(R.id.textViewResultAnimal);
        TextViewBirdInformation = findViewById(R.id.textViewResultBird);
        TextViewInsectInformation = findViewById(R.id.textViewResultInsect);
        TextViewMarineInformation = findViewById(R.id.textViewResultMarine);
        TextViewCorrect = findViewById(R.id.CorrectAnswer);
        TextViewCorrect.setText("Have Fun!" );

        GenerateSpecie();


    }

    private void GenerateSpecie() {
        Random rnd = new Random();
        category = rnd.nextInt(4);
        if (category ==0){
            index = rnd.nextInt(animals.length);
            textView.setText(animals[index]);
            answer = "Animal";
        } else if (category ==1){
            index = rnd.nextInt(birds.length);
            textView.setText(birds[index]);
            answer = "Bird";
        }else if (category ==2){
            index = rnd.nextInt(insects.length);
            textView.setText(insects[index]);
            answer = "Insect";
        }
     else if (category ==3){
        index = rnd.nextInt(marines.length);
        textView.setText(marines[index]);
        answer = "Marine";
    }
      RandomAns();
       RandomcolorButton();

    }

    private void RandomAns() {
        Button[] listofbuttonClasses = {btnOfAnimal, btnOfBird, btnOfInsect, btnOfMarine};
        String[] listofbuttontext = {"Animal", "Bird", "Insect", "Marine"};


        ArrayList<Integer> rnd = new ArrayList<>();

        Random randomizer = new Random();

        int i = 0;
        while (i < 4) {
            int storeRandomIntValue = randomizer.nextInt(4);


            if (!rnd.contains(storeRandomIntValue)) {
                listofbuttonClasses[i].setText(listofbuttontext[storeRandomIntValue]);
                i++;
                rnd.add(storeRandomIntValue);

            }

        }


    }


    private void RandomcolorButton() {
        Button[] listofbuttonClasses = {btnOfAnimal, btnOfBird, btnOfInsect, btnOfMarine};
        ArrayList<Integer> rnd = new ArrayList<>();
        Random random = new Random();

        int i = 0;
        while (i < 4) {
           // int storeRandomColor= randomizer.nextInt(254);


            int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

            if (!rnd.contains(color)) {
                listofbuttonClasses[i].setBackgroundColor(color);
                i++;
                 rnd.add(color);
            }


        }


    }


    public void ShowComments() {
        int index = 0;
        int category1 = 0;
        String[] good = {"Great", "Fantastic", "Fabulous", "Cool", "Impressive", "Outstanding", "fanciful"};
        String[] bad = {"Wrong", "Oops", "sad", "Incorrect", "Mistaken", "inaccurate", "False", "Invalid"};
        Random rnd = new Random();


        if (flag) {
            index = rnd.nextInt(good.length);
            textViewAnswer.setText(good[index]);
            textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.highlighted_text_material_light));

            TextViewCorrect.setText("Correct :)");

        } else {

            index = rnd.nextInt(bad.length);
            textViewAnswer.setText(bad[index]);
            textViewAnswer.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.m3_ref_palette_tertiary50));

            TextViewCorrect.setText("Correct answer is: " + answer);

        }

    }
        @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnAnimal:
                Button temp=findViewById(R.id.btnAnimal);
                if (temp.getText().toString().equals(answer)) {
                   flag = true;
                   ShowComments();
                    animalCorrectCount++;

                } else {
                    flag = false;
                    ShowComments();
                    animalWrongCount++;
                }
                textViewAnimalInformation.setText("Animals\nRight " + animalCorrectCount + "\nWrong " + animalWrongCount);
                break;
            case R.id.btnBird:
                 temp=findViewById(R.id.btnBird);
                if (temp.getText().toString().equals(answer)) {
                    flag = true;
                    ShowComments();
                    birdCorrectCount++;
                } else {
                    flag = false;
                    ShowComments();
                    birdWrongCount++;
                }
                TextViewBirdInformation.setText("Birds\nRight " + birdCorrectCount + "\nWrong " + birdWrongCount);
                break;
            case R.id.btnInsect:
                 temp=findViewById(R.id.btnInsect);
                if (temp.getText().toString().equals(answer)) {
                    flag = true;
                    ShowComments();
                    insectCorrectCount++;
                } else {
                    flag = false;
                    ShowComments();
                    insectWrongCount++;
                }
                TextViewInsectInformation.setText("Insects\nRight " + insectCorrectCount + "\nWrong " + insectWrongCount);
                break;
            case R.id.btnMarine:
                 temp=findViewById(R.id.btnMarine);
                if (temp.getText().toString().equals(answer)) {
                    flag = true;
                    ShowComments();
                    marineCorrectCount++;
                } else {
                    flag = false;
                    ShowComments();
                    marineWrongCount++;
                }
                TextViewMarineInformation.setText("Marines\nRight " + marineCorrectCount + "\nWrong " + marineWrongCount);
                break;
        }
        GenerateSpecie();
    }

}

