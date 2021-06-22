package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Edit_Note extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase database;
    String tableName;
    String dbName;

    EditText editText_title;
    EditText editText_content;

    TextView textView_time;

    String title;
    String content;
    String time;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__note);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();
        dbName = "notepad.db";
        tableName = "noteData";

        editText_title = findViewById(R.id.etxtv_title_edit);
        editText_content = findViewById(R.id.etxtv_content_edit);
        textView_time = findViewById(R.id.txtv_time_edit);

        Intent intent = getIntent();

        title = intent.getExtras().getString("title");
        content = intent.getExtras().getString("content");
        time = intent.getExtras().getString("time");
        position = intent.getExtras().getInt("position");


        editText_title.setText(title);
        editText_content.setText(content);
        String txt_time = getString(R.string.notepad_last_edit_time);
        textView_time.setText(txt_time+ " " + time);

        Button button_save = findViewById(R.id.btn_save_edit);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_title = editText_title.getText().toString();
                String edit_content = editText_content.getText().toString();
                ContentValues contentValues = new ContentValues();

                if(TextUtils.isEmpty(edit_title) && TextUtils.isEmpty(edit_content)){

                    Toast.makeText(Edit_Note.this, R.string.Toast_not_save, Toast.LENGTH_LONG).show();
                    database.delete("noteData", "_id=?", new String[] {String.valueOf(position)});

                    finish();

                    Intent intent1 = new Intent(Edit_Note.this, MainActivity.class);
                    startActivity(intent1);

                    return;
                }

                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String formatDate = sdfNow.format(mDate);



                if (title.equals(edit_title) && content.equals(edit_content)) {
                    Intent intent1 = new Intent(Edit_Note.this, MainActivity.class);
                    Toast.makeText(Edit_Note.this, R.string.Toast_not_save, Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                    return;
                }
                contentValues.put("title", edit_title);
                contentValues.put("content", edit_content);
                contentValues.put("time", formatDate);
                Toast.makeText(Edit_Note.this, R.string.Toast_edit, Toast.LENGTH_SHORT).show();
                database.update("noteData", contentValues, "_id=?", new String[] {String.valueOf(position)});

                finish();
                Intent intent1 = new Intent(Edit_Note.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        Button button_delete = findViewById(R.id.btn_delete_edit);

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Edit_Note.this, R.string.Toast_delete, Toast.LENGTH_SHORT).show();
                database.delete("noteData", "_id=?", new String[] {String.valueOf(position)});
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                finish();
                Intent intent1 = new Intent(Edit_Note.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Edit_Note.this, ViewNote.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        intent.putExtra("time", time);
        intent.putExtra("position", position);
        startActivity(intent);
        finish();

    }
}


