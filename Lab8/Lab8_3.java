package Lab8;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

class tg {
		private static final long serialVersionUID = 1L;
		tg() {
			JFrame k1 = new JFrame();
			k1.setTitle("��ӭע��");
			k1.setBounds(400,200,800,870);
			k1.invalidate();
			Container container = k1.getContentPane();
			container.setLayout(null);
//			container.setLayout(new GridLayout(25,10));
		
			
			//������������
			JLabel name = new JLabel();
			name.setBounds(230,50,30,20);
			final JTextField text1 = new JTextField(20);
			text1.setBounds(260,50,200,20);
			name.setText("����: ");
			container.add(name);
			container.add(text1);
			
			//�����������
			JLabel pwd = new JLabel();
			JPasswordField text2 = new JPasswordField(20);
			pwd.setText("����:");
			pwd.setBounds(230,90,30,20);
			text2.setBounds(260,90,200,20);
			container.add(pwd);
			container.add(text2);
			
			//�������Ա�ĵ�ѡ��
			JLabel p3 = new JLabel();
			p3.setText("�Ա��ǣ�");
			p3.setBounds(220,120,60,30);
			container.add(p3);
			ButtonGroup g1 = new ButtonGroup();
			final JRadioButton jr1 = new JRadioButton("��");
			JRadioButton jr2 = new JRadioButton("Ů");
			g1.add(jr1);
			g1.add(jr2);
			jr1.setBounds(270,120,50,30);
			jr2.setBounds(320,120,50,30);
			container.add(jr1);
			container.add(jr2);
			
			//�����ǰ��õĸ�ѡ��
			JLabel hobby = new JLabel();
			hobby.setText("������:");
			hobby.setBounds(220, 150, 60, 30);
			container.add(hobby);
			
			final JCheckBox h1 = new JCheckBox("ƹ����",false);
			final JCheckBox h2 = new JCheckBox("��ë��",false);
			final JCheckBox h3 = new JCheckBox("����",false);
			final JCheckBox h4 = new JCheckBox("����",false);
			final JCheckBox h5 = new JCheckBox("�ܲ�",false);
			h1.setBounds(280,150,70,30);
			h2.setBounds(370,150,70,30);
			h3.setBounds(460,150,70,30);
			h4.setBounds(550, 150, 70, 30);
			h5.setBounds(640, 150, 70, 30);
			container.add(h1);
			container.add(h2);
			container.add(h3);
			container.add(h4);
			container.add(h5);
			final JPanel jp1 = new JPanel();
			jp1.add(h1);
			jp1.add(h2);
			jp1.add(h3);
			jp1.add(h4);
			jp1.add(h5);
			
			//������ѧ�Ƶ������б�
			JLabel stu = new JLabel("ѧ����:");
			stu.setBounds(220,190,60,30);
			container.add(stu);
			String[] stuData = new String[]{"ר��","����","�о���"};
			final JComboBox<String> comboBox = new JComboBox<String>(stuData);
			comboBox.setBounds(285, 190, 60, 30);
			container.add(comboBox);
			
			//������У�����б�
			JLabel sch = new JLabel("У����:");
			sch.setBounds(220, 240, 60, 30);
			container.add(sch);
			String[] schData = new String[]{"ʯ��","��ѧ��","�Ϻ�"};
			JList<String>jl = new JList(schData);
			JScrollPane js1=new JScrollPane(jl);	
			js1.setBounds(270, 245, 60, 20);
			container.add(js1);
			
			
			//���������ҽ��ܵ�
			JLabel introduction = new JLabel("���ҽ��ܣ�");
			introduction.setBounds(210, 280, 600, 30);
			container.add(introduction);
			JTextArea jt = new JTextArea(" ",10,10);
			JScrollPane js2 = new JScrollPane(jt);
			js2.setBounds(270, 285, 300, 60);
			container.add(js2);
			
			JButton bt1 = new JButton("�ύ");
			bt1.setBounds(350,400,150,30);
			container.add(bt1);
			
			
			final JLabel jb1 = new JLabel();
			jb1.setBounds(100,470,150,100);
			
	
			
			bt1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					String s1 = "";
					
					String s0 = "";
					s0 = text1.getText();
					if(jr1.isSelected()) {
						s1 = "��ʿ";
					}
					else {
						s1 = "Ůʿ";
					}
					String s2 = "";
					if(h1.isSelected()) {
						s2 += h1.getText();
					}
					if(h2.isSelected()) {
						s2 += h2.getText();
					}
					if(h3.isSelected()) {
						s2 += h3.getText();
					}
					if(h4.isSelected()) {
						s2 += h4.getText();
					}
					if(h5.isSelected()) {
						s2 += h5.getText();
					}
					
					String s3 = (String)comboBox.getSelectedItem();
					String str="<html><body><h1>������</h1><p>";
					str+= s0 + s1+"�����Ϻã�</p>";
					str+="<p>����ѧ���ǣ�"+s3+"</p>";
					str+="</body></html>";
					jb1.setText(str);
					
					
				}
				
			});
			container.add(jb1);
			k1.setVisible(true);
			
		}

		
		
	}


public class Lab8_3 {
	public static void main(String[] args) {
		new tg();
	}
}
