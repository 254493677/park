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
import java.awt.Dialog.ModalExclusionType;
import java.util.Vector;

import cn.edu.buaa.park.Park;
import cn.edu.buaa.park.ParkBoy;
import  cn.edu.buaa.park.ParkManage;
import cn.edu.buaa.park.StrategyFactory;
import cn.edu.buaa.ui.JCheckListBox.CheckListBoxModel;


import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class CreateBoy extends JFrame {

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
					CreateBoy frame = new CreateBoy();
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
	public CreateBoy() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车Boy管理");
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Boy名称：");
		lblNewLabel.setBounds(39, 25, 94, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确定");
		
		btnNewButton.setBounds(132, 296, 64, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(132, 21, 155, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("停车场列表：");
		lblNewLabel_1.setBounds(39, 95, 114, 15);
		
		contentPane.add(lblNewLabel_1);
		
		Font font = new Font("微软雅黑", Font.PLAIN, 12);
				contentPane.add(new JScrollPane(), BorderLayout.CENTER);
		       
		        final JLabel label = new JLabel("");
		        label.setVisible(false);
		        label.setBounds(254, 304, 155, 15);
		        label.setFont(font);
		                contentPane.add(label, BorderLayout.NORTH);
		                
		                Vector<String> vt=new Vector<String>();
						for(int i=0;i<pm.getParkList().size();i++){
							
							Park pk=(Park)pm.getParkList().get(i);
							if(!pk.isManaged()){
								vt.add(pk.getCode()+" 名称："+pk.getParkName() +" 车位数："+pk.getTotalNum());
							}
							
						}
						
					
						Object[] ob=new Object[vt.size()];
						for(int j=0;j<vt.size();j++){
							ob[j]=vt.get(j).toString();
							
						}
						
		                final JCheckListBox list = new JCheckListBox(ob);
		                list.setBounds(132, 108, 227, 178);
		                contentPane.add(list);
		                list.setFont(font);
		                
		                JLabel label_1 = new JLabel("停车策略：");
		                label_1.setBounds(39, 58, 94, 15);
		                contentPane.add(label_1);
		                
		                final JComboBox comboBox = new JComboBox();
		                
		                comboBox.setModel(new DefaultComboBoxModel(new String[] {"默认策略", "平均策略", "空置率优先策略"}));
		                comboBox.setSelectedIndex(0);
		                comboBox.setBounds(132, 57, 125, 28);
		                contentPane.add(comboBox);
		                
		               
		                
		                list.getModel().addListDataListener(new ListDataListener() {
		                	
		                	            public void intervalAdded(ListDataEvent e) {
		                	            	
		                	            }
		                	
		                	            public void intervalRemoved(ListDataEvent e) {
		                	            }
		                	
		                	            public void contentsChanged(ListDataEvent e) {
		                	                if (list.getCheckedCount() == 0) {
		                	                   label.setText("");
		                	                } else {
		                	                    String text = "";
		                	                    int[] indices = list.getCheckedIndices();
		                	                    for (int i = 0; i < indices.length; i++) {
		                	                    	text += ((CheckListBoxModel) list.getModel()).getItem(indices[i]).toString() + ",";
		                	                    }
		                	                    
		                	                    label.setText(text);
		                	                }
		                	            }
		                	        });
		                
		                
		                setVisible(true);
		                
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取停车场列表
				
				String[] st=label.getText().split(",");
				ParkBoy pb=new ParkBoy(String.valueOf(pm.getBoyList().size()+1),textField.getText());
				//设置停车策略
				
				int index=comboBox.getSelectedIndex();
				//默认策略
				if(index==0){
					pb.setStrategy(StrategyFactory.getStrategy("default"));
				}else if(index==1){
					//平均策略
					pb.setStrategy(StrategyFactory.getStrategy("average"));
				}else if(index==2){
					//优先策略
					pb.setStrategy(StrategyFactory.getStrategy("vacancyRate"));
				}
				
				for(int i=0;i<st.length;i++){
					//获取停车场编号
					String num=st[i].split(" ")[0];
					for(int j=0;j<pm.getParkList().size();j++){
						
						Park pk=(Park)pm.getParkList().get(j);
						if(num.equals(pk.getCode())){
							pk.setManaged(true);
							
							pb.handlePark(pk);

						}
						
					}
					
				}
				//加入停车boy管理系列
				pm.getBoyList().add(pb);
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
