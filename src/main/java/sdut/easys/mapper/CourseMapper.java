package sdut.easys.mapper;

import org.apache.ibatis.annotations.Select;
import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Course;

import java.util.List;

public interface CourseMapper {

    @Select("select * from course where teacherid=#{teacherid}")
    List<Course> getCourseByTeacherId(int teacherid);

    @Select("select * from completedcourse where courseid= #{courseid}")
    List<CompletedCourse> getScoreByCourseid(int courseid);

    @Select("select * from course")
    List<Course> getCourseList();

    @Select("select count(*) from course")
    int getCourseCount();
}