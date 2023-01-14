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
    int category = 0, index=0, animalCorrectCount=0, animalWrongCount=0,
            birdCorrectCount=0, birdWrongCount=0, insectCorrectCount=0, insectWrongCount=0, marineCorrectCount=0, marineWrongCount=0;
    String answer = "";
    Boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.organismName);
        btnOfAnimal = findViewById(R.id.btn1);
        btnOfAnimal.setOnClickListener(this);
        btnOfBird = findViewById(R.id.btn2);
        btnOfBird.setOnClickListener(this);
        btnOfInsect = findViewById(R.id.btn3);
        btnOfInsect.setOnClickListener(this);
        btnOfMarine = findViewById(R.id.btn4);
        btnOfMarine.setOnClickListener(this);
        textViewAnswer = findViewById(R.id.textViewResult);
        textViewAnimalInformation = findViewById(R.id.textViewResultAnimal);
        TextViewBirdInformation = findViewById(R.id.textViewResultBird);
        TextViewInsectInformation = findViewById(R.id.textViewResultInsect);
        TextViewMarineInformation = findViewById(R.id.textViewResultMarine);
        TextViewCorrect = findViewById(R.id.CorrectAnswer);
        TextViewCorrect.setText("Have Fun!" );

        GenerateSpecie();
        RandomcolorButton();


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
RandomcolorMainTextView();


    }

    public void RandomAns() {
        Button[] listofbuttonClasses = {btnOfAnimal, btnOfBird, btnOfInsect, btnOfMarine};
        String[] listofbuttontext = {"Animal", "Bird", "Insect", "Marine"};
        TextView[] listofresults = {textViewAnimalInformation, TextViewBirdInformation, TextViewInsectInformation, TextViewMarineInformation};
        int[] count= {animalCorrectCount, birdCorrectCount, insectCorrectCount, marineCorrectCount};
        int[] count1= {animalWrongCount, birdWrongCount, insectWrongCount, marineWrongCount};

        ArrayList<Integer> rnd = new ArrayList<>();

        Random randomizer = new Random();
        Random random = new Random();


        int i = 0;
        while (i < 4) {
            int storeRandomIntValue = randomizer.nextInt(4);


            if (!rnd.contains(storeRandomIntValue)) {
                listofbuttonClasses[i].setText(listofbuttontext[storeRandomIntValue]);
                listofresults[i].setText(listofbuttontext[i] +"\nRight "+ count[i] + "\nWrong " + count1[i]);
                listofresults[i].setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));


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

    private void RandomcolorMainTextView() {
        TextView[] listofbuttonClasses = {textView};
        ArrayList<Integer> rnd = new ArrayList<>();
        Random random = new Random();

        int i = 0;
        while (i < 1) {
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
        Random random = new Random();
        int color1 = Color.argb(100, 0,255 ,0 );
        int color2 = Color.argb(150, 255,0 ,0 );


        if (flag) {
            index = rnd.nextInt(good.length);
            textViewAnswer.setText(good[index]);
            textViewAnswer.setBackgroundColor(color1);

            TextViewCorrect.setText("Correct :)");

        } else {

            index = rnd.nextInt(bad.length);
            textViewAnswer.setText(bad[index]);
            textViewAnswer.setBackgroundColor(color2);

            TextViewCorrect.setText("Correct answer is: " + answer);

        }

        TextViewCorrect.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));

    }


    public void showCorrectResult(String answer){
        switch(answer){
            case "Animal":
                animalCorrectCount++;
                break;
            case "Bird":
                birdCorrectCount++;
                break;
            case "Insect":
                insectCorrectCount++;
                break;
            case "Marine":
                marineCorrectCount++;
                break;

        }}


    public void showWrongResult(String answer){
        switch(answer){
            case "Animal":
                animalWrongCount++;
                break;
            case "Bird":
                birdWrongCount++;
                break;
            case "Insect":
                insectWrongCount++;
                break;

            case "Marine":
                marineWrongCount++;
                break;
        }}
        @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Button temp=findViewById(R.id.btn1);
                if (temp.getText().toString().equals(answer)) {
                   flag = true;
                   ShowComments();
                   showCorrectResult(temp.getText().toString());
                } else {
                    flag = false;
                    ShowComments();
                    showWrongResult(temp.getText().toString());
                }
                break;
            case R.id.btn2:
                 temp=findViewById(R.id.btn2);
                if (temp.getText().toString().equals(answer)) {
                    flag = true;
                    ShowComments();
                    showCorrectResult(temp.getText().toString());
                } else {
                    flag = false;
                    ShowComments();
                    showWrongResult(temp.getText().toString());
                }
                break;
            case R.id.btn3:
                 temp=findViewById(R.id.btn3);
                if (temp.getText().toString().equals(answer)) {
                    flag = true;
                    ShowComments();
                    showCorrectResult(temp.getText().toString());
                } else {
                    flag = false;
                    ShowComments();
                    showWrongResult(temp.getText().toString());
                }
                break;
            case R.id.btn4:
                 temp=findViewById(R.id.btn4);
                if (temp.getText().toString().equals(answer)) {
                    flag = true;
                    ShowComments();
                    showCorrectResult(temp.getText().toString());
                } else {
                    flag = false;
                    ShowComments();
                    showWrongResult(temp.getText().toString());
                }

                break;
        }
        GenerateSpecie();
    }

}

//hellow