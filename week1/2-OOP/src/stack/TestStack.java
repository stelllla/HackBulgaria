package stack;

import java.io.IOException;

public class TestStack {

    public static void main(String[] args) throws IOException {
        
        MyStackImpl st = new MyStackImpl(5);
        
        int deletedElement = 0;
        st.pop(deletedElement);
        System.out.println(st);
        
        st.push(10);
        System.out.println(st);
        
        
    }
}
