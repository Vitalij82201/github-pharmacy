package org.hstn.pharmacy.exceptions;

public class InvalidJwtException extends RuntimeException {
    public InvalidJwtException(String msg, Throwable cause) {
        super(msg, cause);
    }

  public InvalidJwtException(String msg) {
    super(msg);
  }
}
