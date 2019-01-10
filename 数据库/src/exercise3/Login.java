package exercise3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



class BackgroundPanel extends JPanel  
{  
    Image im;  
    public BackgroundPanel(Image im)  
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


public class Login {

static int ver=0;
private static BackgroundPanel contentPane;	

public static void main(String[] args){
	final JFrame Login=new JFrame("登录界面");
    Login.setBounds(600, 200, 450, 350);
    Login.setLocationRelativeTo(Login.getOwner());

    
  //  Login.setBackground(new Color(255, 204, 153));  
    contentPane=new BackgroundPanel((new ImageIcon("F:\\学习资料\\JAVA\\calculator\\数据库\\src\\exercise3\\timg[10].jpg")).getImage());
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);
    contentPane.setSize( 400, 300);
    
    
    JLabel userid=new JLabel("工号：");
    final JTextField userid2=new JTextField(10);
    
    JPanel jP1 = new JPanel();
    jP1.add(userid);
    jP1.add(userid2);
    jP1.setLayout(new FlowLayout(FlowLayout.CENTER,0,45));
    //jP1.setOpaque(false);

    //jP1.setBackground(new Color(255, 204, 153));  
   
   
  
    JLabel userPassword=new JLabel("密码：");
    final JPasswordField userPassword2=new JPasswordField(10);
    JPanel jP2 = new JPanel();
    jP2.add(userPassword);
    jP2.add(userPassword2);
    jP2.setLayout(new FlowLayout(FlowLayout.CENTER,0,35));
   // jP2.setBackground(new Color(255, 204, 153)); 
    
    final JRadioButton users =new JRadioButton("用户登录",true);
    final JRadioButton admin =new JRadioButton("管理员登录");
    ButtonGroup group=new ButtonGroup();
    group.add(users);
    group.add(admin);
   // users.setBackground(new Color(255, 204, 153));
   // admin.setBackground(new Color(255, 204, 153));
    final DefaultButtonModel model = (DefaultButtonModel) admin.getModel();
    
    JPanel jP4=new JPanel();
    jP4.add(users);
    jP4.add(admin);
    jP4.setLayout(new FlowLayout(FlowLayout.CENTER,35,20));
    //jP4.setBackground(new Color(255, 204, 153)); 
     final JButton enter=new JButton("登录");
    JButton exit=new JButton("退出");
    JPanel jP3 = new JPanel();
    jP3.add(enter);
    jP3.add(exit);
    jP3.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
   // jP3.setBackground(new Color(255, 204, 153)); 
    Login.setVisible(true);
    jP1.setOpaque(false);
    jP2.setOpaque(false);
    jP3.setOpaque(false);
    jP4.setOpaque(false);
    users.setOpaque(false);
    userPassword2.setOpaque(false);
    admin.setOpaque(false);
    userid2.setOpaque(false);
    Login.add(contentPane);
    contentPane.setLayout(new GridLayout(4,1));
    contentPane.add(jP1);
    contentPane.add(jP2);
    contentPane.add(jP4);
    contentPane.add(jP3);                             //布局
    
 
    
    enter.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		verification(userid2.getText(),MD5.encrypt(userPassword2.getText().trim()));
    	//	System.out.println(userid2.getText());
    	//	System.out.println(userPassword2.getText());
    		
    		//System.out.println(ver);
    		if(ver==2&&users.isSelected()){
    			System.out.println("登录成功");
    			 Login.setVisible(false);
    			 verification.toAdd(Login,userid2.getText().trim());
    			
    		}
    		else if(ver==1&&admin.isSelected())
    		{
    			System.out.println("登录成功");
   			 Login.setVisible(false);
   			 choice.choose();
    			
    		}
    		else{
    			choice.choose();     
    			Login.setVisible(false);    
    		//	JOptionPane.showMessageDialog(null, "          			用户账号或密码错误","Error",JOptionPane.ERROR_MESSAGE); 
    		}
    	}
    });
    
    exit.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		System.exit(0);
    		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		}
});
    	
   
   Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
}

public static int  verification(String pId,String pPasswd){
	try{
		// 建立查询条件
		String sql = "select pId,pPasswd,pAuthority from person;";
		System.out.println("queryAllProcess(). sql = " + sql);

		DbProcess.connect();
		ResultSet rs = DbProcess.executeQuery(sql);

		// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		ver=0;
		while(rs.next()){
			if(pId.equals(rs.getString("pId"))==true&&pPasswd.equals(rs.getString("pPasswd"))==true)
		{   //System.out.println("密码账号匹配成功");
			if(rs.getString("pAuthority").equals("管理员")){
				ver=1;
			}
			else if(rs.getString("pAuthority").equals("员工")){
				ver=2;
			}
		
		}
		
		
		}
	
	
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}
	return ver;
	
}
}



