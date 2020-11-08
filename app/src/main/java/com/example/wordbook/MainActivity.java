package com.example.wordbook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wordbook.Fragment.BlankFragment;
import com.example.wordbook.Fragment.Word_List;
import com.example.wordbook.Model.Word;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏
            setContentView(R.layout.activity_main);

            //数据
            ArrayList<Word> word = new ArrayList<>();
            for(int i=0;i<20;i++){
                Word word1=new Word(i+"");
                word.add(word1);
            }

            //替换界面
            BlankFragment blankFragment=new BlankFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Second_change,blankFragment)
                    .commit();

            Word_List word_list=new Word_List(getFragmentManager(),word);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.First_change,word_list)
                    .commit();




        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
            setContentView(R.layout.activity_main);
        }

    }

    public void Inquiry(View view) {
        Intent intent=new Intent(MainActivity.this,Detail.class);
        startActivity(intent);
    }

   @Override
   public boolean onCreateOptionsMenu(Menu menu){
     MenuInflater menuInflater=new MenuInflater(this);
     menuInflater.inflate(R.menu.menu,menu);
     return true;
   }

    public void Activity_Add(View view) {
        Intent intent=new Intent(MainActivity.this,Add_Activity.class);
        startActivity(intent);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
     super.onCreateContextMenu(menu, v, menuInfo);
     MenuInflater inflater = getMenuInflater();
     inflater.inflate(R.menu.longenter, menu);
     }


}
