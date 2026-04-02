
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.None;

import java.util.*;

public class Comparison {

    static volatile int sink; // Prevent JIT elimination

    // ======= FixedArray (reallocates every insert/delete/append) =======
    static class FixedArray {
        int[] a;
        int size = 0;

        FixedArray(int cap) {
            a = new int[cap];
        }

        int get(int i) {
            return a[i];
        }

        void insertAt(int i, int v) {
            int[] b = new int[size + 1];
            for (int j = 0; j < i; j++)
                b[j] = a[j];
            b[i] = v;
            for (int j = i; j < size; j++)
                b[j + 1] = a[j];
            a = b;
            size++;
        }

        void deleteAt(int i) {
            int[] b = new int[size - 1];
            for (int j = 0; j < i; j++)
                b[j] = a[j];
            for (int j = i + 1; j < size; j++)
                b[j - 1] = a[j];
            a = b;
            size--;
        }

        void append(int v) {
            int[] b = new int[size + 1];
            for (int j = 0; j < size; j++)
                b[j] = a[j];
            b[size] = v;
            a = b;
            size++;
        }
    }

    // ======= Builders (excluded from timing) =======
    static FixedArray buildFixedArray(int N, Random rng) {
        FixedArray fa = new FixedArray(N);
        for (int i = 0; i < N; i++)
            fa.a[i] = rng.nextInt(100);
        fa.size = N;
        return fa;
    }
