package com.park.inter;
import java.util.Map;

import com.park.Car;
import com.park.ParkBoy;
import com.park.ParkSeat;
import com.park.Ticket;
public interface IStrategy {
	public ParkSeat getParkSeat(Map<String,ParkSeat> map);
}
