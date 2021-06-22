package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewNote extends AppCompatActivity {
    DatabaseHelper dbHelper;
    EditText editText_title;
    EditText editText_content;
    SQLiteDatabase database;
    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        tableName = "noteData";
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();
        editText_title = findViewById(R.id.etxtv_title_new);
        editText_content = findViewById(R.id.etxtv_content_new);



        editText_content.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        Button button = findViewById(R.id.btn_save_new);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteAdapter adapter = new NoteAdapter();
                adapter.addItem(new NoteList(editText_title.getText().toString(), editText_content.getText().toString()));



                String input_title = editText_title.getText().toString();
                String input_content = editText_content.getText().toString();


                try {
                    ContentValues contentValues = new ContentValues();


                    if(TextUtils.isEmpty(input_title) && TextUtils.isEmpty(input_content)){
                        Toast.makeText(NewNote.this, R.string.Toast_not_save, Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent = new Intent(NewNote.this, MainActivity.class);
                        startActivity(intent);
                        return;
                    }


                    long now = System.currentTimeMillis();
                    Date mDate = new Date(now);
                    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String formatDate = sdfNow.format(mDate);

                    contentValues.put("title", input_title);
                    contentValues.put("content", input_content);
                    contentValues.put("time", formatDate);

                    Toast.makeText(NewNote.this, R.string.Toast_save, Toast.LENGTH_SHORT).show();

                    database.insert(tableName, null, contentValues);
                }catch (Exception e) {
                    Log.e("ERROR", e.toString());
                }
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                finish();
                Intent intent = new Intent(NewNote.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(NewNote.this, MainActivity.class);
        startActivity(intent);

    }
}

