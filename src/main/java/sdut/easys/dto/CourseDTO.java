package sdut.easys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    // 课程ID
    private Long courseid;

    // 课程名称
    private String coursename;

    // 课程学分
    private Float credits;

    // 开设学期
    private String semester;

    // 最大选课人数
    private Integer maxenrollment;

    // 当前选课人数
    private Integer currentenrollment;

    // 课程开始日期
    private String startdate;

    // 课程结束日期
    private String enddate;

    // 星期几
    private String dayofweek;

    // 课程开始时间
    private String starttime;

    // 课程结束时间
    private String endtime;

    // 教师ID
    private Integer teacherid;

    // 教室
    private String classroom;

}