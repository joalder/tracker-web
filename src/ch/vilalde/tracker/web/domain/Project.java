package ch.vilalde.tracker.web.domain;

import java.awt.*;

/**
 * Project domain POJO
 */
public class Project {
    private String name;
    private Color color;

    public Project(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
