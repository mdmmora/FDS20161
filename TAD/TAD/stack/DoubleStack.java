package TAD.stack;


/**
 * Write a description of class DoubleStack here.
 * 
 * @author Márcia Cristina Moraes
 * @version 16/05/2009
 */
import java.util.*;
public class DoubleStack<E> implements DoubleStackTAD<E>
{
    private E[] data;
    private int count1, count2;
    private int pos1, pos2;
    private int capacity;

    public DoubleStack(int capacity){
        if (capacity>0)
            this.capacity = capacity;
        else
            this.capacity = 10;
        data = (E[]) new Object[this.capacity];
        count1 = 0;
        count2 = 0;
        pos1 = 0;
        pos2 = capacity - 1;
    }
    
    public void pushStack1(E element){
        if( (count1 + count2) == capacity)
           throw new FullStackException("Pilha cheia!!");
        else {
               data[pos1] = element;
               pos1++;
               count1++;
            }
    }
        
    public void pushStack2(E element){
        if( (count1 + count2) == capacity)
           throw new FullStackException("Pilha Cheia!!");
        else {
               data[pos2] = element;
               pos2--;
               count2++;
            }
    }
    
    public E popStack1(){
        if(count1 == 0)
          throw new EmptyStackException();
        else{
              E element = data[pos1-1];
              pos1--;
              count1--;
              return element;
            }
    }
   
    public E popStack2(){
        if(count2 == 0)
          throw new EmptyStackException();
        else{
              E element = data[pos2+1];
              pos2++;
              count2--;
              return element;
            }
    }
    
    public int sizeStack1(){
        return count1;
    }
    
    public int sizeStack2(){
        return count2;
    }

}

