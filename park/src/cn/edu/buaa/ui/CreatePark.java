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
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;
//import java.awt.Dialog.ModalExclusionType;

import cn.edu.buaa.park.Park;
import  cn.edu.buaa.park.ParkManage;
import javax.swing.JTextArea;

public class CreatePark extends JFrame {

	private JPanel contentPane;
	JDialog dialog =null;
	private JTextField textField;
	private JTextField textField_1;
	ParkManage pm = ParkManage.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePark frame = new CreatePark();
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
	public CreatePark() {
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车场管理");
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("停车场名称：");
		lblNewLabel.setBounds(37, 24, 94, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确定");
		
		btnNewButton.setBounds(161, 88, 64, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(122, 21, 155, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("已建停车场：");
		lblNewLabel_1.setBounds(37, 126, 114, 15);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("车位数：");
		lblNewLabel_3.setBounds(56, 60, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 57, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(47, 151, 362, 168);
		contentPane.add(textArea);
		
		String txt="";
		
		for(int i=0;i<pm.getParkList().size();i++){
			
			Park pk=(Park)pm.getParkList().get(i);
			txt=txt+"编号："+pk.getCode()+"  名称："+pk.getParkName()+",车位数："+pk.getTotalNum()+ "\n";
		}
		textArea.setText(txt);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取停车场列表
				
				//创建停车场
				Park park=new Park(String.valueOf(pm.getParkList().size()+1),textField.getText(),Integer.parseInt(textField_1.getText()));
				
				//增加停车场
				pm.addPark(park);
				
				
				String txt="";
				for(int i=0;i<pm.getParkList().size();i++){
					
					Park pk=(Park)pm.getParkList().get(i);
					txt=txt+"编号："+pk.getCode()+" ,名称："+pk.getParkName() +",车位数："+pk.getTotalNum()+ "\n";
				}
				//列表显示
				
				textArea.setText(txt);
			}
		});
		this.addWindowFocusListener(new WindowFocusListener(){
			public void windowGainedFocus(WindowEvent e){}
			public void windowLostFocus(WindowEvent e){
			    e.getWindow().toFront();
			}
			});
	}
}
