package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sdut.easys.Entity.Student;
import sdut.easys.Entity.StudentInfo;

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

    @Select("SELECT * FROM student WHERE studentno = #{studentno}")
    Student getByStudentNo(String studentno);
}