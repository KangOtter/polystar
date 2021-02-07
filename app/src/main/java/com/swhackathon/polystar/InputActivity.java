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

    String Afilename;
    String Qfilename;
    Calendar cal;
    int questionCount=0;

    //질문을 위한 변수들
    String[] Question;
    String questionTxt;
    //몇번째 질문인지 확인 변수
    int r = 0;
    //총 질문 개수 확인 변수
    int howmanyquestion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText result = findViewById(R.id.resultTxt);

        cal = Calendar.getInstance();

        //질문 파일 생성
        questionTxt = readTxt();
        StringTokenizer tokens = new StringTokenizer(questionTxt);
        Question = questionTxt.split("\n");
        howmanyquestion = Question.length;

        //첫번째 질문 출력
        r = (int)(Math.random()*howmanyquestion);
        TextView questionTxtsee = findViewById(R.id.questionTxt);
        questionTxtsee.setText(Question[r]);


        //답변파일 생성 변수
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        //Afilename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount);
        String str = "abc";

        while(str != null && questionCount < 3)
        {
            questionCount = questionCount + 1;
            Afilename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount) +"_" + "A";
            Qfilename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount) +"_" + "Q";
            str = readDiary(Afilename);
            result.setText(str);
        }

        result.setText("");
        result.setHint("답을 입력해 주세요");

        //완료버튼 누를 시 파일에 입력값 입력
        ImageButton checkButton = (ImageButton) findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionCount < 4)
                {
                    try {
                        FileOutputStream outFs = openFileOutput(Afilename, Context.MODE_PRIVATE);
                        String str = result.getText().toString();
                        outFs.write(str.getBytes());
                        outFs.close();

                        outFs = openFileOutput(Qfilename, Context.MODE_PRIVATE);
                        outFs.write(Question[r].getBytes());
                        outFs.close();

                        Toast.makeText(InputActivity.this, Afilename + "이 저장", Toast.LENGTH_SHORT).show();
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
                finish();
            }
        });

        //질문 새로고침
        ImageButton reButton = (ImageButton) findViewById(R.id.reButton);
        reButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView questionTxtsee = findViewById(R.id.questionTxt);   //질문란
                EditText resultTxt = findViewById(R.id.resultTxt);   //대답란

                //질문 새로고침
                r = (int)(Math.random()*howmanyquestion);
                questionTxtsee.setText(Question[r]);

                // 대답 새로고침... 이전 대답 날리기
                resultTxt.setText("");
                resultTxt.setHint("답을 입력해 주세요");
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
                finish();
            }
        });

        //별의 기억버튼
        ImageButton memory1 = (ImageButton) findViewById(R.id.memoryButton1);
        memory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalanderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //별자리버튼
        ImageButton star1 = (ImageButton) findViewById(R.id.starButton1);
        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //즐겨찾기버튼
        ImageButton like1 = (ImageButton) findViewById(R.id.likeButton1);
        like1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BookmarkActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //뒤로가기 버튼
        ImageButton back1 = (ImageButton) findViewById(R.id.backButton1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 사용자정보 가기 버튼
        ImageButton profile_input = (ImageButton) findViewById(R.id.profile_input);
        profile_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
                finish();
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
        EditText result = findViewById(R.id.resultTxt);
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