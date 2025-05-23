package sdut.easys.Service;

import java.util.List;

public interface EnrollmentService {
    List getSelectedCourses(String studentno);

    int getSelectedCount(String studentno);

    List getAvailableCourses(String studentno);

    int getAvailableCount(String studentno);

    boolean selectCourse(String studentno, int courseid);

    boolean exitCourse(String studentno, int courseid);
}
