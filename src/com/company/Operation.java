package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Operation extends  Base{
    private String operation;

    private Calc func;

    private UCalc ufunc;

    private Boolean isR;

    private Boolean isUn;

    private Boolean isPostfix;

    private Boolean isPrefix;


    public Operation(String operation)
    {
        this.operation = operation;
        this.stringValue = operation;
        this.isR = false;
        this.isUn = false;
        this.isPostfix = false;
        this.isPrefix = false;
        switch (operation) {
            case "+":
                this.priority = 5;
                this.func = (x,y) -> this.dis(x,y);
                break;
            case "*":
                this.priority = 6;
                this.func = (x,y) -> this.con(x,y);
                break;
            case "=>":
                this.priority = 3;
                this.func = (x,y) -> this.impl(x,y);
                break;
            case "=":
                this.priority = 2;
                this.func = (x,y) -> this.equal(x,y);
                break;
            case "-":
                this.priority = 7;
                this.ufunc = x -> this.invert(x);
                this.isUn = true;
                this.isPrefix = true;
                break;
            case "++":
                this.priority = 4;
                this.func = (x,y) -> this.bytwo(x,y);
                break;
            default:
                this.priority = -1;
        }
    }

    public int Calculate(int x, int y)
    {
        return this.func.calculate(x,y);
    }

    public int Calculate(int x) {
        return this.ufunc.calculate(x);
    }

    public Boolean IsR()
    {
        return this.isR;
    }

    public Boolean isPostfix() {
        return isPostfix;
    }

    public Boolean isUn() {
        return isUn;
    }

    public boolean isPrefix() {
        return this.isPrefix;
    }

    private int con(int x, int y)
    {
        return x*y;
    }

    private int dis(int x, int y)
    {
        if (x == 0 && y == 0)
            return 0;
        return 1;
    }

    private int impl(int x, int y)
    {
        if (x == 1 && y == 0)
            return 0;
        return 1;
    }

    private int bytwo(int x, int y)
    {
        if (x == y)
            return 0;
        return 1;
    }

    private int invert(int x)
    {
        if (x == 0)
            return 1;
        return 0;
    }

    private int equal(int x, int y)
    {
        if (x == y)
            return 1;
        return 0;
    }
}
