package sdut.easys.Controller.Teacher;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdut.easys.Entity.Admin;
import sdut.easys.Entity.Teacher;
import sdut.easys.Service.TeacherService;
import sdut.easys.Util.Result;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public Result<Teacher> login(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 HttpSession session) {
        log.info("username: {}, password: {}", username, password);
        Result<Teacher> result = teacherService.login(username, password);
        if (result.getData() != null) {
            // 将管理员信息存入会话
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
}