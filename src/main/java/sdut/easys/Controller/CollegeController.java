package sdut.easys.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sdut.easys.Entity.College;
import sdut.easys.Service.CollegeService;
import sdut.easys.Util.Result;

import java.util.List;

@RestController
@RequestMapping("/college")
@Slf4j
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/list")
    public Object getAllColleges() {
        List<College> colleges = collegeService.getAllColleges();
        int count = collegeService.getAllCollegesCount();
        if (colleges != null){
            return Result.success(colleges, count);
        }
        return Result.error("获取学院列表失败");
    }
}