package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registration  extends AppCompatActivity  {
    private TextView un;
    private EditText email;
    private EditText pass;
    private Button reg;
    private EditText op;
    String pa;
    private TextView in;
    private TextView tv7;
    String u1="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);
        email = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText3);
        reg = (Button) findViewById(R.id.button4);
        un = (TextView)findViewById(R.id.textView8);
        op = (EditText)findViewById(R.id.editText2);
        in = (TextView) findViewById(R.id.textView9);
        tv7 = (TextView) findViewById(R.id.textView7);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pa=op.getText().toString();
                if(pa!=null && email.getText().toString()!=null)
                    save(v);
                else if(email.getText().toString()!=null)
                    in.setText("Invalid Password");
                else
                    tv7.setText("Invalid Username");
            }
        });
    }
    public void save(View v)
    {
        String text1 = email.getText().toString().trim();
        String text2 = pass.getText().toString().trim();
        String utext= op.getText().toString();
        FileInputStream fis=null;
        String u="";
        if(!text1.equals("")&& !text2.equals("")) {
            try {
                fis = openFileInput(text1);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text;
                while ((text = br.readLine()) != null) {
                    u = text;
                    break;
                }

                fis.close();

            } catch (Exception e) {
            }
            u.trim();
            if (pa.equals(u)) {

                FileOutputStream fos = null;


                String File_Name = ("00" + (u));


                u1 = "";
                try {
                    fis = openFileInput(File_Name);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String text;
                    while ((text = br.readLine()) != null) {
                        u1 = u1 + "\n" + text;
                    }

                    fis.close();

                } catch (Exception e) {
                }


                try {
                    fos = openFileOutput(text1, MODE_PRIVATE);
                    try {
                        fos.write(text2.getBytes());
                        email.getText().clear();
                        pass.getText().clear();
                        op.getText().clear();
                        Toast.makeText(this, "Saved to " + getFilesDir() + "/" + text1, Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else
                in.setText("Wrong Password / Username Already Exists");

            FileOutputStream fos = null;
            try {
                fos = openFileOutput(("00" + text2), MODE_APPEND);
                fos.write(u1.getBytes());
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else
        {

            tv7.setText("Inavlid Username");
            un.setText("Invalid Password");
        }
    }
}
