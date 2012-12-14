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
import cn.edu.buaa.park.ParkManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;


public class ManagerOperator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDialog dialog =null;
	ParkManage pm = ParkManage.getInstance();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerOperator frame = new ManagerOperator();
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
	public ManagerOperator() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车场经理操作");
		setBounds(100, 100, 490, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("停车");
		
		btnNewButton.setBounds(196, 104, 64, 23);
		contentPane.add(btnNewButton);

		JLabel lblboy = new JLabel("停车场经理：");
		lblboy.setBounds(20, 21, 94, 15);
		contentPane.add(lblboy);
		                
		 final JComboBox comboBox = new JComboBox();
		 
		 //获取停车场经理
		 Vector<String> vt=new Vector<String>();
		
		 vt.add("请选择停车场经理");
		 
		 for(int i=0;i<pm.getManagerList().size();i++){
			 ParkManager pb=(ParkManager)pm.getManagerList().get(i);
			 //管理有停车场经理
			 vt.add(pb.getCode() + " " + pb.getName());
			 
			
		 }
		 comboBox.setModel(new DefaultComboBoxModel(vt.toArray()));
		 comboBox.setSelectedIndex(0);
		 comboBox.setBounds(96, 14, 197, 28);
		 contentPane.add(comboBox);
		 
		 JButton btnNewButton_1 = new JButton("取车");
		
		 btnNewButton_1.setBounds(196, 137, 64, 23);
		 contentPane.add(btnNewButton_1);
		 
		 final JTextArea textArea_1 = new JTextArea();
		 textArea_1.setText("停车场信息");
		 textArea_1.setEditable(false);
		 textArea_1.setBounds(274, 71, 194, 104);
		 contentPane.add(textArea_1);
		 
		 final JLabel lblNewLabel = new JLabel("欢迎光临！");
		 lblNewLabel.setBounds(20, 71, 231, 23);
		 contentPane.add(lblNewLabel);
		 
		 textField = new JTextField();
		 textField.setBounds(84, 104, 90, 21);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_1 = new JLabel("车牌号：");
		 lblNewLabel_1.setBounds(20, 104, 54, 15);
		 contentPane.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("停车票号：");
		 lblNewLabel_2.setBounds(20, 135, 79, 23);
		 contentPane.add(lblNewLabel_2);
		 
		 textField_1 = new JTextField();
		 textField_1.setBounds(84, 135, 94, 21);
		 contentPane.add(textField_1);
		 textField_1.setColumns(10);
		 
		 JLabel lblNewLabel_3 = new JLabel("-----------------------------------------------------------------");
		 lblNewLabel_3.setBounds(30, 46, 454, 15);
		 contentPane.add(lblNewLabel_3);
		 
		 JLabel label = new JLabel("-----------------------------------------------------------------");
		 label.setBounds(41, 185, 454, 15);
		 contentPane.add(label);
		 
		 JLabel lblNewLabel_4 = new JLabel("停车Boy：");
		 lblNewLabel_4.setBounds(20, 210, 79, 15);
		 contentPane.add(lblNewLabel_4);
		 
		 final JComboBox comboBox_1 = new JComboBox();
		 comboBox_1.setBounds(98, 203, 228, 28);
		 contentPane.add(comboBox_1);
		 
		 final JTextArea textArea_2 = new JTextArea();
		 textArea_2.setText("管理停车场信息");
		 textArea_2.setBounds(4, 238, 225, 206);
		 contentPane.add(textArea_2);
		 
		 final JLabel label_1 = new JLabel("欢迎光临");
		 label_1.setBounds(239, 233, 229, 23);
		 contentPane.add(label_1);
		 
		 JLabel label_2 = new JLabel("车牌号：");
		 label_2.setBounds(239, 266, 54, 15);
		 contentPane.add(label_2);
		 
		 textField_2 = new JTextField();
		 textField_2.setColumns(10);
		 textField_2.setBounds(295, 263, 95, 21);
		 contentPane.add(textField_2);
		 
		 JLabel label_3 = new JLabel("停车票号：");
		 label_3.setBounds(231, 294, 79, 15);
		 contentPane.add(label_3);
		 
		 textField_3 = new JTextField();
		 textField_3.setColumns(10);
		 textField_3.setBounds(295, 291, 95, 21);
		 contentPane.add(textField_3);
		 
		 JButton button = new JButton("停车");
		 
		 button.setBounds(400, 262, 64, 23);
		 contentPane.add(button);
		 
		 JButton button_1 = new JButton("取车");
		
		 button_1.setBounds(400, 290, 64, 23);
		 contentPane.add(button_1);
		                       
		 setVisible(true);
		                
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取停车场列表
				
				String id= comboBox.getSelectedItem().toString().split(" ")[0];
				
				for(int i=0;i<pm.getManagerList().size();i++){
					 ParkManager pb=(ParkManager)pm.getManagerList().get(i);
					 
					 //管理有停车场
					
					 if(id.equals(pb.getCode())){
						 
							 lblNewLabel.setText(pb.inCar(textField.getText().trim()));
							
							//停车场信息
							 
							 textArea_1.setText(pb.printParkInfoBySingle());
							 
							 //停车场经理车库已满，停到停车boy停车场车辆
							 
							 if(pb.getPark().getEmptyNum()==0){
								//获取停车场列表
									
									String idboy= comboBox_1.getSelectedItem().toString().split(" ")[0];
									
									for(int k=0;k<pm.getBoyList().size();k++){
										 ParkBoy pbr=(ParkBoy)pm.getBoyList().get(k);
										 //管理有停车场
										 if(pbr.getParkList().size()>0){
											 if(idboy.equals(pbr.getCode())){
												 
												//停车场信息
												 textArea_2.setText(pbr.printParkInfoForBoy());
												
											 }
											
										 }
									 }
								 
								 
							 }

					 }
				 }
				//dispose();
				
			}
		});
		
		 btnNewButton_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String id= comboBox.getSelectedItem().toString().split(" ")[0];
					
					for(int i=0;i<pm.getManagerList().size();i++){
						ParkManager pb=(ParkManager)pm.getManagerList().get(i);
						 //管理有停车场
						 
							 if(id.equals(pb.getCode())){
								 
								 lblNewLabel.setText(pb.outCar(textField_1.getText().trim()));
								
								//停车场信息
								 textArea_1.setText(pb.printParkInfoBySingle());
								 
								 
								 String idboy= comboBox_1.getSelectedItem().toString().split(" ")[0];
									
									for(int k=0;k<pm.getBoyList().size();k++){
										 ParkBoy pbr=(ParkBoy)pm.getBoyList().get(k);
										 //管理有停车场
										 if(pbr.getParkList().size()>0){
											 if(idboy.equals(pbr.getCode())){
												 
												//停车场信息
												 textArea_2.setText(pbr.printParkInfoForBoy());
												
											 }
											
										 }
									 }
								
							 }
							
						 
					 }
			 	}
			 });
		
		comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String id= comboBox.getSelectedItem().toString().split(" ")[0];
		 		if(id==null || id.equals("请选择停车场经理")){
		 			
		 			textArea_1.setText("");
		 			
		 			textArea_2.setText("");
		 			
		 			comboBox_1.setModel(new DefaultComboBoxModel());
		 			
		 		}else{
		 			
		 			for(int i=0;i<pm.getManagerList().size();i++){
						 ParkManager pkm=(ParkManager)pm.getManagerList().get(i);
						 //管理有停车场,目前一个
							 if(id.equals(pkm.getCode())){
								 Park pk=pkm.getPark();
								//停车场信息
								 textArea_1.setText(pkm.printParkInfoBySingle());
								 
								 //管理停车boy
								 Vector<String> vtBoy=new Vector<String>();
								 vtBoy.add("请选择停车管理员");
								
								 for(int j=0;j<pkm.getParkBoyList().size();j++){
									 ParkBoy pboy=(ParkBoy)pkm.getParkBoyList().get(j);
									 vtBoy.add(pboy.getCode() + " " + pboy.getName()+ " "+ pboy.getStrategy().getStrategyName());
								 }
								 comboBox_1.setModel(new DefaultComboBoxModel(vtBoy.toArray()));
							 }
					 }
		 		}
		 		
		 		
		 	}
		 });
		
		 comboBox_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String id= comboBox_1.getSelectedItem().toString().split(" ")[0];
			 		if(id==null || id.equals("请选择停车管理员")){

			 			textArea_2.setText("");
			 		}else{
			 			for(int i=0;i<pm.getManagerList().size();i++){
							 ParkManager pkm=(ParkManager)pm.getManagerList().get(i);
							 //管理有停车场,目前一个
									 for(int j=0;j<pkm.getParkBoyList().size();j++){
										 ParkBoy pb=(ParkBoy)pkm.getParkBoyList().get(j);
										 //管理有停车场
										 if(pb.getParkList().size()>0){
												//停车场信息
												textArea_2.setText(pb.printParkInfoForBoy());

										 }
									 }
									
								 
						 }
			 		}
			 	}
			 });
		 
		 button.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		//获取停车场列表
					
					String id= comboBox_1.getSelectedItem().toString().split(" ")[0];
					
					for(int i=0;i<pm.getBoyList().size();i++){
						 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
						 //管理有停车场
						 if(pb.getParkList().size()>0){
							 if(id.equals(pb.getCode())){
								 
								 label_1.setText(pb.inCar(textField_2.getText().trim()));
								
								//停车场信息
								 
								 textArea_2.setText(pb.printParkInfoForBoy());
								
							 }
							
						 }
					 }
			 	}
			 });
		 button_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		
			 		String id= comboBox.getSelectedItem().toString().split(" ")[0];
					
					for(int i=0;i<pm.getBoyList().size();i++){
						 ParkBoy pb=(ParkBoy)pm.getBoyList().get(i);
						 //管理有停车场
						 if(pb.getParkList().size()>0){
							 if(id.equals(pb.getCode())){
								 
								 label_1.setText(pb.outCar(textField_3.getText().trim()));
								
								//停车场信息
								 
								 textArea_2.setText(pb.printParkInfoForBoy());
								
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
