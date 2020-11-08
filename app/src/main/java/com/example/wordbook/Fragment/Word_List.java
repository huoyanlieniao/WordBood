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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Word_List extends Fragment implements AdapterView.OnItemClickListener {

    private android.app.FragmentManager fragmentManager;
    private ArrayList<Word> words;
    private ListView listView;

    public Word_List() {
        // Required empty public constructor
    }


    public Word_List(android.app.FragmentManager fragmentManager, ArrayList<Word> word) {
        this.fragmentManager=fragmentManager;
        this.words=word;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_listvie, container, false);
        listView=inflate.findViewById(R.id.list_item);
        Word_List_Adapter word_list_adapter=new Word_List_Adapter(words,getActivity());
        listView.setAdapter(word_list_adapter);
        listView.setOnItemClickListener(this);
        return inflate;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BlankFragment blankFragment=new BlankFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.Second_change,blankFragment)
                .commit();
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }
}
