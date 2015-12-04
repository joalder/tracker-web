package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;
import ch.vilalde.tracker.web.domain.Task;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Data holder for projects and tasks
 */
@ManagedBean
@SessionScoped
public class Tracker {


    private ArrayList<Project> projects = new ArrayList<>();

    public Tracker() {
    }

    public void addProject(Project project) {
        if (project != null && !projects.contains(project)) {
            projects.add(project);
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Project already exists!"));
        }
    }

    public ArrayList<Project> findProject(String query){
        ArrayList<Project> results = new ArrayList<>();
        for(Project project : projects){
            if(project.getName().startsWith(query)){
                results.add(project);
            }
        }
        return results;
    }
}
