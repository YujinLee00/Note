package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class EnterPassword extends AppCompatActivity {
    byte len = 0;
    String input_password = "";

    EditText etxtv_password_1;
    EditText etxtv_password_2;
    EditText etxtv_password_3;
    EditText etxtv_password_4;

    String pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        etxtv_password_1 = findViewById(R.id.etxtv_password_1);
        etxtv_password_2 = findViewById(R.id.etxtv_password_2);
        etxtv_password_3 = findViewById(R.id.etxtv_password_3);
        etxtv_password_4 = findViewById(R.id.etxtv_password_4);
        etxtv_password_1.setTextColor(Color.parseColor("#FFFFB74D"));
        etxtv_password_2.setTextColor(Color.parseColor("#FFFFB74D"));
        etxtv_password_3.setTextColor(Color.parseColor("#FFFFB74D"));
        etxtv_password_4.setTextColor(Color.parseColor("#FFFFB74D"));

        SharedPreferences sp = getSharedPreferences("Password", MODE_PRIVATE);
        pw = sp.getString("pw", "0000");

    }

    public void onClickBtnPassword(View view) {
        switch (view.getId()) {
//            각 버튼(숫자) 터치시에 대한 내용임.
            case R.id.btn_0:
                if(len == 0) {
                    len++;
                    input_password = "0";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "0";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "0";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "0";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_1:
                if(len == 0) {
                    len++;
                    input_password = "1";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "1";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "1";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "1";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_2:
                if(len == 0) {
                    len++;
                    input_password = "2";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "2";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "2";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "2";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_3:
                if(len == 0) {
                    len++;
                    input_password = "3";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "3";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "3";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "3";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_4:
                if(len == 0) {
                    len++;
                    input_password = "4";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "4";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "4";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "4";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_5:
                if(len == 0) {
                    len++;
                    input_password = "5";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "5";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "5";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "5";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_6:
                if(len == 0) {
                    len++;
                    input_password = "6";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "6";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "6";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "6";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_7:
                if(len == 0) {
                    len++;
                    input_password = "7";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "7";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "7";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "7";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_8:
                if(len == 0) {
                    len++;
                    input_password = "8";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "8";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "8";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "8";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.btn_9:
                if(len == 0) {
                    len++;
                    input_password = "9";
                    etxtv_password_1.setText("●");
                }
                else if(len == 1) {
                    len++;
                    input_password += "9";
                    etxtv_password_2.setText("●");
                }
                else if(len == 2) {
                    len++;
                    input_password += "9";
                    etxtv_password_3.setText("●");
                }
                else if(len == 3) {
                    len++;
                    input_password += "9";
                    etxtv_password_4.setText("●");
                }
                break;
            case R.id.imgbtn_back:

                if(len == 1) {
                    len--;
                    input_password = "";
                    etxtv_password_1.setText("");
                }
                else if(len == 2) {
                    len--;
                    input_password = input_password.substring(0, 1);

                    etxtv_password_2.setText("");
                }
                else if(len == 3) {
                    len--;
                    input_password = input_password.substring(0, 2);
                    etxtv_password_3.setText("");
                }
                break;
        }
        if(len == 4) {
            if (input_password.equals(pw)) {
                Intent intent = new Intent(EnterPassword.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, R.string.Toast_connect, Toast.LENGTH_SHORT).show();
            }
            else {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(300);

                Toast.makeText(this, R.string.Toast_denied, Toast.LENGTH_SHORT).show();
                len = 0;
                input_password = "";
                etxtv_password_1.setText("");
                etxtv_password_2.setText("");
                etxtv_password_3.setText("");
                etxtv_password_4.setText("");
            }
        }
    }
}


