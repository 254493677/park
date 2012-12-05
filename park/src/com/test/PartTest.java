package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.Before;
import com.park.Car;
import com.park.ParkSeat;
import com.park.Ticket;


public class PartTest {
	ParkSeat park =null;
	//String ps_idcard=null;
	@Before
	public void init(){
		
	//停车场20个停车位、都是空的
	 park = new ParkSeat(20);
	 //ps_idcard="idcard";
	}
	/*
	 * Given 一个停车场，有空车位
		when 停车
		should 成功，空车位-1
	 */
 @Test
 public void setSuccessCar(){
	 
	 Car car = new Car (); 
	 Ticket car_ps_id = park.setCar(car);
	 
	 System.out.println(car_ps_id.getTicket()); 
	 System.out.println(park.getEmpty_num());
	 
	 assertEquals(park.getEmpty_num(),19);  
 }
 
 
 /*
  * given 有效的停车凭证
	when 取车
	should 取到原来的车
  */
 @Test
 public void getSuccessCar (){
	 
	 //先存车
	 Car car = new Car (); 
	 Ticket car_ps_id = park.setCar(car);
	 
	 //在取车
	 Car car_get = park.getCar(car_ps_id);
	 System.out.println(car_ps_id.getTicket());
	 
	 System.out.println(park.getEmpty_num());	 
	 assertEquals(park.getEmpty_num(),20);  
	 
 }
 



	
//	
//	/*
//	given 无效的停车凭证
//	when 取车
//	should 取不走原来的车
//
//	 */
//	@Test
//	public void getCar_invalid_pscard(){
//		 
//		 park.setEmpty_num(park.getPsnum());
//		 
//		 Car car = park.getCar(ps_idcard);
//		 
//		 assertEquals(car,null);  
//		 assertEquals(park.getEmpty_num(),20);  
//		 
//	}
	
	
 
}
