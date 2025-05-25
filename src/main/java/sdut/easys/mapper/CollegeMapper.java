package sdut.easys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sdut.easys.Entity.College;

import java.util.List;

@Mapper
public interface CollegeMapper {

    @Select("SELECT * FROM college")
    List<College> getAllColleges();

    @Select("SELECT COUNT(*) FROM college")
    int getAllCollegesCount();

    @Select("SELECT collegeid FROM college WHERE collegename = #{collegename}")
    int getCollegeIDByName(String collegename);
}