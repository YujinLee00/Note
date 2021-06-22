package com.example.week03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    SQLiteDatabase database;
    String tableName;
    String dbName;
    Intent intent_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbName = "notepad.db";
        tableName = "noteData";

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        createDatabase();
        createTable(tableName);
        executeQuery();


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewNote.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.xml.menu, menu);
        MenuItem mSearch = menu.findItem(R.id.menu_search);
        final SearchView mSearchView = (SearchView)mSearch.getActionView();
        mSearchView.setQueryHint("Search");


        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                mSearchView.clearFocus();

                return false;
            }
        });
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchView.setIconified(false);

            }
        });
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchQuery(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {

                    executeQueryNotSpace();
                }
                else{

                    searchQuery(newText);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_info:
                intent_toolbar = new Intent(MainActivity.this, Info.class);
                startActivity(intent_toolbar);
                break;
            case R.id.menu_password:
                intent_toolbar = new Intent(MainActivity.this, SettingPassword.class);
                startActivity(intent_toolbar);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void searchQuery(String query) {
        String sql = "select * from noteData " +
                "where content Like "+"'%"+query+"%'"+"or title Like "+"'%"+query+"%'"+ "order by time DESC";


        Intent intent = new Intent(MainActivity.this, NoteSearchAdapter.class);
        intent.putExtra("sql", sql);


        Cursor cursor = database.rawQuery("select * from noteData " +
                "where content Like "+"'%"+query+"%'"+"or title Like "+"'%"+query+"%'"+ "order by time DESC", null);


        int recordCount = cursor.getCount();

        NoteSearchAdapter adapter = new NoteSearchAdapter(intent);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            String title = cursor.getString(1);
            String content = cursor.getString(2);
            adapter.addItem(new NoteList(title, content));

        }

        recyclerView.setAdapter(adapter);

        cursor.close();
    }

    private void createDatabase() {
        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

    }

    private void createTable(String name) {
        database.execSQL("create table if not exists " + name + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " title text, "
                + " content text, "
                + " time text)");

    }

    public void executeQuery() {
        Cursor cursor = database.rawQuery("select _id, title, content from noteData order by time DESC", null);

        int recordCount = cursor.getCount();

        NoteAdapter adapter = new NoteAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            String title = cursor.getString(1);
            String content = cursor.getString(2);
            adapter.addItem(new NoteList(title, content));

        }

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(20);
        recyclerView.addItemDecoration(spaceDecoration);


        recyclerView.setAdapter(adapter);


        cursor.close();
    }

    public void executeQueryNotSpace() {
        Cursor cursor = database.rawQuery("select _id, title, content from noteData order by time DESC", null);

        int recordCount = cursor.getCount();

        NoteAdapter adapter = new NoteAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();
            String title = cursor.getString(1);
            String content = cursor.getString(2);
            adapter.addItem(new NoteList(title, content));

        }
        recyclerView.setAdapter(adapter);


        cursor.close();
    }
}


