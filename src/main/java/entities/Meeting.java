package entities;

public class Meeting {
    int meetingId;
    MeetMonth meetMonth;
    int meetDay;
    String topic;


    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public MeetMonth getMeetMonth() {
        return meetMonth;
    }

    public void setMeetMonth(String month) {
        month = month.toUpperCase();
        this.meetMonth = MeetMonth.valueOf(month);
    }

    public int getMeetDay() {
        return meetDay;
    }

    public void setMeetDay(int meetDay) {
        this.meetDay = meetDay;
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
                ", meetMonth=" + meetMonth +
                ", meetDay=" + meetDay +
                ", topic='" + topic + '\'' +
                '}';
    }
}
