package com.example.wordbook.Model;

public class Word {
    public int Word_Id;
    public String Word;
    public String Word_Explation;
    public String[] Word_Sentence;

    public Word(int word_Id, String word) {
        Word_Id = word_Id;
        Word = word;
    }


    public Word() {

    }

    public Word(String word) {
        Word = word;
    }

    public Word(int word_Id, String word, String word_Explation, String[] word_Sentence) {
        Word_Id = word_Id;
        Word = word;
        Word_Explation = word_Explation;
        Word_Sentence = word_Sentence;
    }

    public int getWord_Id() {
        return Word_Id;
    }

    public void setWord_Id(int word_Id) {
        Word_Id = word_Id;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getWord_Explation() {
        return Word_Explation;
    }

    public void setWord_Explation(String word_Explation) {
        Word_Explation = word_Explation;
    }

    public String[] getWord_Sentence() {
        return Word_Sentence;
    }

    public void setWord_Sentence(String[] word_Sentence) {
        Word_Sentence = word_Sentence;
    }
}