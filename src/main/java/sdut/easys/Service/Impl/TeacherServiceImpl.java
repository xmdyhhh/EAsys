package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Admin;
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

    @Override
    public boolean deleteTeacher(int teacherID) {
        return teacherMapper.deleteTeacher(teacherID) > 0;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher) > 0;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher) > 0;
    }

    @Override
    public Result<Teacher> getInfo(int teacherID) {
        Teacher  teacher = teacherMapper.getInfo(teacherID);
        if (teacher == null) {
            return Result.error("教师不存在");
        }
        return Result.success(teacher);
    }

    @Override
    public Result<String> updateInfo(Teacher teacher) {
        int rows = teacherMapper.updateInfo(teacher);
        if (rows > 0) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }

}
