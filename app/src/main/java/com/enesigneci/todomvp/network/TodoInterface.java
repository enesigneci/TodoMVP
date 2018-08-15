package com.enesigneci.todomvp.network;

import com.enesigneci.todomvp.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoInterface {
    @GET("todos")
    Call<List<Todo>> getTodos();
}
