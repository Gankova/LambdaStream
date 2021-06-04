package com.company;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static int example;

    public static void main(String[] args) {
        // в некоторых случаях оператор new может быть использован, как метод объекта

        System.out.println("Введите выражение");
        Scanner sc =new Scanner(System.in);
        String expression = sc.nextLine();
        String operator = "";
        if (expression.contains("+")){
            operator ="+";
        }
        if (expression.contains("-")){
            operator ="-";
        }
        if (expression.contains("*")){
            operator ="*";
        }
        if (expression.contains("/")){
            operator ="/";
        }
        int opIndex = expression.indexOf(operator);
        int x = Integer.parseInt(expression.substring(0,opIndex));
        int y = Integer.parseInt(expression.substring(opIndex+1));

        HashMap<String, Calculator> calc = new HashMap<>();

        // анонимный класс new Calculator, реализация методов происходит при создании объектов
        // анонимный клас нельзя наследовать, но можно расширять, добалять методы
        calc.put("+", new Calculator() {
            private int some;// для примера, что можно расширять анонимный класс
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        });

        calc.put("-", (a,b)-> a-b);
        calc.put("*", (a,b)-> a*b);
        calc.put("/", (a,b)-> a/b);


        /*
        //лямбда выражения реализуют только один абстрактный метод
        //(в интерфейсе, в абстрактнои классе)
        Calculator plus = (int a, int b) -> {
            return a + b;
        };
        System.out.println(plus.calculate(12,78));
        // если в теле лямбды выполняется одно выражение и результат этого выражения необходимо вернуть,
        // то {} и ключевое слово return  можно опустить
        Calculator minus =(a, b) -> a - b;

        Donut d = new Donut();
        d.eat();
        System.out.println(d.hashCode());

        int n = 7;
        Calculator test  = (a, b) -> {
            example = 23;
            System.out.println(example + 45);
            // n = 10 - нельзя
            System.out.println(n * n);
            return 0;
        };


       // n = 12; после использования в лямбде поменять нельзя

        // Donut :: division -статический метод devision  из класса Donut используется в качестве лямбда выражений
        calc.put("/", Donut :: division);
        calc.put("/", new Donut() ::division2);//для нестотического метода через объкт класса (new Donut)
        */

        System.out.println(calc.get(operator).calculate(x,y));


        //Stream API
        ArrayList<Integer> list = new ArrayList<>();
        list.add(999);
        list.add(800);
        list.add(12);
        list.add(400);





        Integer [] filtered = list.stream()
                .filter((e) -> e >= 100)
                .filter((e) -> e % 2 == 0)
                .toArray(Integer[]::new);

        for (Integer i : filtered) {
            System.out.println(i);
        }
        list.stream()
                .filter((e) -> e >= 100)
                .forEach(System.out::println);

        //посмотреть дома habr.com


    }
}
