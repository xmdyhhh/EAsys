package sdut.easys.Service;

import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Course;
import sdut.easys.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByTeacherId(int teacherid);

    List<CompletedCourse> getScoreByCourseid(int courseid);

    List<Course> getCourseList();

    int getCourseCount();

    boolean addCourse(CourseDTO courseDTO);

    boolean updateCourse(CourseDTO courseDTO);

    boolean deleteCourse(int courseID);

    List<Course> getCourses(String coursename);
}
