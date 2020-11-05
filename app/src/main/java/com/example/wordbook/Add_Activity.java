package com.example.wordbook;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Add_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
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


    }

    /**
     * @Author sun
     * @Description 取消按钮
     * @Date 8:13 2020/10/21
     * @Param [view]
     * @return void
     **/
    public void Add_False(View view){
           Intent intent=new Intent(Add_Activity.this,MainActivity.class);
           startActivity(intent);
    }


}
