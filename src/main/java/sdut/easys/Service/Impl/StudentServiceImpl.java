package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Student;
import sdut.easys.Mapper.StudentMapper;
import sdut.easys.Service.StudentService;
import sdut.easys.Util.Result;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result<Student> login(String username, String password) {
        Student  student = studentMapper.getByUsername(username);
        if (student == null) {
            return Result.error("用户名不存在");
        } else if (!student.getPassword().equals(password)) {
            return Result.error("密码错误");
        } else {
            return Result.success(student);
        }
    }
}
