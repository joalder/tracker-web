package ch.vilalde.tracker.web.domain;

import java.awt.*;
import java.util.ArrayList;

/**
 * Project domain POJO
 */
public class Project {
    private String name;
    private String color;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String name, String color) {
        this.name = name;
        this.color = color;
    }

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

    public int getTaskSize(int index) {
        if (index < 2) {
            return 4;
        } else if (index < 10) {
            return 2;
        } else {
            return 1;
        }
    }

    public String getTaskColor(int index) {
        Color projectColor = Color.decode("#" + color);
        Color taskColor = new Color(projectColor.getRed(), projectColor.getGreen(), projectColor.getBlue(), 55 + getTaskSize(index) * 50);
        return String.format("rgba(%d, %d, %d, %f)", taskColor.getRed(), taskColor.getGreen(), taskColor.getBlue(), taskColor.getAlpha() / 255.0);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    public boolean isValid() {
        return name != null && color != null;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        return !(color != null ? !color.equals(project.color) : project.color != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
