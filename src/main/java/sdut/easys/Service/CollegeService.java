package sdut.easys.Service;

import sdut.easys.Entity.College;

import java.util.List;

public interface CollegeService {
    List<College> getAllColleges();

    int getAllCollegesCount();
}