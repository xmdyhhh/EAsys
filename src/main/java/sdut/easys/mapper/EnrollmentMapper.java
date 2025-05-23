package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sdut.easys.Entity.Course;

import java.util.List;

@Mapper
public interface EnrollmentMapper {

    List<Course> getSelectedCourses(String studentno);

    @Select("select count(*) from enrollment where studentno=#{studentno} and status='ENROLLED'")
    int getSelectedCount(String studentno);

    List<Course> getAvailableCourses(String studentno);

    @Select("select count(*) from enrollment where studentno=#{studentno} and status='PENDING'")
    int getAvailableCount(String studentno);

    @Update("update enrollment set status='ENROLLED' where studentno=#{studentno} and courseid=#{courseid}")
    int selectCourse(String studentno, int courseid);

    @Update("update enrollment set status='PENDING' where studentno=#{studentno} and courseid=#{courseid}")
    int exitCourse(String studentno, int courseid);

    @Update("update course set currentenrollment=currentenrollment+1 where courseid=#{courseid}")
    void updateCurrentEnrollment1(int courseid);

    @Update("update course set currentenrollment=currentenrollment-1 where courseid=#{courseid}")
    void updateCurrentEnrollment2(int courseid);

    @Select("select maxenrollment from course where courseid= #{courseid}")
    int getMaxEnrollment(int courseid);

    @Select("select currentenrollment from course where courseid= #{courseid}")
    int getCurrentEnrollment(int courseid);
}
