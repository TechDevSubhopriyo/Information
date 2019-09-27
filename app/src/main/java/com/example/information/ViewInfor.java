package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ViewInfor extends AppCompatActivity {
    private TextView viewit;
    public static String File_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_infor);
        viewit = (TextView)findViewById(R.id.tv);
        Intent intent = getIntent();
        File_Name = ("00"+(intent.getStringExtra(Information2.pas)));

        FileInputStream fis=null;
        String u="";
        try {
            fis=openFileInput(File_Name);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null) {
                u=u+"\n"+text;
            }

            fis.close();

        }
        catch(Exception e)
        {}
        viewit.setText(u);
        viewit.setMovementMethod(new ScrollingMovementMethod());
    }
}
