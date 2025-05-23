package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 教师实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    // 教师ID
    private Integer teacherID;

    // 用户名（工号）
    private String username;

    // 密码（建议加密存储）
    private String password;

    // 姓名
    private String teachername;

    // 性别
    private String sex;

    // 出生日期
    private String birthYear;

    // 学历
    private String degree;

    // 职称
    private String title;

    // 入职时间
    private String grade;

    // 所属学院
    private Integer collegeID;
}