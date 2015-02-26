package com.codehun.soomup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Juanto on 2/25/2015.
 */
public class AnswerListAdapter extends ArrayAdapter<String> {


    public AnswerListAdapter(Context context, String[] resource) {
        super(context, R.layout.fragment_answer_list, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =  LayoutInflater.from(getContext());

        View view = inflater.inflate(R.layout.fragment_answer_list, parent, false);

        String answer = getItem(position);

        TextView answer_text_view = (TextView) view.findViewById(R.id.answer_item);
        answer_text_view.setText(answer);

        return view;
    }
}
