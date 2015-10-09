package TAD.testes;


/**
 * Write a description of class TesteDoubleStack here.
 * 
 * @author Márcia Cristina Moraes 
 * @version 16/05/2009
 */
import java.util.*;

import TAD.stack.DoubleStack;
import TAD.stack.FullStackException;
public class TesteDoubleStack
{
    public static void main(String args[]){
        
        Console cons = new Console();
        
        DoubleStack<String> pilha = new DoubleStack(6);
        
        try{
            
            cons.println("Digite uma palavra para adicionar na pilha 1 (fim para finalizar a entrada de dados):");
            String leitura = cons.readLine();
            while(!leitura.equals("fim")){
                pilha.pushStack1(leitura);
                cons.println("Digite uma palavra para  adicionar na pilha 1 (fim para finalizar a entrada de dados):");
                leitura = cons.readLine();
            }
            
            cons.println("Digite uma palavra para adicionar na pilha 2 (fim para finalizar a entrada de dados):");
            leitura = cons.readLine();
            while(!leitura.equals("fim")){
                pilha.pushStack2(leitura);
                cons.println("Digite uma palavra para  adicionar na pilha 2 (fim para finalizar a entrada de dados):");
                leitura = cons.readLine();
            }
            
        }catch(FullStackException e1){
             System.out.println(e1.getMessage());
        }
        
        try{
            System.out.println("Elementos da pilha 1");
            int tamanho = pilha.sizeStack1();
            for(int i = 0; i < tamanho; i++)
                System.out.println(pilha.popStack1());
            
            System.out.println("Elementos da pilha 2");
            tamanho = pilha.sizeStack2();
            for(int i = 0; i < tamanho; i++)
                System.out.println(pilha.popStack2());
            }catch(EmptyStackException e2){
                System.out.println("Pilha vazia!");
            }
        }
             
}
