package com.enesigneci.todomvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enesigneci.todomvp.R;
import com.enesigneci.todomvp.model.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>{

    List<Todo> todoList;
    Context context;

    public TodoAdapter(List<Todo> todoList, Context context){
        this.todoList=todoList;
        this.context=context;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_item,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.title.setText(todoList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
    public void setTodoList(List<Todo> todoList){
        this.todoList=todoList;
        notifyDataSetChanged();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public TodoViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
        }
    }
}
