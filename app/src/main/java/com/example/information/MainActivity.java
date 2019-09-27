package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    public EditText pass;
    private Button login;
    private Button reset;
    private TextView tp;
    private TextView tu;
    private Button exit;
    private Button reg;
    public static String up;
    public static String need;
    final String Tag=this.getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        reset = (Button) findViewById(R.id.reset);
        exit = (Button) findViewById(R.id.ex);
        tp = (TextView) findViewById(R.id.textView2);
        tu = (TextView) findViewById(R.id.textView3);
        reg = (Button) findViewById(R.id.button3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                up =  pass.getText().toString();
                if(!email.getText().toString().equals("") && !up.equals(""))
                    check(email.getText().toString());
                else if(email.getText().toString().equals(""))
                    tu.setText("Invalid Username");
                else if(up.equals(""))
                    tp.setText("Invalid Password");
                else
                {
                    tu.setText("Invalid Username");
                    tp.setText("Invalid Password");
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setText(null);
                pass.setText(null);
                tp.setText("Enter Password");
                tu.setText("Enter Email Id");
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Close.class);
                startActivity(intent);
                Close c=new Close();
                System.exit(0);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });
    }

    void check(String un)
    {
        FileInputStream fis=null;
        String u="";
        need = un;
        try {
            fis=openFileInput(un);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb=new StringBuilder();
            String text;
            while((text=br.readLine())!=null) {
                u=text;
                break;
            }

            fis.close();

        }
        catch(Exception e)
        {}
        u.trim();
        if(up.equals(u))
        {
            need=up+"/"+un;
            Intent intent=new Intent(MainActivity.this,Information2.class);
            intent.putExtra(need,need);
            startActivity(intent);
        }
        else
            tp.setText("Wrong Password");
    }
    boolean twice=false;
    @Override
    public void onBackPressed(){
        Log.d(Tag,"click");
        if(twice==true){
            Intent intent=new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice=true;
        Log.d(Tag, "twice"+twice);
        Toast.makeText(MainActivity.this, "Press Back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice=false;
                Log.d(Tag,"twice"+twice);
            }
        },3000);
    }
}
