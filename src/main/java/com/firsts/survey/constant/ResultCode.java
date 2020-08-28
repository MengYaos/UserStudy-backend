package com.firsts.survey.constant;

import java.io.Serializable;

public class ResultCode implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String I18N_ERROR_PREFIX = "(errorCode:%d)";
    private int code;
    private String message;
    public static final ResultCode IS_NULL = new ResultCode(-97, "NULL");
    public static final ResultCode SUCCESS = new ResultCode(0, "操作成功");
    public static final ResultCode FAILURE = new ResultCode(-98, "业务异常");
    public static final ResultCode PARAM_VALID_ERROR = new ResultCode(-1, "参数校验失败");
    public static final ResultCode UN_AUTHORIZED = new ResultCode(401, "请求未授权");
    public static final ResultCode NOT_FOUND = new ResultCode(404, "404 没找到请求%name%");
    public static final ResultCode MSG_NOT_READABLE = new ResultCode(400, "消息不能读取");
    public static final ResultCode METHOD_NOT_SUPPORTED = new ResultCode(405, "不支持当前请求方法");
    public static final ResultCode MEDIA_TYPE_NOT_SUPPORTED = new ResultCode(415, "不支持当前媒体类型");
    public static final ResultCode REQ_REJECT = new ResultCode(403, "请求被拒绝");
    public static final ResultCode INTERNAL_SERVER_ERROR = new ResultCode(-99, "服务器异常");
    public static final ResultCode PARAM_MISS = new ResultCode(400, "缺少必要的请求参数");
    public static final ResultCode PARAM_TYPE_ERROR = new ResultCode(400, "请求参数类型错误");
    public static final ResultCode PARAM_BIND_ERROR = new ResultCode(400, "请求参数绑定错误");

    public ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCode valueOf(String message) {
        return new ResultCode(0, message);
    }

    public static ResultCode valueOf(int code, String message) {
        return new ResultCode(code, message);
    }

    private ResultCode() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResultCode)) {
            return false;
        } else {
            ResultCode other = (ResultCode)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResultCode;
    }


    public String toString() {
        return "ResultCode(code=" + this.getCode() + ", message=" + this.getMessage() + ")";
    }
}
