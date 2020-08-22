package com.ss.pdfreadernew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Intent i=new Intent(Main3Activity.this, com.ss.pdfreadernew.BUTTON.class);startActivity(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();



    }
}
