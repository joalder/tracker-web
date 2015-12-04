package ch.vilalde.tracker.web.domain;

/**
 * Task domain POJO
 */
public class Task {

    private String title;
    private int effortEstimated;
    private int effortSpent;
    private String priority;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEffortEstimated() {
        return effortEstimated;
    }

    public void setEffortEstimated(int effortEstimated) {
        this.effortEstimated = effortEstimated;
    }

    public int getEffortSpent() {
        return effortSpent;
    }

    public void setEffortSpent(int effortSpent) {
        this.effortSpent = effortSpent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValid() {
        return title != null && !title.equals("") &&
                effortEstimated != 0 &&
                description != null && !description.equals("") &&
                priority != null && !priority.equals("");
    }
}
