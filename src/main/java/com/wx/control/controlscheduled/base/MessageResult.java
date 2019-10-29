package com.wx.control.controlscheduled.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.io.Serializable;

@JsonSerialize(
        include = Inclusion.NON_NULL
)

/**
 * Created by sam on 2017-08-30.
 */
public class MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private Object data;

    public MessageResult(){
    }

    public MessageResult(String code, String msg){
        this.code = code;
        this.message = msg;
    }

    public MessageResult(String code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static MessageResult build(String code, String msg, Object data) {
        return new MessageResult(code, msg, data);
    }

    public static MessageResult build(String code, String msg) {
        return new MessageResult(code, msg, (Object)null);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
