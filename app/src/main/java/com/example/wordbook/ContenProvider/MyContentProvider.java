package com.example.wordbook.ContenProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public static String SqlName="WordBook.db";
    private static final int Word=0;
    private static final int WordId=1;
    private static final int WordExplation=2;
    private static final int WordSentence=3;
    private static String TableName="Word";
    private static final String mAuthoritiesname="com.example.wordbook.ContenProvider";
    private static final UriMatcher Uri=new UriMatcher(UriMatcher.NO_MATCH);
    private SQLiteDatabase db;

    //构建uri
    static{
        //
        Uri.addURI(mAuthoritiesname,"Word",Word);
        //#代表任意数字
        Uri.addURI(mAuthoritiesname,"Word/#",WordExplation);
        //*代表任意文本
        Uri.addURI(mAuthoritiesname,"Word/filter/*",WordSentence);
    }

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int deletedRows=0;
        switch (Uri.match(uri)){
            case Word:
                deletedRows = db.delete(TableName,selection,selectionArgs);
                break;
            case WordId:
                String notesID = uri.getPathSegments().get(1);
                deletedRows =db.delete(TableName,"_id=?",new String[]{notesID});
                break;
        }
        return  deletedRows;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
       int match=Uri.match(uri);
       switch (match){
           case Word:
               long id=db.insert(TableName,null,values);
               return ContentUris.withAppendedId(uri,id);
       }
        return null;
    }

    @Override
    public boolean onCreate() {
        Sql sql=new Sql(getContext());
        db=sql.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        //过滤uri
        int match=Uri.match(uri);

        switch (match){
            case Word:
                return db.query(TableName,projection,selection,selectionArgs,null,null,sortOrder);

            case WordId:
                return db.query(TableName,projection,selection,selectionArgs,null,null,sortOrder);


        }
        return null;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int updataRows =0;
        switch (Uri.match(uri)){
            case Word:
                updataRows =db.update(TableName,values,selection,selectionArgs);
                break;
            case WordId:
                String notesID = uri.getPathSegments().get(1);
                updataRows=db.update(TableName,values,"_id=? ",new  String[]{notesID});
                break;
            default:
                break;
        }
        return updataRows;

    }
}
