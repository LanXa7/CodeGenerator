package com.example.entity.vo.response;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import org.slf4j.MDC;

import java.util.Optional;

/**
 * 响应实体类封装，Rest风格
 *
 * @param code    状态码
 * @param data    响应数据
 * @param message 其他消息
 * @param <T>     响应数据类型
 */
public record Result<T>(long id, int code, T data, String message) {
    public static <T> Result<T> success(T data) {
        return new Result<>(requestId(), 200, data, "请求成功");
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> forbidden(String message) {
        return failure(403, message);
    }

    public static <T> Result<T> unauthorized(String message) {
        return failure(401, message);
    }

    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(requestId(), code, null, message);
    }

    /**
     * 快速将当前实体转换为JSON字符串格式
     *
     * @return JSON字符串
     */
    public String asJsonString() {
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }

    /**
     * 获取当前请求ID方便快速定位错误
     *
     * @return ID
     */
    private static long requestId() {
        try {
            String requestId = Optional.ofNullable(MDC.get("reqId")).orElse("0");
            return Long.parseLong(requestId);
        } catch (NumberFormatException e) {
            // 记录日志或处理异常
            System.err.println("Invalid request ID format: " + MDC.get("reqId"));
            return 0; // 返回默认值
        }
    }
}
