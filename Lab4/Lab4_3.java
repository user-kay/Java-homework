package Lab4;

import java.util.Random;

public class Lab4_3 {
	public static void main(String[] args) {
		int a[] = new int[10];

		for(int i = 0 ; i < 100000 ; i++) {
			Random random = new Random();
			int n = random.nextInt(6) + 1;
			a[n]++;
		}
		for(int i = 1 ; i <= 6 ; i++) {
			System.out.println( i + "���ֵĴ���Ϊ��" +  a[i]);
		}
		int sum1 = a[1] + a[2] + a[3];
		System.out.println("С�������ֵĴ���Ϊ��" + sum1);
		int sum2 = a[4] + a[5] + a[6];
		System.out.println("��������ֵĴ���Ϊ��" + sum2);
	}
}
