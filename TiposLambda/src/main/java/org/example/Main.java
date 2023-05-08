package org.example;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // *** Parenteses *** \\
        Runnable runnable = () -> System.out.println("Vendo tipos de lambda.");  // Quando não temos parâmetros no método que chamamos

        IntStream.range(0, 5)  // Contando de zero a cinco
                .filter((int n) -> n % 2 == 0)  // Quando queremos declarar o tipo da variável
                .reduce((n1, n2) -> n1 + n2)    // Quando temos mais de um parâmetro para passar
                .ifPresent(System.out::println);  // Utilizando method reference


        // *** Chaves *** \\
        IntStream.range(0, 5)  // Contando de zero a cinco
                .filter(n -> {  // Quando queremos executar mais de um método - lembre-se do ponto e vírgula
                    System.out.println("Exemplo de parenteses");
                    return n % 2 == 0;
                })
                .forEach(n -> System.out.println(n));  // Simples
    }
}