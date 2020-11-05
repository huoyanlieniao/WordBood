package com.example.wordbook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏
            setContentView(R.layout.activity_main);
            BlankFragment blankFragment=new BlankFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.aaaaa,blankFragment)
                    .commit();
            Toast.makeText(MainActivity.this,"aaaa",Toast.LENGTH_LONG).show();

            Wordlist wordlist=new Wordlist();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bbbb,wordlist)
                    .commit();

        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
            setContentView(R.layout.activity_main);
        }
        //setContentView(R.layout.activity_main);

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
