package cn.edu.buaa.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JScrollPane;

//import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import  cn.edu.buaa.park.ParkManage;
import cn.edu.buaa.park.ParkManager;

import javax.swing.JTextArea;


public class ManagerReport extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JDialog dialog =null;
	ParkManage pm = ParkManage.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerReport frame = new ManagerReport();
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
	public ManagerReport() {
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车场经理报表");
		setBounds(100, 100, 450, 367);
		
		String txt="";
		
		if(pm.getManagerList().size()==0){
			txt = "还未创建停车场经理。";
			
		}
		
		//获取停车场经理
		
		for(int i=0;i<pm.getManagerList().size();i++){
			
			ParkManager pk=(ParkManager)pm.getManagerList().get(i);
			txt=txt + "停车经理编号：" + pk.getCode() + "\n";
			txt=txt + "停车经理名称：" + pk.getName() + "\n";
			txt =txt + pk.printParkInfo();
			
		}
		
		JTextArea textArea = new JTextArea();
		
		
		textArea.setRows(10);
		textArea.setColumns(5);
		textArea.setEditable(false);
		textArea.setAutoscrolls(true); 
		textArea.setBounds(10, 10, 390, 309);
		textArea.setText(txt);
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(textArea);
		this.add(jsp);
		
		this.addWindowFocusListener(new WindowFocusListener(){
			public void windowGainedFocus(WindowEvent e){}
			public void windowLostFocus(WindowEvent e){
			    e.getWindow().toFront();
			}
			});
		
	}
}
