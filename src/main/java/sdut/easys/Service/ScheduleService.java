package sdut.easys.Service;

import sdut.easys.Entity.Schedule;

import java.util.List;

public interface ScheduleService {

    void updateSchedule(String studentno);

    List<Schedule> getSchedule();

    int getScheduleCount();
}
