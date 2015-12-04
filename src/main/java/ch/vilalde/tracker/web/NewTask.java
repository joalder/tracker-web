package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 * Bean to handle new task creation
 */
@ManagedBean
@SessionScoped
public class NewTask {

    @Inject
    private Tracker tracker;

    private String name;
    private int estimatedEffort;
    private Project project;
    private String description;

    public int getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(int estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
