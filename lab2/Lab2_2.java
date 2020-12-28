package lab2;

import java.util.Scanner;

public class Lab2_2 {
	public static void main(String[] args) {
		int sum = 0;//计算当天天数
		int flag = 0 ;//标记是否为闰年
		System.out.println("请输入今年的年份");
		Scanner input1 = new Scanner(System.in);
		int year = input1.nextInt();
		if( (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ) {
			flag = 1;//该值为闰年
		}
		System.out.println("请输入今年的月份");
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
		
		System.out.println("请输入日期");
		Scanner input3 = new Scanner(System.in);
		int day = input3.nextInt();
		sum += day;
		System.out.println("该日期的天数为：" + sum);
	}
}
