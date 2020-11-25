package guifan.except;

public class UnloginException  extends RuntimeException {

    private String code;
    private String msg;
    public UnloginException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
