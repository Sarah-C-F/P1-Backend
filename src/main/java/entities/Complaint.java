package entities;

public class Complaint {
    private int complaintId;
    private String firstName;
    private String lastName;
    private String description;
    private Level priority = Level.UNASSIGNED;
    private int meeting = 0;

    public Complaint() {
    }

    public Complaint(String givePriority, int meeting) {
        this.priority = Level.valueOf(givePriority);
        this.meeting = meeting;
    }

    public Complaint(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getPriority() {
        return priority;
    }

    public void setPriority(String temp) {
        temp = temp.toUpperCase();
        this.priority = Level.valueOf(temp);
    }

    public int getMeeting() {
        return meeting;
    }

    public void setMeeting(int meeting) {
        this.meeting = meeting;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", meeting=" + meeting +
                '}';
    }
}
