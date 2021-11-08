package com.example.quiz;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView NAME ;
    public static final String EXTRA_MESSAGE ="com.example.quiz.MESSAGE";
    RadioGroup radioGroup;
    int checkedRadioButtonId;
    String question1 ="0";
    Button Continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        NAME = findViewById(R.id.name);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        NAME.setText(message.toString());
    }
    public void step1(View view) {
        radioGroup = (RadioGroup)findViewById(R.id.group1);
        checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.Drawable) {
           question1="1";
        }
        Intent intent = new Intent(this, ThirdActivity.class);
        String message = NAME.getText().toString();
        intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);

        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("question1",question1);
        startActivity(intent);
        finish();
    }

    public void visible(View view) {
        Continue = (Button)findViewById(R.id.Continue);
        Continue.setVisibility(View.VISIBLE);
    }
}
