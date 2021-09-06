package com.example.payslip.dto.response;

import com.example.payslip.enums.ResponseStatusCode;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Date;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {

  private Integer code;

  private String message;


  private Long timestamp = new Date().getTime();

  public ResponseStatus(){}

  public ResponseStatus(ResponseStatusCode responseCode) {
    this(responseCode.getCode(), responseCode.getReasonPhrase());
  }

  public ResponseStatus(ResponseStatusCode statusCode, String actualErrorMessage) {
    this(statusCode.getCode(), actualErrorMessage);
  }


  public ResponseStatus(int code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  public ResponseStatus(ResponseStatusCode statusCode, Map<String, String> errors) {
  }



  public Integer getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTimestamp() {
    return timestamp;
  }

}
