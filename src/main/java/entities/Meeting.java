package entities;

public class Meeting {
    int meetingId;
    long meetingDate;
    String topic;

    public Meeting() {
    }

    public Meeting(int meetingId, long meetingDate, String topic) {
        this.meetingId = meetingId;
        this.meetingDate = meetingDate;
        this.topic = topic;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public long getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(long meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + meetingId +
                ", meetingDate=" + meetingDate +
                ", topic='" + topic + '\'' +
                '}';
    }

}
