package com.example.wordbook.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.wordbook.Model.Word;
import com.example.wordbook.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private Word word;


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        /*Word_List_Adapter word_list_adapter=new Word_List_Adapter(words,getActivity());
        ListView listView=inflate.findViewById(R.id.list_item);
        listView.setAdapter(word_list_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/
        if(word!=null){
            TextView textView=inflate.findViewById(R.id.txt_content);
            textView.setText(word.getWord());
            TextView textView1=inflate.findViewById(R.id.aa);
            textView1.setText(word.getWord_Explation());
            TextView textView2=inflate.findViewById(R.id.aaa);
            textView2.setText(word.getWord_Sentence());
        }


        return inflate;
    }


    @Subscribe(sticky = true)
    public void getData(Word data){
        this.word=data;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
