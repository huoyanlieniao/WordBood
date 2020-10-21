package com.example.wordbook;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
