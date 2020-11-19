package com.example.wordbook;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.wordbook.Model.Word;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

    public TextView name;
    public TextView explation;
    public TextView sentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        name=findViewById(R.id.Detail_Name);
        explation=findViewById(R.id.Detail_Explanation);
        sentence=findViewById(R.id.Detail_1);
        Intent intent = getIntent();
        Bundle word = intent.getBundleExtra("word");
        Word word1 = (Word)word.get("word");
        name.setText(word1.getWord());
        explation.setText(word1.getWord_Explation());
        sentence.setText(word1.getWord_Sentence());

        //Intent intent=new Intent(Detail.this,MainActivity.class);


    }
}
