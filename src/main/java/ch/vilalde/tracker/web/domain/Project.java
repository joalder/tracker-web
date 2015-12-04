package ch.vilalde.tracker.web.domain;

/**
 * Project domain POJO
 */
public class Project {
    private String name;
    private String color;

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
}
