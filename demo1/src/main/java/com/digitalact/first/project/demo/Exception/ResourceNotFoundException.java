package com.digitalact.first.project.demo.Exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public  ResourceNotFoundException(String resource, Long id){

        super(String.format("The resource %s with identifier %s is not found", resource,id));
    }
}
