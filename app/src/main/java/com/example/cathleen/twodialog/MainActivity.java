package com.example.cathleen.twodialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;


/**
 * ？？？EditText获取不到内容，停止运行
 * 解决方法
 *LayoutInflater inflater = getLayoutInflater();
 *builder.setView(inflater.inflate(R.layout.log, null))
 * 换成
 *log = (LinearLayout)getLayoutInflater().inflate(R.layout.log,null);
 builder.setView(log)
 */

public class MainActivity extends AppCompatActivity {
    Button loginDialog,infroDialog;
    EditText userName,psw;
    String un,ps;
    LinearLayout log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 登录对话框
         */
        loginDialog = (Button)findViewById(R.id.loginDialog);
        loginDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                log = (LinearLayout)getLayoutInflater().inflate(R.layout.log,null);
                builder.setView(log);
                builder.setTitle("Login");


                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"取消？",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userName = (EditText)log.findViewById(R.id.userName);
                        un = userName.getText().toString();
                        psw = (EditText)log.findViewById((R.id.psw));
                        ps = psw.getText().toString();
                        if(!un.equals("abc")){
                            Toast.makeText(MainActivity.this,"用户名不正确",Toast.LENGTH_SHORT).show();
                        }
                        if(!ps.equals("123")){
                            Toast.makeText(MainActivity.this,"密码不正确",Toast.LENGTH_SHORT).show();
                        }
                        if(un.equals("abc")&&ps.equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder.create();
                builder.show();
            }
        });
        /**
         * 提示对话框
         */
        infroDialog = (Button)findViewById(R.id.infroDialog);
        infroDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Information");
                builder.setMessage("这是一个普通的对话框");
                builder.setNeutralButton("忽略？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"单击了忽略",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"单击了取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"单击了确定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }
}
