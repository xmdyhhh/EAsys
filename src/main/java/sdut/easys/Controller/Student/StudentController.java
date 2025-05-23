package sdut.easys.Controller.Student;

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
                                 @RequestParam("password") String password) {
        log.info("username: {}, password: {}", username, password);
        return studentService.login(username, password);
    }
}