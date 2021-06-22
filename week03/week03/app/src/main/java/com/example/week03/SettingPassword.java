package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SettingPassword extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);
        editText = findViewById(R.id.etxtv_settingpassword);


        editText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


        ImageButton imageButton_cancel = findViewById(R.id.imgbtn_cancel_setting_password);
        imageButton_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingPassword.this, R.string.Toast_password_cancel, Toast.LENGTH_SHORT).show();

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                finish();
            }
        });


        ImageButton imageButton_ok = findViewById(R.id.imgbtn_ok_setting_password);
        imageButton_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String setPW = editText.getText().toString();

                if (setPW.length() < 4) {
                    Toast.makeText(SettingPassword.this, R.string.Toast_password_limit, Toast.LENGTH_SHORT).show();

                    return;
                }


                SharedPreferences sp = getSharedPreferences("Password", MODE_PRIVATE);
                String checker = sp.getString("pw", "0000");

                if (setPW.equals(checker)) {
                    Toast.makeText(SettingPassword.this, R.string.Toast_password_not_change, Toast.LENGTH_LONG).show();
                    editText.setText("");
                }
                else {

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("pw", setPW);
                    editor.apply();


                    Resources resources = getResources();
                    String tmp = String.format(resources.getString(R.string.Toast_password_ok), setPW);

                    Toast.makeText(SettingPassword.this, tmp, Toast.LENGTH_LONG).show();


                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    finish();
                }
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(SettingPassword.this, R.string.Toast_password_cancel, Toast.LENGTH_SHORT).show();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        finish();
    }
}
