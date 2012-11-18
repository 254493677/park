package com.park;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkSeat {
	private static int empty_num=20;
	private static int psnum=20;
	
	//private static String ps_idcard= "idcard";
	
	public static int getPsnum() {
		return psnum;
	}
	public static void setPsnum(int psnum) {
		ParkSeat.psnum = psnum;
	}


	Map ps_map = new HashMap();
	
	public ParkSeat(int num ){
		empty_num = num;
		psnum = num;
	}
	public String  setCar(Car car){

		String flag="";
		//生成取车凭证
		String ps_id=getPs_id();
		if(empty_num>0){
			
			ps_map.put(ps_id, car);
			empty_num--;
			flag = ps_id;
		}else{
			flag =  "fail";
		}
		
		return flag;
	}
	
	
	public Car  getCar(String ps_id){
		Car car = null;
		//没车
		if(empty_num==psnum){
			car=null;
		}else{
			car = (Car)ps_map.get(ps_id);
			ps_map.remove(ps_id);
			empty_num++;
		}
		
		return car;
	}


	public  int getEmpty_num() {
		return empty_num;
	}


	public  void setEmpty_num(int empty_num) {
		ParkSeat.empty_num = empty_num;
	}

	
	//生成取车凭证
    public String getPs_id(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
    	String ps_id = sdf.format(date);
    	return ps_id;
    }
	

	
	
}
