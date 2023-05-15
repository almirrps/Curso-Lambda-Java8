package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // ***Criando a List para ser utilizada nos exemplos*** \\
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // Diferença entre parallel e parallelStream
        //list.parallelStream();  // O parallelStream conseguimos chamar diretamente da lista
        //IntStream.range(0, 5).parallel();  // O parallel é quando não temos uma lista, aí é necessário chamar o .parallel para transformá-lo


        // **********************************************************************************
        // *** O parallel ou parallelStream é recomendado únicamente quando precisamos
        // *** ganhar performance em um algoritmo específico em que esteja sendo tratada uma
        // *** quantidade de elementos na casa dos milhões ou mais. Em outros casos o correto
        // *** é utilizar o stream comum, SimpleThread.
        // **********************************************************************************



        // forEach vs forEachOrdered
        System.out.println("Exemplo forEach em parallelStream");
        list.parallelStream()
                .forEach(System.out::println);  // Apresenta os elementos na ordem como foi tratado no stream

        System.out.println("Exemplo forEachOrdered em parallelStream");
        list.parallelStream()
                .forEachOrdered(System.out::println);  // Ordena os elementos corretamente antes de apresentá-los


        // findAny: retorna um Optional dos elementos apresentando o primeiro elemento encontrado.
        System.out.println("Exemplo findAny em parallelStream e stream");
        list.parallelStream()
                .findAny()  // No parallelStream, temos várias threads funcionando ao mesmo tempo, daí o resultado diferente à cada execução
                .ifPresent(System.out::println);

        list.stream()
                .findAny()  // No stream temos uma única execução, daí o resultado sempre igual
                .ifPresent(System.out::println);


        // unordered: utilizado junto com skip, limit e/ou distinct, ele garante ao parallel
        // a execução independente das threads obtendo assim ganho de performance na execução
        System.out.println("Exemplo unordered, skip, limit e distinct em parallelStream");
        list.parallelStream()
                .unordered()
                .skip(1)   // Pula uma certa quantidade de elementos
                .limit(2)  // Limita a quantidade de elementos à serem tratados
                .distinct()  //Apresenta elementos com valores iguais
                .forEach(System.out::println);


        // reduce
        // (1+2)+(3+4) + 2 = 12 -> operação associativa: não importa a ordem do cálculo, o resultado é sempre o mesmo
        // (1-2)-(3-4) - 2 != 12 -> operação não-associativa: dependendo da ordem, o resultado muda
        System.out.println("Exemplo reduce em parallelStream");
        list.parallelStream()
                .reduce((n1, n2) -> n1 + n2)  // Você só tem garantia do resultado com operações associativas
                .ifPresent(System.out::println);


        // toMap vs toConcurrentMap: o toMap é um objeto HashMap que não suporta o acesso simultâneo
        // no mesmo map ao ao mesmo tempo. Por isso ele cria um map para cada Thread para depois juntar
        // tudo em um único map para apresentar o resultado final, comprometendo assim a performance.
        // Já o toConcurrentMap consegue ter acesso simultâneo ao mesmo Map ao mesmo tempo garantindo a performance.
        // obs.: o ConcurrentMap não dá garantia de que irá manter a ordem do valor dos elementos, já  que está
        // executando várias threads ao mesmo tempo.
        System.out.println("Exemplo toMap e toConcurrentMap em parallelStream");
        Map<Integer, Boolean> collectToMap = list.parallelStream()
                                                 .collect(
                                                         Collectors
                                                                 .toMap(n -> n, n -> n % 2 == 0)
                                                         );
        System.out.println(collectToMap);

        Map<Integer, Boolean> collectToConcurrent = list.parallelStream()
                                                        .collect(
                                                                Collectors
                                                                        .toConcurrentMap(n -> n, n -> n % 2 == 0)
                                                                );
        System.out.println(collectToConcurrent);


        // groupingBy é a mesma coisa do toMap. Já o groupingByConcurrent é o mesmo que o toConcurrentMap.
        System.out.println("Exemplo groupingBy vs groupingByConcurrent em parallelStream");
        Map<Boolean, List<Integer>> collectGroupingBy = list.parallelStream()
                .collect(
                        Collectors
                                .groupingBy(n -> n % 2 == 0)
                );
        System.out.println(collectGroupingBy);

        Map<Boolean, List<Integer>> collectGroupingByConc = list.parallelStream()
                .collect(
                        Collectors
                                .groupingByConcurrent(n -> n % 2 == 0)
                );
        System.out.println(collectGroupingByConc);

    }
}