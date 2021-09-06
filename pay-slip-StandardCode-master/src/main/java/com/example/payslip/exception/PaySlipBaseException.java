package com.example.payslip.exception;


import com.example.payslip.enums.ResponseStatusCode;

public class PaySlipBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final Integer code;
    private final String message;

    public PaySlipBaseException(ResponseStatusCode statusCode) {
        super();
        this.code = statusCode.getCode();
        this.message = statusCode.getReasonPhrase();
    }
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
