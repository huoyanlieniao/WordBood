package com.example.wordbook;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.wordbook.Model.Word;

import java.util.ArrayList;

public class Add_Activity extends AppCompatActivity {


    public ArrayList<EditText> sentence=new ArrayList<>();
    public ArrayList<EditText> explation=new ArrayList<>();
    public ArrayList<EditText> chinese=new ArrayList<>();
    public ContentResolver resolver;


    //单词列表
    private String uri = "content://com.example.wordbook.ContenProvider/Word";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        resolver=this.getContentResolver();
        Update();

    }

    /**
     * @Author sun
     * @Description 给添加句子的linelayout添加
     * @Date 19:47 2020/10/20
     * @Param [view]
     * @return void
     **/
    public void Add_Sentence(View view){
        //获取linearout
        LinearLayout linear=findViewById(R.id.lsentence);
        //创建Edittext
        EditText editText=new EditText(this);
        editText.setHint("请添加例句");
        linear.addView(editText);
        sentence.add(editText);
        Add_Chinese(view);
    }

    /**
     * @Author sun
     * @Description 添加例句汉语
     * @Date 8:11 2020/10/21
     * @Param [view]
     * @return void
     **/
    public void Add_Chinese(View view){
        //获取linearout
        LinearLayout linear=findViewById(R.id.lchinese);
        //创建Edittext
        EditText editText=new EditText(this);
        editText.setHint("请添加释义");
        chinese.add(editText);
        linear.addView(editText);
    }


    /**
     * @Author sun
     * @Description 添加解释
     * @Date 7:54 2020/10/21
     * @Param [view]
     * @return void
     **/
    public void Add_Explanation(View view){
        //获取linearout
        LinearLayout linear=findViewById(R.id.lexplanation);
        //创建Edittext
        EditText editText=new EditText(this);
        editText.setHint("请添加释义");
        explation.add(editText);
        linear.addView(editText);
    }

    /**
     * @Author sun
     * @Description 确定按钮
     * @Date 8:12 2020/10/21
     * @Param [view]
     * @return void
     **/
    public void Add_True(View view){
        String chinese1="";
        String explation1="";
        String sentence1="";
        for(int i=0;i<chinese.size();i++){
            chinese1=chinese.get(i).getText().toString()+";";
        }
        for(int i=0;i<explation.size();i++){
            explation1=explation.get(i).getText().toString()+";";
        }
        for(int i=0;i<sentence.size();i++){
            sentence1=sentence.get(i).getText().toString()+";";
        }

        EditText editText=findViewById(R.id.Add_Add_Name);
        Uri Uri1=Uri.parse(uri);
        ContentValues values=new ContentValues();
        values.put("Word",editText.getText().toString());
        values.put("WordSentence",sentence1);
        values.put("WordExplation",explation1);
        Uri insert = resolver.insert(Uri1, values);
        Toast.makeText(Add_Activity.this,insert+"",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(Add_Activity.this,MainActivity.class);
        startActivity(intent);

    }

    /**
     * @Author sun
     * @Description 更新按钮
     * @Date 8:13 2020/10/21
     * @Param [view]
     * @return void
     **/
    @RequiresApi(api = 30)
    public void Add_False(View view){

        String chinese1="";
        String explation1="";
        String sentence1="";
        for(int i=0;i<chinese.size();i++){
            chinese1=chinese.get(i).getText().toString()+";";
        }
        for(int i=0;i<explation.size();i++){
            explation1=explation.get(i).getText().toString()+";";
        }
        for(int i=0;i<sentence.size();i++){
            sentence1=sentence.get(i).getText().toString()+";";
        }

        EditText editText=findViewById(R.id.Add_Add_Name);
        Uri Uri1=Uri.parse(uri);
        ContentValues values=new ContentValues();
        values.put("Word",editText.getText().toString());
        values.put("WordSentence",sentence1);
        values.put("WordExplation",explation1);
        String selection="Word=?";
        String[] a={editText.getText().toString()};
        resolver.update(Uri1,values,selection,a);

        Intent intent=new Intent(Add_Activity.this,MainActivity.class);
           startActivity(intent);



    }

    public void Update(){
        Intent intent = getIntent();

        Bundle word = intent.getBundleExtra("word");
        if(word!=null) {
            EditText e=findViewById(R.id.Add_Add_Name);
            e.setHint("");
            Word word1 = (Word) word.get("word");
            LinearLayout linear1 = findViewById(R.id.lsentence);
            LinearLayout linear3 = findViewById(R.id.lexplanation);
            e.setText(word1.getWord());
            //创建Edittext
            EditText editText1 = new EditText(this);
            String s=word1.getWord_Explation();
            editText1.setText(s);
            linear3.addView(editText1);

            EditText editText2 = new EditText(this);
            s=word1.getWord_Sentence();
            editText2.setText(s);
            linear1.addView(editText2);
        }

    }

}
