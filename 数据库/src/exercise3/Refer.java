package exercise3;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



class BackgroundPanel5 extends JPanel  
{  
    Image im;  
    public BackgroundPanel5(Image im)  
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




public class Refer {
	
	
	private static BackgroundPanel contentPane;	
	static String Selectfield="工号";
	static int count=0;
	

	
	public static void referStaff(final JFrame choice){
			contentPane=new BackgroundPanel((new ImageIcon("F:\\学习资料\\JAVA\\calculator\\数据库\\src\\exercise3\\e54791eab7d801a2ac93627b27086831_51t58PICVvI_1024.jpg")).getImage());
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    contentPane.setLayout(null);
		    contentPane.setSize( 1020, 550);
		final JFrame referStaff=new JFrame("员工信息查询修改");
		referStaff.setBounds(200, 200,1020, 550);
		referStaff.setLocationRelativeTo(referStaff.getOwner());

		referStaff.setVisible(true);
		JLabel title=new JLabel("员工档案",JLabel.CENTER);
		JLabel SelectField =new JLabel("选择查询字段");    //选择查询字段
		JLabel boring =new JLabel("=");         //=
		
		/*  属性值面板  */
		JLabel Id=new JLabel("员 工 号",JLabel.CENTER);
		JLabel Name=new JLabel("姓        名 ",JLabel.CENTER);
		JLabel Sex=new JLabel("    性      别",JLabel.CENTER);
		JLabel Passwd=new JLabel("当前密码",JLabel.CENTER);
		JLabel Authority=new JLabel("用 户 权 限",JLabel.CENTER);
		
		JLabel Department=new JLabel("所在部门",JLabel.CENTER);
		JLabel Job=new JLabel("职        务 ",JLabel.CENTER);
		JLabel Edulevel=new JLabel("受教育程度",JLabel.CENTER);
		JLabel Spcialty=new JLabel("专业技能",JLabel.CENTER);
		JLabel Birthday=new JLabel("生        日",JLabel.CENTER);
		
		JLabel Address=new JLabel("家庭住址",JLabel.CENTER);
		JLabel Tel=new JLabel("联系电话",JLabel.CENTER);
		JLabel Email=new JLabel("电子邮件",JLabel.CENTER);
		JLabel State=new JLabel("当前状态",JLabel.CENTER);
		JLabel Remark=new JLabel("备        注",JLabel.CENTER);
		
		
		
		
		/*  输入输出框    */
		final JTextField id=new JTextField(10);
		id.setEditable(false);
		final JTextField passwd=new JTextField(10);
		final JTextField authority=new JTextField(10);
		final JTextField name=new JTextField(10);
		final JTextField sex=new JTextField(10);
		final JTextField birthday=new JTextField(10);
		final JTextField department=new JTextField(10);
		department.setEditable(false);
		final JTextField job=new JTextField(10);
		job.setEditable(false);
		final JTextField edulevel=new JTextField(10);
		final JTextField spcialty=new JTextField(10);
		
		final JTextField address=new JTextField(10);
		final JTextField tel=new JTextField(10);
		final JTextField email=new JTextField(10);
		final JTextField state=new JTextField(10);
		state.setEditable(false);
		final JTextField remark=new JTextField(10);
		
		JButton found=new JButton("查询");
		JButton foundAll=new JButton("查询所有记录");
		JButton insert=new JButton("插入该条信息");
		 insert.setVisible(false);
		JButton update=new JButton("更新该条信息");
	//	JButton delete=new JButton("删除该条信息");
		JButton back=new JButton("返回");
		
		
		
		JComboBox<String> Select = new JComboBox<String>();
		Select.addItem("工号");
		Select.addItem("姓名");
		Select.addItemListener(new ItemListener() {//下拉框事件监听  
	        public void itemStateChanged(ItemEvent event) {  
	            switch (event.getStateChange()) {  
	            case ItemEvent.SELECTED:  
	            	Selectfield = (String) event.getItem();  
	                System.out.println("选中：" + Selectfield);  
	                break;  
	            case ItemEvent.DESELECTED:  
	                System.out.println("取消选中：" + event.getItem());  
	                break;  
	            }  
	        }  
	    });
		
		final JTextField selectItem=new JTextField(10);
		
		Vector titleVector = new Vector();       //二维表标题部分
		final Vector staffVector = new Vector();     //二维表下部分
		titleVector.add("员工号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("当前密码");
		titleVector.add("用户权限");
		titleVector.add("所在部门");
		titleVector.add("职务");
		titleVector.add("受教育程度");
		titleVector.add("专业技能");
		titleVector.add("生日");
		titleVector.add("家庭住址");
		titleVector.add("联系");
		titleVector.add("电子邮件");
		titleVector.add("当前状态");
		titleVector.add("备注");
		
		
		final JTable StaffJTable = new JTable(staffVector, titleVector);
		StaffJTable.setPreferredScrollableViewportSize(new Dimension(1000,250));
		JScrollPane staffJScrollPane = new JScrollPane(StaffJTable);
		//分别设置水平和垂直滚动条自动出现
		staffJScrollPane.setHorizontalScrollBarPolicy(                
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // 当需要时则出现滚动条
		staffJScrollPane.setVerticalScrollBarPolicy(                
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		StaffJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) staffVector.get(row);

				id.setText((String) v.get(0));// 学号
				name.setText((String) v.get(1));// 姓名
				sex.setText((String) v.get(2));// 性别
				passwd.setText((String) v.get(3));// 年龄
				authority.setText((String) v.get(4));// 专业
				department.setText((String) v.get(5));// 住址
				job.setText((String) v.get(6));// 住址
				edulevel.setText((String) v.get(7));// 住址
				spcialty.setText((String) v.get(8));// 住址
				birthday.setText((String) v.get(9));// 住址
				address.setText((String) v.get(10));// 住址
				tel.setText((String) v.get(11));// 住址
				email.setText((String) v.get(12));// 住址
				state.setText((String) v.get(13));// 住址
				remark.setText((String) v.get(14));// 住址
				
			}
		});
		
		
	
		JPanel division1=new JPanel();
		JPanel division2=new  JPanel();
		JPanel division3=new  JPanel();
		JPanel division4=new  JPanel();
		JPanel division5=new  JPanel();
		JPanel division6=new  JPanel ();
		JPanel division7=new  JPanel ();
		
		
		JPanel top=new  JPanel();
		JPanel bottom=new  JPanel();
		
		
		division1.add(title,BorderLayout.SOUTH);
		division2.add(staffJScrollPane);
		
		division3.setLayout(new FlowLayout(FlowLayout.LEFT,15,0));
		division3.add(SelectField);
		division3.add(Select);
		division3.add(boring);
		division3.add(selectItem);
		division3.add(found);
		division3.add(foundAll);
		
		
		division4.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		division4.add(Id);
		division4.add(id);
		division4.add(Name);
		division4.add(name);
		division4.add(Sex);
		division4.add(sex);
		division4.add(Passwd);
		division4.add(passwd);
		division4.add(Authority);
		division4.add(authority);
		
		division5.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		division5.add(Department);
		division5.add(department);
		division5.add(Job);
		division5.add(job);
		division5.add(Edulevel);
		division5.add(edulevel);
		division5.add(Spcialty);
		division5.add(spcialty);
		division5.add(Birthday);
		division5.add(birthday);
		
		division7.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		division7.add(Address);
		division7.add(address);
		division7.add(Tel);
		division7.add(tel);
		division7.add(Email);
		division7.add(email);
		division7.add(State);
		division7.add(state);
		division7.add(Remark);
		division7.add(remark);
	  
		division6.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));
		division6.add(insert);
		division6.add(update);
	//	division6.add(delete);
		
		division6.add(back);
		division6.setVisible(true);
		
		
		
		top.add(division1);
		top.add(division2);
		bottom.setLayout(new GridLayout(5, 1));
		bottom.add(division3);
		bottom.add(division4);
		bottom.add(division5);
		bottom.add(division7);
		bottom.add(division6);
	

	  // bottom.add(division6);
	   //bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		contentPane.setLayout(new GridLayout(2,1,20,0));
		contentPane.add(top);
		contentPane.add(bottom);
		//referStaff.setLayout(new GridLayout(2,1,20,0));
		//referStaff.add(top);
		//referStaff.add(bottom);
		referStaff.add(contentPane);
		top.setOpaque(false);
		division1.setOpaque(false);
		division2.setOpaque(false);
		bottom.setOpaque(false);
		division3.setOpaque(false);
		division4.setOpaque(false);
		division5.setOpaque(false);
		division6.setOpaque(false);
		division7.setOpaque(false);
		staffJScrollPane.setOpaque(false);
		StaffJTable.setOpaque(false);
		
		
		referStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		found.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!selectItem.getText().isEmpty()){
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryProcess(sQueryField,staffVector,StaffJTable);  
	    		}
	    	}
	    });
		
		foundAll.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryAllProcess(staffVector,StaffJTable);  
	    		
	    	}
	    });
		
		insert.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!name.getText().isEmpty()){
	    			count=refercount()+1;
	    			String pId =String.valueOf(count);
	    			String pName = name.getText().trim(); 
	    	    	String pSex= sex.getText().trim(); 
	    	    	String pPasswd = passwd.getText().trim(); 
	    	    	String pAuthority = authority.getText().trim();
	    	    	
	    	    	String pDepartment = department.getText().trim();
	    	    	String pJob = job.getText().trim(); 
	    	    	String pEdulevel= edulevel.getText().trim(); 
	    	    	String pSpcialty = spcialty.getText().trim(); 
	    	    	String pBitrhday = birthday.getText().trim(); 
	    	    	
	    	    	String pAddress = address.getText().trim();
	    	    	String pTel = tel.getText().trim(); 
	    	    	String pEmail= email.getText().trim(); 
	    	    	String pState = state.getText().trim(); 
	    	    	String pRemark = remark.getText().trim(); 
	    			
	    	    	addProcess(pId,pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBitrhday,pAddress,pTel,pEmail,pState,pRemark);
	    	    	queryAllProcess(staffVector,StaffJTable);  
	    		}
	    		
	    	}
	    });
		
		update.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!name.getText().isEmpty()){
	    	    	String pName = name.getText().trim(); 
	    	    	String pSex= sex.getText().trim(); 
	    	    	String pPasswd = MD5.encrypt(passwd.getText().trim()); 
	    	    	String pAuthority = authority.getText().trim();
	    	    	
	    	    	String pDepartment = department.getText().trim();
	    	    	String pJob = job.getText().trim(); 
	    	    	String pEdulevel= edulevel.getText().trim(); 
	    	    	String pSpcialty = spcialty.getText().trim(); 
	    	    	String pBitrhday = birthday.getText().trim(); 
	    	    	
	    	    	String pAddress = address.getText().trim();
	    	    	String pTel = tel.getText().trim(); 
	    	    	String pEmail= email.getText().trim(); 
	    	    	String pState = state.getText().trim(); 
	    	    	String pRemark = remark.getText().trim(); 
	    	    	
	    	    	UpdateProcess(pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBitrhday,pAddress,pTel,pEmail,pState,pRemark);
	    	    	queryAllProcess(staffVector,StaffJTable);
	    	    	JOptionPane.showMessageDialog(null, "更新成功","提示",JOptionPane.INFORMATION_MESSAGE); 
	    	    	name.setText("");
	    	    	sex.setText("");
	    	    	passwd.setText("");
	    	    	authority.setText("");
	    	    	department.setText("");
	    	    	job.setText("");
	    	    	edulevel.setText("");
	    	    	spcialty.setText("");
	    	    	birthday.setText("");
	    	    	address.setText("");
	    	    	tel.setText("");
	    	    	email.setText("");
	    	    	state.setText("");
	    	    	remark.setText("");
	    	    	
	    	    	
	    		}
	    		else
	    			JOptionPane.showMessageDialog(null, "请确认修改项！！","提示",JOptionPane.ERROR_MESSAGE); 	
	    	}
	    });
		
		
		 back.addMouseListener(new MouseAdapter(){
		    	public void mouseClicked(MouseEvent e){
		    		referStaff.setVisible(false);
		    		choice.setVisible(true);
		    		}
		    	});
		 
		 
	}
	
	public static void queryProcess(String sQueryField,Vector staffVector,JTable StaffJTable){
		try{
			String sql=null;
			if(Selectfield.equals("工号")){
			sql = "select pId,pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBirthday,pAddress,pTel,pEmail,pState,pRemark from person where ";
			sql = sql + "pId";
				sql = sql + " like ";
				sql = sql + "'" +'%' +sQueryField +'%' +"';";
		
			
			System.out.println("queryProcess(). sql = " + sql);
			}
			else if(Selectfield.equals("姓名")){
				sql = "select pId,pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBirthday,pAddress,pTel,pEmail,pState,pRemark from person where ";
				sql = sql + "pName";
				sql = sql + " like ";
				sql = sql + "'" +'%' +sQueryField +'%' +"';";
			
				
				System.out.println("queryProcess(). sql = " + sql);		
			}
	
			DbProcess.connect();
			
			 DbProcess.executeQuery(sql);   //结果集ResultSet
		
		//	while(DbProcess.rs.next()){
			//	System.out.println(DbProcess.rs.getString("pName"));
				//}
			
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			staffVector.clear();    
	while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pSex"));
				v.add(DbProcess.rs.getString("pPasswd"));
				v.add(DbProcess.rs.getString("pAuthority"));
				v.add(DbProcess.rs.getString("pDepartment"));
				v.add(DbProcess.rs.getString("pJob"));
				v.add(DbProcess.rs.getString("pEdulevel"));
				v.add(DbProcess.rs.getString("pSpcialty"));
				v.add(DbProcess.rs.getString("pBirthday"));
				v.add(DbProcess.rs.getString("pAddress"));
				v.add(DbProcess.rs.getString("pTel"));
				v.add(DbProcess.rs.getString("pEmail"));
				v.add(DbProcess.rs.getString("pState"));
				v.add(DbProcess.rs.getString("pRemark"));
				
				
				staffVector.add(v);
			}
	StaffJTable.updateUI();
			DbProcess.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
}
	
	public static void queryAllProcess(Vector staffVector,JTable StaffJTable)
	{
		try{
			// 建立查询条件
			String sql = "select * from person;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			DbProcess.connect();
			

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		
			
			 DbProcess.executeQuery(sql);   //结果集ResultSet
		
		//	while(DbProcess.rs.next()){
			//	System.out.println(DbProcess.rs.getString("pName"));
				//}
			
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			staffVector.clear();    
			while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pSex"));
				v.add( MD5.decrypt(DbProcess.rs.getString("pPasswd"))); 
				v.add(DbProcess.rs.getString("pAuthority"));
				v.add(DbProcess.rs.getString("pDepartment"));
				v.add(DbProcess.rs.getString("pJob"));
				v.add(DbProcess.rs.getString("pEdulevel"));
				v.add(DbProcess.rs.getString("pSpcialty"));
				v.add(DbProcess.rs.getString("pBirthday"));
				v.add(DbProcess.rs.getString("pAddress"));
				v.add(DbProcess.rs.getString("pTel"));
				v.add(DbProcess.rs.getString("pEmail"));
				v.add(DbProcess.rs.getString("pState"));
				v.add(DbProcess.rs.getString("pRemark"));
				
				staffVector.add(v);
			}
	StaffJTable.updateUI();
			DbProcess.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
}

public static void  UpdateProcess(String pName,String pSex,String pPasswd,String pAuthority,String pDepartment,String pJob,String pEdulevel,String pSpcialty,String pBirthday,String pAddress,String pTel,String pEmail,String pState,String pRemark)
{   
	//int QNo=AddStaff.refercount();
   // String qNo=String.valueOf(QNo+1);
	String sql = "update person set pSex = '";
	sql = sql + pSex + "', pPasswd = '";
	sql = sql + pPasswd + "', pAuthority = '";
	sql = sql + pAuthority + "', pDepartment = '";
	sql = sql + pDepartment + "', pJob = '";
	sql = sql + pJob + "', pEdulevel = '";
	sql = sql + pEdulevel + "', pSpcialty = '";
	sql = sql + pSpcialty + "', pBirthday = '";
	sql = sql + pBirthday + "', pAddress = '";
	sql = sql + pAddress + "', pEmail = '";
	sql = sql + pEmail + "', pState = '";
	sql = sql + pState + "', pRemark = '";
	sql = sql + pRemark + "'";
	sql = sql + " WHERE pName = '" + pName + "';";
	System.out.println("updateProcess(). sql = " + sql);
	try{
		if (DbProcess.executeUpdate(sql) < 1) {
			System.out.println("updateProcess(). update database failed.");
		}
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
	}

}

public static void  addProcess(String pId,String pName,String pSex,String pPasswd,String pAuthority,String pDepartment,String pJob,String pEdulevel,String pSpcialty,String pBirthday,String pAddress,String pTel,String pEmail,String pState,String pRemark)
{   
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
			
			
	       }
	}catch(Exception e){
		System.out.println("e = " + e);
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
