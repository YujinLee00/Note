package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;



public class ViewNote extends AppCompatActivity {

    TextView textView_title;
    TextView textView_content;
    TextView textView_time;

    String title;
    String content;
    String time;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        textView_title = findViewById(R.id.txtv_title_View);
        textView_content = findViewById(R.id.txtv_content_View);
        textView_time = findViewById(R.id.txtv_time_View);

        Intent intent = getIntent();

        title = intent.getExtras().getString("title");
        content = intent.getExtras().getString("content");
        time = intent.getExtras().getString("time");
        position = intent.getExtras().getInt("position");

        textView_title.setText(title);
        textView_content.setText(content);
        String txt_time = getString(R.string.notepad_last_edit_time);
        textView_time.setText(txt_time + " " + time);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case(MotionEvent.ACTION_DOWN):
                Intent intent = new Intent(this, Edit_Note.class);
                intent.putExtra("title",title);
                intent.putExtra("content",content);
                intent.putExtra("time", time);
                intent.putExtra("position", position);
                startActivity(intent);
                finish();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ViewNote.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}


