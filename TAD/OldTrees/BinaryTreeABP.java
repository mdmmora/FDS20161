package OldTrees;
import java.util.*;
import java.io.Serializable;

public class BinaryTreeABP<Dado extends Comparable<Dado>> implements BinaryTreeTADABPBasic<Dado>, Serializable{
	
		class Nodo  implements Serializable {
			private Nodo pai = null;
			private Nodo esq = null;
			private Nodo dir = null;
			private Dado elem = null;
			
			public Nodo getDir() {
				return dir;
			}
			public void setDir(Nodo dir) {
				this.dir = dir;
			}
			public Nodo getEsq() {
				return esq;
			}
			public void setEsq(Nodo esq) {
				this.esq = esq;
			}
			public Nodo getPai() {
				return pai;
			}
			public void setPai(Nodo pai) {
				this.pai = pai;
			}
			public Dado getElem() {
				return elem;
			}
			public void setElem(Dado valor) {
				this.elem = valor;
			}		
		}

		private int qtde = 0;
		private Nodo refRaiz = null;
		private Nodo corrente = null;

		public BinaryTreeABP() {}
		
		public BinaryTreeABP(Dado [] vet)
		{
			for (Dado aux:vet)
				addABP(aux);
		}

		public void addABP(Dado d)
		{
			Nodo novo; 
			
			if (refRaiz == null)
			{
				novo = new Nodo();
				novo.setElem(d);
				novo.setPai(null);
				novo.setEsq(null);
				novo.setDir(null);
				
				refRaiz = novo;
				corrente = novo;
				
				qtde ++;
			}
			else 
				addABPAux(d, refRaiz);
		}
		
		private void addABPAux(Dado d, Nodo n)
		{
			Nodo novo;
			
			if (n != null)
			{
				if (d.compareTo(n.getElem()) < 0)
					if (n.getEsq() != null)
						addABPAux(d, n.getEsq());
					else
					{
						novo = new Nodo();
						novo.setElem(d);
						novo.setPai(n);
						novo.setEsq(null);
						novo.setDir(null);
						
						n.setEsq(novo);
						corrente = novo;
						qtde++;
					}
				else 
				{
					if (n.getDir() != null)
							addABPAux(d, n.getDir());
					else
					{
						novo = new Nodo();
						novo.setElem(d);
						novo.setPai(n);
						novo.setEsq(null);
						novo.setDir(null);
						
						n.setDir(novo);
						corrente = novo;
						qtde++;
					}
				}
			}

		}

		public Dado searchABP(Dado d)
		{
			Nodo nAux;
			Dado res = null;
			
			nAux = searchNodoValueABP(d, refRaiz);
			
			if (nAux != null)
				res = nAux.getElem();
			
			return res;
		}
		
		private Nodo searchNodoValueABP(Dado d, Nodo n)
		{
			Nodo res = null;
			
			if (n != null)
			   if (d.compareTo(n.getElem()) == 0)
				   res = n;
			   else if (d.compareTo(n.getElem()) < 0)
				   		res = searchNodoValueABP(d, n.getEsq());
			   else res = searchNodoValueABP(d, n.getDir());
			
			corrente = res;
			return res;
		}

		public Vector<Dado> traversalCentral()
		{
			Vector<Dado> res = new Vector<Dado>();
			
			traversalCentralAux(refRaiz, res);
			
			return res;
		}
			
		private void traversalCentralAux(Nodo n, Vector<Dado> res)
		{
			if (n != null)
			{
				traversalCentralAux(n.getEsq(), res);
				res.add(n.getElem());
				traversalCentralAux(n.getDir(), res);
			} 

		}
		

}

