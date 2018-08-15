package com.enesigneci.todomvp.main;

import android.Manifest;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.enesigneci.todomvp.R;
import com.enesigneci.todomvp.adapter.TodoAdapter;
import com.enesigneci.todomvp.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewInterface{
    MainPresenter presenter;
    RecyclerView rvTodos;
    TodoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTodos=findViewById(R.id.todos_recycler);
        adapter=new TodoAdapter(MainActivity.this);
        rvTodos.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        rvTodos.setAdapter(adapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.INTERNET},0);
        }
        presenter =new MainPresenter(this);
        presenter.getTodos();


    }
    @Override
    public void onTodosLoaded(List<Todo> todoList) {
        Log.d("All Todos from MainView",todoList.toString());
        adapter.setTodoList(todoList);
    }
}
