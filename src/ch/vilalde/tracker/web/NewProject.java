package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;
import ch.vilalde.tracker.web.domain.Task;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.awt.*;

/**
 * Bean to handle project creation
 */
@ManagedBean
@SessionScoped
public class NewProject {
    private String name;
    private Color color;
    private Tracker tracker;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
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

    public void clear(){
        name = null;
        color = null;
    }

    public Boolean isValid(){
        return name != null && color != null;
    }

    public void save() {
        if(isValid()) {
            Project project = new Project(name, color);
            tracker.addProject(project);
            clear();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Project " + project.getName() + " added!"));
        }else{
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Please fill all the fields"));
        }
    }
}
