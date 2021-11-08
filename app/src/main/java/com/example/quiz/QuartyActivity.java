package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuartyActivity extends AppCompatActivity {
    TextView NAME ;
    public static final String EXTRA_MESSAGE ="com.example.quiz.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    RadioGroup radioGroup;
    int checkedRadioButtonId;
    String question3="0";
    String question2;
    Button Continue3;
    String question1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarty);
        NAME = findViewById(R.id.name);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        question1 = intent.getStringExtra("question1");
        question2 = intent.getStringExtra("question2");
        NAME.setText(message.toString());

    }

    public void visible(View view) {
        Continue3 = (Button)findViewById(R.id.Continue3);
        Continue3.setVisibility(View.VISIBLE);
    }

    public void step3(View view) {
        radioGroup = (RadioGroup)findViewById(R.id.group3);
        checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.ID) {
            question3="1";
        }
        Intent intent = new Intent(this, FifthActivity.class);
        String message = NAME.getText().toString();
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("question1",question1);
        intent.putExtra("question2", question2);
        intent.putExtra("question3",question3);
        startActivity(intent);
        finish();    }
}