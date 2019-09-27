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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddInfo extends AppCompatActivity {
    private Button s;
    private EditText n;
    private EditText p;
    private EditText b;
    private EditText a;
    private EditText r;
    public static String File_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_info);
        n = (EditText) findViewById(R.id.editText4);
        p = (EditText) findViewById(R.id.editText6);
        b = (EditText) findViewById(R.id.editText7);
        a = (EditText) findViewById(R.id.editText8);
        r = (EditText) findViewById(R.id.editText9);
        s = (Button) findViewById(R.id.button9);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method();

            }
        });

    }
    public void method()
    {
        final String text1 ="Name: "+ n.getText().toString()+"\n";
        final String text2 ="Mob.: "+p.getText().toString()+"\n";
        final String text3 ="Blood Group: "+b.getText().toString()+"\n\n";
        final String text4 ="Adress: "+a.getText().toString()+"\n";
        final String text5 ="Roll. no.: "+r.getText().toString()+"\n";
        Intent intent = getIntent();
        String File_Name = ("00"+(intent.getStringExtra(Information2.pas)));
        b.setText(File_Name);
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(File_Name, MODE_APPEND);
            fos.write(text1.getBytes());
            fos.write(text2.getBytes());
            fos.write(text4.getBytes());
            fos.write(text5.getBytes());
            fos.write(text3.getBytes());
            r.getText().clear();
            n.getText().clear();
            p.getText().clear();
            b.getText().clear();
            a.getText().clear();
            Toast.makeText(this, "Saved to "+getFilesDir()+"/"+File_Name,Toast.LENGTH_SHORT);
        } catch (Exception e) {
        } finally {
            if (fos != null) {
                try {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}

