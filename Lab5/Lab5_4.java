package Lab5;

interface alarm { //����ӿ�
	public void alarming(); //���巽��
}

abstract class door {
	door() {
		System.out.println("����һ����");
	}
	abstract void open();
	abstract void close();
}

class AlarmDoor extends door implements alarm {
	public void open() {
		System.out.println("�ű�����");
	}
	public void close() {
		System.out.println("�ű�������");
	}
	public void alarming() {
		System.out.println("�����˾�����");
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
