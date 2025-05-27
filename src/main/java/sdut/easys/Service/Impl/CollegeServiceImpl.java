package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.College;
import sdut.easys.Service.CollegeService;
import sdut.easys.mapper.CollegeMapper;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> getAllColleges() {
        return collegeMapper.getAllColleges();
    }

    @Override
    public int getAllCollegesCount() {
        return collegeMapper.getAllCollegesCount();
    }

    @Override
    public List<College> getColleges(String collegename) {
        return collegeMapper.getColleges(collegename);
    }

    @Override
    public boolean addCollege(College college) {
        return collegeMapper.addCollege(college) > 0;
    }

    @Override
    public boolean updateCollege(College college) {
        return collegeMapper.updateCollege(college) > 0;
    }

    @Override
    public boolean deleteCollege(int collegeID) {
        return collegeMapper.deleteCollege(collegeID) > 0;
    }
}
