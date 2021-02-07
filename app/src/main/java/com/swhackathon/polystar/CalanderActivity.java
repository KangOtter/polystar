package com.swhackathon.polystar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

public class CalanderActivity extends AppCompatActivity {

    //파일을 불러오기위한 변수들
    DatePicker datePicker;
    String filename;
    TextView answer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

        // datePicker를 현재날짜로 초기화해주기 위해 오늘의 년, 월, 일을 받아온다.
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePicker = findViewById(R.id.datepicker);


        // datepicker를 오늘의 날짜로 초기값을 정해준다.
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

            // datepicker에서 날짜가 바뀔때마다 파일이름을 정해준다
            // readDiary메소드를 통해 파일이 존재하면 파일의 내용을 가져오고
            // 그렇지 않다면 null을 가져온다.
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {

                answer = findViewById(R.id.question1);
                filename = Integer.toString(i) + "_" + Integer.toString(i1) + "_" + Integer.toString(i2) + "_" + 1;
                String str1 = readDiary(filename);
                answer.setText(str1);

                answer = findViewById(R.id.question2);
                filename = Integer.toString(i) + "_" + Integer.toString(i1) + "_" + Integer.toString(i2) + "_" + 2;
                String str2 = readDiary(filename);
                answer.setText(str2);

                answer = findViewById(R.id.question3);
                filename = Integer.toString(i) + "_" + Integer.toString(i1) + "_" + Integer.toString(i2) + "_" + 3;
                String str3 = readDiary(filename);
                answer.setText(str3);
            }
        });


        //네비게이션 바 버튼
        //홈버튼
        ImageButton home = (ImageButton) findViewById(R.id.homeButton1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //별의 기억버튼
        /*ImageButton memory = (ImageButton) findViewById(R.id.memoryButton1);
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalanderActivity.class);
                startActivity(intent);
            }
        });*/

        //별자리버튼
        ImageButton star = (ImageButton) findViewById(R.id.starButton1);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });

        //즐겨찾기버튼
        ImageButton like = (ImageButton) findViewById(R.id.likeButton1);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BookmarkActivity.class);
                startActivity(intent);
            }
        });

        //뒤로가기 버튼
        ImageButton back = (ImageButton) findViewById(R.id.backButton1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    // 파일 읽기 함수
    String readDiary(String filename){

        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(filename);

            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
        }catch (IOException e){
            answer.setHint("답변 없음");
        }

        return diaryStr;
    }

}

