package com.example.clase1.modelos;

public class Task {
    private  long id;
    private  String title;
    private  String description;
    private  String priority;
    private  boolean finished;



    public Task(long id, String title, String description, String priority, boolean finished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.finished = finished;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
