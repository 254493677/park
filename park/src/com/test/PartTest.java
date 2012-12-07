package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;
import com.park.Car;
import com.park.ParkBoy;

import com.park.ParkSeat;
import com.park.Ticket;
import com.park.inter.IStrategy;
import com.strategy.FoolStrategy;
import com.strategy.RelateStrategy;
import com.strategy.SmartStrategy;




public class PartTest {
	ParkSeat park =null;
	ParkBoy parkm =null;

	ParkSeat parka =null;
	ParkSeat parkb =null;
	

	@Before
	public void init(){
		
	//停车场20个停车位、都是空的
	 park = new ParkSeat(20);
	 
	 parka = new ParkSeat(5);
	 parkb = new ParkSeat(10);
	 
	 parkm= new ParkBoy();
	 parkm.getPm_ps().put("A", parka);
	 parkm.getPm_ps().put("B", parkb);

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
	 
	 Assert.assertEquals(park.getEmpty_num(),19);
 }
 
 
 /*
  * given 有效的停车凭证
	when 取车
	should 取到原来的车、且取出来的车是同一个车
  */
 @Test
 public void getSuccessCar (){
	 
	 //先存车
	 Car car = new Car (); 
	 Ticket car_ps_id = park.setCar(car);
	 
	 //在取车
	 Car car_get = park.getCar(car_ps_id);

	 
	 Assert.assertSame(car_get,car);
	 Assert.assertEquals(park.getEmpty_num(),20);
	 
 }
 
	/*
	given 一个停车场，没有空车位
	when 停车
	should fail
	 */
 @Test
 public void setCar_NoSeat (){
	 
	 ParkSeat park = new ParkSeat(0);
	 Car car =  new Car();
	 Ticket tmp_ticket = park.setCar(car);
	 
	 Assert.assertEquals(tmp_ticket,null);  
	 Assert.assertEquals(park.getEmpty_num(),0);  
	 
 }
 
 

	/*
	 given 空的停车场
	 when 取车
	 should fail
 
	 */
	@Test
	public void getCar_NoSeat (){
		 
		 //Car car = park.getCar(new Ticket("201211011111031"));
		Car car = park.getCar(new Ticket());
		 
		 Assert.assertEquals(car,null);  
		 Assert.assertEquals(park.getEmpty_num(),20);  
		 
	}
	
	
	/*
	 given 同样的ticket
	 when 取车
	 should fail

	 */
	@Test
	public void getCar_SameTicket (){
		 
		//先存车
		 Car car = new Car (); 
		 Ticket getcart_ticket = park.setCar(car);
		 Ticket cope_ticket = new Ticket();
		 //在取车
		 Car car_getCopy = park.getCar(cope_ticket);
		 Car car_get = park.getCar(getcart_ticket);
		 
		 Assert.assertEquals(car_getCopy, null);
		 Assert.assertNotSame(car_get, car_getCopy);
	}
	

	/*
	 * 2个停车场都是空的
	 * 存车
	 * 成功
	 */
	@Test
	public void setCar_2Park_2Emp (){
		 
		//先存车
		 Car car = new Car (); 
		 parkm.setStrategy(new FoolStrategy());
		 Ticket getcart_ticket = parkm.setCar(car);

		
		 Assert.assertEquals(parkm.getEmpty_num(),14);
		
	}
	
	

	/*
	 * 1个停车场是空的\另一个是满的
	 * 存车
	 * 成功
	 */
	@Test
	public void setCar_2Park_1Full (){
		 
		//先存车
		IStrategy fool = new FoolStrategy();
		parkm.setStrategy(fool);
		 for(int i=0;i<10;i++){
			 Car car = new Car (); 
			 
			 Ticket getcart_ticket = parkm.setCar(car);	 
		 }
		 
		 Car car = new Car (); 
		 Ticket getcart_ticket = parkm.setCar(car);

		 
		 Assert.assertEquals(parkm.getEmpty_num(),4);
		 Assert.assertEquals(parkm.getPark("A").getEmpty_num(),0);
		 Assert.assertEquals(parkm.getPark("B").getEmpty_num(),4);
	}
	
	
	/*
	 * 1个停车场是空的\另一个是满的
	 * 存车
	 * 成功
	 */
	@Test
	public void setCar_2Park_2Full (){
		 
		//先存车
		IStrategy fool = new FoolStrategy();
		parkm.setStrategy(fool);
		 for(int i=0;i<20;i++){
			 Car car = new Car (); 
			 Ticket getcart_ticket = parkm.setCar(car);	 
		 }
		 
		 Car car = new Car (); 
		 Ticket getcart_ticket = parkm.setCar(car);

		 Assert.assertEquals(getcart_ticket,null);  
	}
	
	
	/*
	 * 车库有车，取车
	 */
	@Test
	public void getCar_2Park (){
		 
		//先存车
		IStrategy fool = new FoolStrategy();
		parkm.setStrategy(fool);
		 Car car = new Car (); 
		 Ticket getcart_ticket = parkm.setCar(car);	 
		
		 
		 Car car1 = parkm.getCar(getcart_ticket);

		 Assert.assertSame(car1, car);
	}
	
	
	/*
	 * 车库有车，取车
	 */
	@Test
	public void getCar_2Park_2Emp (){
		 

		 Ticket getcart_ticket = new Ticket();
		
		 
		 Car car = parkm.getCar(getcart_ticket);

		 //Assert.assertEquals(getcart_ticket,null);  
		 Assert.assertEquals(car, null);
	}
	
	
	
	/*
	 * 1一个停车场车位多、一个少，停车、停在了少的中
	 * 存车
	 * 成功、停车位多的空车位多了一个
	 */
	@Test
	public void setCar_Cle_2Park_Emp (){
		 
		//初始化
		ParkBoy pm = new ParkBoy();
		
		ParkSeat parka1 = new ParkSeat(10);
		ParkSeat parkb1 = new ParkSeat(5);
		Map<String,ParkSeat> map = new HashMap();
		map.put("A1",parka1);
		map.put("B1",parkb1);
		pm.setPm_ps(map);
		
		
		//聪明人存车
		IStrategy smart = new SmartStrategy();
		 Car car = new Car (); 
		 pm.setStrategy(smart);
		 Ticket getcart_ticket = pm.setCar(car);
		 
		 Assert.assertEquals(pm.getPark("A1").getEmpty_num(),9);
		 Assert.assertEquals(pm.getPark("B1").getEmpty_num(),5);
		 
		//笨人存车
		 IStrategy fool = new FoolStrategy();
		 Car car1 = new Car (); 
		 pm.setStrategy(fool);
		 getcart_ticket = pm.setCar(car1);

		 Assert.assertEquals(pm.getPark("B1").getEmpty_num(),4);
		 Assert.assertEquals(pm.getPark("A1").getEmpty_num(),9);
		 
	}
	

	
	/*
	 * 1一个停车场车位多、一个少，停车、停在了少的中
	 * 存车
	 * 聪明人按照空位率高的进行存车、空位率高的停车场多了一个车
	 */
	@Test
	public void setCar_Ralate_2Park_Emp (){
		 
		//初始化
		ParkBoy pm = new ParkBoy();
		
		ParkSeat parka1 = new ParkSeat(10);
		 for(int i=0;i<5;i++){
			 Car car = new Car (); 
			 parka1.setCar(car);	 
		 }
		ParkSeat parkb1 = new ParkSeat(5);
		 for(int i=0;i<2;i++){
			 Car car = new Car (); 
			 parkb1.setCar(car);	 
		 }
		Map<String,ParkSeat> map = new HashMap();
		map.put("A1",parka1);
		map.put("B1",parkb1);
		pm.setPm_ps(map);
		
		
		//聪明人按照空位率高的进行存车
		IStrategy smart_relateStrategy = new RelateStrategy();
		 Car car = new Car (); 
		 pm.setStrategy(smart_relateStrategy);
		 Ticket getcart_ticket = pm.setCar(car);

		 Assert.assertEquals(pm.getPark("A1").getEmpty_num(),5);
		 Assert.assertEquals(pm.getPark("B1").getEmpty_num(),2);
		 
		 Car rate_car = pm.getCar(getcart_ticket);
		 Assert.assertSame(rate_car, car);
		
		 
	}
	
}
