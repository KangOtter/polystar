package com.swhackathon.polystar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class InputActivity extends AppCompatActivity {

    //파일입력에 필요한 변수

    String filename;
    EditText result;
    ImageButton checkButton;
    int questionCount=0;
    Calendar cal;
    String String;
    String[] Strings = {"어떤 삶을 살고 싶어?", "현재 프로필 사진은 어떤 거야?",
            "오늘 하루 가장 기억에 남는 것은 뭐야?", "가장 속상했던 일은 뭐야?",
            "오늘 자신을 세 단어로 표현해 본다면?","너의 취미는 뭐야?",
            "다시 태어난다면 무엇으로 태어나고 싶어?","주말을 보내는 너만의 가장 행복한 방법은?",
            "가장 최근에 신용카드로 구입한 물건은?","네 존재가 특별한 이유는 뭐라고 생각해?",
            "오늘 하루 하늘을 몇 번 올려다보았어?"};

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



        //완료버튼
        /*ImageButton checkButton = (ImageButton) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //db

            }
        });*/
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