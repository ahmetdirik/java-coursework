
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

    static ArrayList<Integer> buildArrayList(int N, Random rng) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < N; i++)
            al.add(rng.nextInt(100));
        return al;
    }

    static LinkedList<Integer> buildLinkedList(int N, Random rng) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < N; i++)
            ll.add(rng.nextInt(100));
        return ll;
    }

    // ======= Stats (post-warmup) =======
    static double meanAfterWarmup(double[] a, int warmup) {
        int n = a.length - warmup;
        double s = 0;
        for (int i = warmup; i < a.length; i++)
            s += a[i];
        return s / n;
    }

    static double stdAfterWarmup(double[] a, int warmup, double m) {
        int n = a.length - warmup;
        double s = 0;
        for (int i = warmup; i < a.length; i++) {
            double d = a[i] - m;
            s += d * d;
        }
        return Math.sqrt(s / n);
    }

    public static void main(String[] args) {
        final int[] SIZES = { 5_000, 10_000, 20_000, 40_000, 80_000, 160_000 };
        final int OPS = 1000;
        final int WARMUP = OPS / 4; // 25% warm-up discard
        final double NS_PER_US = 1e3;
        final Random rng = new Random(7);
        final double[] x = Arrays.stream(SIZES).asDoubleStream().toArray();

        // mean arrays
        double[] insFA = new double[SIZES.length], insAL = new double[SIZES.length], insLL = new double[SIZES.length];
        double[] delFA = new double[SIZES.length], delAL = new double[SIZES.length], delLL = new double[SIZES.length];
        double[] accFA = new double[SIZES.length], accAL = new double[SIZES.length], accLL = new double[SIZES.length];
        double[] appFA = new double[SIZES.length], appAL = new double[SIZES.length], appLL = new double[SIZES.length];
        double[] ins0FA = new double[SIZES.length], ins0AL = new double[SIZES.length], ins0LL = new double[SIZES.length];
        double[] del0FA = new double[SIZES.length], del0AL = new double[SIZES.length], del0LL = new double[SIZES.length];

        // std arrays
        double[] eInsFA = new double[SIZES.length], eInsAL = new double[SIZES.length], eInsLL = new double[SIZES.length];
        double[] eDelFA = new double[SIZES.length], eDelAL = new double[SIZES.length], eDelLL = new double[SIZES.length];
        double[] eAccFA = new double[SIZES.length], eAccAL = new double[SIZES.length], eAccLL = new double[SIZES.length];
        double[] eAppFA = new double[SIZES.length], eAppAL = new double[SIZES.length], eAppLL = new double[SIZES.length];
        double[] eIns0FA = new double[SIZES.length], eIns0AL = new double[SIZES.length], eIns0LL = new double[SIZES.length];
        double[] eDel0FA = new double[SIZES.length], eDel0AL = new double[SIZES.length], eDel0LL = new double[SIZES.length];

        for (int si = 0; si < SIZES.length; si++) {
            int N = SIZES[si];
            int mid = N / 2;

            int[] randIdx = new int[OPS];
            for (int k = 0; k < OPS; k++) randIdx[k] = rng.nextInt(N);

            // temporary arrays per N
            double[] tInsFA = new double[OPS], tInsAL = new double[OPS], tInsLL = new double[OPS];
            double[] tDelFA = new double[OPS], tDelAL = new double[OPS], tDelLL = new double[OPS];
            double[] tAccFA = new double[OPS], tAccAL = new double[OPS], tAccLL = new double[OPS];
            double[] tAppFA = new double[OPS], tAppAL = new double[OPS], tAppLL = new double[OPS];
            double[] tIns0FA = new double[OPS], tIns0AL = new double[OPS], tIns0LL = new double[OPS];
            double[] tDel0FA = new double[OPS], tDel0AL = new double[OPS], tDel0LL = new double[OPS];

            for (int k = 0; k < OPS; k++) {
                long t0, t1;

                // ===== Insert at middle =====
                FixedArray faIns = buildFixedArray(N, rng);
                t0 = System.nanoTime();
                faIns.insertAt(mid, 1);
                t1 = System.nanoTime();
                tInsFA[k] = (t1 - t0) / NS_PER_US;

                ArrayList<Integer> alIns = buildArrayList(N, rng);
                t0 = System.nanoTime();
                alIns.add(mid, 1);
                t1 = System.nanoTime();
                tInsAL[k] = (t1 - t0) / NS_PER_US;

                LinkedList<Integer> llIns = buildLinkedList(N, rng);
                t0 = System.nanoTime();
                llIns.add(mid, 1);
                t1 = System.nanoTime();
                tInsLL[k] = (t1 - t0) / NS_PER_US;

                // ===== Delete at middle =====
                FixedArray faDel = buildFixedArray(N, rng);
                t0 = System.nanoTime();
                faDel.deleteAt(mid);
                t1 = System.nanoTime();
                tDelFA[k] = (t1 - t0) / NS_PER_US;

                ArrayList<Integer> alDel = buildArrayList(N, rng);
                t0 = System.nanoTime();
                alDel.remove(mid);
                t1 = System.nanoTime();
                tDelAL[k] = (t1 - t0) / NS_PER_US;

                LinkedList<Integer> llDel = buildLinkedList(N, rng);
                t0 = System.nanoTime();
                llDel.remove(mid);
                t1 = System.nanoTime();
                tDelLL[k] = (t1 - t0) / NS_PER_US;

                // ===== Random access =====
                int idx = randIdx[k];
                FixedArray faAcc = buildFixedArray(N, rng);
                t0 = System.nanoTime();
                int tmpFA = faAcc.get(idx);
                t1 = System.nanoTime();
                tAccFA[k] = (t1 - t0) / NS_PER_US;

                ArrayList<Integer> alAcc = buildArrayList(N, rng);
                t0 = System.nanoTime();
                int tmpAL = alAcc.get(idx);
                t1 = System.nanoTime();
                tAccAL[k] = (t1 - t0) / NS_PER_US;

                LinkedList<Integer> llAcc = buildLinkedList(N, rng);
                t0 = System.nanoTime();
                int tmpLL = llAcc.get(idx);
                t1 = System.nanoTime();
                tAccLL[k] = (t1 - t0) / NS_PER_US;

                // ===== Append at end =====
                FixedArray faApp = buildFixedArray(N, rng);
                t0 = System.nanoTime();
                faApp.append(1);
                t1 = System.nanoTime();
                tAppFA[k] = (t1 - t0) / NS_PER_US;

                ArrayList<Integer> alApp = buildArrayList(N, rng);
                t0 = System.nanoTime();
                alApp.add(1);
                t1 = System.nanoTime();
                tAppAL[k] = (t1 - t0) / NS_PER_US;

                LinkedList<Integer> llApp = buildLinkedList(N, rng);
                t0 = System.nanoTime();
                llApp.addLast(1);
                t1 = System.nanoTime();
                tAppLL[k] = (t1 - t0) / NS_PER_US;

                sink = tmpFA ^ tmpAL ^ tmpLL;

                // ===== Insert at 0 =====
                FixedArray faIns0 = buildFixedArray(N, rng);
                t0 = System.nanoTime();
                faIns0.insertAt(0, 1);
                t1 = System.nanoTime();
                double ins0fa = (t1 - t0) / NS_PER_US;

                ArrayList<Integer> alIns0 = buildArrayList(N, rng);
                t0 = System.nanoTime();
                alIns0.add(0, 1);
                t1 = System.nanoTime();
                double ins0al = (t1 - t0) / NS_PER_US;

                LinkedList<Integer> llIns0 = buildLinkedList(N, rng);
                t0 = System.nanoTime();
                llIns0.addFirst(1);
                t1 = System.nanoTime();
                double ins0ll = (t1 - t0) / NS_PER_US;

                tIns0FA[k] = ins0fa;  tIns0AL[k] = ins0al;  tIns0LL[k] = ins0ll;

                // ===== Remove at 0 =====
                FixedArray faDel0 = buildFixedArray(N, rng);
                t0 = System.nanoTime();
                faDel0.deleteAt(0);
                t1 = System.nanoTime();
                double del0fa = (t1 - t0) / NS_PER_US;

                ArrayList<Integer> alDel0 = buildArrayList(N, rng);
                t0 = System.nanoTime();
                alDel0.remove(0);
                t1 = System.nanoTime();
                double del0al = (t1 - t0) / NS_PER_US;

                LinkedList<Integer> llDel0 = buildLinkedList(N, rng);
                t0 = System.nanoTime();
                llDel0.removeFirst();
                t1 = System.nanoTime();
                double del0ll = (t1 - t0) / NS_PER_US;

                tDel0FA[k] = del0fa;  tDel0AL[k] = del0al;  tDel0LL[k] = del0ll;
            }

            // ===== aggregate post-warmup stats =====
            insFA[si] = meanAfterWarmup(tInsFA, WARMUP);
            eInsFA[si] = stdAfterWarmup(tInsFA, WARMUP, insFA[si]);
            insAL[si] = meanAfterWarmup(tInsAL, WARMUP);
            eInsAL[si] = stdAfterWarmup(tInsAL, WARMUP, insAL[si]);
            insLL[si] = meanAfterWarmup(tInsLL, WARMUP);
            eInsLL[si] = stdAfterWarmup(tInsLL, WARMUP, insLL[si]);

            delFA[si] = meanAfterWarmup(tDelFA, WARMUP);
            eDelFA[si] = stdAfterWarmup(tDelFA, WARMUP, delFA[si]);
            delAL[si] = meanAfterWarmup(tDelAL, WARMUP);
            eDelAL[si] = stdAfterWarmup(tDelAL, WARMUP, delAL[si]);
            delLL[si] = meanAfterWarmup(tDelLL, WARMUP);
            eDelLL[si] = stdAfterWarmup(tDelLL, WARMUP, delLL[si]);

            accFA[si] = meanAfterWarmup(tAccFA, WARMUP);
            eAccFA[si] = stdAfterWarmup(tAccFA, WARMUP, accFA[si]);
            accAL[si] = meanAfterWarmup(tAccAL, WARMUP);
            eAccAL[si] = stdAfterWarmup(tAccAL, WARMUP, accAL[si]);
            accLL[si] = meanAfterWarmup(tAccLL, WARMUP);
            eAccLL[si] = stdAfterWarmup(tAccLL, WARMUP, accLL[si]);

            appFA[si] = meanAfterWarmup(tAppFA, WARMUP);
            eAppFA[si] = stdAfterWarmup(tAppFA, WARMUP, appFA[si]);
            appAL[si] = meanAfterWarmup(tAppAL, WARMUP);
            eAppAL[si] = stdAfterWarmup(tAppAL, WARMUP, appAL[si]);
            appLL[si] = meanAfterWarmup(tAppLL, WARMUP);
            eAppLL[si] = stdAfterWarmup(tAppLL, WARMUP, appLL[si]);

            ins0FA[si] = meanAfterWarmup(tIns0FA, WARMUP);
            eIns0FA[si] = stdAfterWarmup(tIns0FA, WARMUP, ins0FA[si]);
            ins0AL[si] = meanAfterWarmup(tIns0AL, WARMUP);
            eIns0AL[si] = stdAfterWarmup(tIns0AL, WARMUP, ins0AL[si]);
            ins0LL[si] = meanAfterWarmup(tIns0LL, WARMUP);
            eIns0LL[si] = stdAfterWarmup(tIns0LL, WARMUP, ins0LL[si]);

            del0FA[si] = meanAfterWarmup(tDel0FA, WARMUP);
            eDel0FA[si] = stdAfterWarmup(tDel0FA, WARMUP, del0FA[si]);
            del0AL[si] = meanAfterWarmup(tDel0AL, WARMUP);
            eDel0AL[si] = stdAfterWarmup(tDel0AL, WARMUP, del0AL[si]);
            del0LL[si] = meanAfterWarmup(tDel0LL, WARMUP);
            eDel0LL[si] = stdAfterWarmup(tDel0LL, WARMUP, del0LL[si]);

            System.out.printf("N=%d warm-up discarded: %d/%d%n", N, WARMUP, OPS);
        }

        // ======= Charts (build all) =======
        XYChart insChart = new XYChartBuilder().width(760).height(440)
            .title("Insert at Middle (µs, mean ± std, post-warmup)")
            .xAxisTitle("N").yAxisTitle("Time (µs)").build();
        insChart.addSeries("FixedArray", x, insFA, eInsFA).setMarker(new None());
        insChart.addSeries("ArrayList", x, insAL, eInsAL).setMarker(new None());
        insChart.addSeries("LinkedList", x, insLL, eInsLL).setMarker(new None());

        XYChart delChart = new XYChartBuilder().width(760).height(440)
            .title("Delete at Middle (µs, mean ± std, post-warmup)")
            .xAxisTitle("N").yAxisTitle("Time (µs)").build();
        delChart.addSeries("FixedArray", x, delFA, eDelFA).setMarker(new None());
        delChart.addSeries("ArrayList", x, delAL, eDelAL).setMarker(new None());
        delChart.addSeries("LinkedList", x, delLL, eDelLL).setMarker(new None());

        XYChart accChart = new XYChartBuilder().width(760).height(440)
            .title("Random Access (µs, mean ± std, post-warmup)")
            .xAxisTitle("N").yAxisTitle("Time (µs)").build();
        accChart.addSeries("FixedArray", x, accFA, eAccFA).setMarker(new None());
        accChart.addSeries("ArrayList", x, accAL, eAccAL).setMarker(new None());
        accChart.addSeries("LinkedList", x, accLL, eAccLL).setMarker(new None());

        XYChart appChart = new XYChartBuilder().width(760).height(440)
            .title("Append at End (µs, mean ± std, post-warmup)")
            .xAxisTitle("N").yAxisTitle("Time (µs)").build();
        appChart.addSeries("FixedArray", x, appFA, eAppFA).setMarker(new None());
        appChart.addSeries("ArrayList", x, appAL, eAppAL).setMarker(new None());
        appChart.addSeries("LinkedList", x, appLL, eAppLL).setMarker(new None());

        XYChart ins0Chart = new XYChartBuilder().width(760).height(440)
            .title("Insert at 0 (µs, mean ± std, post-warmup)")
            .xAxisTitle("N").yAxisTitle("Time (µs)").build();
        ins0Chart.addSeries("FixedArray", x, ins0FA, eIns0FA).setMarker(new None());
        ins0Chart.addSeries("ArrayList",  x, ins0AL, eIns0AL).setMarker(new None());
        ins0Chart.addSeries("LinkedList", x, ins0LL, eIns0LL).setMarker(new None());

        XYChart del0Chart = new XYChartBuilder().width(760).height(440)
            .title("Remove at 0 (µs, mean ± std, post-warmup)")
            .xAxisTitle("N").yAxisTitle("Time (µs)").build();
        del0Chart.addSeries("FixedArray", x, del0FA, eDel0FA).setMarker(new None());
        del0Chart.addSeries("ArrayList",  x, del0AL, eDel0AL).setMarker(new None());
        del0Chart.addSeries("LinkedList", x, del0LL, eDel0LL).setMarker(new None());

        // ======= Display once =======
        new SwingWrapper<>(Arrays.asList(
            insChart, delChart, accChart, appChart,
            ins0Chart, del0Chart
        )).displayChartMatrix();
    }
}
