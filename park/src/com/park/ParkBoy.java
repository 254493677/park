package com.park;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.park.inter.IStrategy;

/*
 * 管理停车场的boy
 */
public class ParkBoy {
protected static Map<String,ParkSeat>  pboy_ps = new HashMap();
	//存车的策略
	public IStrategy strategy=null;

	//所有停车场的空车位
	public int getEmpty_num() {
		int total = 0;

		
		for(Entry<String, ParkSeat> ps: pboy_ps.entrySet())
		{ 
			total = total + pboy_ps.get(ps.getKey()).getEmpty_num();
		} 
		return total;
	}

	//parkboy取得可管理的停车场列表
	public Map<String, ParkSeat> getPm_ps() {
		return pboy_ps;
	}
	
	//parkboy设置可管理的停车场列表
	public void setPm_ps(Map<String, ParkSeat> pboy_ps) {
		this.pboy_ps = pboy_ps;
	}
	
	//根据key取得parkboy的管理停车场
	public ParkSeat getPark(String string) {

		ParkSeat ps = pboy_ps.get(string);
		return ps;
	}
	
	//parkboy取车
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


	//parkboy存车
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

	//parkboy的存车策略
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	


}
