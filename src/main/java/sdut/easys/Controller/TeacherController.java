package sdut.easys.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Course;
import sdut.easys.Entity.Teacher;
import sdut.easys.Service.CourseService;
import sdut.easys.Service.TeacherService;
import sdut.easys.Util.Result;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;

    @PostMapping("/login")
    public Result<Teacher> login(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 HttpSession session) {
        log.info("username: {}, password: {}", username, password);
        Result<Teacher> result = teacherService.login(username, password);
        if (result.getData() != null) {
            session.setAttribute("teacher", result.getData());
        }
        return result;
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除会话属性
        session.removeAttribute("admin");
        session.removeAttribute("student");
        session.removeAttribute("teacher");
        // 重定向到登录页面
        return "redirect:/login.html";
    }
    @GetMapping("/getTeacherName")
    public String getTeacherName(HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        log.info("teacher: {}", teacher);
        if (teacher != null) {
            return teacher.getTeachername();
        }
        return null;
    }

    @GetMapping("/getInfo")
    public Teacher getInfo(HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        int teacherID = teacherService.getTeacherID(teacher.getUsername());
        if (teacher != null) {
            return teacherService.getInfo(teacherID);
        }
        return null;
    }

    @PostMapping("/updateInfo")
    public Result<String> updateInfo(@RequestBody Teacher teacher, HttpSession session) {
        Teacher nowTeacher = (Teacher) session.getAttribute("teacher");
        if (nowTeacher == null) {
            return Result.error("未登录");
        }
        Teacher newTeacher = teacherService.updateInfo(teacher);
        if (newTeacher == null) {
            return Result.error("更新失败");
        }
        session.setAttribute("teacher", newTeacher);
        return Result.success("更新成功");
    }

    @GetMapping("/getTeacherCourse")
    public Object getTeacherCourse(HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        log.info("teacher: {}", teacher);
        if (teacher != null) {
            int teacherID = teacherService.getTeacherID(teacher.getUsername());
            List<Course> courses = courseService.getCourseByTeacherId(teacherID);
            return Result.success(courses);
        }
        return null;
    }

    @GetMapping("/getScoreByCourseid")
    public Object getScoreByCourseid(@RequestParam("courseid") int courseid) {
        List<CompletedCourse> courses = courseService.getScoreByCourseid(courseid);
        return Result.success(courses);
    }

    @PostMapping("/score")
    public Result<String> submitScore(@RequestParam("courseid") Long courseId,
                                      @RequestParam("studentno") String studentNo,
                                      @RequestParam("grade") Double grade,
                                      HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (teacher == null) {
            return Result.error("未登录");
        }
        boolean success = teacherService.saveScore(courseId, grade, studentNo);
        if (!success) {
            return Result.error("评分失败");
        }

        return Result.success("评分成功");
    }

    @PostMapping("/add")
    public Result<String> addTeacher(@RequestBody Teacher teacher) {
        boolean success = teacherService.addTeacher(teacher);
        if (!success) {
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @PutMapping("/update")
    public Result<String> updateTeacher(@RequestBody Teacher teacher) {
        boolean success = teacherService.updateTeacher(teacher);
        if (!success) {
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

    @DeleteMapping("/delete")
    public Result<String> deleteTeacher(@RequestParam("teacherID") int teacherID) {
        boolean success = teacherService.deleteTeacher(teacherID);
        if (!success) {
            return Result.error("删除失败");
        }
        return Result.success("删除成功");
    }

}