package sdut.easys.mapper;

import org.apache.ibatis.annotations.*;
import sdut.easys.Entity.Teacher;
import sdut.easys.Entity.TeacherInfo;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where username = #{username}")
    Teacher getByUsername(String username);

    @Select("select teacherID from teacher where username = #{username}")
    Integer getTeacherID(String username);

    @Update("update completedcourse set grade = #{grade} where courseID = #{courseId} AND studentno=#{studentno}")
    int saveScore(Long courseId, Double grade, String studentno);

    @Insert("insert into teacher(username,password,teachername,sex,birthYear,degree,title,grade,collegeID) values(#{username},#{password},#{teachername},#{sex},#{birthYear},#{degree},#{title},#{grade},#{collegeID})")
    int addTeacher(Teacher teacher);

    @Delete("delete from teacher where teacherID = #{teacherID}")
    int deleteTeacher(int teacherID);

    @Update("update teacher set username = #{username},password = #{password},teachername = #{teachername},sex = #{sex},birthYear = #{birthYear},degree = #{degree},title = #{title},grade = #{grade},collegeID = #{collegeID} where teacherID = #{teacherID}")
    int updateTeacher(Teacher teacher);

    @Select("SELECT t.*, c.collegename FROM teacher t " +
            "LEFT JOIN college c ON t.collegeID = c.collegeid " +
            "WHERE t.teacherID = #{teacherID}")
    TeacherInfo getInfo(int teacherID);

    int updateInfo(Teacher teacher);

    List<Teacher> selectTeacher(@Param("teachername") String teachername,
                                @Param("username") String username);

    @Select("select collegeName from college where collegeID = #{collegeID}")
    String getCollegeName(Integer collegeID);

    @Select("select collegeID from college where collegeName = #{collegename}")
    int getCollegeIDByName(String collegename);
}