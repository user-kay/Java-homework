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
			System.out.println("����k���ڱ���x");
		}
		else {
			System.out.println("����x���ڱ���k");
		}
		int y = 1;
		int total = 0;
		while(y <= 10) {
			total += y;
			y++;
		}
		System.out.println("total=" + total);
		String str = "���տƼ�";
		switch(str) {
		case"����":
			System.out.println("��ĳĳͼ����");
			break;
		
		case"���տƼ�":
			System.out.println("���տƼ����޹�˾");
			break;
		default:
			System.out.println("����Ĳ�����");
		}
	}
}
