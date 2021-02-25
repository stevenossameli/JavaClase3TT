package paquete;

import java.util.Comparator;

public class QuickSortSorterImple<E> implements Sorter<E> {

    @Override
    public <T> void sort(T[] arr, Comparator<T> c) {
        qsort(arr, 0, arr.length-1, c);
    }

    private <T> void qsort(T[] array, int left, int right, Comparator<T> c) {
        int ll = left;
        int rr = right;

        if (rr > ll) {
            T pivot = array[(ll + rr) / 2];
            while (ll <= rr) {
                while (ll < right && c.compare(array[ll], pivot) < 0) {
                    ll += 1;
                }
                while (rr > left && c.compare(array[rr], pivot) > 0) {
                    rr -= 1;
                }
                if (ll <= rr) {
                    swap(array, ll, rr);
                    ll += 1;
                    rr -= 1;
                }
            }
            if (left < rr) {
                qsort(array, left, rr, c);

            }
            if (ll < right) {
                qsort(array, ll, right, c);
            }
        }
    }

   private <T> void swap (T [] arr, int l, int r)
    {
        T t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}