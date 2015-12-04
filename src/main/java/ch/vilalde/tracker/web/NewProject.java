package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;

/**
 * Bean to handle project creation
 */
@ManagedBean
@SessionScoped
public class NewProject {

    private Project project = new Project();
    @ManagedProperty(value = "#{tracker}")
    private Tracker tracker;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void save() {
        System.out.println("Trying to save project! Name: " + project.getName() + " Color: " + project.getColor());

        if(project.isValid()) {
            tracker.addProject(project);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Project " + project.getName() + " added!"));
            project = new Project();
        }else{
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Please fill all the fields"));
        }
    }

    public void reset(){
        project = new Project();
    }
}
