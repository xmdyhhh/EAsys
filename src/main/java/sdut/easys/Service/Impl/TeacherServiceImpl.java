package sdut.easys.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.Admin;
import sdut.easys.Entity.Teacher;
import sdut.easys.Entity.TeacherInfo;
import sdut.easys.dto.TeacherDTO;
import sdut.easys.mapper.CollegeMapper;
import sdut.easys.mapper.TeacherMapper;
import sdut.easys.Service.TeacherService;
import sdut.easys.Util.Result;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CollegeMapper collegeMapper;

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
    public List<Teacher> getTeachers(String teachername, String username) {
        return teacherMapper.selectTeacher(teachername, username); // 该方法已支持模糊查询和空条件
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
    public TeacherInfo getInfo(int teacherID) {
        return teacherMapper.getInfo(teacherID);
    }

    @Override
    public Result<Teacher> updateInfo(TeacherInfo teacherInfo,  String collegename) {
        int collegeID = collegeMapper.getCollegeIDByName(collegename);
        Teacher teacher = new Teacher();
        teacher.setTeacherID(teacherInfo.getTeacherID());
        teacher.setUsername(teacherInfo.getUsername());
        teacher.setPassword(teacherInfo.getPassword());
        teacher.setTeachername(teacherInfo.getTeachername());
        teacher.setSex(teacherInfo.getSex());
        teacher.setBirthYear(teacherInfo.getBirthYear());
        teacher.setDegree(teacherInfo.getDegree());
        teacher.setTitle(teacherInfo.getTitle());
        teacher.setGrade(teacherInfo.getGrade());
        teacher.setCollegeID(collegeID);
        int rows = teacherMapper.updateInfo(teacher);
        if (rows > 0) {
            return Result.success(teacher);
        } else {
            return Result.error("更新失败");
        }
    }
}