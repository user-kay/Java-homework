package Lab14;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Lab14_2 {
 public static void main(String[] args)
 {
  JFrame frame = new TransformFrame();
  frame.setVisible(true);
 }
}

class TransformFrame extends JFrame implements ActionListener
{
 //��Ӽ�����ť���������
 JButton rote = new JButton("��ת") ;
 JButton flipX= new JButton("ˮƽ��ת");
 JButton flipY= new JButton("��ֱ��ת");
 JButton zoomIn = new JButton("�Ŵ�") ;
 JButton zoomOut = new JButton("��С") ;
 public TransformFrame()
 {
  setTitle("TransformTest");
  setSize(400, 400);
  addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    System.exit(0);
   }
  });
  Container contentPane = getContentPane();
  canvas = new TransPanel();
  contentPane.add(canvas, "Center");
  JPanel buttonPanel = new JPanel();
  buttonPanel.add(rote);
  rote.addActionListener(this);
  buttonPanel.add(flipX);
  flipX.addActionListener(this);
  buttonPanel.add(flipY);
  flipY.addActionListener(this);
  
  buttonPanel.add(zoomIn) ;
  zoomIn.addActionListener(this) ;
  buttonPanel.add(zoomOut) ;
  zoomOut.addActionListener(this) ;
  contentPane.add(buttonPanel, "North");
 }

 public void actionPerformed(ActionEvent event)
 {
  Object source = event.getSource();
  //����source == ???���ַ����������������³��ִ������ԣ���Ҫ����ʹ��event.getSource().equals()���������==
  if (source == rote)
  {
   canvas.setRotate();
  } else
  if (source == flipX)
  {
   canvas.flipX();
  } else
  if (source == flipY)
  {
   canvas.flipY();
  } else
  if (source == zoomIn)
  {
   canvas.zoomIn();
  } else
  if (source == zoomOut)
  {
   canvas.zoomOut();
  }
 }
 private TransPanel canvas;
}

class TransPanel extends JPanel
{
 //ˮƽ��ת�����ı�־��-1��ʾ��Ҫ����ˮƽ��ת
 int m_nFlipXScale = 1 ;
 //��ֱ��ת�����ı�־��-1��ʾ��Ҫ���д�ֱ��ת
 int m_nFlipYScale = 1 ; 
 //��ת�ĽǶȡ���Ϊ������Ҫ��������ֱ��д����90�����Ը��ݾ�����Ҫ��̬�޸ģ��Է���ʵ�����
 int roteAngle = 0 ; 
 //���ű�����Ĭ�ϵı���0��ʾû�з�ת������ķ�ת��Сͨ��һ������:getZoomSize()��ȡ
 int zoomLevel = 0 ;
 public TransPanel()
 {
  //��������һ��ͼƬ��
  img = new ImageIcon("G:\\eclipse-workspace\\JavaSE\\src\\Lab14\\1.jpg").getImage();
 }
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  g.drawImage(img,0,0,this) ;
  
  drawTransImage(g,img.getWidth(this),img.getHeight(this),zoomLevel) ;
  
 }
 
 public void drawTransImage(Graphics g,int drawx,int drawy,int zoom)
 {
  int x = 0 ;
  int y = 0 ;
  int w = img.getWidth(this) ;
  int h = img.getHeight(this) ;
  int zoomw = getZoomSize(w,zoom) ;
  int zoomh = getZoomSize(h,zoom) ;
  int xPos = 0 ;
  int yPos = 0 ;
  if (m_nFlipXScale == -1)
    xPos = -zoomw ;
  if (m_nFlipYScale == -1)
    yPos = -zoomh ; 
  Graphics2D g2 = (Graphics2D)g ;
  //ת������ԭ�㡣�ⲽ��ҪҲ�ɣ����ǽ���ǰλ��ת��Ϊ����ԭ��󣬿��Խ�ʡ�ö���㲽�裬�ǳ����á�
   //�����ǵ��������Ժ�һ��Ҫ��ԭ��ת��������Ҫ��Ȼ�����ط�������
  g2.translate(drawx,drawy);
  if (roteAngle != 0)
    g2.rotate(Math.toRadians(m_nFlipXScale * m_nFlipYScale * roteAngle),zoomw >> 1,zoomh >> 1);
    //�����m_nFlipXScale * m_nFlipYScale��Ҫ����˵��һ�£���Ϊʵ��ʹ���У���������������ϵ����������
    //��flipX����flipY�Ժ�Ȼ������ת����ʱ��ͼƬ����ת����ͻ���ִ��󣬼�����δ�����Ա�֤����ʹ���������
    //������ʽ������֤����תͼƬ��ʱ���ǰ���˳ʱ��ķ��������ת��
  if (m_nFlipXScale == -1)
    g2.scale(-1,1);//��һ��ֵ��ʾˮƽ��-1��ʾ�ȿ�ˮƽ��ת��Math.abs(m_nFlipXScale)��ֵԽ�󣬳�����ͼƬ��Խ��
  if (m_nFlipYScale == -1)
    g2.scale(1,-1);//�ڶ���ֵ��ʾ��ֱ��-1��ʾ�ȸߴ�ֱ��ת��Math.abs(m_nFlipYScale)��ֵԽ�󣬳�����ͼƬ��Խ��
  //��ʾͼƬ
  g2.drawImage(img,xPos,yPos,xPos + zoomw,yPos + zoomh,x,y,w,h,null) ;
  g2.translate(-drawx,-drawy);  
 }
 public void setRotate()
 {
  roteAngle += 90 ;
  roteAngle %= 360 ;
  repaint();
 }
 public void flipX()
 {
  m_nFlipXScale = -m_nFlipXScale ;
  repaint();
 }
 
 public void flipY()
 {
  m_nFlipYScale = -m_nFlipYScale ;
  repaint();
 } 
 
 public void zoomIn()
 {
  zoomLevel++ ;
  repaint();
 }
 
 public void zoomOut()
 {
  zoomLevel-- ;
  repaint();
 }
 
 public static final int getZoomSize(int sourceSize,int zoomLevel)
 {
  if (zoomLevel == 0)
    return sourceSize ;
  else
  if (zoomLevel < 0)
   return sourceSize / (Math.abs(zoomLevel) + 1) ;
  else
   return sourceSize * (zoomLevel + 1) ;
  } 
 private Image img;
}