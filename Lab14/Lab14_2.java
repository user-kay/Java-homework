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
 //添加几个按钮方便操作。
 JButton rote = new JButton("旋转") ;
 JButton flipX= new JButton("水平翻转");
 JButton flipY= new JButton("垂直翻转");
 JButton zoomIn = new JButton("放大") ;
 JButton zoomOut = new JButton("缩小") ;
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
  //对于source == ???这种方法，在特殊的情况下出现错误，所以，需要酌情使用event.getSource().equals()方法来替代==
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
 //水平翻转比例的标志。-1表示需要进行水平翻转
 int m_nFlipXScale = 1 ;
 //垂直翻转比例的标志。-1表示需要进行垂直翻转
 int m_nFlipYScale = 1 ; 
 //旋转的角度。因为工程需要，代码中直接写成了90，可以根据具体需要动态修改，以符合实际情况
 int roteAngle = 0 ; 
 //缩放比例。默认的比例0表示没有翻转，具体的翻转大小通过一个方法:getZoomSize()获取
 int zoomLevel = 0 ;
 public TransPanel()
 {
  //首先载入一张图片。
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
  //转换坐标原点。这步不要也成，但是将当前位置转换为坐标原点后，可以节省好多计算步骤，非常好用。
   //不过记得用完了以后，一定要把原点转换回来，要不然其他地方就乱了
  g2.translate(drawx,drawy);
  if (roteAngle != 0)
    g2.rotate(Math.toRadians(m_nFlipXScale * m_nFlipYScale * roteAngle),zoomw >> 1,zoomh >> 1);
    //上面的m_nFlipXScale * m_nFlipYScale需要特殊说明一下：因为实际使用中，可能遇到各种组合的情况，比如
    //先flipX或者flipY以后然后再旋转，这时候，图片的旋转方向就会出现错误，加上这段代码可以保证无论使用哪种组合
    //操作方式，都保证在旋转图片的时候是按照顺时针的方向进行旋转。
  if (m_nFlipXScale == -1)
    g2.scale(-1,1);//第一个值表示水平，-1表示等宽水平翻转，Math.abs(m_nFlipXScale)的值越大，出来的图片就越宽
  if (m_nFlipYScale == -1)
    g2.scale(1,-1);//第二个值表示垂直，-1表示等高垂直翻转，Math.abs(m_nFlipYScale)的值越大，出来的图片就越高
  //显示图片
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