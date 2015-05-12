package problem0;

import java.util.Stack;


public class BracketsCheck {
    
    public boolean isCorrect (String expr) {
        
        if ( expr.charAt(0) != '(' || expr.charAt(expr.length() - 1) != ')') {
            return false;
        }
        
        Stack<Character> st = new Stack<>();
        int i = 0;
        while ( i != expr.length()) {
            char elem = expr.charAt(i);
            
            if ( elem == '(') {
                st.push(elem);
            }
            
            if ( elem == ')') {
                if ( st.size() > 0){
                    char x = st.pop();
                    if ( x != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            
            i++;
        }
        return true;
    }

}
