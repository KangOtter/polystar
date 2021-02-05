package com.swhackathon.polystar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class InputActivity extends AppCompatActivity {

    String filename;
    EditText result;
    ImageButton checkButton;
    int questionCount=0;
    Calendar cal;
    String String;
    String[] Strings = {"좋아하는 물건과 그 이유는 무엇인가요?", "오늘 하지 못했던 말이 있나요?",
            "당신에게 성공이란 어떤 것인가요?", "당신에게 가족이란 어떤 의미인가요?",
            "당신은 지금 행복한가요?","살면서 가장 잘한 일은 무엇인가요?",
            "최근에 성취감을 느낀 것은 어떤 때였나요?","당신이 가장 하고싶은 일은 무엇인가요?",
            "요즘 당신의 가슴을 뛰게 하는 일이 있나요?","올해 안에 가장 도전해보고 싶은 것은 무엇인가요?",
            "오늘의 자신을 세 단어로 표현해본다면?"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        //몇번째 질문인지 확인하는 변수
        checkButton = findViewById(R.id.checkButton);
        result = findViewById(R.id.resultTxt);
        cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String s = BookmarkActivity.returnQuestion(questionCount)+"\n"; //s대신 질문을 넣을 것!!

        filename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount);
        String str = readDiary(filename);
        result.setText(str);


        //완료버튼 누를 시 파일에 입력값 입력
        checkButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                    String str = result.getText().toString();
                    outFs.write(s.getBytes());
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(InputActivity.this, filename + "이 저장", Toast.LENGTH_SHORT).show();
                    questionCount = questionCount + 1;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        //네비게이션 바 버튼

        //홈버튼
        ImageButton home1 = (ImageButton) findViewById(R.id.homeButton1);
        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //별의 기억버튼
        ImageButton memory1 = (ImageButton) findViewById(R.id.memoryButton1);
        memory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalanderActivity.class);
                startActivity(intent);
            }
        });

        //별자리버튼
        ImageButton star1 = (ImageButton) findViewById(R.id.starButton1);
        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });

        //즐겨찾기버튼
        ImageButton like1 = (ImageButton) findViewById(R.id.likeButton1);
        like1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BookmarkActivity.class);
                startActivity(intent);
            }
        });

        //뒤로가기 버튼
        ImageButton back1 = (ImageButton) findViewById(R.id.backButton1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 사용자정보 가기 버튼
        ImageButton profile_input = (ImageButton) findViewById(R.id.profile_input);
        profile_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });

        Random random = new Random();



        // 질문 새로고침
        ImageButton reButton = (ImageButton) findViewById(R.id.reButton);
        reButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView questionTxt = findViewById(R.id.questionTxt);   //질문란
                EditText resultTxt = findViewById(R.id.resultTxt);   //대답란

                int r = (int)(Math.random()*11);
                questionTxt.setText(Strings[r]);
                // 질문 새로고침 db 저장 작성
                resultTxt.setText("");
            }
        });
    }

    //저장되어있는 답변을 읽어오는 함수
    private String readDiary(String filename) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(filename);

            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();

        }catch (IOException e){
            result.setHint("답을 입력해 주세요");
            diaryStr="";
        }
        return diaryStr;
    }
}