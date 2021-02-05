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
    int questionCount;
    Calendar cal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);


        //몇번째 질문인지 확인하는 변수
        questionCount = 1;

        checkButton = findViewById(R.id.checkButton);
        result = findViewById(R.id.resultTxt);
        cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String s = "hello\n"; //s대신 질문을 넣을 것!!


        filename = Integer.toString(year) + "_" + Integer.toString(month) + "_" + Integer.toString(day) + "_" + Integer.toString(questionCount);
        String str = readDiary(filename);
        result.setText(str);
        questionCount = questionCount + 1;


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

        // 질문 새로고침
        ImageButton reButton = (ImageButton) findViewById(R.id.reButton);
        reButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView questionTxt = findViewById(R.id.questionTxt);
                EditText resultTxt = findViewById(R.id.resultTxt);
                // 질문 새로고침 db코드작성
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
        /*
         * intent 불러오기
         * */
        Intent intent= getIntent();
        if(intent.hasExtra("질문")) {
            String qmsg = intent.getStringExtra("질문");
            String amsg = intent.getStringExtra("답");
            TextView qtextView = (TextView) findViewById(R.id.questionTxt);
            qtextView.setText(qmsg);
            TextView atextView = (TextView) findViewById(R.id.resultTxt);
            atextView.setText(amsg);
        }

    }

    //파일을 출력하는 함..수?
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