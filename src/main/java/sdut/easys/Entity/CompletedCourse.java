package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 已完成课程实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompletedCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    // 已完成课程ID
    private Long completedcourseid;

    // 课程ID
    private Long courseid;

    // 课程名称
    private String coursename;

    // 学生学号
    private String studentno;

    // 成绩
    private BigDecimal grade;
}