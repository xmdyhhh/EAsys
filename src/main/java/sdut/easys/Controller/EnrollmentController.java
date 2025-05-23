package sdut.easys.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sdut.easys.Entity.Student;
import sdut.easys.Service.EnrollmentService;
import sdut.easys.Util.Result;
import sdut.easys.Entity.Course;


import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @RequestMapping("/selectedlist")
    public Object getSelectedCourses(HttpSession session) {
        try {
            Student student = (Student) session.getAttribute("student");
            if (student == null) {
                return Result.error("未登录");
            }
            String studentno = student.getStudentno();
            List<Course> courses = enrollmentService.getSelectedCourses(studentno);
            int count = enrollmentService.getSelectedCount(studentno);

            return Result.success(courses, count);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取已选课程失败");
        }
    }


    @RequestMapping("/availablelist")
    public Object getAvailableCourses(HttpSession session) {
        try {
            Student student = (Student) session.getAttribute("student");
            if (student == null) {
                return Result.error("未登录");
            }
            String studentno = student.getStudentno();
            List<Course> courses = enrollmentService.getAvailableCourses(studentno);
            int count = enrollmentService.getAvailableCount(studentno);
            return Result.success(courses, count);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("获取可选课程失败");
        }
    }

    @RequestMapping("/selectcourse")
    public Object selectCourse(HttpSession session, @RequestParam int courseid) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return Result.error("请先登录");
        }
        String studentno = student.getStudentno();
        try {
            boolean success = enrollmentService.selectCourse(studentno, courseid);
            if (success) {
                return Result.success("选课成功");
            } else {
                return Result.error("选课失败，该课程已满");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("服务器内部错误");
        }
    }

    @RequestMapping("/exitcourse")
    public Object exitCourse(HttpSession session, @RequestParam int courseid) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return Result.error("请先登录");
        }
        String studentno = student.getStudentno();
        try {
            boolean success = enrollmentService.exitCourse(studentno, courseid);
            if (success) {
                return Result.success("退课成功");
            } else {
                return Result.error("退课失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("服务器内部错误");
        }
    }
}