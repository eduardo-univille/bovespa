package com.bovespa;

public class Sorter {
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            Comparable cur = a[i];
            int j = i - 1;
            while ((j >= 0) && (a[j].compareTo(cur) > 0)) {
                a[j + 1] = a[j--];
            }
            a[j + 1] = cur;
        }
    }
}
