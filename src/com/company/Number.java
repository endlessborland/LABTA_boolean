package com.company;

public class Number extends Base {

    public Number(String number)
    {
        this.number = Integer.parseInt(number);
        this.stringValue = number;
        this.priority = -1;
    }

    public Number(int number)
    {
        this.number = number;
        this.priority = -1;
        this.stringValue = String.valueOf(number);
    }

    public int getNumber()
    {
        return this.number;
    }

    private int number;

}
