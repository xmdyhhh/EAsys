package sdut.easys.Service;

import sdut.easys.Entity.Student;
import sdut.easys.Entity.StudentInfo;
import sdut.easys.Util.Result;

import java.util.List;

public interface StudentService {
    Result<Student> login(String username, String password);

    StudentInfo getInfo(String studentno);

    Result<Student> updateInfo(StudentInfo studentInfo, String collegename);

    List<Student> getStudentList();

    int getStudentCount();
}