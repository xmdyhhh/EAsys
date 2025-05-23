package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Course;
import sdut.easys.Service.EnrollmentService;
import sdut.easys.mapper.EnrollmentMapper;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    @Autowired
    private EnrollmentMapper  enrollmentMapper;

    @Override
    public List<Course> getSelectedCourses(String studentno) {
        return enrollmentMapper.getSelectedCourses(studentno);
    }

    @Override
    public int getSelectedCount(String studentno) {
        return enrollmentMapper.getSelectedCount(studentno);
    }

    @Override
    public List<Course> getAvailableCourses(String studentno) {
        return enrollmentMapper.getAvailableCourses(studentno);
    }

    @Override
    public int getAvailableCount(String studentno) {
        return enrollmentMapper.getAvailableCount(studentno);
    }

    public boolean selectCourse(String studentno, int courseid) {
        int maxEnrollment = enrollmentMapper.getMaxEnrollment(courseid);
        int currentEnrollment = enrollmentMapper.getCurrentEnrollment(courseid);
        if (currentEnrollment >= maxEnrollment) {
            return false;
        }
        int rowsAffected = enrollmentMapper.selectCourse(studentno, courseid);
        enrollmentMapper.updateCurrentEnrollment1(courseid);
        return rowsAffected > 0;
    }

    public boolean exitCourse(String studentno, int courseid) {
        int rowsAffected = enrollmentMapper.exitCourse(studentno, courseid);
        enrollmentMapper.updateCurrentEnrollment2(courseid);
        return rowsAffected > 0;
    }
}
