package org.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Print sem method reference");
        list.stream()
                .forEach((n) -> System.out.println(n));  // Printando na tela sem method reference

        System.out.println("Print com method reference");
        list.stream()
                .forEach(System.out::println);  // Printando na tela com method reference


        // *** Métodos Estáticos *** \\
        System.out.println("Método estático sem method reference");
        list.stream()
                .map((n) -> multipliquePorDois(n))  // Chamando método estático multiplicando por dois sem o Method Reference
                .forEach(System.out::println);

        System.out.println("Método estático com method reference");
        list.stream()
                .map(Main::multipliquePorDois)  // Chamando método estático multiplicando por dois com o Method Reference
                .forEach(System.out::println);


        // *** Construtores *** \\
        System.out.println("Construtor sem method reference");
        list.stream()
                .map((n) -> new BigDecimal(n))  // Utilizando construtor para converter Integer para BigDecimal
                .forEach(System.out::println);

        System.out.println("Construtor com method reference");
        list.stream()
                .map(BigDecimal::new)  // Utilizando construtor para converter Integer para BigDecimal
                .forEach(System.out::println);


        // *** Trabalhando com várias instâncias *** \\
        System.out.println("Várias instâncias sem method reference");
        list.stream()
                .map((n) -> n.doubleValue())  // Várias instâncias porque está sendo tratado um elemento por vez
                .forEach(System.out::println);

        System.out.println("Várias instâncias com method reference");
        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);


        // *** Trabalhando com única instância *** \\
        System.out.println("Única instância sem method reference");
        BigDecimal numDois = new BigDecimal(2);  // Convertendo numero dois para BigDecimal
        list.stream()
                .map(BigDecimal::new)  // Definindo
                .map((b) -> numDois.multiply(b))  // Instâncias única porque está sendo tratado todos os elementos de uma única vez
                .forEach(System.out::println);

        System.out.println("Única instância com method reference");
        list.stream()
                .map(BigDecimal::new)
                .map(numDois::multiply)
                .forEach(System.out::println);
    }

    private static Integer multipliquePorDois(Integer valor) {
        return valor * 2;
    }
}