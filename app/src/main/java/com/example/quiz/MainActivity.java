package com.example.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String question5;
    String question4;
    String question3;
    String question2;
    String question1;
    String name;

    Button buttonstart;
    public static final int TEXT_REQUEST = 0;
    public static final String EXTRA_MESSAGE ="com.example.quiz.MESSAGE";
    TextView score;
    Uri image_uri;
    ImageButton  camera;
    int resulat,resulat1,resulat2,resulat3,resulat4,resulat5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        EditText nom = (EditText)findViewById(R.id.nom);
        if (nom.getText().toString().equals("")) {
            new AlertDialog.Builder(this)
                    .setTitle("Données vide")
                    .setMessage("Veuillez saisir votre nom s'il vous plait")
                    .setPositiveButton("OUI", null)
                    .setNegativeButton("NON", null).show();
        }
        else {
            Intent intent = new Intent(this, SecondActivity.class);
            String message = nom.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivityForResult(intent,0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                question1 = data.getStringExtra("question1");
                question2 = data.getStringExtra("question2");
                question3 = data.getStringExtra("question3");
                question4 = data.getStringExtra("question4");
                question5 = data.getStringExtra("question5");
                name = data.getStringExtra(EXTRA_MESSAGE);
                TextView bestscore = findViewById(R.id.bestscore);
                camera = (ImageButton) findViewById(R.id.camera);
                score = findViewById(R.id.score);
                buttonstart = findViewById(R.id.started);
                resulat1 = Integer.parseInt(question1);
                resulat2 = Integer.parseInt(question2);
                resulat3 = Integer.parseInt(question3);
                resulat4 = Integer.parseInt(question4);
                resulat5 = Integer.parseInt(question5);
                resulat = resulat1 + resulat2 + resulat3 + resulat4 + resulat5;
                buttonstart.setText("Restart");
                score.setText("Your score is : " + resulat + " from 5");
                score.setVisibility(View.VISIBLE);
                if (resulat != 5) {
                    bestscore.setVisibility(View.INVISIBLE);
                    camera.setVisibility(View.INVISIBLE);
                }
                if (resulat == 5) {
                    bestscore.setText("Congratulations, "+name);
                    bestscore.setVisibility(View.VISIBLE);
                    camera.setVisibility(View.VISIBLE);
                    camera.setOnClickListener(new View.OnClickListener()
                    {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v)
                        {
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            startActivity(intent);
                    }});
 } } }}


}