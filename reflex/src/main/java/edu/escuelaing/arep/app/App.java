package edu.escuelaing.arep.app;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Class c = "hola".getClass();
            System.out.println("La clase es: " + c);

            byte[] bytes = new byte[1024];
            System.out.println(bytes);

            c = bytes.getClass();
            System.out.println("La clase es: " + c);

            c = boolean.class;
            System.out.println("La clase es: " + c);

            c = Class.forName("edu.escuelaing.arep.app.Reflex");
            System.out.println("La clase es: " + c);

            c = Double.TYPE;
            System.out.println("La clase es: " + c);

            c = javax.swing.JButton.class.getSuperclass();
            while (c != null) {
                System.out.println("La clase es: " + c);
                c = c.getSuperclass();
            }

            c = Class.class.getSuperclass();
            printMembers(c.getDeclaredMethods(), "Methods");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printMembers(Member[] mbrs, String s) {
        System.out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
            System.out.format(" %s%n", ((Field) mbr).toGenericString());
            else if (mbr instanceof Constructor)
            System.out.format(" %s%n", ((Constructor) mbr).toGenericString());
            else if (mbr instanceof Method)
            System.out.format(" %s%n", ((Method) mbr).toGenericString());
        }
        if (mbrs.length == 0){
            System.out.format(" -- No %s --%n", s);
        }
        System.out.format("%n");
    }

    //Buscar Clase, buscar main de clase y ejecutarlo
    
}
