package com.enesigneci.todomvp.main;

import android.app.Activity;

import com.enesigneci.todomvp.model.Todo;
import com.enesigneci.todomvp.network.NetworkClient;
import com.enesigneci.todomvp.network.TodoInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainViewInterface mainViewInterface;
    private List<Todo> todoList;
    public MainPresenter(MainViewInterface mainViewInterface) {
        this.mainViewInterface = mainViewInterface;
    }
    public List<Todo> getTodos(){
        NetworkClient.getInstance().create(TodoInterface.class).getTodos().enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if (response.isSuccessful()){
                    todoList=response.body();
                    mainViewInterface.onTodosLoaded(todoList);
                }
                else {
                    todoList=new ArrayList<>();
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                todoList=new ArrayList<>();
            }
        });
        return todoList;
    }
}
