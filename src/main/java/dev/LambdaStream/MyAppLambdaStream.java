package dev.LambdaStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyAppLambdaStream {

    public static void main(String[] args) {

        //Stream - Fluxo de dados
        List<Integer> asList = Arrays.asList(1,2,3,4);

        //Até o Java 7
        System.out.println("Contagem utilizando Java 7");
        asList.stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer e) {
                        return e % 2 == 0;
                    }
                }) //filtrando números divisíveis por 2
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer e) {
                        System.out.println(e);
                    }
                });


        //No Java 8 com funções Lambda
        System.out.println("Contagem utilizando Lambda Java 8");
        asList.stream()
                .filter(e -> e % 2 == 0) //filtrando números divisíveis por 2
                .forEach(e -> System.out.println(e));

    }

}
