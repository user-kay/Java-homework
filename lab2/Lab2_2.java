package lab2;

import java.util.Scanner;

public class Lab2_2 {
	public static void main(String[] args) {
		int sum = 0;//���㵱������
		int flag = 0 ;//����Ƿ�Ϊ����
		System.out.println("�������������");
		Scanner input1 = new Scanner(System.in);
		int year = input1.nextInt();
		if( (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ) {
			flag = 1;//��ֵΪ����
		}
		System.out.println("�����������·�");
		Scanner input2  = new Scanner(System.in);
		int month = input2.nextInt();
		if(flag == 1) {
			while(month > 1) {
				switch(month) {
				case 3:
				case 5:
				case 7:
				case 9: 
				case 11:
					sum += 31;
					month--;
					break;
				
				case 4:
				case 6:
				case 8:
				case 10:
				case 12:
					sum += 30;
					month--;
					break;
				case 2:
					sum += 29;
				}
			}
				
		}
		if(flag == 0) {
			while(month > 1) {
				switch(month) {
				case 3:
				case 5:
				case 7:
				case 9: 
				case 11:
					sum += 31;
					month--;
					break;
				
				case 4:
				case 6:
				case 8:
				case 10:
				case 12:
					sum += 30;
					month--;
					break;
				case 2:
					sum += 28;
				}
			}
				
		}
		
		System.out.println("����������");
		Scanner input3 = new Scanner(System.in);
		int day = input3.nextInt();
		sum += day;
		System.out.println("�����ڵ�����Ϊ��" + sum);
	}
}
