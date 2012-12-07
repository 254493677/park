package com.strategy;

import java.util.Map;
import java.util.Map.Entry;

import com.park.Car;
import com.park.ParkSeat;
import com.park.inter.IStrategy;

public class FoolStrategy implements IStrategy {

/*
 * 随即取得一个有空位的停车场
 */
public ParkSeat getParkSeat(Map<String,ParkSeat> map) {

			ParkSeat p_tmp=null;
			for(Entry<String, ParkSeat> ps: map.entrySet())
			{
				p_tmp= map.get(ps.getKey());
				
				if(p_tmp.getEmpty_num()>0){
					break;
				}
			}

		return p_tmp;
	}

}
