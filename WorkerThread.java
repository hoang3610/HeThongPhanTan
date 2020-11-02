package baithuongkihtpt;

public class WorkerThread implements Runnable {

    private double num;

    public WorkerThread (double num)
    {
        this.num = num;
    }

    @Override
    public void run() {
        if(checkPerfectSquare(num))
        {
            System.out.println((int) num + " la so chinh phuong");
        }
        else
        {
            System.out.println((int) num + " khong la so chinh phuong");
        }

    }

    private void processCommand() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static boolean checkPerfectSquare(double x)
    {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }
    
}
