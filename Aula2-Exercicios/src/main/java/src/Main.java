package src;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

                .forEach(number -> System.out.println(number));  // realizando o loop sob os elementos

    }
}