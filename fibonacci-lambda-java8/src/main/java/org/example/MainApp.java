package org.example;

import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Chamando Fibonacci Tradicional");
        fibonacciTradicional();

        System.out.println("Chamando Fibonacci Lambda");
        fibonacciLambda();
    }

    public static void fibonacciTradicional() {
        int anterior = 0;
        int atual = 1;

        while (atual < 100) {
            System.out.println(atual);

            int proximo = anterior + atual;

            anterior = atual;
            atual = proximo;
        }

        System.out.println(atual);
    }

    public static void fibonacciLambda() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})  // Realiza o cálculo de fibonacci
                                                                            // posicionando o valor anterior
                                                                            // e atual em dois grupos
                .limit(12)  // Estabelece um limite para calcular de 12 posições
                .forEach(x -> System.out.println("{" + x[0] + ", " + x[1] + "}"));  // Imprime os grupos na tela
    }
}