package TAD.testes;
import java.util.ArrayList;

import TAD.trees.AVL;
import TAD.trees.AVLLinked;

public class TestaAVL
{
    public static void main(String args[])
    {
        AVL<String> avl = new AVL<String>();
        String n1 = new String("M");
        String n2 = new String("O");
        String n3 = new String("C");
        String n4 = new String("P");
        String n5 = new String("D");
        String n6 = new String("A");
        String n7 = new String("N");
        String n8 = new String("L"); 
        String n9 = new String("X");
        String n10 = new String("Y");
        String n11 = new String("Z");
        avl.insere(n1);
        avl.insere(n2);
        avl.insere(n3);
        avl.mostraCentralTeste();
        System.out.println("\n");
        avl.insere(n4);
        avl.mostraCentralTeste();
        System.out.println("\n");
        avl.insere(n5);
        avl.insere(n6);
        avl.insere(n7);
        avl.insere(n8);
        avl.insere(n9);
        avl.mostraCentralTeste();
        System.out.println("\n");
        avl.insere(n10);
        avl.mostraCentralTeste();
        System.out.println("\n");
        avl.insere(n11);
        avl.mostraCentralTeste();
        System.out.println("\n\n\n");
        
        System.out.println("Altura inicial = "+ avl.altura());        
        //System.out.println("Raiz =" + abp.getRaiz());
        //avl.mostraCentralTeste();
        if (avl.ehBalanceada())
            System.out.println("Eh balanceada");
        else
            System.out.println("Nao eh balanceada");
        avl.exclui(n11);
        System.out.println("Após exclusão de "+ n11 + ": ");
        avl.mostraCentralTeste();        
        System.out.println("Altura final = "+ avl.altura());
        
        System.out.println("Pai de " + n4 + " é " + avl.pesquisaPai(n4));
        System.out.println("Pai de " + n9 + " é " + avl.pesquisaPai(n9));
        
        System.out.println("Nivel de " + n8 + " é " + avl.nivel(n8));
        System.out.println("Nivel de " + n3 + " é " + avl.nivel(n3));
        
        System.out.println(n2 + " é folha?" + avl.ehFolha(n2));
        System.out.println(n10 + " é folha?" + avl.ehFolha(n10));
        System.out.println(n2 + " é interno?" + avl.ehInterno(n2));
        System.out.println(n10 + " é interno?" + avl.ehInterno(n10));        
 
        //////////////////////////////
        System.out.println("\n\n----- NOVA AVL -----\n\n");
        AVLLinked<String> avll = new AVLLinked<String>();
        String s1 = new String("M");
        String s2 = new String("O");
        String s3 = new String("C");
        String s4 = new String("P");
        String s5 = new String("D");
        String s6 = new String("A");
        String s7 = new String("N");
        String s8 = new String("L"); 
        String s9 = new String("X");
        String s10 = new String("Y");
        String s11 = new String("Z");
        avll.addRec(s1);
        avll.addRec(s2);
        avll.addRec(s3);
        System.out.println(avll.strTraversalCentralComplete() + "\n");
        avll.addRec(s4);
        System.out.println(avll.strTraversalCentralComplete() + "\n");
        avll.addRec(s5);
        avll.addRec(s6);
        avll.addRec(s7);
        avll.addRec(s8);
        avll.addRec(s9);
        System.out.println(avll.strTraversalCentralComplete() + "\n");
        avll.addRec(s10);
        System.out.println(avll.strTraversalCentralComplete() + "\n");
        avll.addRec(s11);
        System.out.println(avll.strTraversalCentralComplete() + "\n\n\n");
        
        System.out.println("Altura inicial = "+ avll.height());        
        
        if (avll.isBalanced())
            System.out.println("Eh balanceada");
        else
            System.out.println("Nao eh balanceada");
        avll.remove(s11);
        System.out.println("Após exclusão de " + s11 + ": ");
        System.out.println(avll.strTraversalCentral() + "\n");        
        System.out.println("Altura final = "+ avll.height());
        
        System.out.println("Pai de " + s4 + " é " + avll.getFather(s4));
        System.out.println("Pai de " + s9 + " é " + avll.getFather(s9));
        
        System.out.println("Nivel de " + s8 + " é " + avll.level(s8));
        System.out.println("Nivel de " + s3 + " é " + avll.level(s3));
        
        System.out.println(s2 + " é folha?" + avll.isLeave(s2));
        System.out.println(s10 + " é folha?" + avll.isLeave(s10));
        System.out.println(s2 + " é interno?" + avll.isBranch(s2));
        System.out.println(s10 + " é interno?" + avll.isBranch(s10)); 
        
        avll.removeBranch(s1);
        System.out.println(avll.strTraversalCentralComplete() + "\n");
        
        ////////////////////////////
        System.out.println("\n\n ==OUTRO TESTE NOVA AVL== \n");
        AVLLinked<Integer> arv = new AVLLinked<Integer>();

        arv.addRec(8);
        System.out.println(arv.strTraversalPre()+"\n\n ==novo modelo== \n");

        arv.addRec(2);
        System.out.println(arv.strTraversalPre()+"\n\n ==novo modelo== \n");

        arv.addRec(9);
        System.out.println(arv.strTraversalPre()+"\n\n ==novo modelo== \n");

        arv.addRec(5);
        System.out.println(arv.strTraversalPre()+"\n\n ==novo modelo== \n");

        arv.addRec(1);
        System.out.println(arv.strTraversalPre()+"\n\n ==novo modelo== \n");

        arv.addRec(6);
        System.out.println(arv.strTraversalPre()+"\n\n ==novo modelo== \n");  
        
        
        ArrayList<Integer> a = arv.getElements();
        for (Integer i : a)
        	System.out.println(i+"\n");
    }    
}
