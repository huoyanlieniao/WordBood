package com.example.wordbook;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wordbook.ContenProvider.Sql;
import com.example.wordbook.Fragment.BlankFragment;
import com.example.wordbook.Fragment.Word_List;
import com.example.wordbook.Fragment.Word_List_Adapter;
import com.example.wordbook.Model.Word;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //数据库
    Sql sql;
    //单词列表
    public ArrayList<Word> words=new ArrayList<>();

    public ContentResolver resolver;
    private String ur = "content://com.example.wordbook.ContenProvider/Word";
    Uri uri=Uri.parse(ur);
    public ListView listView;
    public static EditText input;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        resolver=this.getContentResolver();
        //创建数据库对象
        sql = new Sql(this,null,null,1);

        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏
            setContentView(R.layout.activity_main);
            Inqury("a");

            //替换界面
            BlankFragment blankFragment=new BlankFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Second_change,blankFragment)
                    .commit();

            /*Word_List_Adapter word_list_adapter = new Word_List_Adapter(words, MainActivity.this);
            listView=null;
            listView = findViewById(R.id.list_item);
            listView.setAdapter(word_list_adapter);
            listView.setOnItemClickListener(this);*/

            Word_List word_list=new Word_List(words);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.First_change,word_list)
                    .commit();


        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
            setContentView(R.layout.activity_main);
            input=findViewById(R.id.Inquiry_Input);
            listView=findViewById(R.id.Word_List);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void Inquiry(View view) {
        words.clear();
        //Toast.makeText(MainActivity.this,"查询",Toast.LENGTH_LONG).show();
        String wo=input.getText().toString();
        String select="Word like ?";
        String[] selectionArg={"%"+wo+"%"};
        String[] columns={"Word","WordExplation","WordSentence"};
        Cursor c=null;
        c=resolver.query(uri,columns,select,selectionArg,null,null);
        while(c.moveToNext()){
            String word=c.getString(c.getColumnIndex("Word"));
            String wordexplation=c.getString(c.getColumnIndex("WordExplation"));
            String wordsentence=c.getString(c.getColumnIndex("WordSentence"));
            Word word1=new Word(word,wordexplation,wordsentence);
            words.add(word1);
        }
        //Toast.makeText(MainActivity.this,""+words.get(0).Word,Toast.LENGTH_LONG).show();
        Word_List_Adapter word_list_adapter = new Word_List_Adapter(words, MainActivity.this);
        listView=null;
        listView = findViewById(R.id.Word_List);
        listView.setAdapter(word_list_adapter);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void Inqury(String s){
        words.clear();
        //Toast.makeText(MainActivity.this,"查询",Toast.LENGTH_LONG).show();
       // String wo=input.getText().toString();
        String select="Word like ?";
        String[] selectionArg={"%"+s+"%"};
        String[] columns={"Word","WordExplation","WordSentence"};
        Cursor c=null;
        c=resolver.query(uri,columns,select,selectionArg,null,null);
        while(c.moveToNext()){
            String word=c.getString(c.getColumnIndex("Word"));
            String wordexplation=c.getString(c.getColumnIndex("WordExplation"));
            String wordsentence=c.getString(c.getColumnIndex("WordSentence"));
            Word word1=new Word(word,wordexplation,wordsentence);
            words.add(word1);
        }

        //Toast.makeText(MainActivity.this,""+words.get(0).Word,Toast.LENGTH_LONG).show();
        //Word_List_Adapter word_list_adapter = new Word_List_Adapter(words, MainActivity.this);
      /*  listView=null;
        listView = findViewById(R.id.Word_List);
        listView.setAdapter(word_list_adapter);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);*/

    }
    //长按创建菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_content, menu);
    }
    //点击事件
    @RequiresApi(api = 30)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Toast.makeText(MainActivity.this,item.getItemId()+"",Toast.LENGTH_LONG).show();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int a=menuInfo.position;
        switch (item.getItemId()) {
            case R.id.Delete:
                Delete(words.get(a).getWord());
                words.remove(a);
                //调整界面
                ListView listView = findViewById(R.id.Word_List);
                Word_List_Adapter musicAdapter = new Word_List_Adapter(words, MainActivity.this);
                listView.setAdapter(musicAdapter);
                listView.setOnItemClickListener(this);
                break;

            case R.id.Update:

                Intent intent=new Intent(MainActivity.this,Add_Activity.class);
                Bundle bundle=new Bundle();
                Word word=words.get(a);
                bundle.putSerializable("word",word);
                intent.putExtra("word",bundle);
                startActivity(intent);

        }
        return super.onContextItemSelected(item);

    }


    @RequiresApi(api = 30)
    public void Delete(String w){
        //ContentValues values=new ContentValues();
        //values.put("Word",w);
        //Bundle bundle=new Bundle();
        //bundle.putString("word",w);
        //int delete = resolver.delete(uri,bundle);
        String[] a={w};
        resolver.delete(uri,"Word=?",a);

    }

    public void Activity_Add(View view) {

       ArrayList<Word> words=new ArrayList<>();
       //Word a=new Word(1,"Apple","fruit","Apple");
       // words.add(a);
      /*  for(int i=0;i<20;i++){
            if(i!=10) {
                Word a = new Word(i, i + "", "测试" + i, "这是测试" + i);
                words.add(a);
            }
        }*/
        //调整界面
        /*ListView listView = findViewById(R.id.Music_List);
        Music_Adapter musicAdapter = new Music_Adapter(words, MainActivity.this);
        listView.setAdapter(musicAdapter);
        listView.setOnItemClickListener(this);
*/
        Intent intent=new Intent(MainActivity.this,Add_Activity.class);
        startActivity(intent);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MainActivity.this,Detail.class);
        Bundle bundle=new Bundle();
        Word word=words.get(position);
        bundle.putSerializable("word",word);
        intent.putExtra("word",bundle);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }







}
