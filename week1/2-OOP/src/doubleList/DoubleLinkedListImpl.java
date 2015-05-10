package doubleList;

import java.util.ArrayList;
import java.util.Scanner;


public class DoubleLinkedListImpl implements DoubleLinkedList {
    
    private class Node {
        private int data;
        Node next;
        Node prev;
        
        Node (int data){
            this.data = data;
        }
    }
    
    ArrayList<Node> array = new ArrayList<>();
    int indexHead,indexTail;
    
    public DoubleLinkedListImpl(int n) {
        
        Scanner sc = new Scanner(System.in);
        
        for ( int i = 0; i < n; i++) {
            System.out.println("elem[" + i + "]=");
            int data = sc.nextInt();
            this.addElem(data);
        }
       
        this.indexHead = 0;
        this.indexTail = array.size()-1;
    }

    @Override
    public void addElem(int elem) {
        Node newNode = new Node (elem);
        array.add(newNode);
        newNode.next = null;
        if (array.size() == 1) {
            newNode.prev = null;
        }
        else {
            newNode.prev = array.get(indexTail);
        }
        indexTail++;
        
    }

    @Override
    public void remove(int elem) {
        
        if( array.size() >= 1) {
         elem = array.get(indexHead).data;
         array.remove(indexHead);
         indexHead++;
        }
        else {
            System.out.println("The DoubleLinkedList is empty!");
        }
    
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public int get(int elementIndex) {
        return array.get(elementIndex).data;
    }

    @Override
    public int getHead() {
        return array.get(indexHead).data;
    }

    @Override
    public int getTail() {
        return array.get(indexTail).data;
    }
    
    @Override 
    public String toString() {
        StringBuilder str = new StringBuilder();
        for ( int i = 0;i < array.size(); i++) {
            str.append(array.get(i)).append(" ");
        }
        return "List:" + str + " size: " + array.size();
    }
    
}
