package com.wanted.mission.exception;

public class DuplicateApplicationException extends RuntimeException{
    public DuplicateApplicationException(String message) {
        super(message);
    }
}
