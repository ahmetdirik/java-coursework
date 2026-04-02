
import java.util.*;

public class FunctionalTest {
    public static void main(String[] args) {
        verifyCorrectness();
        runBenchmark();
    }

    private static void verifyCorrectness() {
        RobinHoodHashTable<String, Integer> test = new RobinHoodHashTable<>(10);
        test.put("Test", 1);
        if (test.get("Test") != 1 || !test.contains("Test") || test.size() != 1) {
            throw new RuntimeException("Metodlar hatalı çalışıyor!");
        }
        test.remove("Test");
        if (test.size() != 0) throw new RuntimeException("Remove hatalı!");
    }

    public static void runBenchmark() {
        System.out.println("--- CMPE261 FINAL PROJECT COMPREHENSIVE BENCHMARK ---");
        int cap = 100000;
        double[] loads = {0.5, 0.8, 0.9};

        System.out.printf("%-5s | %-10s | %-12s | %-10s | %-10s | %-10s | %-10s\n",
                "LF", "Workload", "Type", "Avg Probe", "Max Probe", "Time(ms)", "Mem(KB)");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (double lf : loads) {
            int n = (int)(cap * lf);
            String[] workloads = {"Random", "Clustered", "Mixed"};

            for (String wl : workloads) {
                runInstance(cap, n, wl, false);
                runInstance(cap, n, wl, true);
            }
            System.out.println("--------------------------------------------------------------------------------------------");
        }
    }

    private static void runInstance(int cap, int n, String workload, boolean isRH) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memStart = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        if (isRH) {
            RobinHoodHashTable<Integer, Integer> rh = new RobinHoodHashTable<>(cap);
            performOperations(rh, n, workload, cap);
            printRow(lf(n, cap), workload, "RobinHood", rh.totalPutProbes, rh.maxProbeLength, startTime, memStart, n);
        } else {
            LinearProbingHashTable<Integer, Integer> lp = new LinearProbingHashTable<>(cap);
            performOperations(lp, n, workload, cap);
            printRow(lf(n, cap), workload, "Linear", lp.totalPutProbes, lp.maxProbeLength, startTime, memStart, n);
        }
    }

    private static void performOperations(Object table, int n, String workload, int cap) {
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int key = (workload.equals("Clustered")) ? (i * cap + 42) : rnd.nextInt(10000000);

            if (workload.equals("Mixed")) {
                int op = rnd.nextInt(10);
                if (op < 6) put(table, key, i);
                else if (op < 9) get(table, key);
                else remove(table, key);
            } else {
                put(table, key, i);
            }
        }
    }


    private static void put(Object t, int k, int v) {
        if (t instanceof RobinHoodHashTable) ((RobinHoodHashTable<Integer, Integer>)t).put(k, v);
        else ((LinearProbingHashTable<Integer, Integer>)t).put(k, v);
    }
    private static void get(Object t, int k) {
        if (t instanceof RobinHoodHashTable) ((RobinHoodHashTable<Integer, Integer>)t).get(k);
        else ((LinearProbingHashTable<Integer, Integer>)t).get(k);
    }
    private static void remove(Object t, int k) {
        if (t instanceof RobinHoodHashTable) ((RobinHoodHashTable<Integer, Integer>)t).remove(k);
        else ((LinearProbingHashTable<Integer, Integer>)t).remove(k);
    }
    private static double lf(int n, int cap) { return (double)n/cap; }

    private static void printRow(double lf, String wl, String type, long probes, int max, long start, long memS, int n) {
        long time = System.currentTimeMillis() - start;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - memS;
        System.out.printf("%-5.1f | %-10s | %-12s | %-10.2f | %-10d | %-10d | %-10.1f\n",
                lf, wl, type, (double)probes/n, max, time, (double)mem/1024);
    }
}