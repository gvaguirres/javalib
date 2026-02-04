package org.example;

public class Calculator {
    // control + enter -> generate test
    // tres puntos arriba a la derecha -> run with Coverage
    // Coverage nos va a mostrar cuánto del código está cubierto por los tests

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static float div(int a, int b) {
        return a / b;
        // si hago este cambio y cambio al branch main
        // este cambio también lo puedo ver porque es un cambio local
    }
}
