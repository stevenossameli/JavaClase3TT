package paquete;

public class MiFactory {
    public static Object getInstance(String objName){
        try {
            Class<?> c =  Class.forName(objName);
            return c.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
