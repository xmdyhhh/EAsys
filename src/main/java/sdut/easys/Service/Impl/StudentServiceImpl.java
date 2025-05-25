package sdut.easys.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Student;
import sdut.easys.Entity.StudentInfo;
import sdut.easys.mapper.CollegeMapper;
import sdut.easys.mapper.StudentMapper;
import sdut.easys.Service.StudentService;
import sdut.easys.Util.Result;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;

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

    @Override
    public StudentInfo getInfo(String studentno) {
        return studentMapper.getInfo(studentno);
    }

    @Override
    public Result<Student> updateInfo(StudentInfo studentInfo, String collegename) {
        try {
            int collegeID = collegeMapper.getCollegeIDByName(collegename);

            Student student = new Student();
            student.setUsername(studentInfo.getUsername());
            student.setPassword(studentInfo.getPassword());
            student.setStudentname(studentInfo.getStudentname());
            student.setStudentno(studentInfo.getStudentno());
            student.setEmail(studentInfo.getEmail());
            student.setMajor(studentInfo.getMajor());
            student.setSex(studentInfo.getSex());
            student.setBirthYear(studentInfo.getBirthYear());
            student.setGrade(studentInfo.getGrade());
            student.setCollegeID(collegeID);

            int rows = studentMapper.updateStudentInfo(student);
            if (rows > 0) {
                // 返回更新后的 Student 对象
                return Result.success(student);
            } else {
                return Result.error("更新失败");
            }
        } catch (Exception e) {
            log.error("更新学生信息失败", e);
            return Result.error("系统异常，请稍后再试");
        }
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    @Override
    public int getStudentCount() {
        return studentMapper.getStudentCount();
    }
}