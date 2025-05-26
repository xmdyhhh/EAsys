package sdut.easys.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sdut.easys.Entity.Student;
import sdut.easys.Entity.StudentInfo;
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
        session.removeAttribute("student");
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

    @GetMapping("/getInfo")
    public StudentInfo getInfo(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        String studentno = student.getStudentno();
        if (student != null){
            return studentService.getInfo(studentno);
        }
        return null;
    }

    /**
     * 更新学生信息接口
     */
    @PostMapping("/updateInfo")
    public Result<Student> updateInfo(@RequestBody StudentInfo studentInfo, HttpSession session) {
        // 获取登录用户
        Student nowStudent = (Student) session.getAttribute("student");
        if (nowStudent == null) {
            return Result.error("未登录");
        }
        Student newStudent = studentService.updateInfo(studentInfo, studentInfo.getCollegename()).getData();
        if (newStudent == null) {
            return Result.error("更新失败");
        }
        session.setAttribute("student", newStudent);
        return Result.success(newStudent);
    }

    @PostMapping("/add")
    public Result<String> addStudent(@RequestBody Student student){
        boolean success = studentService.addStudent(student);
        if (success){
            return Result.success("添加成功");
        }else {
            return Result.error("添加失败");
        }
    }

    @PutMapping("/update")
    public Result<String> updateStudent(@RequestBody Student student){
        boolean success = studentService.updateStudent(student);
        if (success){
            return Result.success("更新成功");
        }else {
            return Result.error("更新失败");
        }
    }

    @DeleteMapping("/delete")
    public Result<String> deleteStudent(@RequestParam("studentID") int studentID){
        boolean success = studentService.deleteStudent(studentID);
        if (success){
            return Result.success("删除成功");
        }else {
            return Result.error("删除失败");
        }
    }
}