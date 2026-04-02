

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class TensorCoreSimulator {

    // Global variables
    static final int N = 1000; // Matrix size 1000x1000 [cite: 9]
    static int[][] matrixA = new int[N][N];
    static int[][] matrixB = new int[N][N];
    static int[][] resultSequential = new int[N][N];
    static int[][] resultParallel = new int[N][N];

    // Synchronization tools for Part C [cite: 21]
    static long totalOps = 0; // Shared counter variable [cite: 23]
    static final ReentrantLock lock = new ReentrantLock(); // Locking mechanism [cite: 26]

    // Semaphore for Part D (2 permits - only 2 threads can run simultaneously) [cite: 29]
    static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Tensor Core Simulator (N=" + N + ") ===");
        
        // 1. Data Generation
        System.out.println("Generating data...");
        generateMatrices();

        // --- Part A: Sequential Execution [cite: 8] ---
        System.out.println("\n--- Part A: Sequential Execution");
        long startTime = System.currentTimeMillis();
        runSequential();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Time: " + (endTime - startTime) + " ms"); 

        // --- Part B: Parallel Execution (Fast, lock-free) [cite: 13] ---
        System.out.println("\n--- Part B: Parallel Execution (4 Threads)");
        startTime = System.currentTimeMillis();
        runParallelWrapper(4, false); // 4 Threads, NO Synchronization [cite: 16]
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Time: " + (endTime - startTime) + " ms");

        // --- Part C & D: Parallel Execution with Audit & Semaphore [cite: 21, 27] ---
        System.out.println("\n--- Part C & D: Parallel Execution with Audit (Billing) & Semaphore (8 Threads)");
        // Note: Part D requires spawning 8 threads [cite: 32]
        // Warning: This part will run very slowly due to the "Every time a multiplication occurs" rule [cite: 22]
        totalOps = 0; // Reset the counter
        startTime = System.currentTimeMillis();
        runParallelWrapper(8, true); // 8 Threads, WITH Synchronization
        endTime = System.currentTimeMillis();
        System.out.println("Safe Parallel Time: " + (endTime - startTime) + " ms");
        System.out.println("Total Operations Logged: " + totalOps);
        System.out.println("Expected Operations: " + (long)N * N * N); // N^3 operations
    }

    // Random matrix generation [cite: 9]
    static void generateMatrices() {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrixA[i][j] = rand.nextInt(10);
                matrixB[i][j] = rand.nextInt(10);
            }
        }
    }

    // Part A: Sequential Multiplication [cite: 10]
    static void runSequential() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                resultSequential[i][j] = sum;
            }
        }
    }

    // Parallel execution wrapper (Main thread waiting logic is here)
    static void runParallelWrapper(int threadCount, boolean useSyncAndSemaphore) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];
        int rowsPerThread = N / threadCount; // Workload division [cite: 16]

        for (int i = 0; i < threadCount; i++) {
            int startRow = i * rowsPerThread;
            int endRow = (i == threadCount - 1) ? N : (i + 1) * rowsPerThread; // Last thread takes the remainders

            // Instantiate and start Worker [cite: 18]
            MatrixWorker worker = new MatrixWorker(startRow, endRow, useSyncAndSemaphore);
            threads[i] = new Thread(worker);
            threads[i].start();
        }

        // Main thread waits for all workers to finish (join) [cite: 19]
        for (Thread t : threads) {
            t.join();
        }
    }

    // Worker Class (Runnable implementation) [cite: 15]
    static class MatrixWorker implements Runnable {
        int startRow, endRow;
        boolean useSyncAndSemaphore;

        public MatrixWorker(int startRow, int endRow, boolean useSyncAndSemaphore) {
            this.startRow = startRow;
            this.endRow = endRow;
            this.useSyncAndSemaphore = useSyncAndSemaphore;
        }

        @Override
        public void run() {
            try {
                // Part D: Entry control with Semaphore (acquire) [cite: 30]
                if (useSyncAndSemaphore) {
                    semaphore.acquire();
                }

                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < N; j++) {
                        int sum = 0;
                        for (int k = 0; k < N; k++) {
                            sum += matrixA[i][k] * matrixB[k][j];
                            
                            // Part C: Billing System and Synchronization
                            if (useSyncAndSemaphore) {
                                lock.lock(); // Protect critical section [cite: 26]
                                try {
                                    totalOps++; // Increment shared variable [cite: 24]
                                } finally {
                                    lock.unlock();
                                }
                            }
                        }
                        resultParallel[i][j] = sum;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Part D: Release Semaphore permit [cite: 31]
                if (useSyncAndSemaphore) {
                    semaphore.release();
                }
            }
        }
    }
}