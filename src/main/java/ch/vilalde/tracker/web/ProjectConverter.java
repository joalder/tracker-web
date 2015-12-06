package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.Project;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Converter for the Project class. Used in dropdown's and such
 */
//@FacesConverter(forClass = Project.class)
@ManagedBean
@RequestScoped
public class ProjectConverter implements Converter {

    @ManagedProperty(value = "#{tracker}")
    private Tracker tracker;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        for (Project project : tracker.getProjects()) {
            if (project.getName().equals(s)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Project) {
            for (Project project : tracker.getProjects()) {
                if (project.equals(o)){
                    return project.getName();
                }
            }
        }
        return "";
    }
}
