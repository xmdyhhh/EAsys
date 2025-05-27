package sdut.easys.Service;

import sdut.easys.Entity.College;

import java.util.List;

public interface CollegeService {
    List<College> getAllColleges();

    int getAllCollegesCount();

    List<College> getColleges(String collegeName);

    boolean addCollege(College college);

    boolean updateCollege(College college);

    boolean deleteCollege(int collegeID);
}