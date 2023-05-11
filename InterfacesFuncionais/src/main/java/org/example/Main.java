package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // *** Supplier: são funções que não recebem valor, mas retornam um resultado *** \\
        Stream.generate(() -> new Random().nextInt())  // O generate não recebe valor e retorna um resultado
                .limit(5)
                .forEach(System.out::println);


        // *** Consumer/Biconsumer: Recebe um valor e não retorna um resultado *** \\
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach((e) -> System.out.println(e)); // O foreach neste exemplo recebe um valor, mas não retorna um resultado


        // *** Predicate/Bipredicate: Recebe um valor (ou dois valores para o Bi) e retorna um resultado booleano *** \\
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(e -> e % 2 == 0)  // O filter recebe uma cláusula e retorna o que atende a cláusula e não retorna o que não atende
                .forEach(System.out::println);


        // *** Function/Bifunction: Recebe um valor (ou dois valores para o Bi) qualquer e retorna um resultado qualquer *** \\
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())  // O map recebe um valor qualquer (integer neste exemplo) e retorna um resultado qualquer (Double neste exemplo)
                .forEach(System.out::println);


        // *** UnaryOperator/BinaryOperator: Recebe um valor (ou dois valores para o Bi) e retorna um resultado do mesmo tipo que recebeu *** \\
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .reduce((e1, e2) -> e1 + e2)  // O reduce recebeu um valor binary e retornou um resultado binary
                .ifPresent(System.out::println);
    }
}