package Lab11;

public class Lab11_2 implements Runnable {
	public void run() {
		Thread runThread = Thread.currentThread();
		System.out.println("当前线程"+runThread.getId() + "正在运行" + ",当前运行的时间：" + System.nanoTime() + "纳秒");
		System.out.println();
	}

	public static void main(String[] args) {
		Lab11_2 k = new Lab11_2();
		Thread t1 = new Thread(k); //声明线程对象
		Thread t2 = new Thread(k); 
		Thread t3 = new Thread(k);
		Thread t4 = new Thread(k);
		Thread t5 = new Thread(k);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
