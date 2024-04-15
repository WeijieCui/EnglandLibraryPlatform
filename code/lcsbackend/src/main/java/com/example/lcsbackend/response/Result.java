package com.example.lcsbackend.response;


public class Result {
    private final ResultCode code;
    private final String message;
    private Object data;

    /**
     * default constructor
     * default code: 200
     */
    public Result() {
        code = ResultCode.SUCCESS;
        message = code.getMessage();
    }

    public Result(Object data) {
        this.data = data;
        code = ResultCode.SUCCESS;
        message = code.getMessage();
    }

    public Result(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
        message = this.code.getMessage();
    }

    public Result(ResultCode code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code.getCode();
    }
}
