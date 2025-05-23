package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Course;
import sdut.easys.Entity.Schedule;
import sdut.easys.mapper.EnrollmentMapper;
import sdut.easys.mapper.ScheduleMapper;
import sdut.easys.Service.ScheduleService;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public void updateSchedule(String studentno) {
        scheduleMapper.dropSchedule();
        scheduleMapper.createSchedule();
        List<Course> courses =enrollmentMapper.getSelectedCourses(studentno);
        courses.forEach(course -> {
            Schedule schedule = new Schedule();
            // 设置schedule的属性
            schedule.setCoursename(course.getCoursename());
            schedule.setTeachername(course.getTeachername());
            schedule.setClassroom(course.getClassroom());
            schedule.setDayofweek(course.getDayofweek().substring(0, 2));
            schedule.setStarttime(course.getStarttime().substring(0, 5));
            schedule.setEndtime(course.getEndtime().substring(0, 5));
            // 插入到数据库
            scheduleMapper.insertSchedule(schedule);
        });
    }

    @Override
    public List<Schedule> getSchedule() {
        return scheduleMapper.getSchedule();
    }

    @Override
    public int getScheduleCount() {
        return scheduleMapper.getScheduleCount();
    }
}
