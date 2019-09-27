package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Information2 extends AppCompatActivity {
    private Button ai;
    private Button vi;
    public static String pas,name="";
    private TextView tv4;
    private Button si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_information2);
        ai = (Button)findViewById(R.id.button7);
        vi = (Button)findViewById(R.id.button8);
        Intent intent = getIntent();
        pas = (intent.getStringExtra(MainActivity.need)).substring(0,(intent.getStringExtra(MainActivity.need)).indexOf('/'));
        name=(intent.getStringExtra(MainActivity.need)).substring((intent.getStringExtra(MainActivity.need)).indexOf('/')+1);
        tv4 = (TextView)findViewById(R.id.textView4);
        tv4.setText("Welcome user "+name);
        si = (Button)findViewById(R.id.button9);
        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send1();
            }
        });
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send2();
            }
        });
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send3();
            }
        });

    }
    public void send1()
    {
        Intent intent=new Intent(Information2.this,AddInfo.class);
        intent.putExtra(pas,pas);
        startActivity(intent);
    }
    public void send2()
    {
        Intent intent=new Intent(Information2.this,ViewInfor.class);
        intent.putExtra(pas,pas);
        startActivity(intent);
    }
    public void send3()
    {
        Intent intent=new Intent(Information2.this,SearInf.class);
        intent.putExtra(pas,pas);
        startActivity(intent);
    }

}
