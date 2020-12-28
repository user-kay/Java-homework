package Lab4;

import java.util.Scanner;

public class Lab4_1 {
	public static void main(String[] args) {
		System.out.println("请输入行数");
		Scanner input = new Scanner(System.in); 
		int n = input.nextInt();
		System.out.println("请输入列数");
		Scanner input2 = new Scanner(System.in);
		int m = input.nextInt();
		int a[][] = new int[n + 10][m + 10];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				Scanner input3 = new Scanner(System.in);
				int k = input3.nextInt();
				a[i][j] = k;
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(a[j][i] + " ");
			}
			System.out.println(" ");
		}
	}
	
}
