package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sdut.easys.Entity.Admin;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where username = #{username}")
    Admin getByUsername(String username);

    @Select("select adminID from admin where username = #{username}")
    int getAdminID(String username);

    @Select("SELECT * FROM admin WHERE adminID = #{adminID}")
    Admin getInfo(int adminID);

    @Update("UPDATE admin SET username = #{username}, password = #{password}, email = #{email} WHERE adminID = #{adminID}")
    int updateInfo(Admin admin);
}