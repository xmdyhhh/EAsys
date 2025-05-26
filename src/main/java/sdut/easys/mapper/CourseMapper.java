package sdut.easys.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sdut.easys.Entity.CompletedCourse;
import sdut.easys.Entity.Course;
import sdut.easys.dto.CourseDTO;

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

    @Insert("insert into course(coursename,credits,semester,maxenrollment,currentenrollment,startdate,enddate,dayofweek,starttime,endtime,teacherid,classroom) values(#{coursename},#{credits},#{semester},#{maxenrollment},#{currentenrollment},#{startdate},#{enddate},#{dayofweek},#{starttime},#{endtime},#{teacherid},#{classroom})")
    int addCourse(CourseDTO courseDTO);

    @Update("update course set coursename=#{coursename},credits=#{credits},semester=#{semester},maxenrollment=#{maxenrollment},currentenrollment=#{currentenrollment},startdate=#{startdate},enddate=#{enddate},dayofweek=#{dayofweek},starttime=#{starttime},endtime=#{endtime},teacherid=#{teacherid}")
    int updateCourse(CourseDTO courseDTO);

    @Delete("delete from course where courseid= #{courseid}")
    int deleteCourse(int courseID);
}