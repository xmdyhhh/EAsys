package sdut.easys.Controller.Teacher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
                                 @RequestParam("password") String password) {
        log.info("username: {}, password: {}", username, password);
        return teacherService.login(username, password);
    }
}