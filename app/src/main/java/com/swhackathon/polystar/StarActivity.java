package com.swhackathon.polystar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.InputStream;

public class StarActivity extends AppCompatActivity {

    String loginName, loginId;
    ImageButton imageEdit;
    ImageView imageProfile;
    boolean[] light={false,false,false,false,false,false,false};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
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
        /*ImageButton star2 = (ImageButton) findViewById(R.id.starButton2);
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarActivity.class);
                startActivity(intent);
            }
        });*/

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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton b1=(ImageButton)findViewById(R.id.b1Button);
        ImageButton b2=(ImageButton)findViewById(R.id.b2Button);
        ImageButton b3=(ImageButton)findViewById(R.id.b3Button);
        ImageButton b4=(ImageButton)findViewById(R.id.b4Button);
        ImageButton b5=(ImageButton)findViewById(R.id.b5Button);
        ImageButton b6=(ImageButton)findViewById(R.id.b6Button);
        ImageButton b7=(ImageButton)findViewById(R.id.b7Button);
        //ImageButton b8=(ImageButton)findViewById(R.id.b8Button);
        ImageButton b9=(ImageButton)findViewById(R.id.b9Button);
        //ImageButton b10=(ImageButton)findViewById(R.id.b10Button);
        ImageButton b11=(ImageButton)findViewById(R.id.b11Button);
        ImageButton b12=(ImageButton)findViewById(R.id.b12Button);
        /*
            활성화 되어있는 5개
        * */
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarInfoActivity2.class);
                startActivity(intent);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarInfoActivity3.class);
                startActivity(intent);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StarInfoActivity.class);
                startActivity(intent);
            }
        });
        /*
            스위치
        * */
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[0]){
                    b1.setImageResource(R.drawable.ba1);
                    light[0]=true;
                }
                else{
                    b1.setImageResource(R.drawable.b1);
                    light[0]=false;
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[1]){
                    b2.setImageResource(R.drawable.ba2);
                    light[1]=true;
                }
                else{
                    b2.setImageResource(R.drawable.b2);
                    light[1]=false;
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[2]){
                    b4.setImageResource(R.drawable.ba4);
                    light[2]=true;
                }
                else{
                    b4.setImageResource(R.drawable.b4);
                    light[2]=false;
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[3]){
                    b5.setImageResource(R.drawable.ba5);
                    light[3]=true;
                }
                else{
                    b5.setImageResource(R.drawable.b5);
                    light[3]=false;
                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[4]){
                    b6.setImageResource(R.drawable.ba6);
                    light[4]=true;
                }
                else{
                    b6.setImageResource(R.drawable.b6);
                    light[4]=false;
                }
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[5]){
                    b9.setImageResource(R.drawable.ba9);
                    light[5]=true;
                }
                else{
                    b9.setImageResource(R.drawable.b9);
                    light[5]=false;
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!light[6]){
                    b12.setImageResource(R.drawable.ba12);
                    light[6]=true;
                }
                else{
                    b12.setImageResource(R.drawable.b12);
                    light[6]=false;
                }
            }
        });
        //프로필 정보 출력
        SharedPreferences auto = getSharedPreferences("auto", Activity.MODE_PRIVATE);

        loginName = auto.getString("inputName", null);
        loginId = auto.getString("inputId", null);

        TextView textName = findViewById(R.id.textName);
        TextView textId = findViewById(R.id.textId);

        textName.setText(loginName);
        textId.setText("@ " + loginId);

        // 갤러리 구현
        imageProfile = (ImageView) findViewById(R.id.imageView18);
        imageEdit = (ImageButton) findViewById(R.id.imageButton9);

        imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override   //갤러리 들어가는 코드
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    imageProfile.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}