package p190331_instance_of_Void;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanceOfVoid {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> voidConstructor = Class.forName("java.lang.Void").getDeclaredConstructors()[0];
        voidConstructor.setAccessible(true);
        Object voidInstance = voidConstructor.newInstance();
        System.out.println(voidInstance);
    }
}
