package sdut.easys.Service;

import com.github.pagehelper.PageInfo;
import sdut.easys.Entity.Teacher;
import sdut.easys.Entity.TeacherInfo;
import sdut.easys.Util.Result;
import sdut.easys.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    Result<Teacher> login(String username, String password);

    Integer getTeacherID(String username);

    boolean saveScore(Long courseId, Double grade, String studentNo);

    boolean deleteTeacher(int teacherID);

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    TeacherInfo getInfo(int teacherID);

    Result<Teacher> updateInfo(TeacherInfo teacherInfo,  String collegename);

    List<Teacher> getTeachers(String teachername, String username);
}