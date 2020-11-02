package baithuongkihtpt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        // tạo một pool chứa 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 20; i++) {
            Runnable worker = new WorkerThread(i);
            // call phương thức execute của ExecutorService
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
 
        System.out.println("Finished all threads");
    }
}
