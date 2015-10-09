package TAD.testes;
import java.util.ArrayList;

import TAD.trees.BinaryTreeLinked;
import TAD.trees.NodePosition;


public class TestaArvoreBinaria
{
    public static void main(String args[])
    {
        BinaryTreeLinked<String> arv = new BinaryTreeLinked<String>();
        String n1 = "+";
        String n2 = "*";
        String n3 = "/";
        String n4 = new String("-");
        String n5 = "A";
        String n6 = "B";
        String n7 = "C";
        String n8 = "D";        
        String n9 = "E";
        arv.add(n1,null, null);
        arv.add(n2, n1, NodePosition.LEFT);
        arv.add(n3, n1, NodePosition.RIGHT);
        arv.add(n5, n2, NodePosition.LEFT);
        arv.add(n6, n2, NodePosition.RIGHT);
        arv.add(n7, n3, NodePosition.LEFT);
        arv.add(n4, n3, NodePosition.RIGHT);
        arv.add(n8, n4, NodePosition.LEFT);
        arv.add(n9, n4, NodePosition.RIGHT);      
        
        System.out.println("Elementos em largura:");
        System.out.println(arv.strTraversalWidth());
        
        System.out.println("\nElementos Central Ordem:");
        System.out.println(arv.strTraversalWidth());
        
        System.out.println("\n- Pai de " + n1);
        System.out.println(arv.getFather(n1));
        System.out.println("\n- Pai de " + n6);
        System.out.println(arv.getFather(n6));        
        System.out.println("\n- Pai de " + n9);
        System.out.println(arv.getFather(n9));
        
        System.out.println("\n- Pre-fixado");
        System.out.println(arv.strTraversalPre());
        System.out.println("\n- Central");
        System.out.println(arv.strTraversalCentral());
        System.out.println("\n- Pós-fixado");
        System.out.println(arv.strTraversalPos());
        System.out.println("\n TOTAL DE NODOS:" + arv.size());
      
        System.out.println("Esquerda de " + n4 + " = " + arv.getLeft(n4));
        System.out.println("Direita de " + n2 + " = " + arv.getRight(n2));
        
        System.out.println("Altura inicial = " + arv.height());
        
        if (arv.isLeave(n2))
            System.out.println(n2 + " eh folha");
        else
            System.out.println(n2 + " não eh folha");    
        if (arv.isLeave(n9))
            System.out.println(n9 + " eh folha");
        else
            System.out.println(n9 + " não eh folha");             
            
        if (!arv.isLeave(n2))
            System.out.println(n2 + " eh interno");
        else
            System.out.println(n2 + " não eh interno");    
        if (!arv.isLeave(n9))
            System.out.println(n9 + " eh folha");
        else
            System.out.println(n9 + " não eh interno"); 
            
      }
}
