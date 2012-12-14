package cn.edu.buaa.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JScrollPane;


import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;


import cn.edu.buaa.park.ParkDirector;
import  cn.edu.buaa.park.ParkManage;

import javax.swing.JTextArea;

public class BossReport extends JFrame {
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
					BossReport frame = new BossReport();
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
	public BossReport() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("停车场Boss报表");
		setBounds(100, 100, 450, 367);
		
		JTextArea textArea = new JTextArea();
		 
		
		textArea.setRows(10);
		textArea.setColumns(5);
		textArea.setEditable(false);
		textArea.setAutoscrolls(true); 
		textArea.setBounds(10, 10, 390, 309);
		textArea.setText(new ParkDirector().printParkInfo());
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
