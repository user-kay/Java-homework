package lab3;

public class Lab3_1 {
	public static void main(String[] args) {
		String s1 = new String("cjq,yyds");
		//string��Ĺ���
		int size = s1.length();
		System.out.println("s1�ĳ���Ϊ��" + size);
		//���濪ʼ�ַ���������
		int pos = s1.indexOf("j");
		System.out.println("j��λ��Ϊ" + (pos + 1)); 
		int pos2 = s1.lastIndexOf("y");
		System.out.println("���һ��y��λ��Ϊ��" + (pos2 + 1));
		//���濪ʼ�����ַ�
		String s2 = "heddo world";
		char mychar = s2.charAt(2);
		System.out.println("s2��λ��Ϊ2���ַ���Ϊ��" + mychar);
		//���濪ʼ��ȡ�ַ�
		String s4 = s2.substring(5);
		System.out.println(s4);
		String s5 = s2.substring(5,8);
		System.out.println(s5);
		//���濪ʼȥ�ո�
		String s6 = "     java   class    ";
		System.out.println("ȥ��ǰ��ո��Ժ��ֵΪ" + s6.trim());
		//���濪ʼ���ִ�
		String s7 = "asdasd";
		String newstr = s7.replace("d", "D");
		System.out.println("�µ��ַ���Ϊ" + newstr);
		//�ж��Ƿ����
		String s8 = "ABD";
		String s9 =  "ABD";
		String s10 = "ABG";
		boolean k = s8.equals(s9);
		boolean k2 = s8.equals(s10);
		System.out.println("s8��s9�ж��Ƿ���ȵĽ��Ϊ��" + k );
		System.out.println("s8��s10�ж��Ƿ���ȵĽ��Ϊ��" + k2 );
		//�Ƚϴ�С
		String s11 = new String("d");
		String s12 = new String("k");
		System.out.println("s12��s12��С���жϽ��Ϊ��" + s11.compareTo(s12));
		//���濪ʼ�����ַ����ķָ�
		String s13 = "123.123.454";
		String []firstArrays = s13.split("\\.");
		String []secondArrays = s13.split("\\.",2);
		for(String a: firstArrays) {
			System.out.print("[" + a + "]");
		}
		System.out.println("");
		System.out.println("�ָ����εĽ������");
		for(String a: secondArrays) {
			System.out.print("[" + a + "]");
		}
		
		
		
	}
}