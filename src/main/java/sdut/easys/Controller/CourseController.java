package sdut.easys.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdut.easys.Entity.Course;
import sdut.easys.Service.CourseService;
import sdut.easys.Util.Result;
import sdut.easys.dto.CourseDTO;

import java.util.List;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public Result<String> addCourse(@RequestBody CourseDTO courseDTO){
        boolean success = courseService.addCourse(courseDTO);
        return success ? Result.success("添加成功") : Result.error("添加失败");
    }

    @PutMapping("/update")
    public Result<String> updateCourse(@RequestBody CourseDTO courseDTO){
        boolean success = courseService.updateCourse(courseDTO);
        return success ? Result.success("修改成功") : Result.error("修改失败");
    }

    @DeleteMapping("/delete")
    public Result<String> deleteCourse(@RequestParam("courseID") int courseID){
        boolean success = courseService.deleteCourse(courseID);
        return success ? Result.success("删除成功") : Result.error("删除失败");
    }

    @GetMapping("/list")
    public Result<List<Course>> getCourses(
            @RequestParam(required = false) String coursename
    ){
        List<Course> courses = courseService.getCourses(coursename);
        return Result.success(courses);
    }
}