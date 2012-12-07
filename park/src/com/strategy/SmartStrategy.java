package com.strategy;

import java.util.Map;
import java.util.Map.Entry;

import com.park.Car;
import com.park.ParkBoy;
import com.park.ParkSeat;
import com.park.Ticket;
import com.park.inter.IStrategy;

public class SmartStrategy implements IStrategy{
	
	/*
	 * 取得一个有空位的停车场,并且是空位最多的停车场
	 */
	public ParkSeat getParkSeat(Map<String,ParkSeat> map) {

			ParkSeat p=null;
			int car_num=0;
			for(Entry<String, ParkSeat> ps: map.entrySet())
			{
				ParkSeat p_tmp= map.get(ps.getKey());
				 int tmp_count = p_tmp.getEmpty_num();
					if(tmp_count>car_num){
						car_num = tmp_count;
						p=p_tmp;
					}
			}

			return p;
		}
	
	
}
