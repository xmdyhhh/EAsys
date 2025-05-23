package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学生实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    // 学生ID
    private Integer studentID;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 姓名
    private String studentname;

    // 学号
    private String studentno;

    // 性别
    private String sex;

    // 出生日期
    private String birthYear;

    // 电子邮件地址
    private String email;

    // 专业
    private String major;

    // 年级（例如：大一、大二）
    private String grade;

    // 所属学院
    private Integer collegeID;
}