package com.park;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkSeat {
	//private  int empty_num=0;
	private  int psnum=0;

	
	//private static String ps_idcard= "idcard";
	

	public  int getPsnum() {
		return psnum;
	}

	private Map<Ticket,Car> ps_map = new HashMap();
	
	public ParkSeat(int num ){
		psnum = num;
	}
	public Ticket  setCar(Car car){

		Ticket ticket=null;
		//生成取车凭证
		//ticket =getPs_id();
		
		if(getEmpty_num()>0){
			ticket = new Ticket();
			ps_map.put(ticket, car);

			
		}else{
			//ticket =  new Ticket("fail");
		}
		
		return ticket;
	}
	
	
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


	public  int getEmpty_num() {
		int empty_num = getPsnum()-ps_map.size();
		return empty_num;
	}

	
//	//生成取车凭证
//    public Ticket getPs_id(){
//    	Date date = new Date();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
//    	String ps_id = sdf.format(date);
//    	return new Ticket(ps_id);
//    }
	
	
	
}
