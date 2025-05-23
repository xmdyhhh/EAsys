package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sdut.easys.Entity.Teacher;


@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where username = #{username}")
    Teacher getByUsername(String username);
}