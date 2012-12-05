package com.strategy;

import java.util.Map.Entry;

import com.park.Car;
import com.park.ParkManager;
import com.park.ParkSeat;
import com.park.Ticket;
import com.park.inter.IStrategy;

public class FoolStrategy implements IStrategy {

public Ticket setCar(Car car,ParkManager pm) {
		
		Ticket ticket=null;
		
		if(pm.getEmpty_num()>0){
			
			
			for(Entry<String, ParkSeat> ps: pm.getPm_ps().entrySet())
			{
				ParkSeat p_tmp= pm.getPm_ps().get(ps.getKey());
				 int tmp_count = p_tmp.getEmpty_num();
				 if(tmp_count>0){
					 ticket = p_tmp.setCar(car);
					 break;
				 }
				
			}

		}
		
		return ticket;
	}

}
