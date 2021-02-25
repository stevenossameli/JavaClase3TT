package paquete;

import paquete.BubbleSorterImple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;
import java.util.Properties;

public class MainBubble {
    public static void main(String[] args) {
        // Ordenar Integer[]

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String factoryPropertiesPath = rootPath+"MiFactory.properties";

        Properties props = new Properties();

        try {
            FileInputStream fi = new FileInputStream(factoryPropertiesPath);
            props.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String miSorter = props.getProperty("sorter");
        System.out.println(miSorter);
        Sorter<?> sorter = (Sorter<?>) MiFactory.getInstance(miSorter);


        Integer[] iArr = {6, 3, 5, 1, 8, 2, 9, 7, 4};
        String [] sArr = {"Pablo", "Alberto", "Juan", "Carlos"};

        Comparator<Integer> c1 = (a,b)->a-b;
        Comparator<String>  c2  = (a,b) -> a.compareToIgnoreCase(b);


        sorter.sort(sArr, c2);
        sorter.sort(iArr, c1);

        for (Integer integer : iArr) {
            System.out.println(integer);
        }

        for (String string : sArr) {
            System.out.println(string);
        }


    }
}
