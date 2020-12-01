package org.dkwork.javatemplate.common.exceptions;

public class CheckAuthException extends RuntimeException {
    public CheckAuthException() {
    }
    public CheckAuthException(String message) {
        super(message);
    }
}
