package paquete;

import paquete.util.Time;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class MainBubble {
    public static void main(String[] args) {
        Integer[] iArr = {6, 3, 5, 1, 8, 2, 9, 7, 4};
        String [] sArr = {"Pablo", "Alberto", "Juan", "Carlos"};

        Comparator<Integer> c1 = (a,b)->a-b;
        Comparator<String>  c2  = (a,b) -> a.compareToIgnoreCase(b);

        //Sorter<?> sorter = new QuickSortSorterImple<>();
        Sorter<?> sorter = new HeapSortSorterImple<>();

        sorter.sort(sArr, c2);
        sorter.sort(iArr, c1);


        for (Integer integer : iArr) {
            System.out.println(integer);
        }

        for (String string : sArr) {
            System.out.println(string);
        }

        try {

            Time t = new Time(0L);

            t.start();
            TimeUnit.SECONDS.sleep(5);
            t.stop();
            System.out.println(t.getTime() + " miliseconds Transcurridos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
