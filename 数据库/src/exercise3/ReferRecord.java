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

class BackgroundPanel8 extends JPanel  
{  
    Image im;  
    public BackgroundPanel8(Image im)  
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






public class ReferRecord {
	private static BackgroundPanel8 contentPane;
	static String Selectfield="记录编号";
	
	public static void referRecord(final JFrame choice){
		
		
		contentPane=new BackgroundPanel8((new ImageIcon("F:\\学习资料\\JAVA\\calculator\\数据库\\src\\exercise3\\56565656.jpg")).getImage());
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    contentPane.setSize( 700, 450);
	    
	    
		final JFrame referRecord=new JFrame("人事变更记录");
		referRecord.setBounds(200, 200,814, 516);
		referRecord.setLocationRelativeTo(referRecord.getOwner());

		referRecord.setVisible(true);
		JLabel title=new JLabel("人事变更记录",JLabel.CENTER);
		
		Vector titleVector = new Vector();       //二维表标题部分
		final Vector RecordVector = new Vector();     //二维表下部分
		titleVector.add("记录编号");
		titleVector.add("员工号");
		titleVector.add("变动");
		titleVector.add("详细描述");
		
		
		JLabel Id=new JLabel("记录编号",JLabel.CENTER);
		JLabel pId=new JLabel("员工号",JLabel.CENTER);
		JLabel pChange=new JLabel("变更代码",JLabel.CENTER);
		JLabel pDescription=new JLabel("详细记录",JLabel.CENTER);
		
		final JTextField id=new JTextField(15);
		final JTextField pid=new JTextField(15);
		final JTextField pchange=new JTextField(15);
		final JTextField pdescription=new JTextField(15);
		
		final JTable StaffJTable = new JTable(RecordVector, titleVector);
		StaffJTable.setPreferredScrollableViewportSize(new Dimension(690,130));
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
				v = (Vector) RecordVector.get(row);

				id.setText((String) v.get(0));// 
				pid.setText((String) v.get(1));// 
				pchange.setText((String) v.get(2));// 
				pdescription.setText((String) v.get(3));// 
				
				
			}
		});
		
		
		JLabel SelectField =new JLabel("选择查询字段");    //选择查询字段
		JComboBox<String> Select = new JComboBox<String>();
		Select.addItem("记录编号");
		Select.addItem("员工号");
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
		JLabel boring =new JLabel("=");         //=
		final JTextField selectItem=new JTextField(10);
		JButton found=new JButton("查询");
		JButton foundAll=new JButton("查询所有记录");
		JButton back=new JButton("返回");
		
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
		
		
		division4.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		division4.add(Id);
		division4.add(id);
		division4.add(pId);
		division4.add(pid);
		
		division5.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		division5.add(pChange);
		division5.add(pchange);
		division5.add(pDescription);
		division5.add(pdescription);
		
		division6.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));
		division6.add(back);
		
		top.add(division1);
		top.add(division2);
		
		bottom.setLayout(new GridLayout(4, 1,0,0));
		bottom.add(division3);
		bottom.add(division4);
		bottom.add(division5);
		bottom.add(division6);
		
	//	referRecord.setLayout(new GridLayout(2,1,20,0));
	//	referRecord.add(top);
	//	referRecord.add(bottom);
		
		contentPane.setLayout(new GridLayout(2,1,10,0));
		contentPane.add(top);
		contentPane.add(bottom);
		//referStaff.setLayout(new GridLayout(2,1,20,0));
		//referStaff.add(top);
		//referStaff.add(bottom);
		referRecord.add(contentPane);
		top.setOpaque(false);
		division1.setOpaque(false);
		division2.setOpaque(false);
		bottom.setOpaque(false);
		division3.setOpaque(false);
		division4.setOpaque(false);
		division5.setOpaque(false);
		division6.setOpaque(false);
		division7.setOpaque(false);
		

		
		found.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!selectItem.getText().isEmpty()){
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryProcess(sQueryField,RecordVector,StaffJTable);  
	    		}
	    	}
	    });
		
		foundAll.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryAllProcess(RecordVector,StaffJTable);  
	    		
	    	}
	    });
		
		 back.addMouseListener(new MouseAdapter(){
		    	public void mouseClicked(MouseEvent e){
		    		referRecord.setVisible(false);
		    		choice.setVisible(true);
		    		}
		    	});
		
	}
	
	
	public static void queryProcess(String sQueryField,Vector RecordVector,JTable StaffJTable){
		try{
			String sql=null;
			if(Selectfield.equals("记录编号")){
			sql = "select Id,pId,pChange,pDescription from personnel where ";
			sql = sql + "Id";
			sql = sql + " like ";
			sql = sql + "'" +'%' +sQueryField +'%' +"';";
		
			
			System.out.println("queryProcess(). sql = " + sql);
			}
			else if(Selectfield.equals("员工号")){
				sql = "select Id,pId,pChange,pDescription from personnel where ";
				sql = sql + "pId";
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
			 RecordVector.clear();    
	while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pChange"));
				v.add(DbProcess.rs.getString("pDescription"));
			
				
				RecordVector.add(v);
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
	
	public static void queryAllProcess(Vector RecordVector,JTable StaffJTable)
	{
		try{
			// 建立查询条件
			String sql = "select * from personnel;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			DbProcess.connect();
			

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			
			
			 DbProcess.executeQuery(sql);   //结果集ResultSet
		
		//	while(DbProcess.rs.next()){
			//	System.out.println(DbProcess.rs.getString("pName"));
				//}
			
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			 RecordVector.clear();    
			while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pChange"));
				v.add(DbProcess.rs.getString("pDescription"));
				
				RecordVector.add(v);
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
}
