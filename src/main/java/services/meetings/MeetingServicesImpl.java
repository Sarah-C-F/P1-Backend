package services.meetings;

import daos.meetings.MeetingDao;
import entities.Meeting;

import java.util.ArrayList;

public class MeetingServicesImpl implements MeetingServices{

    private MeetingDao meetingDao;

    public MeetingServicesImpl(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    @Override
    public ArrayList<Meeting> getAllMeetings() {
        return this.meetingDao.getAllMeetings();
    }

    @Override
    public int createMeeting(Meeting meeting) {
        System.out.println(2);
        return this.meetingDao.createMeeting(meeting);
    }
}
