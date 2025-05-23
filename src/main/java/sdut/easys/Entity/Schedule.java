package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程安排实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    // 课程安排ID
    private Long scheduleid;

    // 课程名称
    private String coursename;

    // 教师姓名
    private String teachername;

    // 教室名称
    private String classroomname;

    // 星期几
    private String dayofweek;

    // 开始时间
    private String starttime;

    // 结束时间
    private String endtime;
}