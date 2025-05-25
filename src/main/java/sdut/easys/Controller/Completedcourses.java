package sdut.easys.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Student;
import sdut.easys.Service.CompletedcoursesService;
import sdut.easys.Util.Result;

import java.util.List;

@RestController
@RequestMapping("/completed")
@Slf4j
public class Completedcourses {

    @Autowired
    private CompletedcoursesService completedcoursesService;

    @RequestMapping("/list")
    public Object getCompletedCourses(HttpSession session){
        try {
            Student student = (Student) session.getAttribute("student");
            if (student == null) {
                return Result.error("未登录");
            }
            String studentno = student.getStudentno();
            List<CompletedCourse> courses = completedcoursesService.getCompletedCourses(studentno);
            int count = completedcoursesService.getCompletedCoursesCount(studentno);
            return Result.success(courses, count);
        } catch (Exception e) {
            log.error("获取已修课程失败", e);
            return Result.error("获取已修课程失败，请稍后再试");
        }
    }
}
