package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class QuestionAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Questions> questions;
    private LayoutInflater inflater;

    public QuestionAdapter(Context context, ArrayList<Questions> questions) {
        this.context = context;
        this.questions = questions;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int position) {
        return questions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_question, parent, false);
            holder = new ViewHolder();
            holder.textViewQuestion = convertView.findViewById(R.id.textViewQuestion);
            holder.radioGroupChoices = convertView.findViewById(R.id.radioGroupChoices);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Questions question = questions.get(position);
        holder.textViewQuestion.setText(question.getQuestion());
        holder.radioGroupChoices.removeAllViews();

        for (int i = 0; i < question.getChoices().length; i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(question.getChoices()[i]);
            radioButton.setId(i);
            holder.radioGroupChoices.addView(radioButton);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView textViewQuestion;
        RadioGroup radioGroupChoices;
    }
}
