package cn.edu.buaa.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ParkMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDialog dialog =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkMain frame = new ParkMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParkMain() {
		setTitle("\u505C\u8F66\u573A\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
        JMenu m1 = new JMenu();
        m1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        m1.setText("\u7CFB\u7EDF\u7BA1\u7406");
        JMenu m2 = new JMenu();
        m2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        m2.setText("停车场管理");
        JMenu m3 = new JMenu();
        m3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        m3.setText("帮助");
        
        JMenuItem item11 = new JMenuItem();
        
        item11.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item11.setText("停车场管理");
        JMenuItem item12 = new JMenuItem();
        item12.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item12.setText("停车管理员");
        JMenuItem item14 = new JMenuItem();
        item14.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item14.setText("退出");
        JMenuItem item22 = new JMenuItem();

        item22.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item22.setText("经理");
        
        JMenuItem item31 = new JMenuItem();
        item31.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item31.setText("欢迎");
        JMenuItem item32 = new JMenuItem();
        item32.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item32.setText("版本信息");
        
        m1.add(item11);
        
        JMenuItem menu13 = new JMenuItem();
        
        menu13.setText("停车场经理");
        menu13.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        m1.add(menu13);
        m1.add(item12);
        m1.add(item14);
        
        JMenuItem item21 = new JMenuItem();

        item21.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        item21.setText("boy");
        
        m2.add(item21);
        m2.add(item22);
        
        m3.add(item31);
        m3.add(item32);
        
        menuBar.add(m1);
        menuBar.add(m2);
        
        JMenu m4 = new JMenu();
        menuBar.add(m4);
        m4.setText("报表管理");
        m4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        
        JMenuItem m41 = new JMenuItem();

        m41.setText("停车场经理");
        m41.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        m4.add(m41);
        
        JMenuItem m42 = new JMenuItem();

        m42.setText("停车场BOSS");
        m42.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        m4.add(m42);
        menuBar.add(m3);
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JLabel lblNewLabel = new JLabel("欢迎使用停车场管理系统");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		//创建停车场
		item11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {

        		new CreatePark().setVisible(true);
        	}
        });
		
		//创建停车场管理经理
		menu13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new CreateManager().setVisible(true);
        	}
        });
		
		//创建停车boy
		item12.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		new CreateBoy().setVisible(true);
		        	}
		});
        m41.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new ManagerReport().setVisible(true);
        	}
        });
        m42.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new BossReport().setVisible(true);
        	}
        });
        
        item21.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new ParkBoyOperator().setVisible(true);
        	}
        });
        
        item22.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
	}
	


}
