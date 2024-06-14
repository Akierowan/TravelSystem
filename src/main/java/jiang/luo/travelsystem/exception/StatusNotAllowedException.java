package jiang.luo.travelsystem.exception;

/**
 * 状态异常
 */
public class StatusNotAllowedException extends RuntimeException {
    public StatusNotAllowedException() {

    }

    public StatusNotAllowedException(String msg) {
        super(msg);
    }
}
