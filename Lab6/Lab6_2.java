package Lab6;

interface Car {
	void run();
}


//下面这个是成员内部类版
//class CarTest implements Car{
//	public void run() {
//		System.out.println("跑起来了");
//	}
//	private class k {
//		public void CarRun(Car ins) {
//			ins.run();
//		}
//	}
//}


//下面这个是局部内部类版
//class CarTest  {
//	public Car f1() {
//		class case1 implements Car {
//			case1() {
//				System.out.println("跑起来了");
//			}
//			public void run() {
//				System.out.println("k1");
//			}
//		}
//		return new case1();
//	}
//}

//下面这个是匿名内部类版
class CarTest {
	public Car f2() {
		return new Car() {
			public void run() {
				System.out.println("跑起来了3");
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
