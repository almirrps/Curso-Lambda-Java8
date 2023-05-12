package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ***Criando a List para ser utilizada nos exemplos*** \\
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        // forEach: lista os elementos de uma lista
        System.out.println("Exemplo com forEach em lista");
        list.forEach(n -> System.out.println(n));  // Este forEach recebe somente 1 elemento por vez


        // removeIf: remove um elemento da lista, se atender à condição
        System.out.println("Exemplo com remofeIf");
        list.removeIf(n -> n % 2 == 0);  // Remove valores cujo divisor por 2 resulta em zero
        list.forEach(n -> System.out.println(n));


        // replaceAll: substitui um elemento por um outro valor
        System.out.println("Exemplo com replaceAll");
        list.replaceAll(n -> n * 2);  // Substitui o valor atual do elemento pelo próprio valor multiplicado por 2
        list.forEach(n -> System.out.println(n));



        // ***Criando um mapa para utilizar nos próximos exemplos*** \\
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Teste");
        map.put(1, "realizado");
        map.put(2, "com");
        map.put(3, "Hashmap");


        // forEach: lista os elementos de um Hashmap
        System.out.println("Exemplo com forEach em Hashmap");
        map.forEach((key, value) -> System.out.println(key + "-" + value));  // Este forEach recebe 2 elementos por vez <Chave, ValorDaChave>


        // compute: substitui o valor de um elemento
        System.out.println("Exemplo com compute em Hashmap");
        map.compute(0, (key, value) -> value + " cabuloso");  // Este compute está substituido o valor
                                                                  // do map com chave 0 pelo próprio valor
                                                                  // concatenado com um novo valor
        map.forEach((key, value) -> System.out.println(key + "-" + value));


        // merge: mescla o valor de um elemento
        System.out.println("Exemplo com merge em Hashmap");
        map.merge(3, "!", (value1, value2) -> value1 + value2);  // Este merge está mesclando o valor
                                                                           // do map com chave 3 com um novo valor informado
        map.forEach((key, value) -> System.out.println(key + "-" + value));


        // replaceAll: substitui o valor de um elemento
        System.out.println("Exemplo com replaceAll em Hashmap");
        map.replaceAll((key, value) -> value + "!");  // Este compute recebe está substituido o valor
                                                      // de todos os elementos pelo próprio valor
                                                      // concatenado com um novo valor
        map.forEach((key, value) -> System.out.println(key + "-" + value));

    }
}