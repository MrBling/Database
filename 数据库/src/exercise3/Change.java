package exercise3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
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
import javax.swing.table.DefaultTableModel;


class BackgroundPanel6 extends JPanel  
{  
    Image im;  
    public BackgroundPanel6(Image im)  
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


public class Change {
	/*//static DbProcess dbProcess=null;
	static  JFrame changes=null;
	static 	JLabel SelectNo=null;
	static 	JTextField Selectno=null;

	static Vector titleVector = null;       //二维表标题部分
	 static Vector staffVector = null ;   //二维表下部分
	static JTable StaffJTable = null;
	static JLabel SelectType=null;
	static JComboBox<String> SelectField = null;
	static JLabel boring=null;
	static JTextField alter=null;
	
	static JButton ok=null;
	static	JButton back=null;
	static 	JButton found=null;
	
	
	static	 JPanel division1=null;
	static	 JPanel division2=null;
	static	 JPanel division3=null;
	static	 JPanel division4=null;
	
	static DefaultTableModel staffTableModel = null;
	
	static String Selectfield="职位调整";
	
	static JScrollPane staffJScrollPane=null;
	
	
	static ResultSet rs=null;
	*/

private static BackgroundPanel6 contentPane;
static String Selectfield="职位调整";
static String a1="";
static String b1="";
static String c1="";


	//static Vector<Vector<String>> staffVector = null ;
	//static JTable StaffJTable = null;
public static void changes(final JFrame choice){
     
	contentPane=new BackgroundPanel6((new ImageIcon("F:\\学习资料\\JAVA\\calculator\\数据库\\src\\exercise3\\1243123.png")).getImage());
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);
    contentPane.setSize( 500, 380);
	
	
	 final JFrame changes=new JFrame("人事变更");
	changes.setBounds(600, 350, 500, 380);
	changes.setLocationRelativeTo(changes.getOwner());

	changes.setVisible(true);
	//changes.setLayout(new GridLayout(4,1,20,25));
	contentPane.setLayout(new GridLayout(4,1,20,25));
	
	JLabel SelectNo=new JLabel("请输入有人事变动的员工号：");
	final JTextField Selectno=new JTextField(10);
	JButton found=new JButton("查询");
	
	
	Vector titleVector = new Vector();       //二维表标题部分
	final Vector staffVector = new Vector();     //二维表下部分
	
	titleVector.add("工号");
	titleVector.add("姓名");
	titleVector.add("所在部门");
	titleVector.add("职位");
	titleVector.add("当前状态");
	
	final JTable StaffJTable = new JTable(staffVector, titleVector);
	StaffJTable.setPreferredScrollableViewportSize(new Dimension(385,100));
	
	JScrollPane staffJScrollPane = new JScrollPane(StaffJTable);
	//分别设置水平和垂直滚动条自动出现
	staffJScrollPane.setHorizontalScrollBarPolicy(                
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // 当需要时则出现滚动条
	staffJScrollPane.setVerticalScrollBarPolicy(                
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	

	
	
	
	JLabel SelectType=new JLabel("修改项目：");
	JComboBox SelectField = new JComboBox<String>();
	SelectField.addItem("职位调整");
	SelectField.addItem("部门调整");
	SelectField.addItem("员工辞退");
	
	SelectField.addItemListener(new ItemListener() {//下拉框事件监听  
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
	
	
	JLabel boring=new JLabel("=");
	final JTextField alter=new JTextField(10);
	
	JButton ok=new JButton("确认修改");
	JButton back=new JButton("返回");
	
	
	 JPanel division1=new  JPanel();
	 division1.setLayout(new FlowLayout(FlowLayout.CENTER,5,20));
	 division1.add(SelectNo);
	 division1.add(Selectno);
	 division1.add(found);
	 
	 JPanel division2=new  JPanel();
	 division2.add(staffJScrollPane);
	 
	 JPanel division3=new  JPanel();
	 division3.add(SelectType);
	 division3.add(SelectField);
	 division3.add(boring);
	 division3.add(alter);
	 
	 JPanel division4=new  JPanel();
	 division4.add(ok);
	 division4.add(back);
	 division4.setLayout(new FlowLayout(FlowLayout.CENTER,70,0));
	 
	 contentPane.add(division1);
	 contentPane.add(division2);
	 contentPane.add(division3);
	 contentPane.add(division4);
	 
	 division1.setOpaque(false);
	 division2.setOpaque(false);
	 division3.setOpaque(false);
	 division4.setOpaque(false);
	 
	 changes.add(contentPane);
	 
	 back.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		changes.setVisible(false);
	    		choice.setVisible(true);
	 }
                });
	 
	 found.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    if(!Selectno.getText().isEmpty()){
	    	String sQueryField = Selectno.getText().trim(); 
	    	
	    	queryProcess(sQueryField,staffVector,StaffJTable);           
	    	System.out.println(a1+" "+b1+" "+c1);
	    }
	    		
	    		
	    		}
	});
	 
	 ok.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		String sQueryField = Selectno.getText().trim();  
	    		String update=alter.getText().trim(); 
	    		if(!update.equals("")){
	    		System.out.println(sQueryField+"   "+update);
	    		Update(sQueryField,update);
	    		addRecord(sQueryField,update);
	    		queryProcess(sQueryField,staffVector,StaffJTable );
	    		JOptionPane.showMessageDialog(null, "修改成功","提示",JOptionPane.INFORMATION_MESSAGE); 
	    		alter.setText("");
	    		
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "请确认修改项！！","提示",JOptionPane.ERROR_MESSAGE); 	
	    		}
	    		
	    }
	});
	 
	 changes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
}

public static   void addRecord(String sQueryField,String update){
	
	System.out.println(sQueryField+"   "+update);
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
	System.out.println(Id);
	String PId=sQueryField;
	System.out.println(PId);
	System.out.println(Selectfield);
	
	try{String sql = null;	
		if(Selectfield.equals("职位调整"))
	{  
		String pChange="1";
		String pDescription="员工号:  "+PId+" ,由"+b1+"调整至"+update;
		 sql="insert into personnel values('";
		sql=sql+Id+"','";
		sql=sql+PId+"','";
		sql=sql+pChange+"','";
		sql = sql +pDescription + "');";
		System.out.println("addProcess().sql="+sql);
	}
	else if(Selectfield.equals("部门调整")){
		String pChange="1";
		String pDescription="员工号:  "+PId+" ,由"+a1+"调整至"+update;
		 sql="insert into personnel values('";
		sql=sql+Id+"','";
		sql=sql+PId+"','";
		sql=sql+pChange+"','";
		sql = sql +pDescription + "');";
	}
	else if(Selectfield.equals("员工辞退")){
		String pChange="2";
		String pDescription="员工号:  "+PId+" ,由"+c1+" 状态变为"+update+"状态";
		sql="insert into personnel values('";
		sql=sql+Id+"','";
		sql=sql+PId+"','";
		sql=sql+pChange+"','";
		sql = sql +pDescription + "');";
		System.out.println("addProcess().sql="+sql);
		}
		
	
		
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


public static   void queryProcess(String sQueryField,Vector staffVector,JTable StaffJTable ){
	
		try{
			String sql = "select pId,pName,pDepartment,pJob,pState from person where ";
			String queryFieldStr = "pId";
	
		
			
				
				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";
		
			
			System.out.println("queryProcess(). sql = " + sql);
	
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
				v.add(DbProcess.rs.getString("pDepartment"));
				a1=DbProcess.rs.getString("pDepartment");
				v.add(DbProcess.rs.getString("pJob"));
				b1=DbProcess.rs.getString("pJob");
				v.add(DbProcess.rs.getString("pState"));
				c1=DbProcess.rs.getString("pState");
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

public static void Update(String sQueryField,String update){
	String sql = null;
	if(Selectfield.equals("职位调整"))
	{
		sql = "update person set pJob = '";
	sql = sql + update + "'";
	sql = sql + " WHERE pId = '" + sQueryField + "';";
	}
	else if(Selectfield.equals("部门调整")){
		sql = "update person set pDepartment = '";
		sql = sql + update + "'";
		sql = sql + " WHERE pId = '" + sQueryField + "';";
	}
	else if(Selectfield.equals("员工辞退")){
		sql = "update person set pState = '";
		sql = sql + update + "'";
		sql = sql + " WHERE pId = '" + sQueryField + "';";
	}
	System.out.println("Update(). sql = " + sql);
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
	
	
}
