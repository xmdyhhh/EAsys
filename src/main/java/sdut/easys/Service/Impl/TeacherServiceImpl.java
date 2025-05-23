package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Teacher;
import sdut.easys.Mapper.TeacherMapper;
import sdut.easys.Service.TeacherService;
import sdut.easys.Util.Result;

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
}
