package sdut.easys.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdut.easys.Entity.Student;
import sdut.easys.Service.ScheduleService;
import sdut.easys.Util.Result;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/list")
    public Result getSchedule(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        String studentno = student.getStudentno();
        try {
            scheduleService.updateSchedule(studentno);
            List list = scheduleService.getSchedule();
            int count = scheduleService.getScheduleCount();
            return Result.success(list,count);
        } catch (Exception e){
            e.printStackTrace();
        }
        return Result.error("获取课表失败");
    }
}
