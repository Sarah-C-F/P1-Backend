package servicesTests;

import daos.meetings.MeetingDao;
import daos.meetings.MeetingDaoPostgres;
import services.meetings.MeetingServices;
import services.meetings.MeetingServicesImpl;

import static org.mockito.Mockito.mock;

public class MeetingServicesTests {

    MeetingDao meetingDaoMock = mock(MeetingDao.class);
    MeetingServices meetingServices = new MeetingServicesImpl(meetingDaoMock);

}
