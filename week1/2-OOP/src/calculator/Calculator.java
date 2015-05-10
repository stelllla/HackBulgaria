package calculator;

import java.util.Stack;


public class Calculator {
    
    public boolean isOperator (char elem) {
        if ( elem == '+' || elem == '-' || elem == '/' || elem == '*') {
            return true;
        }
        else {
            return false;
        }
    }
    public int getWeight (char c) {
        int p;
        switch (c) {
            case'+' :
            case'-' : p = 0; break;
            case'*' :
            case'/' : p = 1;break;
            default : p=-1;
        }
        return p;
    }
    
    public String convertToPolish (String expr) {
        
        Stack<Character> help = new Stack<Character>();
        StringBuilder polishExpr = new StringBuilder();
        
        int i = 0;
        while ( i != expr.length()) {
            char elem = expr.charAt(i);
            
            if ( elem >= '0' && elem <= '9') {
                polishExpr.append(elem);
            }
            
            if ( elem == '(') {
                help.push(elem);
            }
            
            if ( elem == ')') {
                while ( help.peek() == '(') {
                    char op =help.pop();
                    polishExpr.append(op);
                }
            }
            
            if( isOperator(elem)) {
                if (!help.isEmpty()) {
                    if ( getWeight(help.peek()) <= getWeight(elem) ) {
                        help.push(elem);
                }
                else {
                    char ch = help.pop();
                    polishExpr.append(ch);
                    help.push(elem);
                }
            } else {
                help.push(elem);
            }
            
        }
            
        i++;
        
        }
        while ( !help.isEmpty()) {
            char op = help.pop();
            if ( op != '(') {
                polishExpr.append(op);
            }
            
        }
        
        return polishExpr.toString();
        
    }
    
    public Double calculatePolishExpr (String polish) {
        
        Stack<Double> result = new Stack<Double>();
        
        int i = 0;
        while ( i != polish.length()) {
            char elem = polish.charAt(i);
            
            if ( elem >= '0' && elem <='9') {
                double doubleElem = (double) (elem - '0');
                result.push(doubleElem);
            }
            
            if (isOperator(elem)) {
                double op1 = result.pop();
                double op2 = result.pop();
                
                switch (elem) {
                    case '+' :{
                        double res = op1 + op2;
                        result.push(res);
                        break;
                    }
                        
                    case '-' :{
                        double res = op2 - op1;
                        result.push(res);
                        break;
                    }
                    case '*' :
                    {
                        double res = op1 * op2;
                        result.push(res);
                        break;
                    }
                    case '/' :{
                        double res = op2 / op1;
                        result.push(res);
                        break;
                    }
                }
               
            }
            
            i++;
        }
        return result.pop();
    }
    
    public Double calculate(String expr) {
        
        String polish = convertToPolish(expr);
      
        Double result = calculatePolishExpr(polish);
        
        return result;
        
    }

}
   