package daos.meetings;

import entities.Meeting;

import java.util.ArrayList;

public interface MeetingDao {

    ArrayList<Meeting> getAllMeetings();

    int createMeeting(Meeting meeting);
}
