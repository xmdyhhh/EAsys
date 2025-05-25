package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sdut.easys.Entity.CompletedCourse;

import java.util.List;

@Mapper
public interface CompletedMapper {

    @Select("SELECT * FROM completedcourse WHERE studentno = #{studentno}")
    List<CompletedCourse> getCompletedCourses(String studentno);

    @Select("SELECT COUNT(*) FROM completedcourse WHERE studentno = #{studentno}")
    int getCompletedCoursesCount(String studentno);
}
