package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {
    TextView NAME ;
    public static final String EXTRA_MESSAGE ="com.example.quiz.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    RadioGroup radioGroup;
    int checkedRadioButtonId;
    String question4="0";
    String question3;
    String question2;
    Button Continue4;
    String question1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        NAME = findViewById(R.id.name);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        question1 = intent.getStringExtra("question1");
        question2 = intent.getStringExtra("question2");
        question3 = intent.getStringExtra("question3");
        NAME.setText(message.toString());

    }

    public void step4(View view) {
        radioGroup = (RadioGroup)findViewById(R.id.group4);
        checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.SDKManager) {
            question4="1";
        }
        Intent intent = new Intent(this, SixthActivity.class);
        String message = NAME.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        intent.putExtra("question1",question1);
        intent.putExtra("question2", question2);
        intent.putExtra("question3",question3);
        intent.putExtra("question4",question4);
        startActivity(intent);
        finish();
    }

    public void visible(View view) {
        Continue4= (Button)findViewById(R.id.Continue4);
        Continue4.setVisibility(View.VISIBLE);
    }
}