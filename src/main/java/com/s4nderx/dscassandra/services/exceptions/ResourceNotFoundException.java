package com.s4nderx.dscassandra.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 6897595737225414628L;

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
