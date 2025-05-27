package sdut.easys.mapper;

import org.apache.ibatis.annotations.*;
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

    List<College> getColleges(@Param("collegeName") String collegeName);

    @Insert("INSERT INTO college(collegeName) VALUES(#{collegeName})")
    int addCollege(College college);

    @Update("UPDATE college SET collegeName = #{collegeName} WHERE collegeID = #{collegeID}")
    int updateCollege(College college);

    @Delete("DELETE FROM college WHERE collegeID = #{collegeID}")
    int deleteCollege(int collegeID);
}