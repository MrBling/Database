package exercise3;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


class BackgroundPanel2 extends JPanel  
{  
    Image im;  
    public BackgroundPanel2(Image im)  
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

public class AddStaff {
	
	private static BackgroundPanel2 contentPane;	
	static  int count=0;
	static String Count;
	static JLabel Id=new JLabel("员工号",JLabel.CENTER);
	static JLabel Name=new JLabel("姓        名 ",JLabel.CENTER);
	static JLabel Sex=new JLabel("性        别",JLabel.CENTER);
	static JLabel Passwd=new JLabel("密码修改",JLabel.CENTER);
	static JLabel Authority=new JLabel("用户权限",JLabel.CENTER);
	
	static JLabel Department=new JLabel("所在部门",JLabel.CENTER);
	static JLabel Job=new JLabel("职        务 ",JLabel.CENTER);
	static JLabel Edulevel=new JLabel("受教育程度",JLabel.CENTER);
	static JLabel Spcialty=new JLabel("专业技能",JLabel.CENTER);
	static JLabel Birthday=new JLabel("生        日",JLabel.CENTER);
	
	static JLabel Address=new JLabel("家庭住址",JLabel.CENTER);
	static JLabel Tel=new JLabel("联系电话",JLabel.CENTER);
	static JLabel Email=new JLabel("电子邮件",JLabel.CENTER);
	static JLabel State=new JLabel("当前状态",JLabel.CENTER);
	static JLabel Remark=new JLabel("备        注",JLabel.CENTER);
	
	static	JTextField id=new JTextField(10);
	static	JTextField passwd=new JTextField(10);
	static	JTextField authority=new JTextField(10);
	static	JTextField name=new JTextField(10);
	static	JTextField sex=new JTextField(10);
	static	JTextField birthday=new JTextField(10);
	static	JTextField department=new JTextField(10);
	static	JTextField job=new JTextField(10);
	static	JTextField edulevel=new JTextField(10);
	static	JTextField spcialty=new JTextField(10);
	static	JTextField address=new JTextField(10);
	static	JTextField tel=new JTextField(10);
	static	JTextField email=new JTextField(10);
	static JTextField state=new JTextField(10);
	static	JTextField remark=new JTextField(10);

	static	JTextField Addall=new JTextField(20);
	
	
	static JLabel title=new JLabel("新员工添加",JLabel.CENTER);
	
	
	
public static void toAdd(final JFrame choice){
	
	 Addall.setText("批量处理   txt路径");     
	 Addall.setHorizontalAlignment(JTextField.CENTER);
	
	contentPane=new BackgroundPanel2((new ImageIcon("F:\\学习资料\\JAVA\\calculator\\数据库\\src\\exercise3\\timgCAGXN8G9.jpg")).getImage());
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);
    contentPane.setSize( 1000, 450);
    contentPane.setLayout(new GridLayout(3,1));
    
	final JFrame addWindows=new JFrame("新员工档案建立");
	addWindows.setBounds(400, 200,1000, 450);
	addWindows.setLocationRelativeTo(addWindows.getOwner());
	addWindows.setVisible(true);
	addWindows.setPreferredSize(new Dimension(20,20)); 
	
	title.setFont(new Font("Dialog",1,30));
	id.setEditable(false);
	//System.out.println("count="+refercount());
	
	Count=String.valueOf(refercount()+1);
	id.setText(Count);
	count=0;
	
	name.setText("必填");
	sex.setText("必填");
	department.setText("必填");
	authority.setText("必填");
	job.setText("必填");
	edulevel.setText("必填");
	
	 JPanel centre=new  JPanel();
	 centre.setLayout(new GridLayout(3,1,20,25));
	 JPanel centre1=new  JPanel();
	 centre1.add(Id);
	 centre1.add(id);
	 centre1.add(Name);
	 centre1.add(name);
	 centre1.add(Sex);
	 centre1.add(sex);
	 centre1.add(Birthday);
	 centre1.add(birthday);
	 centre1.add(Department);
	 centre1.add(department);
	 
	 JPanel centre2=new  JPanel();
	 centre2.add(Authority);
	 centre2.add(authority);
	 centre2.add(Passwd);
	 centre2.add(passwd);
	 passwd.setText("123456");
	 centre2.add(Job);
	 centre2.add(job);
	 centre2.add(Edulevel);
	 centre2.add(edulevel);
	 centre2.add(Spcialty);
	 centre2.add(spcialty);
	 
	 JPanel centre3=new  JPanel();
	 centre3.add(Address);
	 centre3.add(address);
	 centre3.add(Tel);
	 centre3.add(tel);
	 centre3.add(Email);
	 centre3.add(email);
	 centre3.add(State);
	 centre3.add(state);
	 centre3.add(Remark);
	 centre3.add(remark);
	 
	 JPanel centre4=new  JPanel();
	
	
	 
	 centre.add(centre1);
	 centre.add(centre2);
	 centre.add(centre3);
	
	 
	 JPanel bottom=new JPanel();
	 bottom.setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
	 
	 JPanel bottom2=new JPanel();
	 bottom2.setLayout(new FlowLayout(FlowLayout.RIGHT,50,30));
	 
	 JButton btn0=new JButton("批量处理");
	 JButton btn1=new JButton("加入");
	 JButton btn2=new JButton("返回");
	 JButton btn3=new JButton("退出");
	 
	 name.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    		name.setText("");
	    		
	    }
	    	});
	sex.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    		sex.setText("");
	    		
	    }
	    	});
	department.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    		department.setText("");
	    		
	    }
	    	});
	 authority.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    		authority.setText("");
	    		
	    }
	    	});
	 job.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    		job.setText("");
	    		
	    }
	    	});
	 edulevel.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    		 edulevel.setText("");
	    		
	    }
	    	});
	 
	 
	 btn1.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!id.getText().isEmpty()
	    				&&!id.getText().equals("必填")
	    				&&!name.getText().isEmpty()
	    				&&!name.getText().equals("必填")
	    				&&!sex.getText().isEmpty()
	    				&&!sex.getText().equals("必填")
	    				&&!department.getText().isEmpty()
	    				&&!department.getText().equals("必填")
	    				&&!authority.getText().isEmpty()
	    				&&!authority.getText().equals("必填")
	    				&&!passwd.getText().isEmpty()
	    				&&!passwd.getText().equals("必填")
	    				&&!job.getText().isEmpty()
	    				&&!job.getText().equals("必填")
	    				&&!edulevel.getText().isEmpty()
	    				&&!edulevel.getText().equals("必填")
	    				){
	    			System.out.println("新员工加入");
	    			
	    			addProcess();
	    			addRecord();
	    			JOptionPane.showMessageDialog(null, "员工添加成功","提示",JOptionPane.INFORMATION_MESSAGE); 
	    			name.setText("");
    				sex.setText("");
    				birthday.setText("");
    				department.setText("");
    				authority.setText("");
    				passwd.setText("123456");
    			    job.setText("");
    				edulevel.setText("");
    				spcialty.setText("");
    				address.setText("");
    				tel.setText("");
    				email.setText("");
    				state.setText("");
    				remark.setText("");
	    		//	Count=String.valueOf(refercount()+1);
	    		//	id.setText(Count);
	    		//	count=0;
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "员工添加失败，或信息不完整","提示",JOptionPane.ERROR_MESSAGE); 
	    		}
	    }
	    	});
	 
	 btn2.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		addWindows.setVisible(false);
	    		choice.setVisible(true);
	    		
	    		}

			
	    });
	 
	 btn3.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		System.exit(0);
	    		addWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		}

			
	    });
	 
	 btn0.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		try {
					alladd();
					count=0;
					Count=String.valueOf(refercount()+1);
					id.setText(Count);
					count=0;
					//addRecord();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		}

			
	    }); 
	 
	 Addall.addMouseListener(new MouseAdapter(){
		 public void mouseClicked(MouseEvent e){
		 Addall.setText("");
		 }
	    }); 
	 bottom.add(Addall);
	 bottom.add(btn0);
	 bottom.add(btn1);
	 bottom.add(btn2);
	 bottom.add(btn3);
	 
	
	 
	 title.setOpaque(false);
	 centre.setOpaque(false);
	 centre1.setOpaque(false);
	 centre2.setOpaque(false);
	 centre3.setOpaque(false);
	 bottom.setOpaque(false);
	 //bottom2.setOpaque(false);
	 
	 contentPane.add(title);
	 contentPane.add(centre);
	 contentPane.add(bottom);
	// contentPane.add(bottom2);
	 
	 
	 addWindows.add( contentPane);
	  
	 
	 addWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


public static void alladd() throws Exception{
	 String sp[]=new String[14];
	 String lu=Addall.getText();
	 FileReader reader =new FileReader(lu);	
	 BufferedReader br=new BufferedReader(reader);
	 String str;
	 
	 while((str=br.readLine())!=null){
			String [] strArray=str.split(" ");
			
				//Count=String.valueOf(refercount()+1);
			    count=0;
				String pId=String.valueOf(refercount()+1);
				
				Calendar date=Calendar.getInstance();
				int a=date.get(Calendar.YEAR);
				int b=date.get(Calendar.MONTH)+1;
				int c=date.get(Calendar.DATE);
				int d=date.get(Calendar.HOUR);
				int e=date.get(Calendar.MINUTE);
				int f=date.get(Calendar.SECOND);
				
				String A= String.valueOf(a);
				String B= String.valueOf(b);
				String C= String.valueOf(c);
				String D= String.valueOf(d);
				String E= String.valueOf(e);
				String F= String.valueOf(f);
				
				
				String Id=A+B+C+D+E+F;
				
				
				String pChange="0";
				String pDescription="员工号:  "+pId+" ,加入公司";
				
				String sql="insert into personnel values('";
				sql=sql+Id+"','";
				sql=sql+pId+"','";
				sql=sql+pChange+"','";
				sql = sql +pDescription + "');";
				
				
				
				System.out.println("addProcess().sql="+sql);
				try{
					if (DbProcess.executeUpdate(sql) < 1) {
						System.out.println("addProcess(). add database failed.");
					}
					else
						{System.out.println("记录插入成功！！！");
						   }
				}catch(Exception e1){
					System.out.println("e = " + e1);
					JOptionPane.showMessageDialog(null,
						"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
				}
				
				count=0;
				String pName=strArray[0].trim();
				String pSex=strArray[1].trim();
				String pBirthday=strArray[2].trim();
				String pDepartment=strArray[3].trim();
				
				String pAuthority=strArray[4].trim();
				
				String pPasswd=MD5.encrypt(strArray[5].trim()) ;            
				String pJob=strArray[6].trim();
				String pEdulevel=strArray[7].trim();
				String pSpcialty=strArray[8].trim();
				
				String pAddress=strArray[9].trim();
				String pTel=strArray[10].trim();
				String pEmail=strArray[11].trim();
				String pState=strArray[12].trim();
				String pRemark=strArray[13].trim();
				
				String sql1="insert into person values('";
				sql1=sql1+pId+"','";
				sql1=sql1+pName+"','";
				sql1=sql1+pSex+"','";
				sql1=sql1+pBirthday+"','";
				sql1=sql1+pDepartment+"','";
				sql1=sql1+pAuthority+"','";
				sql1=sql1+pPasswd+"','";
				sql1=sql1+pJob+"','";
				sql1=sql1+pEdulevel+"','";
				sql1=sql1+pSpcialty+"','";
				sql1=sql1+pAddress+"','";
				sql1=sql1+pTel+"','";
				sql1=sql1+pEmail+"','";
				sql1=sql1+pState+"','";
				sql1 = sql1 +pRemark + "');";
				
				
				
				System.out.println("addProcess().sql="+sql1);
				try{
					if (DbProcess.executeUpdate(sql1) < 1) {
						System.out.println("addProcess(). add database failed.");
					}
					else
						{System.out.println("插入成功！！！");
						
						
				       }
				}catch(Exception e1){
					System.out.println("e = " + e1);
					JOptionPane.showMessageDialog(null,
						"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
				}
				
			
		}
	 
	 
}

public static  void addProcess(){
	 
	String pId=id.getText().trim();
	String pName=name.getText().trim();
	String pSex=sex.getText().trim();
	String pBirthday=birthday.getText().trim();
	String pDepartment=department.getText().trim();
	
	String pAuthority=authority.getText().trim();
	
	String pPasswd=MD5.encrypt(passwd.getText().trim()) ;            
	String pJob=job.getText().trim();
	String pEdulevel=edulevel.getText().trim();
	String pSpcialty=spcialty.getText().trim();
	
	String pAddress=address.getText().trim();
	String pTel=tel.getText().trim();
	String pEmail=email.getText().trim();
	String pState=state.getText().trim();
	String pRemark=remark.getText().trim();
	
	String sql="insert into person values('";
	sql=sql+pId+"','";
	sql=sql+pName+"','";
	sql=sql+pSex+"','";
	sql=sql+pBirthday+"','";
	sql=sql+pDepartment+"','";
	sql=sql+pAuthority+"','";
	sql=sql+pPasswd+"','";
	sql=sql+pJob+"','";
	sql=sql+pEdulevel+"','";
	sql=sql+pSpcialty+"','";
	sql=sql+pAddress+"','";
	sql=sql+pTel+"','";
	sql=sql+pEmail+"','";
	sql=sql+pState+"','";
	sql = sql +pRemark + "');";
	
	
	
	System.out.println("addProcess().sql="+sql);
	try{
		if (DbProcess.executeUpdate(sql) < 1) {
			System.out.println("addProcess(). add database failed.");
		}
		else
			{System.out.println("插入成功！！！");
			Count=String.valueOf(refercount()+1);
			id.setText(Count);
			count=0;
			
	       }
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}
	       }


public static  void addRecord(){
	Calendar date=Calendar.getInstance();
	int a=date.get(Calendar.YEAR);
	int b=date.get(Calendar.MONTH)+1;
	int c=date.get(Calendar.DATE);
	int d=date.get(Calendar.HOUR);
	int e=date.get(Calendar.MINUTE);
	int f=date.get(Calendar.SECOND);
	
	String A= String.valueOf(a);
	String B= String.valueOf(b);
	String C= String.valueOf(c);
	String D= String.valueOf(d);
	String E= String.valueOf(e);
	String F= String.valueOf(f);
	
	
	String Id=A+B+C+D+E+F;
	
	String PId=id.getText().trim();
	int i = Integer.parseInt(PId); 
	i=i-1;
	String pId= String.valueOf(i);
	String pChange="0";
	String pDescription="员工号:  "+pId+" ,加入公司";
	
	String sql="insert into personnel values('";
	sql=sql+Id+"','";
	sql=sql+pId+"','";
	sql=sql+pChange+"','";
	sql = sql +pDescription + "');";
	
	
	
	System.out.println("addProcess().sql="+sql);
	try{
		if (DbProcess.executeUpdate(sql) < 1) {
			System.out.println("addProcess(). add database failed.");
		}
		else
			{System.out.println("记录插入成功！！！");
			   }
	}catch(Exception e1){
		System.out.println("e = " + e1);
		JOptionPane.showMessageDialog(null,
			"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}
	       }

public static  int refercount(){
	try{
		// 建立查询条件
		String sql = "select * from person;";
		System.out.println("queryAllProcess(). sql = " + sql);

		DbProcess.connect();
		ResultSet rs = DbProcess.executeQuery(sql);

		// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		
		while(rs.next()){
			count++;
		}
		System.out.println("已有员工： "+(count));
	
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}
	return count;
}
	


}
