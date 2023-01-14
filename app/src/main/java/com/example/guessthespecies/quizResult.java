package com.example.guessthespecies;

import java.util.Date;

public class quizResult {

   // Date datetime;
    String SelectedAns;
    String CorrectAns;
    boolean isCorrect;

    public quizResult( String selectedAns, String correctAns, boolean isCorrect) {
      //  this.datetime = datetime;
        SelectedAns = selectedAns;
        CorrectAns = correctAns;
        this.isCorrect = isCorrect;
    }

    public quizResult() {
     //   this.datetime = null;
        SelectedAns = "";
        CorrectAns = "";
        this.isCorrect = false;
    }

/*    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }*/

    public String getSelectedAns() {
        return SelectedAns;
    }

    public void setSelectedAns(String selectedAns) {
        SelectedAns = selectedAns;
    }

    public String getCorrectAns() {
        return CorrectAns;
    }

    public void setCorrectAns(String correctAns) {
        CorrectAns = correctAns;
    }

    public boolean getisCorrect() {
        return isCorrect;
    }

    public void setisCorrect(boolean correct) {
        isCorrect = correct;
    }



    @Override
    public String toString() {
        return "Selected=" + SelectedAns + ", Correct=" + CorrectAns + ", Score=" + isCorrect ;
    }

}
