package Lab1_1;

public class DataType {
	public static void main(String[] args) {
		int x = 10;
		char ch = 'a';
		double mydouble = 45.4523;
		System.out.println(x);
		System.out.println(ch);
		System.out.println(mydouble);
		int k = 1;
		if(k > x) {
			System.out.println("变量k大于变量x");
		}
		else {
			System.out.println("变量x大于变量k");
		}
		int y = 1;
		int total = 0;
		while(y <= 10) {
			total += y;
			y++;
		}
		System.out.println("total=" + total);
		String str = "明日科技";
		switch(str) {
		case"明日":
			System.out.println("陈某某图书网");
			break;
		
		case"明日科技":
			System.out.println("明日科技有限公司");
			break;
		default:
			System.out.println("上面的不符合");
		}
	}
}
