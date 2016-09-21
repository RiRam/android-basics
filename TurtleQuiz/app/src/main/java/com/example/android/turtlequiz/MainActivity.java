package com.example.android.turtlequiz;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks the quiz answers when the "submit" button is pressed.
     * Changes the question text to be red if the answer is wrong.
     */
    public void checkAnswers(View v) {
        int correct = 0;

        //Question 1 answer
        RadioButton a1 = (RadioButton) findViewById(R.id.q1_a2);

        if (a1.isChecked()) {
            correct++;
        } else {
            TextView q1 = (TextView) findViewById(R.id.question_1);
            q1.setTextColor(Color.RED);
        }

        //Question 2 answer
        RadioButton a2 = (RadioButton) findViewById(R.id.q2_a2);

        if (a2.isChecked()) {
            correct++;
        } else {
            TextView q2 = (TextView) findViewById(R.id.question_2);
            q2.setTextColor(Color.RED);
        }

        //Question 3
        CheckBox a3_1 = (CheckBox) findViewById(R.id.q3_a1);
        CheckBox a3_2 = (CheckBox) findViewById(R.id.q3_a2);
        CheckBox a3_3 = (CheckBox) findViewById(R.id.q3_a3);

        if (a3_1.isChecked() && a3_2.isChecked() && a3_3.isChecked()) {
            correct++;
        } else {
            TextView q3 = (TextView) findViewById(R.id.question_3);
            q3.setTextColor(Color.RED);
        }

        //Question 4
        EditText a4 = (EditText) findViewById(R.id.q4_a);

        if (a4.getText().toString().equalsIgnoreCase(getResources().getString(R.string.q4_a))) {
            correct++;
        } else {
            TextView q4 = (TextView) findViewById(R.id.question_4);
            q4.setTextColor(Color.RED);
        }

        //Question 5
        RadioButton a5 = (RadioButton) findViewById(R.id.q5_a3);

        if (a5.isChecked()) {
            correct++;
        } else {
            TextView q5 = (TextView) findViewById(R.id.question_5);
            q5.setTextColor(Color.RED);
        }

        //Question 6
        RadioButton a6 = (RadioButton) findViewById(R.id.q6_a1);

        if (a6.isChecked()) {
            correct++;
        } else {
            TextView q6 = (TextView) findViewById(R.id.question_6);
            q6.setTextColor(Color.RED);
        }

        //Question 7
        EditText a7 = (EditText) findViewById(R.id.q7_a);

        if (a7.getText().toString().equalsIgnoreCase(getResources().getString(R.string.q7_a))) {
            correct++;
        } else {
            TextView q7 = (TextView) findViewById(R.id.question_7);
            q7.setTextColor(Color.RED);
        }

        //Question 8
        RadioButton a8 = (RadioButton) findViewById(R.id.q8_a1);

        if (a8.isChecked()) {
            correct++;
        } else {
            TextView q8 = (TextView) findViewById(R.id.question_8);
            q8.setTextColor(Color.RED);
        }

        //Toast
        Context context = getApplicationContext();
        CharSequence text = "Score: " + correct + "/8";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
    }
}
