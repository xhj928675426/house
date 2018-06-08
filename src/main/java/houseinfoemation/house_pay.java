package houseinfoemation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.standard.PresentationDirection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import java_work.ATM;
public class house_pay {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					house_pay window = new house_pay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public house_pay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JButton button = new JButton("\u9009\u62E9\u8D2D\u4E70");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(10, 210, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u623F\u5C4B");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(275, 210, 93, 23);
		frame.getContentPane().add(button_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(0, 10, 440, 170);
		frame.getContentPane().add(textArea);
		JButton button_2 = new JButton("\u5237\u65B0");
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		button_2.setBounds(156, 210, 93, 23);
		
		try {
		
		JDBC j=new JDBC();
		String text="姓名:";
		String sql="select*from house_pay";
		Statement st=j.con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			text+=rs.getString("people");
			text+="\t"+"id: "+rs.getString("id");
			text+="\t"+"状态： "+rs.getString("status");
			text+="\t"+"平方米： "+rs.getString("squer");
			text+="\t"+"价格： "+rs.getString("money");
			text+="\t"+"所属人： "+rs.getString("whoes");
			text+="\t"+"所属人账户："+rs.getString("accountnumber");
		}
		textArea.setText(text);
		
	
		frame.getContentPane().add(button_2);
		rs.close();
		st.close();
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
		}
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str=JOptionPane.showInputDialog(null,"请输入房屋id：\n","title",JOptionPane.PLAIN_MESSAGE);
				JDBC j=new JDBC();
				PreparedStatement st;
				String sta=null;
				try {
					st = (PreparedStatement) j.con.prepareStatement("select status from house_pay where id=?");
					st.setString(1, str);
					ResultSet rs=st.executeQuery();
					while(rs.next()) {
						sta=rs.getString("status");
					}
					if(sta.equals("占用")) {
					
						JOptionPane.showMessageDialog(null, "该房屋已被占用！");
					}else {
						
						//购买操作 ，调用ATM机
						PreparedStatement tt=(PreparedStatement) j.con.prepareStatement("update  house_pay set status='占用' where id=?");
						tt.setString(1, str);
						tt.executeUpdate();	
						ATM m=new ATM();				 	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		
		
		//刷新
		button_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			frame.dispose();
			house_pay l=new house_pay();
				
			}
		});
		
		
		
	}
}
