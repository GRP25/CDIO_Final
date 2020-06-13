package REST;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class SuccessMessage {
    private String message;
    private int    code;
    private String docUrl;

    public SuccessMessage() {
    }

    public SuccessMessage(String message, int code, String docUrl) {
        this.message = message;
        this.code = code;
        this.docUrl = docUrl;
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

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }
}
