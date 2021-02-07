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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.StringTokenizer;

public class InputActivity extends AppCompatActivity {

    String filename;
    EditText result;
    ImageButton checkButton;
    Calendar cal;
    int questionCount=0;
    String[] Question;
    String questionTxt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        checkButton = findViewById(R.id.checkButton);
        result = findViewById(R.id.resultTxt);
        cal = Calendar.getInstance();

        //질문 파일 생성
        questionTxt = readTxt();
        StringTokenizer tokens = new StringTokenizer(questionTxt);
        Question = questionTxt.split("\n");

        TextView questionTxt = findViewById(R.id.questionTxt);
        questionTxt.setText(Question[1]);


        //답변파일 생성 변수
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        filename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount);
        String s = BookmarkActivity.returnQuestion(1)+"\n"; //s대신 질문을 넣을 것!!
        String str = "abc";

        while(str != null && questionCount < 5)
        {
            questionCount = questionCount + 1;
            filename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount);
            str = readDiary(filename);
            result.setText(str);
        }



        //완료버튼 누를 시 파일에 입력값 입력
        checkButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionCount < 4)
                {
                    try {
                        FileOutputStream outFs = openFileOutput(filename, Context.MODE_PRIVATE);
                        String str = result.getText().toString();
                        outFs.write(str.getBytes());
                        outFs.close();
                        Toast.makeText(InputActivity.this, filename + "이 저장", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), String.format("더이상 답변을 입력 할 수 없습니다..."), Toast.LENGTH_SHORT).show();
                    finish();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
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

                int r = (int)(Math.random()*12);
                questionTxt.setText(Question[r]);
                // 질문 새로고침 db 저장 작성
                resultTxt.setText("");
            }
        });
    }

    private String readTxt() {
        String data = null;
        InputStream input = getResources().openRawResource(R.raw.question);
        ByteArrayOutputStream bytearrayout = new ByteArrayOutputStream();
        int i;
        try{
            i = input.read();
            while (i != -1){
                bytearrayout.write(i);
                i = input.read();
            }
            data = new String(bytearrayout.toByteArray(),"MS949");
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
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
        }
        return diaryStr;
    }
}