package sdut.easys.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("teacherID")
    private Integer teacherID;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("teachername")
    private String teachername;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("birthYear")
    private String birthYear;

    @JsonProperty("degree")
    private String degree;

    @JsonProperty("title")
    private String title;

    @JsonProperty("grade")
    private String grade;

    @JsonProperty("collegename")
    private String collegename;

    @JsonProperty("collegeID")
    private Integer collegeID;

}