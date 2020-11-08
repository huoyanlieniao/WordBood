package com.example.wordbook.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.wordbook.Model.Word;
import com.example.wordbook.R;

import java.util.List;

public class Word_List_Adapter extends BaseAdapter {

    private List<Word> Word;
    private Context context;

    public Word_List_Adapter(List<com.example.wordbook.Model.Word> word, Context context) {
        Word = word;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Word.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();
        if(convertView == null){
            //视图为空
            //创建视图
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_word_list,parent,false);
            viewHolder = new ViewHolder();
            //获取控件
            viewHolder.word= (TextView) convertView.findViewById(R.id.Word);
            viewHolder.word_explation= (TextView) convertView.findViewById(R.id.Word_Explation);
            viewHolder.word_sentence= (TextView) convertView.findViewById(R.id.Word_Sentence);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.word.setText(Word.get(position).getWord());
        viewHolder.word_explation.setText(Word.get(position).getWord_Explation());
       // viewHolder.word_sentence.setText(Word.get(position).getWord_Sentence().toString());
        return convertView;
    }


    private class ViewHolder{
        TextView word;
        TextView word_explation;
        TextView word_sentence;
    }

}