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
}
