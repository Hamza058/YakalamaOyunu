package com.hmz.yakalamaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView img;
    TextView textView1;
    int score=0;
    Random rnd=new Random();
    Runnable runnable;
    Handler handler;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txt);
        textView1=findViewById(R.id.textView);
        img=findViewById(R.id.imageView2);
        handler =new Handler();

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                textView.setText("Time: "+l/1000);
                number= (int) l/1000;
            }

            @Override
            public void onFinish() {
                textView.setText("Finished!");
            }
        }.start();

        runnable =new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,600);
                int x= rnd.nextInt(700);
                int y= rnd.nextInt(1500-150)+150;
                img.setX(x);
                img.setY(y);
                if(number==0){
                    handler.removeCallbacks(runnable);
                    Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_LONG).show();
                    img.setEnabled(false);
                }
            }
        };
        handler.post(runnable);
    }

    public void puan(View view){
        score++;
        textView1.setText("Skore: "+score);
    }
}