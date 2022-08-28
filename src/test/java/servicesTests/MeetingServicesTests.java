package servicesTests;

import daos.meetings.MeetingDao;
import daos.meetings.MeetingDaoPostgres;
import entities.Meeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.meetings.MeetingServices;
import services.meetings.MeetingServicesImpl;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MeetingServicesTests {

    MeetingDao meetingDaoMock = mock(MeetingDao.class);
    MeetingServices meetingServices = new MeetingServicesImpl(meetingDaoMock);
    Meeting test = new Meeting(0,1661708905, "testing");


    @Test
    void get_all_meetings_service_test_standard(){
        ArrayList<Meeting> testList = new ArrayList<>();
        testList.add(test);

        when(meetingDaoMock.getAllMeetings()).thenReturn(testList);

        ArrayList<Meeting> result = meetingServices.getAllMeetings();

        Assertions.assertEquals(1, result.size());
    }

    @Test
    void create_meeting_services_test_standard(){
        when(meetingDaoMock.createMeeting(test)).thenReturn(200);
        int result = meetingServices.createMeeting(test);

        Assertions.assertEquals(200, result);
    }
}
