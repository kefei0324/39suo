package org.feona.engine.rest;

import java.io.Serializable;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  17:10
 **/
public class BaseResponse<T> implements Serializable {

    private boolean success = false;
    private String message = null;
    private T result = null;

    public void isSuccess(boolean b) {
        this.success = b;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }
}
