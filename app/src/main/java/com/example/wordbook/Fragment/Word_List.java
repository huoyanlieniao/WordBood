package com.example.wordbook.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.wordbook.Model.Word;
import com.example.wordbook.R;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Word_List extends Fragment {

    private ArrayList<Word> words;

    public Word_List(ArrayList<Word> words) {
        // Required empty public constructor
        this.words=words;

    }

    public Word_List() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_listvie, container, false);
        Word_List_Adapter word_list_adapter=new Word_List_Adapter(words,getActivity());
        ListView listView=inflate.findViewById(R.id.list_item);
        listView.setAdapter(word_list_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Word word=words.get(position);
                EventBus.getDefault().postSticky(word);
            }
        });
        return inflate;
    }


}
