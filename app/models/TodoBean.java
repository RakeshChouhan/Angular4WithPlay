package models;

public class TodoBean{
    private String task;

    public TodoBean(String task){
        this.task = task;
    }

    public void setTask(String task){
        this.task = task;
    }
    public String getTask(){
        return task;
    }
}