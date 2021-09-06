package com.example.payslip.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ResponseStatusCode {
  SUCCESS(10000, "SUCCESS"),

  FAIL(10001, "FAIL"),
  USER_ID_NOT_EXIST(10002, "USER_ID_NOT_EXIST"),
  INVALID_REQUEST_PARAMETER(10003, "INVALID_REQUEST_PARAMETER"),
  USER_ID_ALREADY_EXIST(10004, "USER_ID_ALREADY_EXIST");
  private final Integer code;
  private final String reasonPhrase;

  private static final Map<Integer, ResponseStatusCode> RESPONSE_STATUS_CODE_MAP =
      Arrays.stream(ResponseStatusCode.values())
          .collect(Collectors.toMap(ResponseStatusCode::getCode, Function.identity()));

  private ResponseStatusCode(Integer code, String reasonPhrase) {
    this.code = code;
    this.reasonPhrase = reasonPhrase;
  }

  public static ResponseStatusCode valueOf(int value) {
    if (RESPONSE_STATUS_CODE_MAP.containsKey(value)) {
      return RESPONSE_STATUS_CODE_MAP.get(value);
    }
    throw new IllegalArgumentException("No matching constant for [" + value + "]");
  }

  public Integer getCode() {
    return code;
  }

  public String getReasonPhrase() {
    return reasonPhrase;
  }

  @Override
  public String toString() {
    return "ResponseStatusCode{" + "code=" + code + ", reasonPhrase='" + reasonPhrase + '\'' + '}';
  }
}
