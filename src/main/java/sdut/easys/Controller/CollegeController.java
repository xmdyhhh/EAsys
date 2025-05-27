package sdut.easys.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/getlist")
    public Result<List<College>> getColleges(
            @RequestParam(required = false) String collegeName
    ) {
        List<College> colleges = collegeService.getColleges(collegeName);
        return Result.success(colleges);
    }

    @PostMapping("/add")
    public Result<String> addCollege(@RequestBody College college) {
        boolean success = collegeService.addCollege(college);
        if (success) {
            return Result.success("添加成功");
        } else {
            return Result.error("添加失败");
        }
    }

    @PutMapping("/update")
    public Result<String> updateCollege(@RequestBody College college) {
        boolean success = collegeService.updateCollege(college);
        if (success) {
            return Result.success("更新成功");
        }
        return Result.error("更新失败");
    }

    @DeleteMapping("/delete")
    public Result<String> deleteCollege(@RequestParam("collegeID") int collegeID) {
        boolean success = collegeService.deleteCollege(collegeID);
        if (success) {
            return Result.success("删除成功");
        }
        return Result.error("删除失败");
    }
}