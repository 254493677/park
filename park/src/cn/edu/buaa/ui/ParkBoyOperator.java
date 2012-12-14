package cn.edu.buaa.ui;


import java.awt.EventQueue;


import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.util.Vector;

import cn.edu.buaa.park.Park;
import cn.edu.buaa.park.ParkBoy;
import  cn.edu.buaa.park.ParkManage;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;


public class ParkBoyOperator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDialog dialog =null;
	ParkManage pm = ParkManage.getInstance();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkBoyOperator frame = new ParkBoyOperator();
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
	public ParkBoyOperator() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车Boy操作");
		setBounds(100, 100, 490, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("停车");
		
		btnNewButton.setBounds(179, 116, 64, 23);
		contentPane.add(btnNewButton);

		JLabel lblboy = new JLabel("停车Boy：");
		lblboy.setBounds(14, 21, 94, 15);
		contentPane.add(lblboy);
		                
		 final JComboBox comboBox = new JComboBox();
		 
		 //获取停车Boy列表
		 Vector<String> vt=new Vector<String>();
		 vt.add("请选择停车Boy");
		 for(int i=0;i<pm.getBoyList().size();i++){
			 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
			 //管理有停车场
			 if(pb.getParkList().size()>0){
				 vt.add(pb.getCode() + " " + pb.getName()+ " "+ pb.getStrategy().getStrategyName());
			 }
		 }
		 comboBox.setModel(new DefaultComboBoxModel(vt.toArray()));
		 comboBox.setSelectedIndex(0);
		 comboBox.setBounds(65, 14, 277, 28);
		 contentPane.add(comboBox);
		 
		 JButton btnNewButton_1 = new JButton("取车");
		
		 btnNewButton_1.setBounds(179, 160, 64, 23);
		 contentPane.add(btnNewButton_1);
		 
		 final JTextArea textArea_1 = new JTextArea();
		 textArea_1.setEditable(false);
		 textArea_1.setBounds(253, 75, 211, 198);
		 contentPane.add(textArea_1);
		 
		 final JLabel lblNewLabel = new JLabel("欢迎光临");
		 lblNewLabel.setBounds(14, 75, 229, 23);
		 contentPane.add(lblNewLabel);
		 
		 textField = new JTextField();
		 textField.setBounds(69, 117, 100, 21);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_1 = new JLabel("车牌号：");
		 lblNewLabel_1.setBounds(14, 120, 54, 15);
		 contentPane.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("停车票号：");
		 lblNewLabel_2.setBounds(10, 164, 79, 15);
		 contentPane.add(lblNewLabel_2);
		 
		 textField_1 = new JTextField();
		 textField_1.setBounds(75, 161, 94, 21);
		 contentPane.add(textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel label = new JLabel("-----------------------------------------------------------------");
		 label.setBounds(14, 46, 454, 15);
		 contentPane.add(label);
		                
		                
		 setVisible(true);
		                
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取停车场列表
				
				String id= comboBox.getSelectedItem().toString().split(" ")[0];
				
				for(int i=0;i<pm.getBoyList().size();i++){
					 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
					 //管理有停车场
					 if(pb.getParkList().size()>0){
						 if(id.equals(pb.getCode())){
							 
							 lblNewLabel.setText(pb.inCar(textField.getText().trim()));
							
							//停车场信息
							 
							 textArea_1.setText(pb.printParkInfoForBoy());
							
						 }
						
					 }
				 }
				//dispose();
				
			}
		});
		
		 btnNewButton_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String id= comboBox.getSelectedItem().toString().split(" ")[0];
					
					for(int i=0;i<pm.getBoyList().size();i++){
						 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
						 //管理有停车场
						 if(pb.getParkList().size()>0){
							 if(id.equals(pb.getCode())){
								 
								 lblNewLabel.setText(pb.outCar(textField_1.getText().trim()));
								
								//停车场信息
								 
								 textArea_1.setText(pb.printParkInfoForBoy());
								
							 }
							
						 }
					 }
			 	}
			 });
		
		comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String id= comboBox.getSelectedItem().toString().split(" ")[0];
		 		if(id==null || id.equals("请选择停车Boy")){
		 			
		 			textArea_1.setText("");
		 		}
		 		
		 		for(int i=0;i<pm.getBoyList().size();i++){
					 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
					 //管理有停车场
					 if(pb.getParkList().size()>0){
						 if(id.equals(pb.getCode())){
							
							//停车场信息
							 
							 textArea_1.setText(pb.printParkInfoForBoy());
							
						 }
						
					 }
				 }
		 		
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
