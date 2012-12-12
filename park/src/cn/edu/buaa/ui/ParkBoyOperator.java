package cn.edu.buaa.ui;


import java.awt.EventQueue;


import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
		setBounds(100, 100, 490, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("停车");
		
		btnNewButton.setBounds(179, 196, 64, 23);
		contentPane.add(btnNewButton);

		JLabel lblboy = new JLabel("停车Boy：");
		lblboy.setBounds(39, 21, 94, 15);
		contentPane.add(lblboy);
		                
		 final JComboBox comboBox = new JComboBox();
		 
		 //获取停车Boy列表
		 Vector<String> vt=new Vector<String>();
		 vt.add("");
		 for(int i=0;i<pm.getBoyList().size();i++){
			 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
			 //管理有停车场
			 if(pb.getParkList().size()>0){
				 vt.add(pb.getCode() + " " + pb.getName());
			 }
		 }
		 comboBox.setModel(new DefaultComboBoxModel(vt.toArray()));
		 comboBox.setSelectedIndex(0);
		 comboBox.setBounds(114, 14, 164, 28);
		 contentPane.add(comboBox);
		 
		 final JTextArea textArea = new JTextArea();
		 textArea.setBounds(114, 54, 244, 78);
		 contentPane.add(textArea);
		 
		 JButton btnNewButton_1 = new JButton("取车");
		
		 btnNewButton_1.setBounds(179, 278, 64, 23);
		 contentPane.add(btnNewButton_1);
		 
		 final JTextArea textArea_1 = new JTextArea();
		 textArea_1.setEditable(false);
		 textArea_1.setBounds(253, 175, 211, 244);
		 contentPane.add(textArea_1);
		 
		 final JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(14, 142, 407, 23);
		 contentPane.add(lblNewLabel);
		 
		 textField = new JTextField();
		 textField.setBounds(79, 197, 90, 21);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_1 = new JLabel("车牌号：");
		 lblNewLabel_1.setBounds(14, 200, 54, 15);
		 contentPane.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("停车票号：");
		 lblNewLabel_2.setBounds(10, 254, 79, 15);
		 contentPane.add(lblNewLabel_2);
		 
		 textField_1 = new JTextField();
		 textField_1.setBounds(39, 279, 115, 21);
		 contentPane.add(textField_1);
		 textField_1.setColumns(10);
		                
		                
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
		 		if(id==null || id.equals("")){
		 			textArea.setText("");
		 			textArea_1.setText("");
		 		}
		 		
		 		for(int i=0;i<pm.getBoyList().size();i++){
					 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
					 //管理有停车场
					 if(pb.getParkList().size()>0){
						 if(id.equals(pb.getCode())){
							 textArea.setText("名称："+pb.getName()+", 策略："+pb.getStrategy().getStrategyName() + "\n");
							 for(int j=0;j<pb.getParkList().size();j++){
								 Park pk=(Park)pb.getParkList().get(j);
								 textArea.setText(textArea.getText() + "停车场编号：" + pk.getCode()+", 名称:"+pk.getParkName() + ",车位数:"+ pk.getTotalNum() +"\n"); 
							 }
							 
							//停车场信息
							 
							 textArea_1.setText(pb.printParkInfoForBoy());
							
						 }
						
					 }
				 }
		 		
		 		
		 		
		 		
		 		
		 	}
		 });
	}
}
