package com.enesigneci.todomvp.model;

public class Todo {
    private int userId;
    private int id;
    private String title;



    private boolean completed;

    public Todo() {

    }

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
