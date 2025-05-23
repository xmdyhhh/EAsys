package sdut.easys.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdut.easys.Entity.Student;
import sdut.easys.Service.StudentService;
import sdut.easys.Util.Result;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public Result<Student> login(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 HttpSession session) {
        log.info("username: {}, password: {}", username, password);
        Result<Student> result = studentService.login(username, password);
        if (result.getData() != null) {
            session.setAttribute("student", result.getData());
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
    @GetMapping("/getStudentName")
    public String getStudentName(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        log.info("student: {}", student);
        if (student != null) {
            return student.getStudentname();
        }
        return null;
    }
}