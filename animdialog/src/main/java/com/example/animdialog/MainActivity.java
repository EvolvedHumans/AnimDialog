package com.example.animdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/*
仿58同城的退出动画
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置顶部状态栏为透明
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);
    }
    /*
    点击退出按钮键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("提示:");
//        builder.setMessage("这是一个普通对话框");
//        builder.setIcon(R.drawable.ic_launcher_background);
       // builder.setCancelable(false); //点击对话框以外的位置，是否让对话框消失
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Window window = alertDialog.getWindow(); //获取对话框窗口
        window.setGravity(Gravity.CENTER);
        window.setContentView(R.layout.dialog_layout);
        Button button1 = window.findViewById(R.id.buttonPanel1);
        Button button2 = window.findViewById(R.id.buttonPanel2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        return super.onKeyDown(keyCode,event);
    }

}
