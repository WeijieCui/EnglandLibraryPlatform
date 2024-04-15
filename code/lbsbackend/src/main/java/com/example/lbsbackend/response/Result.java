package com.example.lbsbackend.response;

/**
 * Result
 *
 * @Description: wrap api result, including code, message and data
 **/
public class Result {
    private final ResultCode code;
    private final String message;
    private Object data;

    /**
     * Result
     *
     * @description: default construction
     * @param: null
     * @return: Result
     */
    public Result() {
        code = ResultCode.SUCCESS;
        message = code.getMessage();
    }

    /**
     * Result
     *
     * @description: construction
     * @param: data
     * @return: Result
     */
    public Result(Object data) {
        this.data = data;
        code = ResultCode.SUCCESS;
        message = code.getMessage();
    }

    /**
     * Result
     *
     * @description: construction
     * @param: code, data
     * @return: Result
     */
    public Result(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
        message = this.code.getMessage();
    }

    /**
     * Result
     *
     * @description: construction
     * @param: code, message, data
     * @return: Result
     */
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
