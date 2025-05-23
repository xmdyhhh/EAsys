package sdut.easys.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sdut.easys.Entity.Student;

@Mapper
public interface StudentMapper {
    @Select("select * from student where username = #{username}")
    Student getByUsername(String username);
}