package paquete;

import java.io.FileInputStream;
import java.util.Comparator;
import java.util.Objects;
import java.util.Properties;

public class Programa {
    public static void main(String[] args) {

        Sorter<?> sorter = (Sorter<?>) MiFactory.getInstance(leerProperties("sorter"));

        Integer[] iArr = {6, 3, 5, 1, 8, 2, 9, 7, 4};
        Comparator<Integer> iComp = (a, b)->a-b;

        String [] sArr = {"Pablo", "Alberto", "Juan", "Carlos"};
        Comparator<String>  sComp  = (a,b) -> a.compareToIgnoreCase(b);

        if(sorter!=null) {
            sorter.sort(iArr, iComp);
            sorter.sort(sArr, sComp);
        }

        imprimir(iArr);
        imprimir(sArr);


    }

    public static <T> void imprimir(T[] arr)
    {
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":"\n"));
        }
    }


    public static String leerProperties(String key){

        Properties props = new Properties();

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String propertiesPath = rootPath+"MiFactory.properties";


        try {
            FileInputStream fi = new FileInputStream(propertiesPath);
            props.load(fi);
            return props.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "Not Found";
        }

    }
}
