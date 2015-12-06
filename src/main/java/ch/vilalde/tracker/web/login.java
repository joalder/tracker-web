package ch.vilalde.tracker.web;

import ch.vilalde.tracker.web.domain.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Login and registration page
 */
@ManagedBean
@SessionScoped
public class Login {

    @ManagedProperty("#{tracker}")
    private Tracker tracker;
    private User user = new User();
    private String welcomeMessage;
    private Boolean loggedIn = false;

    public String register() throws IOException {
        if (user != null && user.isValid() && !tracker.getUsers().contains(user)) {
            tracker.addUser(user);
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Registered user '" + user.getName() + "'"));
            login();
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Failed to register!"));
        }
        return "";
    }

    public void login() throws IOException {
        if (user != null && tracker.getUsers().contains(user)) {
            loggedIn = true;
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Logged in as user '" + user.getName() + "'"));
            context.getExternalContext().getFlash().setKeepMessages(true);
            context.getExternalContext().redirect("index.xhtml");
            context.responseComplete();
        } else {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Failed to login!"));
        }
    }

    public void logout() throws IOException {
        loggedIn = false;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Logged out!"));
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.getExternalContext().redirect("login.xhtml");
        context.responseComplete();
    }

    public void reset(){
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Not implemented, sorry!"));
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.welcomeMessage = "Hello " + user.getName();
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
