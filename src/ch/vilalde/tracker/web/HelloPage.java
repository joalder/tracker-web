package ch.vilalde.tracker.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * First bean to be created
 */
@ManagedBean
@RequestScoped
public class HelloPage {
    private String message = "Nope!";
    private int number = 0;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
