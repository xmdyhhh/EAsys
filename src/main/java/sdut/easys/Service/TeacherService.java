package sdut.easys.Service;

import sdut.easys.Entity.Teacher;
import sdut.easys.Util.Result;

import java.util.List;

public interface TeacherService {
    Result<Teacher> login(String username, String password);

    Integer getTeacherID(String username);

    boolean saveScore(Long courseId, Double grade, String studentNo);

    List<Teacher> getTeacherList();

    int getTeacherCount();

    boolean deleteTeacher(int teacherID);

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    Teacher getInfo(int teacherID);

    Teacher updateInfo(Teacher teacher);
}
