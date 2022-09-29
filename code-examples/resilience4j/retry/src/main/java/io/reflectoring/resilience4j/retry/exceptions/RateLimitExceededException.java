package io.reflectoring.resilience4j.retry.exceptions;

public class RateLimitExceededException extends FlightServiceBaseException {
    String errorCode;

    public RateLimitExceededException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}