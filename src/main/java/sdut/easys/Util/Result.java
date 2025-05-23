package sdut.easys.Util;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 *
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;     // 编码：1 成功，0 和其它数字为失败
    private String message;   // 错误信息
    private T data;           // 数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMessage("success");
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setData(object);
        result.setCode(1);
        result.setMessage("success");
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setMessage(message);
        result.setCode(0);
        return result;
    }
}