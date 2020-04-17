package com.wangfengta.api.exception;

/**
 * Created by jiacheo on 15/5/23.
 */
public class ApiException extends Exception {
  public ApiException() {
  }

  public ApiException(String message) {
    super(message);
  }

  public ApiException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApiException(Throwable cause) {
    super(cause);
  }
}
