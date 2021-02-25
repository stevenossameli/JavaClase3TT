package paquete.main;

import paquete.Sorter;
import paquete.util.MiFactory;
import paquete.util.ReadProperties;
import paquete.util.Time;

import java.util.Comparator;

public class MedirTiempo {
    public static void main(String[] args) {
        String objName = ReadProperties.leer("sorter");

        System.out.println("###### Algoritmo de ordenamiento: " + objName + " #####\n");

       Integer[] arr = new Integer[100000];
       llenarArreglo(arr);


        Sorter<?> sorter = (Sorter<?>) MiFactory.getInstance(objName);
        Comparator<Integer> c = (a,b)->a-b;



        if(sorter!=null) {
           Time tiempo = new Time();
           tiempo.start();

           sorter.sort(arr, c);

           tiempo.stop();

            System.out.println("Tiempo transcurrido: " + tiempo.getTime() + " milisegundos");

       }

        // BubbleSort -> 8247 milisegundos
        // QuickSort -> 16 milisegundos
        // HeapSort -> 67 milisegundos


    }

    public static void llenarArreglo (Integer[] arr)
    {
        for (int i = arr.length-1; i >= 0 ; i--) {
           arr[i] = i;
        }
    }
}
