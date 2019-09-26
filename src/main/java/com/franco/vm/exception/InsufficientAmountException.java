package com.franco.vm.exception;

public class InsufficientAmountException extends Exception {
    public InsufficientAmountException(){
        super("CashDrawer is less than required amount..");
    }
}
