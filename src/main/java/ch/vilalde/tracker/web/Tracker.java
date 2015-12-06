package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;
import ch.vilalde.tracker.web.domain.Task;
import ch.vilalde.tracker.web.domain.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Data holder for projects and tasks
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class Tracker {

    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private String search;

    public Tracker() {
        Project project = new Project("Dummy Project", "FF0000");
        project.addTask(new Task("Task #1", 10, "High", "Some text..."));
        project.addTask(new Task("Task #2", 6, "Medium", "Some more text..."));
        addProject(project);

        project = new Project("Other Project", "00FF00");
        project.addTask(new Task("Task #1", 16, "Low", "Some text..."));
        project.addTask(new Task("Task #2", 1, "High", "Some more text..."));
        addProject(project);

        users.add(new User("admin", "admin"));
    }

    public void addProject(Project project) {
        if (project != null && !projects.contains(project)) {
            projects.add(project);
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Project already exists!"));
        }
    }

    public ArrayList<Project> findProject(String query) {
        ArrayList<Project> results = new ArrayList<>();
        for (Project project : projects) {
            if (project.getName().startsWith(query)) {
                results.add(project);
            }
        }
        return results;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void doSearch() {
        if (search != null && !search.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Searching for '" + search + "'"));
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (user != null && !users.contains(user)) {
            users.add(user);
        }
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
}
