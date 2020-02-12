package com.code.users.exception;

public class ResourcesNotFoundException extends Exception {


    private static final String msg = null;

    public ResourcesNotFoundException(){
        this(msg);
    }

    public ResourcesNotFoundException(String msg){

    }
}
