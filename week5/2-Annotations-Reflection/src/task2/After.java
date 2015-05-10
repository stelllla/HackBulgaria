package task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import task2.Before.Priority;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface After {
    Priority priority() default Priority.LOW;
}
