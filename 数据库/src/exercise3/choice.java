package exercise3;


import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



class BackgroundPanel1 extends JPanel  
{  
    Image im;  
    public BackgroundPanel1(Image im)  
    {  
        this.im=im;  
        this.setOpaque(false);                    //设置控件不透明,若是false,那么就是透明
    }  
    //Draw the background again,继承自Jpanle,是Swing控件需要继承实现的方法,而不是AWT中的Paint()
    public void paintComponent(Graphics g)       //绘图类
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //绘制指定图像中当前可用的图像。图像的左上角位于该图形上下文坐标空间的 (x, y)。图像中的透明像素不影响该处已存在的像素

    }  
}

public class choice {
	
	private static BackgroundPanel1 contentPane;	
public static void choose(){
	
	final JFrame choice=new JFrame("操作选择");
	choice.setBounds(600, 200, 260, 400);
	choice.setLocationRelativeTo(choice.getOwner());

	choice.setLayout(null);
	choice.setVisible(true);
	
	 contentPane=new BackgroundPanel1((new ImageIcon("F:\\学习资料\\JAVA\\calculator\\数据库\\src\\exercise3\\2YAB{QYGYN5]$R9X%UR]Y2Y.png")).getImage());
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    contentPane.setSize( 260, 400);
	
    choice.add(contentPane);
	
	JButton addStaff=new JButton("新员工档案输入 ");
	JButton change=new JButton(" 员工人事变更 ");
	JButton refer=new JButton("员工档案查询修改");
	JButton referRecord=new JButton("人事变更记录");
	addStaff.setBounds(50, 50, 160, 35);
	change.setBounds(50, 120, 160, 35);
	refer.setBounds(50, 190, 160, 35);
	referRecord.setBounds(50, 260, 160, 35);
	contentPane.add(addStaff);
	contentPane.add(change);
	contentPane.add(refer);
	contentPane.add(referRecord);
	
	
	addStaff.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		choice.setVisible(false);
    		AddStaff.toAdd(choice);
    	}
    	});
	
	change.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		choice.setVisible(false);
		Change.changes(choice);
		}
	});
	
	refer.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		choice.setVisible(false);
		Refer.referStaff(choice);
		}
	});
	
	referRecord.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		choice.setVisible(false);
		ReferRecord.referRecord(choice);
		}
	});
	
	 choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
