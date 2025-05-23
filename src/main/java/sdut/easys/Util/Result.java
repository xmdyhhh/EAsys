package sdut.easys.Util;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 后端统一返回结果
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;     // 编码：1 成功，0 和其它数字为失败
    private String message;   // 错误信息
    private T data;           // 返回数据

    private int count; // 总记录数，用于分页接口

    /**
     * 分页查询构造方法
     *
     * @param data  数据内容
     * @param count 总记录数
     */
    public Result(int count, T data) {
        this.count = count;
        this.data = data;
    }

    /**
     * 成功响应（无数据）
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMessage("success");
        return result;
    }

    /**
     * 成功响应（带数据）
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data, int count) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMessage("success");
        result.setData(data);
        result.setCount(count);
        return result;
    }

    /**
     * 失败响应（自定义错误信息）
     */
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMessage(message);
        return result;
    }

    /**
     * 自定义响应
     */
    public static <T> Result<T> build(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}