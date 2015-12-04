package ch.vilalde.tracker.web.domain;

import java.util.ArrayList;

/**
 * Project domain POJO
 */
public class Project {
    private String name;
    private String color;
    private ArrayList<Task> tasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        if(task != null) {
            tasks.add(task);
        }
    }

    public boolean isValid() {
        return name != null && color != null;
    }

    public String toString(){
        return name;
    }
}
