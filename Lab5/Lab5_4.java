package Lab5;

interface alarm { //定义接口
	public void alarming(); //定义方法
}

abstract class door {
	door() {
		System.out.println("这是一扇门");
	}
	abstract void open();
	abstract void close();
}

class AlarmDoor extends door implements alarm {
	public void open() {
		System.out.println("门被打开了");
	}
	public void close() {
		System.out.println("门被关上了");
	}
	public void alarming() {
		System.out.println("响起了警报声");
	}
}

public class Lab5_4 {
	public static void main(String[] args) {
		AlarmDoor a1 = new AlarmDoor();
		a1.open();
		a1.alarming();
		a1.close();		
	}
}
