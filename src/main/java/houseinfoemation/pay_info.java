package houseinfoemation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class pay_info {

	private JFrame frame;
	public String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay_info window = new pay_info("1");
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
	public pay_info(String id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\1b9e477d6ab34c122ed80d122eaf2690.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -2748426784349171958L;

			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(
						"C:\\Users\\Administrator\\eclipse-workspace\\house\\1b9e477d6ab34c122ed80d122eaf2690.jpg");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}

		};
		panel_1.setBounds(0, 0, 434, 262);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("    \u4E8C\u624B\u623F\u4E70\u5356\u4E2D\u5FC3");
		label.setForeground(new Color(139, 0, 0));
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(100, 10, 198, 36);
		panel_1.add(label);
		
		JButton btnNewButton = new JButton("\u6211\u8981\u4E70\u623F");
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(32, 106, 93, 85);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("\u6211\u8981\u5356\u623F");
		button.setBackground(new Color(253, 245, 230));
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(270, 106, 93, 85);
		panel_1.add(button);
		
		//我要买房
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				house_pay HOUSE_PAY=new house_pay(id);
				
			}
		});
		
		//我要卖房
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				house_sell HOUSE_SELL=new house_sell(id);
					
			}
		});
	}
}
