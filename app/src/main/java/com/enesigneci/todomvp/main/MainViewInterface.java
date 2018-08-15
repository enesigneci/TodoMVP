package com.enesigneci.todomvp.main;

import com.enesigneci.todomvp.model.Todo;

import java.util.List;

public interface MainViewInterface {
    void onTodosLoaded(List<Todo> todoList);
}
