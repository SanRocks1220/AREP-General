package edu.escuelaing.arep.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InvokeMain {
    public static void main(String... args)  {
        try {

            Class<?> c = Class.forName(args[0]); //Busca nombre de clase

            Class[] argTypes = new Class[] { String[].class }; //Arreglo de clases con el tipo .class

            Method main = c.getDeclaredMethod("main", argTypes); //Búsque un método que se llame Main y que reciba esa lista de argumentos

            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length); //Le paso los valores de los parámetros, desde 1 hasta args.length

            System.out.format("invoking %s.main()%n", c.getName());

            main.invoke(null, (Object) mainArgs); //Invoca el main, nulo (en un contexto estático)(si quisiera en contexto de un objeto, le paso el objeto) y la lista de argumentos
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}


//java -cp target/classes edu.escuelaing.arep.app.InvokeMain edu.escuelaing.arep.app.Reflex