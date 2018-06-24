package houseinfoemation;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.mysql.jdbc.PreparedStatement;
import java_work.ATM;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

public class house_pay {

	private JFrame frame;
	public String id;
	JTable t;
	Vector columnNames, rowData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					house_pay window = new house_pay("1");
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
	public house_pay(String id) {
		this.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\152d35494e0bf0cdbc0c6f3f7acd0aab.jpeg"));
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 12));
		frame.setBounds(100, 100, 511, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon(
				"C:\\Users\\Administrator\\eclipse-workspace\\house\\152d35494e0bf0cdbc0c6f3f7acd0aab.jpeg");
		// 要设置的背景图片
		JLabel imgLabel = new JLabel(img);
		// 将背景图放在标签里。
		frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		// 将背景标签添加到jfram的LayeredPane面板里。
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// 设置背景标签的位置
		Container contain = frame.getContentPane();
		((JComponent) contain).setOpaque(false);
		// 将内容面板设为透明。将LayeredPane面板中的背景显示出来。

		JButton button = new JButton("\u9009\u62E9\u8D2D\u4E70");
		button.setBounds(10, 210, 93, 23);
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u67E5\u8BE2\u623F\u5C4B");
		button_1.setBounds(275, 210, 147, 23);
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("\u5237\u65B0");
		button_2.setBounds(156, 210, 93, 23);
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		frame.getContentPane().add(button_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 505, 206);
		frame.getContentPane().add(scrollPane);

		try {

			columnNames = new Vector();

			columnNames.add("占用人ID");
			columnNames.add("房屋ID");
			columnNames.add("状态");
			columnNames.add("大小");
			columnNames.add("价格");
			columnNames.add("所属人");
			columnNames.add("所属人账户");

			rowData = new Vector();
			JDBC j = new JDBC();
			String sql = "select*from house_pay";
			Statement st = j.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Vector data = new Vector();
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getInt(4));
				data.add(rs.getInt(5));
				data.add(rs.getString(6));
				data.add(rs.getString(7));
				rowData.add(data);
			}

			rs.close();
			st.close();
			t = new JTable(rowData, columnNames);
			scrollPane.add(t);
			scrollPane.setViewportView(t);

		} catch (Exception e) {

			e.printStackTrace();

		}

		// 选择购买
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = JOptionPane.showInputDialog(null, "请输入房屋id：\n", "title", JOptionPane.PLAIN_MESSAGE);
				if (isexit(str) == false) {
					JDBC j = new JDBC();
					PreparedStatement st;
					String sta = null;
					try {
						st = (PreparedStatement) j.con.prepareStatement("select status from house_pay where id=?");
						st.setString(1, str);
						ResultSet rs = st.executeQuery();
						while (rs.next()) {
							sta = rs.getString("status");
						}
						if (sta.equals("占用")) {

							JOptionPane.showMessageDialog(null, "该房屋已被占用！");
						} else {

							// 购买操作 ，调用ATM机
							PreparedStatement tt = (PreparedStatement) j.con
									.prepareStatement("update  house_pay set status='占用' where id=?");
							tt.setString(1, str);
							tt.executeUpdate();
							tt.close();
							PreparedStatement t = (PreparedStatement) j.con
									.prepareStatement("update  house_pay set people=? where id=?");
							System.out.println(house_index.Did);
							t.setString(1, id);
							t.setString(2, str);
							t.executeUpdate();
							t.close();
							ATM m = new ATM();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "该ID不存在！");
				}
			}
		});

		// 刷新
		button_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.dispose();
				house_pay l = new house_pay(id);

			}
		});
		// 查询

		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				select_houseinfo info = new select_houseinfo();
			}
		});

	}

	public boolean isexit(String str) {
		JDBC j = new JDBC();
		try {
			Statement st = j.con.createStatement();
			ResultSet rs = st.executeQuery("select id from house_pay");
			while (rs.next()) {
				String str1 = rs.getString("id");
				if (str.equals(str1)) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}
