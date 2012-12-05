package com.strategy;

import java.util.Map.Entry;

import com.park.Car;
import com.park.ParkManager;
import com.park.ParkSeat;
import com.park.Ticket;
import com.park.inter.IStrategy;

public class SmartStrategy implements IStrategy{
	
	public Ticket setCar(Car car,ParkManager pm) {
		
		Ticket ticket=null;
		
		if(pm.getEmpty_num()>0){
			int car_num=Integer.MIN_VALUE;
			ParkSeat p=null;
			for(Entry<String, ParkSeat> ps: pm.getPm_ps().entrySet())
			{
				ParkSeat p_tmp= pm.getPm_ps().get(ps.getKey());
				 int tmp_count = p_tmp.getEmpty_num();
				if(tmp_count>car_num){
					car_num = tmp_count;
					p=p_tmp;
				}
				
			}
			
			p.setCar(car);

		}
		
		return ticket;
	}
	
	
}
