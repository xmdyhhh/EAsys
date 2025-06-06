package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Course;
import sdut.easys.Service.CourseService;
import sdut.easys.dto.CourseDTO;
import sdut.easys.mapper.CourseMapper;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getCourseByTeacherId(int teacherid) {
        return courseMapper.getCourseByTeacherId(teacherid);
    }

    @Override
    public List<CompletedCourse> getScoreByCourseid(int courseid) {
        return courseMapper.getScoreByCourseid(courseid);
    }

    @Override
    public List<Course> getCourseList() {
        return courseMapper.getCourseList();
    }

    @Override
    public int getCourseCount() {
        return courseMapper.getCourseCount();
    }

    @Override
    public boolean addCourse(CourseDTO courseDTO) {
        return courseMapper.addCourse(courseDTO) > 0;
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) {
        return courseMapper.updateCourse(courseDTO) > 0;
    }

    @Override
    public boolean deleteCourse(int courseID) {
        return courseMapper.deleteCourse(courseID) > 0;
    }

    @Override
    public List<Course> getCourses(String courseName) {
        return courseMapper.getCourses(courseName);
    }
}