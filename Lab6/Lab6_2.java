package Lab6;

interface Car {
	void run();
}


//��������ǳ�Ա�ڲ����
//class CarTest implements Car{
//	public void run() {
//		System.out.println("��������");
//	}
//	private class k {
//		public void CarRun(Car ins) {
//			ins.run();
//		}
//	}
//}


//��������Ǿֲ��ڲ����
//class CarTest  {
//	public Car f1() {
//		class case1 implements Car {
//			case1() {
//				System.out.println("��������");
//			}
//			public void run() {
//				System.out.println("k1");
//			}
//		}
//		return new case1();
//	}
//}

//��������������ڲ����
class CarTest {
	public Car f2() {
		return new Car() {
			public void run() {
				System.out.println("��������3");
			}
		};
	}
}


public class Lab6_2 {
	public static void main(String[]args) {
//		CarTest k = new CarTest();
//		k.run();
		
//		CarTest k = new CarTest();
//		k.f1().run();
		
		CarTest k = new CarTest();
		k.f2().run();;
	}
}
