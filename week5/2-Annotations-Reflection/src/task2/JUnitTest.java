package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import task2.Before.Priority;

public class JUnitTest {
    
    @Before (priority = Priority.MEDIUM)
    public void funcBefore2() {
        System.out.println("the second before function");
    }
    
    @Before(priority = Priority.HIGHT)
    public void funcBefore () {
        System.out.println("before function");
    }
    
    @Execute()
    public static void funcExecute() {
        System.out.println("executing function");
    }
    
    @Execute()
    public static void funcExecute2() {
        System.out.println("executing function");
    }

    @After( priority = Priority.MEDIUM) 
    public void funcAfter() {
        System.out.println("after function");
    }
    
    @After( priority = Priority.LOW) 
    public void funcAfter2() {
        System.out.println("the second after function");
    }
    
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        JUnitTest test = new JUnitTest();
        
        Method[] methods = test.getClass().getDeclaredMethods();
        
        List< Method> before = new ArrayList<Method>();
        List< Method> execute = new ArrayList<Method>();
        List< Method> after = new ArrayList<Method>();
        
        for ( Method m : methods) {
            if (m.isAnnotationPresent(Before.class))
                before.add(m);
            if (m.isAnnotationPresent(Execute.class))
                execute.add(m);
            if (m.isAnnotationPresent(After.class))
                after.add(m);
          }
        
     Comparator<Method> c = new Comparator<Method>() {

        @Override
        public int compare(Method o1, Method o2) {
            if(o1.getAnnotation(Before.class) != null) {    
                Before left = (Before) o1.getAnnotation(Before.class);
                Before right = (Before) o2.getAnnotation(Before.class);
                 return right.priority().compareTo(left.priority());

            } else if (o1.getAnnotation(After.class) != null) {
                After left = (After) o1.getAnnotation(After.class);
                After right = (After) o2.getAnnotation(After.class);
                return right.priority().compareTo(left.priority());
            }
            return 0;
        }
    };   
        
     before.sort(c);
     after.sort(c);
     
     List <Method> doIt = new ArrayList<Method>();
     for ( Method e : execute) {
         doIt.addAll(before);
         doIt.add(e);
         doIt.addAll(after);
     }
     
     for ( Method d: doIt) {
         d.invoke(test);
     }
    }
}
        
        
        
