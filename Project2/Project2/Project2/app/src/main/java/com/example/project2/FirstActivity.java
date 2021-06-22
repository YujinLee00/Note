package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FirstActivity extends AppCompatActivity {

    private RecyclerView mRv_todo;
    private Button mBtn_write;
    private ArrayList<TodoItem> mTodoItems;
    private DBHelper mDBHelper;
    private CustomAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        setInit();

    }

    private void setInit() {
        mDBHelper = new DBHelper(this);
        mRv_todo = findViewById(R.id.rv_todo);
        mBtn_write = findViewById(R.id.mBtn_write);
        mTodoItems = new ArrayList<>();



//        loadRecentDB();

        mBtn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, Dialog_edit.class);
                startActivity(intent);
//                EditText edit_title = findViewById(R.id.edit_title);
//                EditText edit_content = findViewById(R.id.edit_content);
//                Button btn_ck = findViewById(R.id.btn_ck);
//                btn_ck.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date());
//
//                        mDBHelper.InsertTodo(edit_title.getText().toString(), edit_content.getText().toString(), currentTime);
//
//                        TodoItem item = new TodoItem();
//                        item.setTitle(edit_title.getText().toString());
//                        item.setContent(edit_content.getText().toString());
//                        item.setWriteDate(currentTime);
//
//                        mAdapter.addItem(item);
//                        mRv_todo.smoothScrollToPosition(0);
//
//                        Toast.makeText(FirstActivity.this, "목록에 추가되었습니다",Toast.LENGTH_SHORT).show();
//
//                    }
//                });



            }
        });
    }

//    private void loadRecentDB() {
//        mTodoItems = mDBHelper.getTodoList();
//        if (mAdapter == null) {
//            mAdapter = new CustomAdapter(mTodoItems, this);
//            mRv_todo.setHasFixedSize(true);
//            mRv_todo.setAdapter(mAdapter);
//        }
//    }
}