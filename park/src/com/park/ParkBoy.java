package com.park;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.park.inter.IStrategy;

/*
 * ����ͣ������boy
 */
public class ParkBoy {
protected static Map<String,ParkSeat>  pboy_ps = new HashMap();
	//�泵�Ĳ���
	public IStrategy strategy=null;

	//����ͣ�����Ŀճ�λ
	public int getEmpty_num() {
		int total = 0;

		
		for(Entry<String, ParkSeat> ps: pboy_ps.entrySet())
		{ 
			total = total + pboy_ps.get(ps.getKey()).getEmpty_num();
		} 
		return total;
	}

	//parkboyȡ�ÿɹ����ͣ�����б�
	public Map<String, ParkSeat> getPm_ps() {
		return pboy_ps;
	}
	
	//parkboy���ÿɹ����ͣ�����б�
	public void setPm_ps(Map<String, ParkSeat> pboy_ps) {
		this.pboy_ps = pboy_ps;
	}
	
	//����keyȡ��parkboy�Ĺ���ͣ����
	public ParkSeat getPark(String string) {

		ParkSeat ps = pboy_ps.get(string);
		return ps;
	}
	
	//parkboyȡ��
	public Car getCar(Ticket getcart_ticket) {
		Car car = null;
		for(Entry<String, ParkSeat> ps: pboy_ps.entrySet())
		{
			car = pboy_ps.get(ps.getKey()).getCar(getcart_ticket);
			if(car !=null){
				break;
			}
		}

		return car;
	}


	//parkboy�泵
	public Ticket setCar(Car car) {
		Ticket ticket=null;
		
		if(getEmpty_num()>0){
			
			ParkSeat ps = this.strategy.getParkSeat(this.getPm_ps());
			if(ps!=null){
				ticket = ps.setCar(car);
			}

		}
		
		return ticket;
	}

	//parkboy�Ĵ泵����
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	


}
