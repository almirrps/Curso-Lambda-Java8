package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Stream em Collection
        System.out.println("Exemplo de Stream em Collection");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(System.out::println);


        // Stream com Arrays
        System.out.println("Exemplo de Stream em Arrays");
        Integer[] intArray = new Integer[] {1, 2, 3, 4};
        Arrays.stream(intArray).forEach(System.out::println);


        // Utilizando Stream.of: cria uma collection de qualquer valor informado
        System.out.println("Exemplo de Stream.of");
        Stream
                .of("Teste", "com", "Stream", "of", "!")
                .forEach(System.out::println);


        // Utilizando IntStream.range: realiza uma contagem previamente definida
        System.out.println("Exemplo de IntStream.range");
        IntStream.range(0, 5).forEach(System.out::println);


        // Utilizando IntStream.rangeClosed: faz o mesmo que o IntStream.range, mas inclui o último valor
        System.out.println("Exemplo de IntStream.rangeClosed");
        IntStream.rangeClosed(0, 5).forEach(System.out::println);


        // Utilizando Stream.iterate: recebe um valor inicial e uma expressão que será a transformação aplicada ao valor inicial
        System.out.println("Exemplo de IntStream.iterate");
        IntStream
                .iterate(5, n -> n * 2)  // Aplicação do iterate
                .limit(10)             // Limit: necessário para que o iterate saiba a hora de parar
                .forEach(System.out::println);


        // Utilizando BufferedReader: lê um determinado arquivo e retorna o conteúdo em um streams
        System.out.println("Exemplo de BufferedReader");
        File file = new File("streams.txt");
        FileReader fR = new FileReader(file);
        try (BufferedReader bR = new BufferedReader(fR)) {
            bR
                    .lines()  // Cria a lista com o conteúdo do arquivo
                    .forEach(System.out::println);
        }


        // Files: manuseia arquivos de um determinado diretório
        System.out.println("Exemplo de Files");
        Path path = Paths.get("");  // Listando os arquivos do diretório raiz da aplicação
        Files
                .list(path)  // Cria o stream com a lista de arquivos do diretório
                .forEach(System.out::println);


        // Random: cria lista de números inteiros em forma aleatória
        new Random()
                .ints()  //  Cria o stream com a lista de números aleatórios
                .limit(10)  // Necessário definir um limite
                .forEach(System.out::println);


        // Pattern: para trabalhar com Regex
        String texto = "Testando Regex no Pattern";
        Pattern pattern = Pattern.compile(" ");  // Expressão Regex - quebrar linha onde tem espaço
        pattern
                .splitAsStream(texto)  // Criando a stream e aplicando a Regex
                .forEach(System.out::println);
    }
}