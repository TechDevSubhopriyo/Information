package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class SearInf extends AppCompatActivity {

    private EditText nam;
    private EditText num;
    private String pas , name , number;
    private Button sna;
    private Button snu;
    String FILE_NAME = "";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sear_inf);
        Intent intent = getIntent();
        FILE_NAME = ("00" + intent.getStringExtra(Information2.pas));
        tv = (TextView) findViewById(R.id.info);
        nam = (EditText) findViewById(R.id.name);
        num = (EditText) findViewById(R.id.number);
        sna = (Button) findViewById(R.id.searchbyname);
        snu = (Button) findViewById(R.id.searchbynumber);
        sna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search1();
            }
        });
        snu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search2();
            }
        });

    }

    public void search1() {
        FileInputStream fis=null;
        name = ("Name: "+(nam.getText().toString()));
        String u="";
        try {
            fis=openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null) {
                if(text.equals(name)) {
                    u = u + "\n" + text;
                    text = br.readLine();
                    u = u + "\n" + text;
                    text = br.readLine();
                    u = u + "\n" + text;
                    text = br.readLine();
                    u = u + "\n" + text;
                    text = br.readLine();
                    u = u + "\n" + text + "\n";
                }
            }

            fis.close();

        }
        catch(Exception e)
        {}
        tv.setText(u);
        tv.setMovementMethod(new ScrollingMovementMethod());
        nam.setText("");
        num.setText("");

    }
    public void search2() {
        number = ("Mob.: "+(num.getText().toString()));
        FileInputStream fis = null;
        String text="",u="",text1="";
        try {
            fis=openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            while((text=br.readLine())!=null)  {
                text1=br.readLine();
                if(text1.equals(number)) {
                    u = u + "\n" + text;
                    u = u + "\n" + text1;
                    text = br.readLine();
                    u = u + "\n" + text;
                    text = br.readLine();
                    u = u + "\n" + text;
                    text = br.readLine();
                    u = u + "\n" + text + "\n";
                }
            }

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tv.setText(u);
        tv.setMovementMethod(new ScrollingMovementMethod());
        nam.setText("");
        num.setText("");
    }
}