package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView NAME ;
    public static final String EXTRA_MESSAGE ="com.example.quiz.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    RadioGroup radioGroup;
    int checkedRadioButtonId;
    String question2 ="0";
    Button Continue2;
    String question1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        NAME = findViewById(R.id.name);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        question1 = intent.getStringExtra("question1");
        NAME.setText(message.toString());

    }

    public void visible(View view) {
        Continue2 = (Button)findViewById(R.id.Continue2);
        Continue2.setVisibility(View.VISIBLE);
    }

    public void step2(View view) {
        radioGroup = (RadioGroup)findViewById(R.id.group2);
        checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.reponse1) {
            question2="1";
        }
        Intent intent = new Intent(this, QuartyActivity.class);
        String message = NAME.getText().toString();
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("question1", question1);
        intent.putExtra("question2",question2);
        startActivity(intent);
        finish();
    }
}