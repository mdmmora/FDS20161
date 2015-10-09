package OldTrees;

import java.util.*;
import java.io.Serializable;


public class ABPArvBinBased<Dado extends Comparable<Dado>> implements BinaryTreeABPTAD<Dado>, Serializable {
	private BinaryTreeTAD<Dado> arv = new BinaryTreeLinked<Dado>();
	
	public void addABP(Dado d)
	{
		Dado res = null, prox;
		String lado;
		
		if (arv.isEmpty())
			arv.add(d, null, "E");
		else 
		{
			res = arv.getRoot();
			
			do
			{
				res = arv.get();
				if (d.compareTo(res) < 0)
				{
					prox = arv.getLeft();
					lado = "E";
				}
				else
				{
					prox = arv.getRight();
					lado = "D";
				}
			}
			while (prox != null);

			arv.add(d, res, lado);
		}			
	}

	public Dado searchABP(Dado d)
	{
		Dado res = null;
		
		return res;
	}
	
	public int getQtde() {
		return arv.size();
	}

	public int count() {
		return arv.count();
	}

	public int countLeaves() {
		return arv.countLeaves();
	}

	public Dado get() {
		return arv.get();
	}

	public Dado getRight() {
		return arv.getRight();
	}

	public Dado getLeft() {
		return arv.getLeft();
	}

	public Dado getRoot() {
		return arv.getRoot();
	}

	public Dado getFather() {
		return arv.getFather();
	}

	public ArrayList<Dado> traversalCentral() {
		return (ArrayList<Dado>) arv.traversalCentral();
	}

	public ArrayList<Dado> traversalPos() {
		return (ArrayList<Dado>)arv.traversalPos();
	}

	public ArrayList<Dado> traversalPre() {
		return (ArrayList<Dado>)arv.traversalPre();
	}

	public ArrayList<Dado> traversalWidth() {
		return (ArrayList<Dado>)arv.traversalWidth();
	}
	
	public String strTraversalPre() {
		return arv.strTraversalPre();
	}
	
	public String strTraversalPos() {
		return arv.strTraversalPos();
	}
	
	public String strTraversalCentral() {
		return arv.strTraversalCentral();
	}


}

