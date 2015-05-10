package task1;

import java.lang.annotation.Annotation;

@ClassInfo (
     author = "Stella Gavrailova",
     related = { Student.class }
     )

public class Person {
     private String name;
     private int age;
     
     Person(String name,int age) {
         this.name = name;
         this.age = age;
     }
     
     public String getName() {
         return name;
     }
     
     public int getAge() {
         return age;
     }
     
     public void setName(String name) {
         this.name = name;
     }
     
     public void setAge (int age) {
         this.age = age;
     }
     
     
     public static void main(String[] args) {
        Person p = new Person ("Jenifer Lopez",20);
        Annotation[] annotations = p.getClass().getAnnotations();
        
        System.out.println("Annotations:" + annotations.length);
        for ( Annotation a : annotations) {
            System.out.println(a);
        }
        
        Person p2 = new Person ("alalal", 12);
        ClassInfo ann = p2.getClass().getAnnotation(ClassInfo.class);
        System.out.println(ann);
    }
}
