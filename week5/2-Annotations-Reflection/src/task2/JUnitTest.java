package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import task2.Before.Priority;

public class JUnitTest {

    @Before(priority = Priority.MEDIUM)
    public void funcBefore2() {
        System.out.println("the second before function");
    }

    @Before(priority = Priority.HIGHT)
    public void funcBefore() {
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

    @After(priority = Priority.MEDIUM)
    public void funcAfter() {
        System.out.println("after function");
    }

    @After(priority = Priority.LOW)
    public void funcAfter2() {
        System.out.println("the second after function");
    }

    public static void extractAnnotations(JUnitTest test, List<Method> before, List<Method> execute, List<Method> after) {

        Method[] methods = test.getClass().getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Before.class))
                before.add(m);
            if (m.isAnnotationPresent(Execute.class))
                execute.add(m);
            if (m.isAnnotationPresent(After.class))
                after.add(m);
        }
    }

    public static List<Method> arrangeMethods(List<Method> before, List<Method> execute, List<Method> after)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        List<Method> listToInvokeMethods = new ArrayList<Method>();

        for (Method e : execute) {
            listToInvokeMethods.addAll(before);
            listToInvokeMethods.add(e);
            listToInvokeMethods.addAll(after);
        }
        return listToInvokeMethods;
    }

    public static void start(JUnitTest test, List<Method> list) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        for (Method m : list) {
            m.invoke(test);
        }
    }

    private static void sortBeforeMethods(List<Method> beforeList) {
        Comparator<Method> beforeComp = new Comparator<Method>() {

            @Override
            public int compare(Method o1, Method o2) {
                if (o1.getAnnotation(Before.class) != null) {
                    Before left = (Before) o1.getAnnotation(Before.class);
                    Before right = (Before) o2.getAnnotation(Before.class);
                    return right.priority().compareTo(left.priority());
                }
                return 0;
            }
        };

        beforeList.sort(beforeComp);
    }

    public static void sortAfterMethods(List<Method> afterList) {
        Comparator<Method> afterComp = new Comparator<Method>() {

            @Override
            public int compare(Method o1, Method o2) {
                if (o1.getAnnotation(After.class) != null) {
                    After left = (After) o1.getAnnotation(After.class);
                    After right = (After) o2.getAnnotation(After.class);
                    return right.priority().compareTo(left.priority());
                }
                return 0;
            }
        };
        afterList.sort(afterComp);
    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {

        JUnitTest test = new JUnitTest();

        List<Method> before = new ArrayList<Method>();
        List<Method> execute = new ArrayList<Method>();
        List<Method> after = new ArrayList<Method>();

        extractAnnotations(test, before, execute, after);

        sortBeforeMethods(before);
        sortAfterMethods(after);

        List<Method> listToInvokeMethods = arrangeMethods(before, execute, after);
        start(test, listToInvokeMethods);

    }
}
