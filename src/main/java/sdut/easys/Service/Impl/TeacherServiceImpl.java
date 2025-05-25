package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Teacher;
import sdut.easys.mapper.TeacherMapper;
import sdut.easys.Service.TeacherService;
import sdut.easys.Util.Result;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Result<Teacher> login(String username, String password) {
        Teacher teacher = teacherMapper.getByUsername(username);
        if (teacher == null) {
            return Result.error("用户名不存在");
        } else if (!teacher.getPassword().equals(password)) {
            return Result.error("密码错误");
        } else {
            return Result.success(teacher);
        }
    }

    @Override
    public Integer getTeacherID(String username) {
        return teacherMapper.getTeacherID(username);
    }

    @Override
    public boolean saveScore(Long courseId, Double grade, String studentNo) {
        return teacherMapper.saveScore(courseId, grade, studentNo) > 0;
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherMapper.getTeacherList();
    }

    @Override
    public int getTeacherCount() {
        return teacherMapper.getTeacherCount();
    }
}
