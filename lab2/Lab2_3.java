package lab2;

import java.util.Scanner;

public class Lab2_3 {
	
	public static void main(String[] args) {
		int [] arr = new int [1000001];
		// ��¼����
		
		System.out.println("��������������");
		Scanner input1 = new Scanner(System.in);
		int n = input1.nextInt();
		//	��¼��������
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println("�������" + (i + 1)  + "�����ĸ߶�");
			Scanner input2 = new Scanner(System.in);
			arr[i] = input2.nextInt();
		}
		int k = 0;
		int sum1 = 0, ans = 0;//������
		for(int i = 0 ; i < n - 1 ; i++) {
			k = i;
			while(k < n - 2) {
				if(arr[k] < arr[k + 1]) {
					ans++;
					k++;
				}
				else {
					if(ans > sum1) {
						sum1 = ans;
						ans = 0;
					}
					break;
				}
			}
			
		}

		ans = 0;
		int sum2 = 0;
		
		for(int i = 0 ; i < n - 1 ; i++) {
			k = i;
			while(k < n - 2) {
				if(arr[k] > arr[k + 1]) {
					ans++;
					k++;
				}
				else {
					if(ans > sum2) {
						sum2 = ans;
						ans = 0;
					}
					break;
				}
			}
			
		}
		
		if(sum1 > sum2) {
			System.out.println(sum1 + 1);
		}
		else {
			System.out.println(sum2 + 1);
		}
		
		
	}
}
