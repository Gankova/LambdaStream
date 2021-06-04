package com.company;

public class Donut {
    public void eat (){
        Calculator c  =  (a, b) -> {
            // this  внутри лямбды ссылка на объкт типа Donut
            System.out.println(this.hashCode());
            return 0;
        };
        c.calculate(1,7);
    }
    public static int division (int a, int b) {
        return a/b;
    }
    public int division2 (int a, int b) {
        return a/b;
    }
}
