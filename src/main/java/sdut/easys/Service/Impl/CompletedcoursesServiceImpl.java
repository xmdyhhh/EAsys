package sdut.easys.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Service.CompletedcoursesService;
import sdut.easys.mapper.CompletedMapper;

import java.util.List;

@Service
public class CompletedcoursesServiceImpl implements CompletedcoursesService {

    @Autowired
    private CompletedMapper completedMapper;
    @Override
    public List<CompletedCourse> getCompletedCourses(String studentno) {
        return completedMapper.getCompletedCourses(studentno);
    }

    @Override
    public int getCompletedCoursesCount(String studentno) {
        return completedMapper.getCompletedCoursesCount(studentno);
    }
}
