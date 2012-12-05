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
		
	//ͣ����20��ͣ��λ�����ǿյ�
	 park = new ParkSeat(20);
	 //ps_idcard="idcard";
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
	 
	 System.out.println(car_ps_id.getTicket()); 
	 System.out.println(park.getEmpty_num());
	 
	 assertEquals(park.getEmpty_num(),19);  
 }
 
 
 /*
  * given ��Ч��ͣ��ƾ֤
	when ȡ��
	should ȡ��ԭ���ĳ�
  */
 @Test
 public void getSuccessCar (){
	 
	 //�ȴ泵
	 Car car = new Car (); 
	 Ticket car_ps_id = park.setCar(car);
	 
	 //��ȡ��
	 Car car_get = park.getCar(car_ps_id);
	 System.out.println(car_ps_id.getTicket());
	 
	 System.out.println(park.getEmpty_num());	 
	 assertEquals(park.getEmpty_num(),20);  
	 
 }
 



	
//	
//	/*
//	given ��Ч��ͣ��ƾ֤
//	when ȡ��
//	should ȡ����ԭ���ĳ�
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
