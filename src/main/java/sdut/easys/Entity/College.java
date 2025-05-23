package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学院实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    // 学院ID
    private Integer collegeID;

    // 学院名称
    private String collegeName;
}