package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sdut.easys.Entity.Teacher;

import java.util.List;


@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where username = #{username}")
    Teacher getByUsername(String username);

    @Select("select teacherID from teacher where username = #{username}")
    Integer getTeacherID(String username);

    @Update("update completedcourse set grade = #{grade} where courseID = #{courseId} AND studentno=#{studentno}")
    int saveScore(Long courseId, Double grade,String studentno);

    @Select("select * from teacher")
    List<Teacher> getTeacherList();

    @Select("select count(*) from teacher")
    int getTeacherCount();
}