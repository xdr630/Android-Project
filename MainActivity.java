package com.example.task15;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeorder.Order.Chocolate;
import com.example.coffeeorder.Order.Cookies;
import com.example.coffeeorder.Order.IceCream;
import com.example.coffeeorder.Order.Order;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn_reset;
    private EditText edt1, edt2;
    private int n = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn_reset = (Button)findViewById(R.id.btn_reset);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else if (edt2.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edt1.getText().toString().trim().equals("xdr")) {
                    if (edt2.getText().toString().trim().equals("1234")) {
                        Toast.makeText(MainActivity.this, "欢迎进入咖啡厅!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(intent);
                    }
                } else {
                    n++;
                    Toast.makeText(MainActivity.this, "用户名或密码错误!", Toast.LENGTH_SHORT).show();
                    if (n > 3) {
                        System.exit(0);
                    }
                }
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();

                alert.setTitle("退出？");
                alert.setMessage("真的要退出本软件吗？");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.show();
            }
        });
    }
}
