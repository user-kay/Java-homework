package Lab4;

public class Lab4_2 {
	public static void main(String[] args) {
		//����Ϊinteger���ʹ�÷���
		Integer number = new Integer("45");
		System.out.println("��������ص�ֵΪ��" + number.intValue());		//������parseInt������
		String str[] = {"23","43","90","13","90"};
		int sum = 0;
		for(int i = 0 ; i < str.length ; i++) {
			int k1 = Integer.parseInt(str[i]);
			sum += k1;
		}
		System.out.println("������������ܺ�Ϊ��" + sum);
		String k2 = Integer.toString(700);
		System.out.println("'700'�����ֵ��ʮ���Ƶı�ʾΪ��" + k2);
		
		//���濪ʼ��booleanֵ��
		Boolean b = new Boolean(true);
		System.out.println("b�����booleanֵΪ��" + b);
		Boolean k3 = new Boolean("ok");
		System.out.println("k3:" + k3.booleanValue());
		System.out.println("k3��Ӧ�Ĳ���ֵ��boolean����Ϊ" + k3.toString());
		
		//���濪ʼByte���
		byte mybyte =45;
		Byte h = new Byte(mybyte);
		System.out.println("byte������ֵΪ�� "+ h);
		
		//���濪ʼCharacter���
		Character mychar1 = new Character('A');
		Character mychar2 = new Character('B');
		System.out.println(mychar1 + "�Ǵ�д��ĸ��" + Character.isUpperCase(mychar1));
		System.out.println(mychar2 + "��Сд��ĸ��" + Character.isLowerCase(mychar2));
		
		//���濪ʼDouble���
		Double num1 = new Double(2.234);
		System.out.println("Double�����ֵΪ��" + num1);
		int t = num1.intValue();
		System.out.println("Double����ת��Ϊint���ֵΪ" + t);
		Double num2 = new Double(3.56);
		System.out.println("num1 �� num2 �����Ƿ���ȣ�" + num2.equals(num1));
		
		//���濪ʼ��Number���
		Number num3 = new Double(2.252);
		//������������ķ���ʵ����
		System.out.println("Number�����ת��Ϊint���ֵΪ��" + num3.intValue());
		System.out.println("Number�����ת��Ϊdouble���ֵΪ��" + num3.doubleValue());
		System.out.println("Number�����ת��Ϊfloat���ֵΪ��" + num3.floatValue());
	}
}
