package com.park.inter;
import com.park.Car;
import com.park.ParkManager;
import com.park.Ticket;
public interface IStrategy {
	public Ticket setCar(Car car,ParkManager pm);
}
