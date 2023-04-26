package src;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        // Exemplo em Java 4: era necessário utilizar o Iterator
        for (Iterator iterator = lista.iterator(); iterator.hasNext(); ) {
            Integer number = (Integer) iterator.next();
            System.out.println(number);
        }

        // Exemplo em Java 5: utilizando o foreach, não tínhamos a possibilidade de mexer na lista
        for (Integer number: lista) {
            System.out.println(number);
        }

        // Java 8: utilizando o Streams que é um fluxo de dados, diferente do Iterator
        lista.stream()  // alocando a lista no stream na forma de elementos

                // ** Operações Intermediarias - que pode ser chamada quantas vezes eu quiser ** \\
                .skip(2)  // pula ou ignora os dois primeiros elementos do stream
                .limit(2)  // indica para manter somente os dois primeiros elementos (utiliza do equals e do hashcode
                .distinct()  // não permite o stream processar elementos semelhantes (repetidos)
                .filter(number -> number % 2 == 0)  // filtrando por numeros pares
                .map(number -> number * 2)  // apresenta no console o resultado da multiplicação dos elementos por 2
                // *********  \\

                // ** Operações Finais - finaliza um stream, depois dele nenhuma outra operação pode ser chamada ** \\
                .forEach(number -> System.out.println(number));  // realizando o loop sob os elementos


                /*
                .count(); -->> retorna a quantidade de elementos em um stream

                Exemplo:
                */
                long count = lista.stream()
                        .count();
                System.out.println(count);


                /*
                .min(Comparator.naturalOrder()); -->> Retorna o valor mínimo dentre os elementos
                                                 Obs.: O Comparator.naturalOrder() é o comparador da classe
                                                       que estou utilizando, no caso do exemplo abaixo, é o
                                                       comparador da classe Integer.

                Exemplo:
                */
                Optional<Integer> min = lista.stream()
                        .min(Comparator.naturalOrder());
                System.out.println(min.get());


                /*
                .max(Comparator.naturalOrder()); -->> Retorna o valor máximo dentre os elementos
                                                 Obs.: O Comparator.naturalOrder() é o comparador da classe
                                                       que estou utilizando, no caso do exemplo abaixo, é o
                                                       comparador da classe Integer.

                Exemplo:
                */
                Optional<Integer> max = lista.stream()
                        .max(Comparator.naturalOrder());
                System.out.println(max.get());


                /*
                .collect(Collectors.toList()); -->> Coleta os elementos de maneira mais personalizada possível
                                                 Obs.: Utilizando Collectors.toList() estaremos coletando
                                                       elementos para uma nova lista.

                Exemplo 1:
                */
                List<Integer> novaLista = lista.stream()
                        .filter(e -> e % 2 == 0)
                        .collect(Collectors.toList());  // nova lista só com números pares
                System.out.println(novaLista);

                /*
                Obs.: No caso do Collectors.groupingBy() agrupamos os elementos por uma determinada condição;

                Exemplo 1:
                */
                Map<Boolean, List<Integer>> mapa1 = lista.stream()
                        .map(e -> e * 3)
                        .collect(Collectors.groupingBy(e -> e % 2 == 0));  // Multiplica os elementos por 3 e agrupa pelos pares
                System.out.println(mapa1);

                /*
                Exemplo 2:
                */
                Map<Integer, List<Integer>> mapa2 = lista.stream()
                        .collect(Collectors.groupingBy(e -> e % 3));  // Agrupando pelo resto da divisão por 3
                System.out.println(mapa2);

                /*
                Obs.: Com o Collectors.joining() retornamos uma string concatenando todos os elementos do stream

                Exemplo:
                */
                String collect = lista.stream()
                        .map(e -> String.valueOf(e))  // Convertendo os elementos em string
                        .collect(Collectors.joining());  // concatenando os elementos - é possivel colocar um delimitador
                System.out.println(collect);


        /*****************
         *Por que utilizar Stream ao invés dos loops tradicionais
         * Stream são loops implícitos
         * for / while / do..while são loops explícitos
         * No Stream não existe a preocupação de controlar o loop, o código fica menos complexo e mais enxuto.
         * Exemplos no site: https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/
        */
    }
}