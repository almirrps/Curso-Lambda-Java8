package org.example;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class MyAppMain {
	
	// Collector: muito parecido com o Reduce, o propósito dele é trabalhar com objetos mutáveis
	// isto é, com ele é possível armazenar o resultado de um stream (list, map, set...)
	
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        
        
        // Armazenando a lista em um Set convertendo para String
        Set<String> collect = list.stream()
						          .collect(() -> new HashSet<>(),         // supplier - função lambda que fornece a instância onde queremos aculumar o resultado do stream 
						        		  (l, e) -> l.add(e.toString()),  // acumulador - função de acumulação
						        		  (l1, l2) -> l1.addAll(l2)       // combiner - função de combinação
						        		  );
    
        System.out.println(collect);


        
       //***Exemplos com Collectors***\\
       // Exemplo retornando um Set
       Set<Integer> collectorsToSet = list.stream()
    		   .filter((n) -> n % 2 == 0)
    		   .collect(Collectors.toSet());
       
       System.out.println(collectorsToSet);


        // Exemplo retornando uma lista
        List<Integer> collectorsToList = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(collectorsToList);


        // Retornando um Joining - concatena/uni todos os elementos, desde que seja uma string
        String collectorsJoining = list.stream()
                .map(n -> n.toString())          // Convertendo elemento para String
                .collect(Collectors.joining(";"));  // Concatenando os elementos com o joining

        System.out.println(collectorsJoining);


        //***Calculos aritméticos***\\
        // Averaging
        Double toCollectorsAveraging = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue())); // Converte para int primitivo ao retornar a média

        System.out.println(toCollectorsAveraging);


        // Summing
        Integer toCollectorsSumming = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue())); // Converte para int primitivo ao retornar a soma

        System.out.println(toCollectorsSumming);


        // Summarizing
        IntSummaryStatistics toCollectorsSummarizing = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue())); // Converte para int primitivo ao retornar um objeto

        System.out.println("===toCollectorsSummarizing===");
        System.out.println("Média: " + toCollectorsSummarizing.getAverage());
        System.out.println("Quantidade: " + toCollectorsSummarizing.getCount());
        System.out.println("Maior: " + toCollectorsSummarizing.getMax());
        System.out.println("Menor: " + toCollectorsSummarizing.getMin());
        System.out.println("Soma: " + toCollectorsSummarizing.getSum());
        System.out.println("=============================");


        // Counting
        Long toCollectorsCounting = list.stream()
                .collect(Collectors.counting());  // Contanto a quantidade de elementos

        System.out.println(toCollectorsCounting);


        // Max (retorna um Optional)
        Optional<Integer> toCollectorsMax = list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));  // O Comparator é para definir como será feita a comparação para saber qual é o máximo

        System.out.println(toCollectorsMax);


        // Min (retorna um Optional)
        list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))  // O Comparator é para definir como será feita a comparação para saber qual é o mínimo
                .ifPresent(System.out::println);  // Mandando imprimir, caso exista algo no Optional retornado


        //***Retornando Mapa***\\
        // GroupingBy
        Map<Integer, List<Integer>> collectorsGroupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));  // Agrupando pelo resto da divisão por 3

        System.out.println(collectorsGroupingBy);


        // PartitioningBy
        Map<Boolean, List<Integer>> collectorsPartitioningBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0));  // Valida numeros divisiveis por 3

        System.out.println(collectorsPartitioningBy);


        // toMap
        Map<Integer, Integer> collectorsToMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));  // Mapeando valor na segunda potencia

        System.out.println(collectorsToMap);



        //***Exemplos com toCollection***\\
        // Retornando um TreeSet
        Set<Integer> toCollectionTreeSet = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));

        System.out.println(toCollectionTreeSet);


        // Retornando um LinkedList
        List<Integer> toCollectionLinkedList = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));

        System.out.println(toCollectionTreeSet);


        // Retornando um Deque
        Deque<Integer> toCollectionDeque = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new ArrayDeque<Integer>()));

        System.out.println(toCollectionDeque);

    }
    
}