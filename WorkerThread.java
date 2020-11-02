package baitaptuan3_threadpool;

public class WorkerThread implements Runnable {
    private int num;
 
    public WorkerThread(int num) {
        this.num = num;
    }   
 
    public void run() {
        if(isPrimeNumber(num))
        {
            System.out.println(num + " la SNT");
        }
        else
        {
            System.out.println(num + "khong la SNT");
        }
        processMessage();
    }
 
    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // check so nguyen to
    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
