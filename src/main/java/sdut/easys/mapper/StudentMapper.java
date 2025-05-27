package sdut.easys.mapper;

import org.apache.ibatis.annotations.*;
import sdut.easys.Entity.Student;
import sdut.easys.Entity.StudentInfo;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student where username = #{username}")
    Student getByUsername(String username);

    @Select("SELECT s.*, c.collegename FROM student s " +
            "LEFT JOIN college c ON s.collegeID = c.collegeid " +
            "WHERE s.studentno = #{studentno}")
    StudentInfo getInfo(String studentno);

    @Update("UPDATE student SET username = #{username},password = #{password},studentname=#{studentname},studentno=#{studentno}, sex = #{sex}, birthYear = #{birthYear}, email = #{email}, major = #{major}, grade = #{grade}, collegeID = #{collegeID} WHERE studentno = #{studentno}")
    int updateStudentInfo(Student student);

    @Insert("INSERT INTO student(username,password,studentname,studentno,sex,birthYear,email,major,grade,collegeID) VALUES(#{username},#{password},#{studentname},#{studentno},#{sex},#{birthYear},#{email},#{major},#{grade},#{collegeID})")
    int addStudent(Student student);

    @Update("UPDATE student SET username = #{username},password = #{password},studentname= #{studentname},sex = #{sex}, birthYear = #{birthYear}, email = #{email}, major = #{major}, grade = #{grade}, collegeID = #{collegeID} WHERE studentID = #{studentID}")
    int updateStudent(Student student);

    @Delete("DELETE FROM student WHERE studentID = #{studentID}")
    int deleteStudent(int studentID);

    List<Student> getStudents(@Param("studentname") String studentname, @Param("studentno") String studentno);
}