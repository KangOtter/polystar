package com.swhackathon.polystar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    boolean[] starLine={false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //별의 기억버튼
        ImageButton memory = (ImageButton) findViewById(R.id.memoryButton);
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalanderActivity.class);
                startActivity(intent);
            }
        });

        //별자리버튼
        ImageButton star = (ImageButton) findViewById(R.id.starButton);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });

        //즐겨찾기버튼
        ImageButton like = (ImageButton) findViewById(R.id.likeButton);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BookmarkActivity.class);
                startActivity(intent);
            }
        });

        ImageButton StarButton1=findViewById(R.id.StarButton1);
        StarButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView star1=findViewById(R.id.starLine1);
                if(!starLine[0]){
                    star1.setImageResource(R.drawable.sl1);
                    starLine[0]=true;
                }
                else{
                    star1.setImageResource(0);
                    starLine[0]=false;
                }
            }
        });
        ImageButton StarButton2=findViewById(R.id.StarButton2);
        StarButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView star1=findViewById(R.id.starLine2);
                if(!starLine[1]){
                    star1.setImageResource(R.drawable.sl2);
                    starLine[1]=true;
                }
                else{
                    star1.setImageResource(0);
                    starLine[1]=false;
                }
            }
        });
        ImageButton StarButton3=findViewById(R.id.StarButton3);
        StarButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView star1=findViewById(R.id.starLine3);
                if(!starLine[2]){
                    star1.setImageResource(R.drawable.sl3);
                    starLine[2]=true;
                }
                else{
                    star1.setImageResource(0);
                    starLine[2]=false;
                }
            }
        });
        ImageButton StarButton4=findViewById(R.id.StarButton4);
        StarButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView star1=findViewById(R.id.starLine4);
                if(!starLine[3]){
                    star1.setImageResource(R.drawable.sl4);
                    starLine[3]=true;
                }
                else{
                    star1.setImageResource(0);
                    starLine[3]=false;
                }
            }
        });
        ImageButton StarButton5=findViewById(R.id.StarButton5);
        StarButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView star1=findViewById(R.id.starLine5);
                if(!starLine[4]){
                    star1.setImageResource(R.drawable.sl5);
                    starLine[4]=true;
                }
                else{
                    star1.setImageResource(0);
                    starLine[4]=false;
                }
            }
        });
    }
}