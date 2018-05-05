package com.example.dactien.homework_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class TutorialActivity extends AppCompatActivity {

    ImageView imgTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        imgTutor = (ImageView) findViewById(R.id.imgTutor);
        int imgRes = getIntent().getIntExtra("TUTORIAL", 0);
        imgTutor.setImageResource(imgRes);
        //Picasso.with(this).load(imgRes).fit().into(imgTutor);
    }
}
