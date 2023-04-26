package org.example;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Optional_Java8 {

    public static void main(String[] args) {
    	
    	String s = "1";
    	
    	// Chamando o método no conceito até Java 7
    	Integer numeroConvertido = converteEmNumero(s);
    	System.out.println(numeroConvertido);

    	// Chamando o método no conceito Optional
    	Optional<Integer> numeroConvertidoOptional = converteEmNumeroOptional(s);
    	System.out.println(numeroConvertidoOptional);  // Para visualizar o valor convertido
    	System.out.println(numeroConvertidoOptional.isPresent());  // Para verificar se existe um valor ou não (Optional.empty)
    	System.out.println(numeroConvertidoOptional.get());  // Para pegar o valor armazenado - se estiver empty dá erro de exceção
    	
    	// Dois exemplos que, utilizando expressão lambda, verifica se o valor está presente para visualizar
    	numeroConvertidoOptional.ifPresent(n -> System.out.println(n));  
    	  // ou
    	converteEmNumeroOptional(s).ifPresent(n -> System.out.println(n));
    	
    	// Dois exemplos que verifica se o valor está presente para visualizar se não tiver, apresenta outro valor predefinido
    	Integer numeroConvertidoElse;
    	numeroConvertidoElse = numeroConvertidoOptional.orElse(2);  
    	  // ou
    	numeroConvertidoElse = converteEmNumeroOptional(s).orElse(2);
    	System.out.println(numeroConvertidoElse);


    	// Dois exemplos que, utilizando expressão lambda, verifica se o valor está presente para visualizar 
    	// se não tiver, apresenta outro valor predefinido ou o retorno de algum cálculo ou método chamado no lambda
    	Integer numeroConvertidoElseGet;
    	numeroConvertidoElseGet = numeroConvertidoOptional.orElseGet(() -> 5);  
    	  // ou
    	numeroConvertidoElseGet = converteEmNumeroOptional(s).orElseGet(() -> {return 5*2;});
    	System.out.println(numeroConvertidoElseGet);

    	// Utilizando expressão lambda, verifica se o valor está presente para visualizar 
    	// se não tiver, ele lança uma exceção
    	Integer numeroConvertidoThrow = numeroConvertidoOptional.orElseThrow(() -> new NullPointerException("Valor Vazio."));  
    	System.out.println(numeroConvertidoThrow);
    	
    	Stream.of(1, 2, 3)
    		.findFirst()  // Pega o primeiro elemento da lista (retorno é Optional)
    		.ifPresent(n -> System.out.println(n));  // Se existir um valor, ele é visualizado
    	
    	// Chamando o método no conceito Optional com tipo primitivo
    	OptionalInt numeroConvertidoOptionalInt = converteEmNumeroOptionalPrimitivo(s);
    	System.out.println(numeroConvertidoOptionalInt);  // Para visualizar o valor convertido

    }

    // Método criado conforme conceito até Java 7
    public static Integer converteEmNumero(String numeroStr) {
    	try {
    		return Integer.valueOf(numeroStr);  // Tenta converter o valor pra Integer
		} catch (Exception e) {
			return null;  // Se não conseguir, retorna null
		}
        
    }
    
    // Método utilizando o Optional - conceito utilizado à partir do Java 8
    public static Optional<Integer> converteEmNumeroOptional(String numeroStr) {
        try {
        	//return Optional.ofNullable(Integer.valueOf(numeroStr));  // Com o ofNullable, é possível receber um valor nulo 
        	                                                           // e o Optional automaticamente converte para Optional.empty
        	
        	return Optional.of(Integer.valueOf(numeroStr));  // Tenta converter o valor para Integer
		} catch (Exception e) {
			return Optional.empty();  // Se não conseguir, retorna um Optional.empty
		}
    	
    }

    // Método utilizando o Optional com tipo primitivo - conceito utilizado à partir do Java 8
    public static OptionalInt converteEmNumeroOptionalPrimitivo(String numeroStr) {
        try {
        	return OptionalInt.of(Integer.parseInt(numeroStr));  // Tenta converter o valor para Integer
		} catch (Exception e) {
			return OptionalInt.empty();  // Se não conseguir, retorna um Optional.empty
		}
    	
    }

}