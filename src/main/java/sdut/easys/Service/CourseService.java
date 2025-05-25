package sdut.easys.Service;

import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByTeacherId(int teacherid);

    List<CompletedCourse> getScoreByCourseid(int courseid);

    List<Course> getCourseList();

    int getCourseCount();
}
