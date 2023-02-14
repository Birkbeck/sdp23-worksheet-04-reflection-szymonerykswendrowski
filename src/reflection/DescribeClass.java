package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length  > 0) {
            System.out.println("Usage: "); // TODO: describe how to use the utility

            // Read the name of the class
            Class<?> aClass = Class.forName(args[0]);
            System.out.println("The name of the class is " + aClass.getName());

            // Read the interfaces implemented by the class
            Class<?>[] interfaces = aClass.getInterfaces();
            System.out.println("The interfaces implemented by " + aClass.getName() + " are: " + Arrays.toString(interfaces));

            // Read the super class of the class
            Class<?> superClass = aClass.getSuperclass();
            System.out.println("The super class of " + aClass.getName() + " is " + superClass.getName());

            // Read the methods of the class
            Method[] methods = aClass.getMethods();
            System.out.println("The methods of " + aClass.getName() + " are: " + Arrays.toString(methods));

            // Read the modifiers of the methods of the class
            Arrays.stream(methods).map(method -> "The modifiers of method " + method.getName() + " are: " + Modifier.toString(method.getModifiers())).forEach(System.out::println);

            // Read the constructors of the class
            Constructor<?>[] constructors = aClass.getConstructors();
            System.out.println("The constructors of the class are: " + Arrays.toString(constructors));

            // Read the fields of the class
            Class<?>[] fields = aClass.getClasses();
            System.out.println("The fields of " + aClass.getName() + " are: " + Arrays.toString(fields));

        }
    }
}
