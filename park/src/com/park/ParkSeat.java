package com.park;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * 停车场
 */
public class ParkSeat {

	//停车场的车位
	private  int psnum=0;

	
	//停车场的车位
	public  int getPsnum() {
		return psnum;
	}

	//车位和车的对应列表
	private Map<Ticket,Car> ps_map = new HashMap();
	
	
	//停车场构造函数
	public ParkSeat(int num ){
		psnum = num;
	}
	
	//停车场停车
	public Ticket  setCar(Car car){

		Ticket ticket=null;
		//生成取车凭证
		if(getEmpty_num()>0){
			ticket = new Ticket();
			ps_map.put(ticket, car);
		}
		
		return ticket;
	}
	
	
	//停车场取车
	public Car  getCar(Ticket ticket){
		Car car = null;
		//没车
		if(getEmpty_num()==psnum){
			car=null;
		}else{
			car = (Car)ps_map.get(ticket);
			if(car != null){
				ps_map.remove(ticket);
			}
			
		}
		
		return car;
	}


	//停车场对应的空车位
	public  int getEmpty_num() {
		int empty_num = getPsnum()-ps_map.size();
		return empty_num;
	}
	
	//空位率
	//停车场对应的空车位
	public  float getEmpty_Relate() {
		float empty_relate = ((float)getEmpty_num())/getPsnum();
		return empty_relate;
	}
	
}
