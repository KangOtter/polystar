package com.swhackathon.polystar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BookmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);


        //네비게이션 바 버튼

        //홈버튼
        ImageButton home = (ImageButton) findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //별의 기억버튼
        ImageButton memory = (ImageButton) findViewById(R.id.memoryButton);
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalanderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //별자리버튼
        ImageButton star = (ImageButton) findViewById(R.id.starButton);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 사용자정보 가기 버튼
        ImageButton profile_input = (ImageButton) findViewById(R.id.profile_input2);
        profile_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 뒤로가기 버튼
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //질문 연결하기

        Button Button3 = findViewById(R.id.oneqButton);
        Button Button4 = findViewById(R.id.twoqButton);
        Button Button5 = findViewById(R.id.threeqButton);
        Button Button6 = findViewById(R.id.fourqButton);
        Button Button7 = findViewById(R.id.fiveqButton);
        Button Button8 = findViewById(R.id.sixqButton);
        Button Button9 = findViewById(R.id.sevenqButton);
        Button Button10 = findViewById(R.id.eightqButton);
        Button Button11 = findViewById(R.id.nineqButton);
        Button Button12 = findViewById(R.id.tenqButton);
        Button Button13 = findViewById(R.id.elevenqButton);

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(0));
                intent.putExtra("답", "0번답");
                startActivity(intent);
                finish();
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(1));
                intent.putExtra("답", "1번답");
                startActivity(intent);
                finish();
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(2));
                intent.putExtra("답", "2번답");
                startActivity(intent);
                finish();
            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(3));
                intent.putExtra("답", "3번답");
                startActivity(intent);
                finish();
            }
        });

        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(4));
                intent.putExtra("답", "4번답");
                startActivity(intent);
                finish();
            }
        });

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(5));
                intent.putExtra("답", "5번답");
                startActivity(intent);
                finish();
            }
        });

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(6));
                intent.putExtra("답", "6번답");
                startActivity(intent);
                finish();
            }
        });

        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(7));
                intent.putExtra("답", "7번답");
                startActivity(intent);
                finish();
            }
        });

        Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(8));
                intent.putExtra("답", "8번답");
                startActivity(intent);
                finish();
            }
        });

        Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(9));
                intent.putExtra("답", "9번답");
                startActivity(intent);
                finish();
            }
        });

        Button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                //질문페이지로 연결
                //인텐트 전달
                intent.putExtra("질문", returnQuestion(10));
                intent.putExtra("답", "10번답");
                startActivity(intent);
                finish();
            }
        });

    } //end onCreate

    public static String returnQuestion(int num) {
        String res;

        switch (num) {
            case 0:
                res = "좋아하는 물건과 그 이유는 무엇인가요?";
                break;
            case 1:
                res = "당신에게 성공이란 어떤 것인가요?";
                break;
            case 2:
                res = "오늘 하지 못했던 말이 있나요?";
                break;
            case 3:
                res = "당신에게 가족이란 어떤 의미인가요?";
                break;
            case 4:
                res = "당신은 지금 행복한가요?";
                break;
            case 5:
                res = "당신이 가장 하고싶은 일은 무엇인가요?";
                break;
            case 6:
                res = "살면서 가장 잘한일은 무엇인가요?";
                break;
            case 7:
                res = "최근에 성취감을 느낀 것은 어떤 때였나요?";
                break;
            case 8:
                res = "요즘 당신의 가슴을 뛰게 하는 일이 있나요?";
                break;
            case 9:
                res = "올해 안에 가장 도전해보고 싶은 것은 무엇인가요?";
                break;
            case 10:
                res = "오늘의 자신을 세 단어로 표현해본다면?";
                break;
            default:
                res = "Error " + Integer.toString(num);
                break;
        } //end switch

        return res;
    } //end returnQuestion
} //end class