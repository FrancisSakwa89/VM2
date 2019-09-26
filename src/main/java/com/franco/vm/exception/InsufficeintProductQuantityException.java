package com.franco.vm.exception;

public class InsufficeintProductQuantityException extends Exception {
    public  InsufficeintProductQuantityException(){
        super("Product quantity not available...");
    }
}
