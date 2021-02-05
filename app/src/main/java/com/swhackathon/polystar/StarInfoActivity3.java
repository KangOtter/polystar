package com.swhackathon.polystar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StarInfoActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_info3);
        //네비게이션 바 버튼
        //홈버튼
        ImageButton home2 = (ImageButton) findViewById(R.id.homeButton2);
        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //별의 기억버튼
        ImageButton memory2 = (ImageButton) findViewById(R.id.memoryButton2);
        memory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalanderActivity.class);
                startActivity(intent);
            }
        });

        //별자리버튼
        ImageButton star2 = (ImageButton) findViewById(R.id.starButton2);
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });

        //즐겨찾기버튼
        ImageButton like2 = (ImageButton) findViewById(R.id.likeButton2);
        like2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BookmarkActivity.class);
                startActivity(intent);
            }
        });

        //뒤로가기 버튼
        ImageButton back2 = (ImageButton) findViewById(R.id.backButton2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });
    }
}