package ru.trandep.wordfind;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhezlov on 30.01.2016.

public class WordGridAdapter extends BaseAdapter {
    private Context context;
    private String[][] words;

    public WordGridAdapter (Context context, String [][] words){
        this.context = context;
        this.words = words;
    }

    @Override
    public int getCount() {
        return words.length;
    }

    public String getItem (int pos1, int pos2){
        return words[pos1][pos2];
    }


    public View getView (int pos1, int pos2, View convertView, ViewGroup parent){

        TextView label = (TextView) convertView;

        if (convertView == null){
            convertView = new TextView(context);
            label = (TextView) convertView;
        }
        label.setText(words[pos1][pos2]);
        return (convertView);
    }
    }
 */


public class WordGridAdapter extends BaseAdapter   {
    private Context context;
    private List<String> rowLetters;
    public ArrayList<View> viewList;

    public WordGridAdapter(Context context, List<String> rowLetters) {
        this.context = context;
        this.rowLetters = rowLetters;
    }

    @Override
    public int getCount() {
        return rowLetters.size();
    }

    @Override
    public Object getItem(int position) {
        return rowLetters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(context);
            label =  (TextView) convertView;
        }
        label.setText(rowLetters.get(position));
        label.setId(position);
        ArrayList<View> viewList2 = new ArrayList<>();
        viewList2.add(label);
        this.viewList = viewList2;
        //return button;
        return label;

//        Button button;
//
//
//        if (convertView == null) {
//            button = new Button(context);
//            button.setText(rowLetters.get(position)); //.getName());
//        } else {
//            button = (Button) convertView;
//        }
//        button.setId(position);
//
//        return button;
    }
}