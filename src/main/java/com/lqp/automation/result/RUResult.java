/*
 * Liquid Pay
 */


package com.lqp.automation.result;


/**
 *
 * @author Thanh Chuong
 */
public class RUResult {
    private ResultStatus status;
    private String message;

    public RUResult(){this.status=ResultStatus.PASSED;}
    
    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public RUResult (ResultStatus status, String message){
        this.status = status;
        this.message = message;
    }
    
    public enum ResultStatus{PASSED, FAILED};

}
