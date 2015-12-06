package ch.vilalde.tracker.web.domain;

/**
 * Task domain POJO
 */
public class Task {

    private String title;
    private int effortEstimated = 1;
    private int effortSpent = 0;
    private String priority = "Medium";
    private String description;

    public Task (){
    }

    public Task(String title, int effortEstimated, String priority, String description) {
        this.title = title;
        this.effortEstimated = effortEstimated;
        this.priority = priority;
        this.description = description;
    }

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

    public void addHour() {
        effortSpent += 1;
    }

    public boolean isValid() {
        return title != null && !title.equals("") &&
                effortEstimated != 0 &&
                description != null && !description.equals("") &&
                priority != null && !priority.equals("");
    }

    public String toString(){
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (effortEstimated != task.effortEstimated) return false;
        if (effortSpent != task.effortSpent) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (priority != null ? !priority.equals(task.priority) : task.priority != null) return false;
        return !(description != null ? !description.equals(task.description) : task.description != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + effortEstimated;
        result = 31 * result + effortSpent;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
