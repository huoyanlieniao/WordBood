package com.example.wordbook.ContenProvider;

import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class Sql extends SQLiteOpenHelper {

    public static String SqlName="WordBook.db";
    private static final int Word=0;
    private static final int WordId=1;
    private static final int WordExplation=2;
    private static final int WordSentence=3;
    private static String TableName="Word";



    private Context mContext;

    public Sql(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Sql(Context context) {
        //上下文、名称、版本
        super(context,SqlName,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建单词本语句
        String CREAT ="CREATE TABLE "+TableName+"("
                        + "WordId PRIMARY KEY,"
                        + "Word,"+"WordExplation,"
                        + "WordSentence)";

        db.execSQL(CREAT);
      //  Toast.makeText(mContext,"创建数据表成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}