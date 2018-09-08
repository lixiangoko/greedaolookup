package scrollview.com.cn.myproject;

public class ResultBean {
    private Integer error_code;
    private String reason;
    private Class result;

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Class getResult() {
        return result;
    }

    public void setResult(Class result) {
        this.result = result;
    }
}
