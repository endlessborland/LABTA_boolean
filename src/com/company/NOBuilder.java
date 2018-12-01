package com.company;


public class NOBuilder {
    public NOBuilder() {};

    public Base construct(String in) {
        if (in.matches("[01]"))
            return new Number(in);
        return new Operation(in);
    }
}
