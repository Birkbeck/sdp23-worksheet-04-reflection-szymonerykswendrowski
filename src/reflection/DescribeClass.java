package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class DescribeClass {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length  > 0) {

            // Read the name of the class
            DescribeClass aClass = new DescribeClass(args[0]);
            System.out.println("The name of the class is " + aClass.getName());

            // Read the interfaces implemented by the class
            System.out.println("The interfaces implemented by " + aClass.getName() + " are: " + Arrays.toString(aClass.getInterfaces()));

            // Read the super class of the class
            System.out.println("The super class of " + aClass.getName() + " is " + aClass.getSuperClass());

            // Read the methods of the class
            System.out.println("The methods of " + aClass.getName() + " are: " + Arrays.toString(aClass.getMethods()));

            // Read the modifiers of the methods of the class
            aClass.methodModifiers(aClass.getMethods());

            // Read the constructors of the class
            System.out.println("The constructors of the class are: " + Arrays.toString(aClass.getConstructors()));

            // Read the fields of the class
            System.out.println("The fields of " + aClass.getName() + " are: " + Arrays.toString(aClass.getFields()));
        }
    }

    private Class<?> c;

    public DescribeClass(Class<?> c) {
        this.c = c;
    }

    public DescribeClass(String className) throws ClassNotFoundException {
        this.c = Class.forName(className);
    }

    public String getName() {
        return c.getName();
    }

    public Class<?>[] getInterfaces() {
        return c.getInterfaces();
    }

    public Class<?> getSuperClass() {
        return c.getSuperclass();
    }

   public Method[] getMethods() {
        return c.getMethods();
    }

    public void methodModifiers(Method[] methods) {
        Arrays.stream(methods).map(method -> "The modifiers of method " + method.getName() + " are: " + Modifier.toString(c.getModifiers())).forEach(System.out::println);
    }

    public Constructor<?>[] getConstructors() {
        return c.getConstructors();
    }

    public Class<?>[] getFields() {
        return c.getClasses();
    }
}
