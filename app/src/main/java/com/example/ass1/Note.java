package com.example.ass1;

public class Note {
    private String Task ;
    private String date ;
    private String state ;


    public Note() {
    }

    public Note(String task, String date, String state) {
        Task = task;
        this.date = date;
        this.state = state;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    } //

    public void setState(String state) {
        this.state = state;
    } //

    @Override
    public String toString() {
        return "Note{" +
                "Task='" + Task + '\'' +
                ", date='" + date + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
