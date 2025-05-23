package sdut.easys.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 管理员实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    // 管理员ID
    private Integer adminID;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 电子邮件地址
    private String email;
}