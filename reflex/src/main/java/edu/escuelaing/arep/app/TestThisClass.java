package edu.escuelaing.arep.app;

//@Test
public class TestThisClass {

    @Test
    public static void a(){

    }

    @Test
    public static void b()throws Exception{
        d();
    }

    @Test
    public static void c(){

    }

    @Test
    public static void d() throws Exception{
        throw new Exception("Excepción Personalizada");

    }

    @Test
    public static void e(){

    }
    
}
