package stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyStackImpl implements MyStack {
    
    private ArrayList<Integer> array = new ArrayList<Integer> ();
    private int size;
    
    public MyStackImpl(int size) throws IOException {
        
        this.size = size;
        Scanner sc = new Scanner(System.in);
        for ( int i = 0; i < size; i++) {
            System.out.println("Element " + i + "=");
            int elem = sc.nextInt();
            if ( array.contains(elem)){
                continue;
            }
            else {
                array.add(elem);
            }
            
        }
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for ( int i = 0;i < size; i++) {
            str.append(array.get(i)).append(" ");
        }
        return "array:" + str + " size: " + size;
    }

    public void push ( int elem ) {
        array.add(elem);
        size ++;
    }
    
    public void pop (int elem) {
        if ( size >= 1) {
            elem = array.get(size - 1);
            array.remove(size-1);
            size--;
        }
        else {
            System.out.println("There are no elements");
        }
        
    }
    
    public void smartPush (int elem) {
        if ( array.contains(elem)) {
            System.out.println(" The element already exist!");
            return;
        }
        else {
            push (elem);
        }
    }
    
    public int length() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int peek() {
        return array.get(0);
    }
    
    

}
