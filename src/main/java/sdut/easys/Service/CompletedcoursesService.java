package sdut.easys.Service;

import sdut.easys.Entity.CompletedCourse;

import java.util.List;

public interface CompletedcoursesService {
    List<CompletedCourse> getCompletedCourses(String studentno);

    int getCompletedCoursesCount(String studentno);
}
