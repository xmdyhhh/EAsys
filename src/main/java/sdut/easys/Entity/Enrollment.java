package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 选课记录实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    // 选课记录ID
    private Long enrollmentid;

    // 学生学号
    private String studentno;

    // 课程ID
    private Long courseid;

    // 选课状态
    private String status;
}