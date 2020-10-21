package com.example.wordbook;

import java.util.ArrayList;

/**
 * @author sun
 * @Classname Word
 * @TODN 要办的事
 * @Date 2020/10/8 8:48
 **/
public class Word {
   public String Word;
   public String Word_Explanation;
   public ArrayList<String> Word_Sentence;

    public Word(String word, String word_Explanation, ArrayList<String> word_Sentence) {
        Word = word;
        Word_Explanation = word_Explanation;
        Word_Sentence = word_Sentence;
    }

    public Word(String word) {
        Word = word;
    }

    public Word(String word, String word_Explanation) {
        Word = word;
        Word_Explanation = word_Explanation;
    }

    public Word(String word, ArrayList<String> word_Sentence) {
        Word = word;
        Word_Sentence = word_Sentence;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getWord_Explanation() {
        return Word_Explanation;
    }

    public void setWord_Explanation(String word_Explanation) {
        Word_Explanation = word_Explanation;
    }

    public ArrayList<String> getWord_Sentence() {
        return Word_Sentence;
    }

    public void setWord_Sentence(ArrayList<String> word_Sentence) {
        Word_Sentence = word_Sentence;
    }
}
