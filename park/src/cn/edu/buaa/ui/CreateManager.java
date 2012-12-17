package cn.edu.buaa.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;
//import java.awt.Dialog.ModalExclusionType;
import java.util.Vector;

import cn.edu.buaa.park.Park;
import cn.edu.buaa.park.ParkBoy;
import  cn.edu.buaa.park.ParkManage;
import cn.edu.buaa.park.ParkManager;
import cn.edu.buaa.park.StrategyFactory;
import cn.edu.buaa.ui.JCheckListBox.CheckListBoxModel;


import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;


public class CreateManager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDialog dialog =null;
	private JTextField textField;
	ParkManage pm = ParkManage.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateManager frame = new CreateManager();
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
	public CreateManager() {
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车经理管理");
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("名称：");
		lblNewLabel.setBounds(39, 25, 94, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确定");
		
		btnNewButton.setBounds(132, 296, 64, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(132, 21, 155, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("停车场：");
		lblNewLabel_1.setBounds(39, 60, 114, 15);
		
		contentPane.add(lblNewLabel_1);
		
		Font font = new Font("微软雅黑", Font.PLAIN, 12);
				contentPane.add(new JScrollPane(), BorderLayout.CENTER);
		       
	
						//获取停车boy列表
						
						Vector<String> vtboy=new Vector<String>();
						for(int i=0;i<pm.getBoyList().size();i++){
							
							ParkBoy pkboy=(ParkBoy)pm.getBoyList().get(i);
							if(!pkboy.isManaged()){
								vtboy.add(pkboy.getCode()+" 名称："+pkboy.getName());
							}
							
						}
						
					
						Object[] obBoy=new Object[vtboy.size()];
						for(int j=0;j<vtboy.size();j++){
							obBoy[j]=vtboy.get(j).toString();
							
						}
		                
		                //添加停车boy列表
		                final JCheckListBox listboy = new JCheckListBox(obBoy);
		                listboy.setBounds(132, 108, 227, 160);
		                contentPane.add(listboy);
		                listboy.setFont(font);
		                
		                
		                JLabel lblboy = new JLabel("停车Boy列表：");
		                lblboy.setBounds(39, 157, 126, 15);
		                contentPane.add(lblboy);
		                
		                final JLabel labelboy = new JLabel("");
		                labelboy.setBounds(288, 284, 54, 15);
		                labelboy.setVisible(false);
		                contentPane.add(labelboy);
		                
		                final JComboBox comboBox = new JComboBox();
		                comboBox.setBounds(132, 57, 155, 21);
		                
		                for(int i=0;i<pm.getParkList().size();i++){
							
							Park pk=(Park)pm.getParkList().get(i);
							if(!pk.isManaged()){
								comboBox.addItem(pk.getCode()+" 名称："+pk.getParkName() +" 车位数："+pk.getTotalNum());						
							}

						}

		                contentPane.add(comboBox);
		                
		                
		                listboy.getModel().addListDataListener(new ListDataListener() {
		                	
            	            public void intervalAdded(ListDataEvent e) {
            	            	
            	            }
            	
            	            public void intervalRemoved(ListDataEvent e) {
            	            }
            	
            	            public void contentsChanged(ListDataEvent e) {
            	                if (listboy.getCheckedCount() == 0) {
            	                	labelboy.setText("");
            	                } else {
            	                    String text = "";
            	                    int[] indices = listboy.getCheckedIndices();
            	                    for (int i = 0; i < indices.length; i++) {
            	                    	text += ((CheckListBoxModel) listboy.getModel()).getItem(indices[i]).toString() + ",";
            	                    }
            	                    
            	                    labelboy.setText(text);
            	                }
            	            }
            	        });
		                
		                setVisible(true);
		                
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取停车场
				
				ParkManager pkm=new ParkManager(String.valueOf(pm.getManagerList().size()+1),textField.getText());
				
				if(comboBox.getSelectedIndex()!=-1){
					String num=comboBox.getSelectedItem().toString().split(" ")[0];
					
					for(int j=0;j<pm.getParkList().size();j++){
						
						Park pk=(Park)pm.getParkList().get(j);
						if(num.equals(pk.getCode())){
							pk.setManaged(true);
							
							//加入park管理系列
							pkm.handlePark(pk);
						}
						
					}
				}
				
				
				
				//加入停车管理boy
				
				String[] stboy=labelboy.getText().split(",");
				
				for(int i=0;i<stboy.length;i++){
					//获取停车场编号
					String num1=stboy[i].split(" ")[0];
					for(int j=0;j<pm.getBoyList().size();j++){
						
						ParkBoy pkBoy=(ParkBoy)pm.getBoyList().get(j);
						if(num1.equals(pkBoy.getCode())){
							pkBoy.setManaged(true);
							//加入停车boy管理系列
							pkm.getParkBoyList().add(pkBoy);
						}
						
					}
					
				}
				pm.getManagerList().add(pkm);
				dispose();
				
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
