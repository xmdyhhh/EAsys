package sdut.easys.Service;

import sdut.easys.Entity.Teacher;
import sdut.easys.Util.Result;

public interface TeacherService {
    Result<Teacher> login(String username, String password);
}
