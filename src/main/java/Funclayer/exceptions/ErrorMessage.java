package Funclayer.exceptions;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ErrorMessage {
    private String message;
    private int    code;
    private String errorDocUrl;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, int code, String errorDocUrl) {
        this.message = message;
        this.code = code;
        this.errorDocUrl = errorDocUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorDocUrl() {
        return errorDocUrl;
    }

    public void setErrorDocUrl(String errorDocUrl) {
        this.errorDocUrl = errorDocUrl;
    }
}
