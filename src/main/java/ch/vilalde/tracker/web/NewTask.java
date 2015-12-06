package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;
import ch.vilalde.tracker.web.domain.Task;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;

/**
 * Bean to handle new task creation
 */
@ManagedBean
@SessionScoped
public class NewTask {

    @ManagedProperty(value = "#{tracker}")
    private Tracker tracker;
    private Task task = new Task();
    private Project project;
    private ActionListener reset;
    private Boolean another = false;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void save() {
        if (project != null && task.isValid()) {
            project.addTask(task);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Added task '" + task.getTitle() + "' to project '" + project.getName() + "'"));
            reset();
            if(!another) {
                RequestContext.getCurrentInstance().execute("PF('newTask').hide()");
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Please fill all the fields!"));
        }
    }

    public void reset(){
        task = new Task();
    }

    public void setAnother(Boolean another) {
        this.another = another;
    }

    public Boolean getAnother() {
        return another;
    }
}
