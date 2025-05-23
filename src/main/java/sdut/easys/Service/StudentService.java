package sdut.easys.Service;

import sdut.easys.Entity.Student;
import sdut.easys.Util.Result;

public interface StudentService {
    Result<Student> login(String username, String password);
}