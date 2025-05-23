package sdut.easys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sdut.easys.Entity.Schedule;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    @Update("DROP TABLE IF EXISTS schedule")
    void dropSchedule();

    @Update("CREATE TABLE IF NOT EXISTS schedule (" +
            "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
            "coursename VARCHAR(255), " +
            "teachername VARCHAR(255), " +
            "classroom VARCHAR(100), " +
            "dayofweek VARCHAR(20), " +
            "starttime VARCHAR(20), " +
            "endtime VARCHAR(20))")
    void createSchedule();

    @Insert("insert into schedule (coursename, teachername, classroom, dayofweek, starttime, endtime) values (#{coursename}, #{teachername}, #{classroom}, #{dayofweek}, #{starttime}, #{endtime})")
    void insertSchedule(Schedule schedule);

    @Select("select * from schedule")
    List<Schedule> getSchedule();

    @Select("select count(*) from schedule")
    int getScheduleCount();
}