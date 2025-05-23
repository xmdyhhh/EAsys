package sdut.easys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdut.easys.Entity.Course;
import sdut.easys.mapper.EnrollmentMapper;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @GetMapping("/courses")
    public List<Course> test() {
        return enrollmentMapper.getSelectedCourses("S001");
    }
}