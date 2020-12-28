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
			k1.setTitle("欢迎注册");
			k1.setBounds(400,200,800,870);
			k1.invalidate();
			Container container = k1.getContentPane();
			container.setLayout(null);
//			container.setLayout(new GridLayout(25,10));
		
			
			//下面是姓名的
			JLabel name = new JLabel();
			name.setBounds(230,50,30,20);
			final JTextField text1 = new JTextField(20);
			text1.setBounds(260,50,200,20);
			name.setText("姓名: ");
			container.add(name);
			container.add(text1);
			
			//下面是密码的
			JLabel pwd = new JLabel();
			JPasswordField text2 = new JPasswordField(20);
			pwd.setText("密码:");
			pwd.setBounds(230,90,30,20);
			text2.setBounds(260,90,200,20);
			container.add(pwd);
			container.add(text2);
			
			//下面是性别的单选框
			JLabel p3 = new JLabel();
			p3.setText("性别是：");
			p3.setBounds(220,120,60,30);
			container.add(p3);
			ButtonGroup g1 = new ButtonGroup();
			final JRadioButton jr1 = new JRadioButton("男");
			JRadioButton jr2 = new JRadioButton("女");
			g1.add(jr1);
			g1.add(jr2);
			jr1.setBounds(270,120,50,30);
			jr2.setBounds(320,120,50,30);
			container.add(jr1);
			container.add(jr2);
			
			//下面是爱好的复选框
			JLabel hobby = new JLabel();
			hobby.setText("爱好是:");
			hobby.setBounds(220, 150, 60, 30);
			container.add(hobby);
			
			final JCheckBox h1 = new JCheckBox("乒乓球",false);
			final JCheckBox h2 = new JCheckBox("羽毛球",false);
			final JCheckBox h3 = new JCheckBox("足球",false);
			final JCheckBox h4 = new JCheckBox("排球",false);
			final JCheckBox h5 = new JCheckBox("跑步",false);
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
			
			//下面是学制的下拉列表
			JLabel stu = new JLabel("学历是:");
			stu.setBounds(220,190,60,30);
			container.add(stu);
			String[] stuData = new String[]{"专科","本科","研究生"};
			final JComboBox<String> comboBox = new JComboBox<String>(stuData);
			comboBox.setBounds(285, 190, 60, 30);
			container.add(comboBox);
			
			//下面是校区的列表
			JLabel sch = new JLabel("校区是:");
			sch.setBounds(220, 240, 60, 30);
			container.add(sch);
			String[] schData = new String[]{"石牌","大学城","南海"};
			JList<String>jl = new JList(schData);
			JScrollPane js1=new JScrollPane(jl);	
			js1.setBounds(270, 245, 60, 20);
			container.add(js1);
			
			
			//下面是自我介绍的
			JLabel introduction = new JLabel("自我介绍：");
			introduction.setBounds(210, 280, 600, 30);
			container.add(introduction);
			JTextArea jt = new JTextArea(" ",10,10);
			JScrollPane js2 = new JScrollPane(jt);
			js2.setBounds(270, 285, 300, 60);
			container.add(js2);
			
			JButton bt1 = new JButton("提交");
			bt1.setBounds(350,400,150,30);
			container.add(bt1);
			
			
			final JLabel jb1 = new JLabel();
			jb1.setBounds(100,470,150,100);
			
	
			
			bt1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					String s1 = "";
					
					String s0 = "";
					s0 = text1.getText();
					if(jr1.isSelected()) {
						s1 = "男士";
					}
					else {
						s1 = "女士";
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
					String str="<html><body><h1>调查结果</h1><p>";
					str+= s0 + s1+"，早上好！</p>";
					str+="<p>您的学历是："+s3+"</p>";
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
