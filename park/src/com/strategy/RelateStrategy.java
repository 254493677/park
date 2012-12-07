package com.strategy;

import java.util.Map;
import java.util.Map.Entry;

import com.park.ParkSeat;
import com.park.inter.IStrategy;

public class RelateStrategy implements IStrategy {

	/*
	 *求空位率最大的车位
	 */
	public ParkSeat getParkSeat(Map<String, ParkSeat> map) {
		ParkSeat p=null;
		float empty_relate=0;
		for(Entry<String, ParkSeat> ps: map.entrySet())
		{
			ParkSeat p_tmp= map.get(ps.getKey());
			 float empty_relate_tmp = p_tmp.getEmpty_Relate();
				if(empty_relate_tmp>empty_relate){
					empty_relate = empty_relate_tmp;
					p=p_tmp;
				}
		}

		return p;
	}

}
