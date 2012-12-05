package com.park;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.park.inter.IStrategy;

public class ParkManager {
protected static Map<String,ParkSeat>  pm_ps = new HashMap();

	public IStrategy strategy=null;

	public int getEmpty_num() {
		int total = 0;

		
		for(Entry<String, ParkSeat> ps: pm_ps.entrySet())
		{ 
			total = total + pm_ps.get(ps.getKey()).getEmpty_num();
		} 
		return total;
	}

	
	public Map<String, ParkSeat> getPm_ps() {
		return pm_ps;
	}
	public void setPm_ps(Map<String, ParkSeat> pm_ps) {
		this.pm_ps = pm_ps;
	}
	
	
	public ParkSeat getPark(String string) {

		ParkSeat ps = pm_ps.get(string);
		return ps;
	}
	public Car getCar(Ticket getcart_ticket) {
		Car car = null;
		for(Entry<String, ParkSeat> ps: pm_ps.entrySet())
		{
			car = pm_ps.get(ps.getKey()).getCar(getcart_ticket);
			if(car !=null){
				break;
			}
		}

		return car;
	}


	
	public Ticket setCar(Car car) {
		Ticket ticket=null;
		
		if(getEmpty_num()>0){
			
			ticket = strategy.setCar(car,this);
			
		}
		
		return ticket;
	}


	public IStrategy getStrategy() {
		return strategy;
	}


	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	


}
