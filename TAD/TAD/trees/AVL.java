//package TAD.trees;
//
//import java.util.ArrayList;
//
///**
// * Implementação de uma árvore balanceada.
// * 
// * @author Isabel H. Manssour 
// * @version novembro/2007
// */
//
//public class AVL<E extends Comparable<E>>
//{
//    private NodoAVL<E> raiz;
//    
//    private class NodoAVL<T> {
//        private T element;
//        private int altura;
//        private int quantNodos;
//        private NodoAVL<T> esq;
//        private NodoAVL<T> dir;
//        private NodoAVL<T> pai;
//        public NodoAVL(T e) {
//            element = e;
//            altura = 0;
//            quantNodos = 1;
//            esq = null;
//            dir = null;
//            pai = null;
//        }
//        public void setElement(T e) {
//            element = e; 
//        }
//        public void setAltura(int a) {
//            altura = a; 
//        }    
//        public void setQuantNodos(int q) {
//            quantNodos = q; 
//        }           
//        public void setEsquerda (NodoAVL<T> n) { 
//            esq = n; 
//        }
//        public void setDireita (NodoAVL<T> n) { 
//            dir = n; 
//        }        
//        public void setPai (NodoAVL<T> n) { 
//            pai = n; 
//        }  
//        public T getElement() { 
//            return element; 
//        }
//        public int getAltura() { 
//            return altura; 
//        }        
//        public int getQuantNodos() { 
//            return quantNodos; 
//        }        
//        public NodoAVL<T> getEsquerda() { 
//            return esq; 
//        }
//        public NodoAVL<T> getDireita() { 
//            return dir; 
//        }
//        public NodoAVL<T> getPai() { 
//            return pai; 
//        }        
//    }
//    
//    public AVL()
//    {
//        raiz = null;
//    }
//
//    public boolean pesquisa(E e)
//    {
//        NodoAVL<E> aux = pesquisa(raiz,e);
//
//        if (aux == null)
//          return false;
//
//        return true;
//    }
//
//    private NodoAVL<E> pesquisa(NodoAVL<E> a, E e)
//    {
//        int r;
//
//        if (a == null || e==null)
//          return null;
//        
//        r = a.getElement().compareTo(e);
//        
//        if (r == 0)
//          return a;
//        else if (r > 0)
//            return pesquisa(a.getEsquerda(),e);
//        else
//            return pesquisa(a.getDireita(),e);
//    } 
//    
//    public int quantidadeNodos()
//    {
//        if (raiz == null)
//            return 0;
//        return raiz.getQuantNodos();
//    }
//    
//    public E menor()
//    {
//        NodoAVL<E> aux = menor(raiz);
//        if (aux == null)
//          return null;
//        return aux.getElement();        
//    }
//    
//    private NodoAVL<E> menor(NodoAVL<E> a)
//    {
//        if (a == null)
//          return null;
//        if (a.getEsquerda() == null)
//          return a;
//        return menor(a.getEsquerda());
//    }    
//
//    public E maior()
//    {
//        NodoAVL<E> aux = maior(raiz);
//        if (aux == null)
//          return null;
//        return aux.getElement();        
//    }
//    
//    private NodoAVL<E> maior(NodoAVL<E> a)
//    {
//        if (a == null)
//          return null;
//        if (a.getDireita() == null)
//          return a;
//        return maior(a.getDireita());
//    }       
//
//    public E getEsquerda(E e)
//    {
//        NodoAVL<E> aux = pesquisa(raiz,e); 
//        if (aux != null)
//        {
//            if (aux.getEsquerda() != null)
//                return aux.getEsquerda().getElement();
//        }
//        return null;        
//    }
//
//    public E getDireita(E e)
//    {
//        NodoAVL<E> aux = pesquisa(raiz,e); 
//        if (aux != null)
//        {
//            if (aux.getDireita() != null)
//                return aux.getDireita().getElement();
//        }
//        return null;
//    }    
//    
//    public E getRaiz()
//    {
//        if (raiz != null)
//            return raiz.getElement();
//        else    
//            return null;
//    }  
//    
//    public void mostraCentralOrdem() 
//    {
//        mostraCentralOrdem(raiz);
//    }
//    
//    private void mostraCentralOrdem (NodoAVL<E> n) 
//    {
//        if (n == null)
//            return;    
//        mostraCentralOrdem(n.getEsquerda());
//        System.out.println(n.getElement().toString());        
//        mostraCentralOrdem(n.getDireita());
//    }
//
//    public int altura () 
//    {
//        if (raiz == null)
//            return -1;
//        return raiz.getAltura();
//    }      
//    
//    private int fatorBalanceamento(NodoAVL<E> n)
//    {
//        int AE, AD;
//        
//        if (n == null)
//            return 0;
//        
//        AE = AD = -1;
//        
//        if (n.getEsquerda() != null)
//            AE = n.getEsquerda().getAltura();
//            
//        if (n.getDireita() != null)
//            AD = n.getDireita().getAltura();
//            
//        return (AE - AD);
//    }
//    
//    private void ajustaAltura(NodoAVL<E> n)
//    {
//        int AE, AD;
//
//        while (n != null) {
//            AE = AD = -1;
//            if (n.getEsquerda() != null)
//                 AE = n.getEsquerda().getAltura();
//            if (n.getDireita() != null) 
//                 AD = n.getDireita().getAltura();
//
//            if (AE > AD)
//                 n.setAltura(AE+1);
//            else 
//                 n.setAltura(AD+1);
//            n = n.getPai();
//        }
//    }
//   
//    private void ajustaQuantNodos(NodoAVL<E> n)
//    {
//        int QE, QD;
//
//        while (n != null) {
//            QE = QD = 0;
//            if (n.getEsquerda() != null)
//                 QE = n.getEsquerda().getQuantNodos();
//            if (n.getDireita() != null) 
//                 QD = n.getDireita().getQuantNodos();
//
//            n.setQuantNodos(QE+QD+1);
//            n = n.getPai();
//        }
//    }    
//    
//    public void balanceamento()
//    {
//        int fb;
//        fb = fatorBalanceamento(raiz);
//        if (fb > 1)
//           if (fatorBalanceamento(raiz.getEsquerda()) > 0)
//               rotacaoEE(raiz);
//           else
//               rotacaoED(raiz);
//        else if (fb < -1)
//           if (fatorBalanceamento(raiz.getDireita()) < 0)
//               rotacaoDD(raiz);
//           else 
//               rotacaoDE(raiz);
//    }
//    
//    private void rotacaoEE(NodoAVL<E> n)
//    {
//       NodoAVL<E> temp, pai = n.getPai();
//       temp = n.getEsquerda();
//       n.setEsquerda(temp.getDireita());
//       if (n.getEsquerda()!= null)
//           n.getEsquerda().setPai(n);
//       temp.setDireita(n);
//       n.setPai(temp);
//       n = temp;
//       n.setPai(pai);
//       if (pai == null)
//           raiz = n;
//       ajustaAltura(n.getDireita());
//       ajustaQuantNodos(n.getDireita());
//    }
//    
//    private void rotacaoDD(NodoAVL<E> n)
//    {
//       NodoAVL<E> temp, pai = n.getPai();
//       temp = n.getDireita();
//       n.setDireita(temp.getEsquerda());
//       if (n.getDireita()!= null)
//           n.getDireita().setPai(n);
//       temp.setEsquerda(n);
//       n.setPai(temp);
//       n = temp;
//       n.setPai(pai);
//       if (pai == null)
//           raiz = n;
//       ajustaAltura(n.getEsquerda());
//       ajustaQuantNodos(n.getEsquerda());
//    }  
//    
//    private void rotacaoED(NodoAVL<E> n) 
//    {
//        rotacaoDD(n.getEsquerda());
//        rotacaoEE(n);
//    }
//      
//    private void rotacaoDE(NodoAVL<E> n) 
//    {
//        rotacaoEE(n.getDireita());
//        rotacaoDD(n);   
//    }
//    
//    public boolean insere(E e) 
//    {
//        NodoAVL<E> auxD, auxP = null;
//
//        if (e == null)
//          return false;
//        auxD = new NodoAVL<E>(e);
//        if (raiz == null)
//        {
//            raiz = auxD;
//            return true;
//        }
//        auxP = insere(raiz,e);
//        if (auxP == null)
//          return false;
//        if (auxP.getElement().compareTo(e) > 0)
//          auxP.setEsquerda(auxD);
//        else
//          auxP.setDireita(auxD);
//        auxD.setPai(auxP);
//        
//        ajustaQuantNodos(auxP);
//        ajustaAltura(auxP);
//        balanceamento();
//        return true;
//    }
//    
//    private NodoAVL<E> insere(NodoAVL<E> a, E e)
//    {
//        int r;
//
//        if (a == null)
//          return null;
//        r = a.getElement().compareTo(e);
//        if (r == 0)
//          return null;
//        if (r > 0)
//        {
//            if (a.getEsquerda() == null)
//              return a;
//            return insere(a.getEsquerda(),e);
//        }
//        
//        if (a.getDireita() == null)
//          return a;
//        return insere(a.getDireita(),e);
//    }
//  
//    public boolean ehBalanceada()
//    {
//        return ehBalanceada(raiz);
//    }
//       
//    private boolean ehBalanceada(NodoAVL<E> n)
//    {
//        System.out.println("Fator balanceamento=" + fatorBalanceamento(n));
//        if (fatorBalanceamento(n)<=1 && fatorBalanceamento(n)>=-1)
//            return true;
//        else
//            return false;
//    }
//    
//    public boolean exclui(E e) 
//    {
//        NodoAVL<E> aux;
//        
//        if (e == null || raiz == null)
//            return false;     
//        aux = pesquisa(raiz, e);
//        if (aux == null)
//            return false;
//        exclui(aux);
//        balanceamento();       
//        return true;
//    }
//
//    private void exclui(NodoAVL<E> n) 
//    {
//		NodoAVL<E> auxP, m;
//		
//		auxP = n.getPai();
//		
//		if (n.getEsquerda() == null)
//		{
//		  if (n.getDireita() == null)
//		  {
//		      if(raiz == n)
//		      {
//		          raiz = null;
//		          return;
//			  }
//			  if (auxP.getEsquerda() == n)
//			     auxP.setEsquerda(null);
//			  else
//			     auxP.setDireita(null);
//				ajustaQuantNodos(auxP);
//				ajustaAltura(auxP);
//				return; 
//			}
//			m = menor(n.getDireita());
//			n.setElement(m.getElement());
//			exclui(m);
//			return;
//		}		 
//		m = maior(n.getEsquerda());
//		n.setElement(m.getElement());
//		exclui(m);
//    }
//    
//    public void mostraCentralTeste() 
//    {
//        mostraCentralTeste(raiz);
//    }
//    
//    private void mostraCentralTeste (NodoAVL<E> n) 
//    {
//        if (n == null)
//            return;    
//        mostraCentralTeste(n.getEsquerda());
//        System.out.println(n.getElement().toString() + ", altura " + n.getAltura() + ", quant. nodos " + n.getQuantNodos());        
//        mostraCentralTeste(n.getDireita());
//    }    
//    
//    ////////////////////
//    
//    // Verifica se um determinado elemento é a raiz da árvore
//    public boolean ehRaiz(E d)
//    {
//    	if (raiz!=null)
//    		if (raiz.getElement().equals(d))
//    			return true;
//        return false;
//    }
//    
//    // Método que retorna o elemento pai    
//    public E pesquisaPai(E e)
//    {
//        if (e == raiz.getElement())
//            return null;
//        NodoAVL<E> aux = pesquisa(raiz,e);
//        return aux.getPai().getElement();
//    }
//    
//    // Retorna o nivel do elemento na árvore
//    public int nivel(E e)
//    {
//        NodoAVL<E> aux = pesquisa(raiz,e);
//        if (aux == null)
//            return -1;    
//        NodoAVL<E> pai = aux.getPai();
//        if (pai == null)
//            return 0;
//        else
//            return 1 + nivel(pai.getElement());
//    } 
//    
//    // Verifica se um determinado elemento está num nodo folha
//    public boolean ehFolha(E e)
//    {
//        if (raiz == null)
//            return false;
//            
//        NodoAVL<E> aux = pesquisa(raiz,e);
//        if (aux == null)
//            return false;
//        else if (aux.getAltura()==0)
//            return true;
//        else
//            return false;
//    }    
//       
//    // Verifica se um determinado elemento está num nodo interno
//    public boolean ehInterno(E e)
//    {
//        if (raiz == null)
//            return false;
//            
//        NodoAVL<E> aux = pesquisa(raiz,e);
//        if (aux == null)
//            return false;
//        else if (aux.getEsquerda()!=null || aux.getDireita()!=null)
//            return true;
//        else
//            return false;
//    }    
// 
//    // QUESTÃO DE PROVA
//    // Método que retorna um ArrayList que contém todos os elementos
//    // armazenados na ABP em ordem crescente, e chama o método recursivo
//    // implementado mais abaixo.
//    public ArrayList<E> retornaElementosOrdenados()
//    {
//    	ArrayList<E> array = new ArrayList<E>();
//    	incluiElementosOrdenados(array,raiz);
//    	return array;
//    }
//    
//    private void incluiElementosOrdenados(ArrayList<E> array, NodoAVL<E> n)
//    {
//        if (n != null)
//        {
//        	incluiElementosOrdenados(array,n.getEsquerda());
//        	array.add(n.getElement());
//        	incluiElementosOrdenados(array,n.getDireita());
//        }
//        return;
//    }      
//    
//    public ArrayList<E> retornaElementosCompletosOrdenados()
//    {
//    	ArrayList<E> array = new ArrayList<E>();
//    	incluiElementosCompletosOrdenados(array,raiz);
//    	return array;
//    }
//    
//    private void incluiElementosCompletosOrdenados(ArrayList<ClasseAuxiliar> array, NodoAVL<E> n)
//    {
//        if (n != null)
//        {
//        	incluiElementosCompletosOrdenados(array,n.getEsquerda());
//        	ClasseAuxiliar<E> c = new ClasseAuxiliar<E>(n.getElement(), n.getAltura(), n.getQuantNodos());
//        	array.add(c);
//        	incluiElementosCompletosOrdenados(array,n.getDireita());
//        }
//        return;
//    }          
//}
