package com.codehun.soomup;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ListAdapter;
import android.widget.ListView;



/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 */
public class AnswerFragment extends ListFragment {

    private AnswerListSelectionListener answer_listener;


    public interface AnswerListSelectionListener{
        public void onAnswerSelection(int index);
    }

    @Override
    public void onListItemClick(ListView list_view, View view, int position, long id){
        getListView().setItemChecked(position, true);
        answer_listener.onAnswerSelection(position);
    }

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter answer_list_adapter;


    private String[] current_problem_answers;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AnswerFragment() {
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
           answer_listener = (AnswerListSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement AnswerSelectionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setAnswers(String[] problem_answers){
        this.current_problem_answers = problem_answers;
        answer_list_adapter = new AnswerListAdapter(this.getActivity().getApplicationContext(),
                current_problem_answers );
        setListAdapter(answer_list_adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        answer_listener = null;
    }
}
