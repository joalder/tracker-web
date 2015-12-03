package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;
import ch.vilalde.tracker.web.domain.Task;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Data holder for projects and tasks
 */
@ManagedBean
@SessionScoped
public class Tracker {


    private ArrayList<Project> projects = new ArrayList<>();
    private HashMap<Project, ArrayList<Task>> tasks = new HashMap<>();

    @Inject
    public Tracker() {
    }

    public void addTask(Project project, Task task) {
        if (tasks.containsKey(project)) {
            ArrayList<Task> currentTaskList = tasks.get(project);
            currentTaskList.add(task);
        }
    }

    public ArrayList<Task> getTasks(Project project) {
        if (tasks.containsKey(project)) {
            return tasks.get(project);
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Given project '" + project + "' does not exist!"));
            return new ArrayList<>();
        }
    }

    public void addProject(Project project) {
        if (!projects.contains(project)) {
            projects.add(project);
            tasks.put(project, new ArrayList<>());
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Project already exists!"));
        }
    }
}
