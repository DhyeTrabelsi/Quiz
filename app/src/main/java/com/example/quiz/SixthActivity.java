package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SixthActivity extends AppCompatActivity {
    TextView NAME ;
    public static final String EXTRA_MESSAGE ="com.example.quiz.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    RadioGroup radioGroup;
    int checkedRadioButtonId;
    String question5="0";
    String question4;
    String question3;
    String question2;
    Button Continue5;
    String question1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        NAME = findViewById(R.id.name);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        question1 = intent.getStringExtra("question1");
        question2 = intent.getStringExtra("question2");
        question3 = intent.getStringExtra("question3");
        question4 = intent.getStringExtra("question4");
        NAME.setText(message.toString());

    }


    public void finish(View view) {
        radioGroup = (RadioGroup)findViewById(R.id.group5);
        checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.newIntentaction) {
            question5="1";
        }
        Intent intent = new Intent(this,MainActivity.class);
        String message = NAME.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("question1",question1);
        intent.putExtra("question2", question2);
        intent.putExtra("question3",question3);
        intent.putExtra("question4",question4);
        intent.putExtra("question5",question5);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void visible(View view) {
        Continue5= (Button)findViewById(R.id.Continue5);
        Continue5.setVisibility(View.VISIBLE);
    }
}