package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Reduce_Java8 {
	
    public static void main(String[] args) {
    	
    	List<Integer> list = Arrays.asList(-2,1,2,3,4,5,6);  // Coloquei -2 só pra ver o menor valor
    	
    	//  *** Reduce - Soma ***  \\
    	// No exemplo abaixo, é realizada a soma dos elementos da seguinte forma:
    	// O reduce posiciona o primeiro e segundo elemento na primeira e segunda posição, 
    	// soma dos dois e o resultado passa a ficar na primeira posição e o terceiro
    	// elemento vai para a segunda posição, soma os dois e o resultado para a ser a 
    	// primeira posição e o quarto elemento vai para a segunda posição e assim sucessivamente...
    	Optional<Integer> soma = list.stream()
    			.reduce((n1, n2) -> n1 + n2);
    	
    	System.out.println("Soma: " + soma.get());

    	
    	//  *** Reduce - Multiplica ***  \\
    	// Segue o mesmo raciocínio da soma, só que multiplicando
    	Optional<Integer> multiplica = list.stream()
    			.reduce((n1, n2) -> n1 * n2);
    	
    	System.out.println("Multiplicação: " + multiplica.get());
    	
    	
    	//  *** Concatenando palavras de um array *** \\
    	String frase = "Concatenação de uma frase com reduce";
    	String[] split = frase.split(" ");  // Separando as palavras da frase e compondo um array
    	List<String> listStr = Arrays.asList(split);  // Preenchendo o array com as palavras separadas

    	// Segue o mesmo raciocínio da soma, só que concatenando
    	Optional<String> concatenacao = listStr.stream()
    			.reduce((s1, s2) -> s1.concat(" ".concat(s2)));
    	
    	System.out.println("Concatenação: " + concatenacao.get());

    	
    	//  *** Reduce - Menor valor ***  \\
    	// Segue o mesmo raciocínio da soma, só que identificando o menor valor
    	Optional<Integer> menorValor = list.stream()
    			.reduce((d1, d2) -> Math.min(d1, d2));
    	
    	System.out.println("Menor Valor: " + menorValor.get());


    	//  *** Reduce - Menor valor com Double***  \\
    	// Segue o mesmo raciocínio da soma, só que identificando o menor valor
    	OptionalDouble menorValorDouble = DoubleStream.of(1.5, 2.9, 6.7)
    			.reduce((d1, d2) -> Math.min(d1, d2));
    	
    	System.out.println("Menor Valor com Double: " + menorValorDouble);

    	
    	// OBS.: O Reduce só funciona com funções associativas, isto é, funções em que 
    	// a ordem dos fatores não vai alterar o seu resultado final (soma, multiplicação, concatenação, etc).
    	// Ele não funciona com funções como a subtração, por exemplo.
    	
    	

    	//  *** Reduce com valor de identidade ***  \\
    	//  É quando passo como valor inicial na posição 1 um valor que calculado
    	//  com o valor da posição 2 o resultado é o próprio valor da posição 2
    	//  OBS.: Neste caso, o retorno não é Optional, pois ele serve para quando
    	//  você precisa ter um valor sendo retornado quando a lista estiver vazia
    	//  *** Soma ***  \\
    	Integer somaComIdent = list.stream()
    			.reduce(0, (n1, n2) -> n1 + n2);  // 0 + 1 = 1 e se a lista estiver vazia retorna 0
    	
    	System.out.println("Soma com Identificação: " + somaComIdent);

    	
    	//  *** Multiplicação ***  \\
    	Integer multiplicaComIdent = list.stream()
    			.reduce(1, (n1, n2) -> n1 * n2); // 1 * 1 = 1 e se a lista estiver vazia retorna 1
    	
    	System.out.println("Multiplicação com Identificação: " + multiplicaComIdent);
    	
    	
    	//  *** Concatenação *** \\
    	String concatenacaoComIdent = listStr.stream()
    			.reduce("", (s1, s2) -> s1.concat(" ".concat(s2))); // String vazia concatenada com um valor é o próprio valor
    	
    	System.out.println("Concatenação com Identificação: " + concatenacaoComIdent);
        
    	
    	//  *** Menor valor ***  \\
    	Integer menorValorComIdent = list.stream()
    			.reduce(0, (d1, d2) -> Math.min(d1, d2)); // O menor valor é zero e permanece se a lista estiver vazia
    	
    	System.out.println("Menor Valor com Identificação: " + menorValorComIdent);

    	
    	//  *** Menor valor com Double***  \\
    	double menorValorDoubleComIdent = DoubleStream.of(1.5, 2.9, 6.7)
    			.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2)); // O menor valor é zero e permanece se a lista estiver vazia
    	
    	System.out.println("Menor Valor Double com Identificação: " + menorValorDoubleComIdent);

    	
    	
    	//  *** Reduce com combinação ***  \\
    	//  É quando os valores são combinados por meio do grupo de acumulação e de combinação 
    	//  *** Soma ***  \\
    	Integer somaCombinacao = list.stream()
    			.reduce(0,                     // Definindo a identidade
    					(n1, n2) -> n1 + n2,   // Função de acumulação
    					(n1, n2) -> n1 + n2);  // Função de combinação
    	
    	System.out.println("Soma com Combinação: " + somaCombinacao);


    	//  *** Concatenação - utiliza de map + combiner ***  \\
    	Optional<String> concatenaCombinacao = list.stream()
    			.map(n1 -> n1.toString())            // Convertendo cada elemento em String
    			.reduce((n1, n2) -> n1.concat(n2));  // Concatenando as strings
    	
    	System.out.println("Concatenação com Combinação: " + concatenaCombinacao);

    	
    	//  *** Concatenação - com identificação ***  \\
    	String concatenaCombinacaoIdent = list.stream()
    			.reduce("",                                               // Definindo a identidade
    					(n1, n2) -> n1.toString().concat(n2.toString()),  // Função de acumulação convertendo para String
    					(n1, n2) -> n1.concat(n2));                       // Função de combinação concatenando as strings
    	
    	System.out.println("Concatenação com Combinação e Identificação: " + concatenaCombinacaoIdent);

    }
    
}