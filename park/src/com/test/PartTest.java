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
		
	//ͣ����20��ͣ��λ�����ǿյ�
	 park = new ParkSeat(20);
	 
	 parka = new ParkSeat(5);
	 parkb = new ParkSeat(10);
	 
	 parkm= new ParkBoy();
	 parkm.getPm_ps().put("A", parka);
	 parkm.getPm_ps().put("B", parkb);

	}
	
	
	
	/*
	 * Given һ��ͣ�������пճ�λ
		when ͣ��
		should �ɹ����ճ�λ-1
	 */
 @Test
 public void setSuccessCar(){
	 
	 Car car = new Car ();
	 Ticket car_ps_id = park.setCar(car);
	 
	 Assert.assertEquals(park.getEmpty_num(),19);
 }
 
 
 /*
  * given ��Ч��ͣ��ƾ֤
	when ȡ��
	should ȡ��ԭ���ĳ�����ȡ�����ĳ���ͬһ����
  */
 @Test
 public void getSuccessCar (){
	 
	 //�ȴ泵
	 Car car = new Car (); 
	 Ticket car_ps_id = park.setCar(car);
	 
	 //��ȡ��
	 Car car_get = park.getCar(car_ps_id);

	 
	 Assert.assertSame(car_get,car);
	 Assert.assertEquals(park.getEmpty_num(),20);
	 
 }
 
	/*
	given һ��ͣ������û�пճ�λ
	when ͣ��
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
	 given �յ�ͣ����
	 when ȡ��
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
	 given ͬ����ticket
	 when ȡ��
	 should fail

	 */
	@Test
	public void getCar_SameTicket (){
		 
		//�ȴ泵
		 Car car = new Car (); 
		 Ticket getcart_ticket = park.setCar(car);
		 Ticket cope_ticket = new Ticket();
		 //��ȡ��
		 Car car_getCopy = park.getCar(cope_ticket);
		 Car car_get = park.getCar(getcart_ticket);
		 
		 Assert.assertEquals(car_getCopy, null);
		 Assert.assertNotSame(car_get, car_getCopy);
	}
	

	/*
	 * 2��ͣ�������ǿյ�
	 * �泵
	 * �ɹ�
	 */
	@Test
	public void setCar_2Park_2Emp (){
		 
		//�ȴ泵
		 Car car = new Car (); 
		 parkm.setStrategy(new FoolStrategy());
		 Ticket getcart_ticket = parkm.setCar(car);

		
		 Assert.assertEquals(parkm.getEmpty_num(),14);
		
	}
	
	

	/*
	 * 1��ͣ�����ǿյ�\��һ��������
	 * �泵
	 * �ɹ�
	 */
	@Test
	public void setCar_2Park_1Full (){
		 
		//�ȴ泵
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
	 * 1��ͣ�����ǿյ�\��һ��������
	 * �泵
	 * �ɹ�
	 */
	@Test
	public void setCar_2Park_2Full (){
		 
		//�ȴ泵
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
	 * �����г���ȡ��
	 */
	@Test
	public void getCar_2Park (){
		 
		//�ȴ泵
		IStrategy fool = new FoolStrategy();
		parkm.setStrategy(fool);
		 Car car = new Car (); 
		 Ticket getcart_ticket = parkm.setCar(car);	 
		
		 
		 Car car1 = parkm.getCar(getcart_ticket);

		 Assert.assertSame(car1, car);
	}
	
	
	/*
	 * �����г���ȡ��
	 */
	@Test
	public void getCar_2Park_2Emp (){
		 

		 Ticket getcart_ticket = new Ticket();
		
		 
		 Car car = parkm.getCar(getcart_ticket);

		 //Assert.assertEquals(getcart_ticket,null);  
		 Assert.assertEquals(car, null);
	}
	
	
	
	/*
	 * 1һ��ͣ������λ�ࡢһ���٣�ͣ����ͣ�����ٵ���
	 * �泵
	 * �ɹ���ͣ��λ��Ŀճ�λ����һ��
	 */
	@Test
	public void setCar_Cle_2Park_Emp (){
		 
		//��ʼ��
		ParkBoy pm = new ParkBoy();
		
		ParkSeat parka1 = new ParkSeat(10);
		ParkSeat parkb1 = new ParkSeat(5);
		Map<String,ParkSeat> map = new HashMap();
		map.put("A1",parka1);
		map.put("B1",parkb1);
		pm.setPm_ps(map);
		
		
		//�����˴泵
		IStrategy smart = new SmartStrategy();
		 Car car = new Car (); 
		 pm.setStrategy(smart);
		 Ticket getcart_ticket = pm.setCar(car);
		 
		 Assert.assertEquals(pm.getPark("A1").getEmpty_num(),9);
		 Assert.assertEquals(pm.getPark("B1").getEmpty_num(),5);
		 
		//���˴泵
		 IStrategy fool = new FoolStrategy();
		 Car car1 = new Car (); 
		 pm.setStrategy(fool);
		 getcart_ticket = pm.setCar(car1);

		 Assert.assertEquals(pm.getPark("B1").getEmpty_num(),4);
		 Assert.assertEquals(pm.getPark("A1").getEmpty_num(),9);
		 
	}
	

	
	/*
	 * 1һ��ͣ������λ�ࡢһ���٣�ͣ����ͣ�����ٵ���
	 * �泵
	 * �����˰��տ�λ�ʸߵĽ��д泵����λ�ʸߵ�ͣ��������һ����
	 */
	@Test
	public void setCar_Ralate_2Park_Emp (){
		 
		//��ʼ��
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
		
		
		//�����˰��տ�λ�ʸߵĽ��д泵
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
