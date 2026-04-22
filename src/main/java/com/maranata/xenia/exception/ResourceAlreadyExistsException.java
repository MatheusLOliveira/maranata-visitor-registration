package com.maranata.xenia.exception;

import com.maranata.xenia.infra.RestExceptionHandler;

public class ResourceAlreadyExistsException extends RuntimeException{

    public ResourceAlreadyExistsException()  {
        super("Resource already exists.");
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

}
