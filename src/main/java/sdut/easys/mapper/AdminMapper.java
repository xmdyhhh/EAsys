package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sdut.easys.Entity.Admin;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where username = #{username}")
    Admin getByUsername(String username);
}