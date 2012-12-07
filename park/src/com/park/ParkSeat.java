package com.park;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * ͣ����
 */
public class ParkSeat {

	//ͣ�����ĳ�λ
	private  int psnum=0;

	
	//ͣ�����ĳ�λ
	public  int getPsnum() {
		return psnum;
	}

	//��λ�ͳ��Ķ�Ӧ�б�
	private Map<Ticket,Car> ps_map = new HashMap();
	
	
	//ͣ�������캯��
	public ParkSeat(int num ){
		psnum = num;
	}
	
	//ͣ����ͣ��
	public Ticket  setCar(Car car){

		Ticket ticket=null;
		//����ȡ��ƾ֤
		if(getEmpty_num()>0){
			ticket = new Ticket();
			ps_map.put(ticket, car);
		}
		
		return ticket;
	}
	
	
	//ͣ����ȡ��
	public Car  getCar(Ticket ticket){
		Car car = null;
		//û��
		if(getEmpty_num()==psnum){
			car=null;
		}else{
			car = (Car)ps_map.get(ticket);
			if(car != null){
				ps_map.remove(ticket);
			}
			
		}
		
		return car;
	}


	//ͣ������Ӧ�Ŀճ�λ
	public  int getEmpty_num() {
		int empty_num = getPsnum()-ps_map.size();
		return empty_num;
	}
	
	//��λ��
	//ͣ������Ӧ�Ŀճ�λ
	public  float getEmpty_Relate() {
		float empty_relate = ((float)getEmpty_num())/getPsnum();
		return empty_relate;
	}
	
}
