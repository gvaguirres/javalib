package org.example;

public class Calculator {
//control + enter -> generate test
//tres puntos arriba a la derecha -> run with Coverage
//Coverage nos va a mostrar cuánto del código está cubierto por los tests

    public static int add(int a, int b){
        return a + b;
    }

    public static int add(int a, int b, int c){
        return a + b + c;
    }

    public static int add(int ... numbers){
        int sum = 0;
        for (int number : numbers){
            sum += number;
        }
        return sum;
    }
}
