package cn.edu.buaa.park;

import java.util.List;

/**
 * 
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkDirector {
	public ParkDirector() {
		
	}

	/**
	 * 打印停车场信息
	 */
	public String printParkInfo() {
		String txt="";
		if(ParkManage.getInstance().getParkList().size() == 0) {
			txt="目前没有创建任何停车场，请先创建停车场！";
			return txt;
		}
		int emptyNum = 0;
		int totalNum = 0;
		txt= txt + "-----------------------------------------"+ "\n";
		for(int i = 0; i < ParkManage.getInstance().getParkList().size(); i ++) {
			Park park = ParkManage.getInstance().getParkList().get(i);
			txt= txt + "停车场编号：" + park.getCode() + "\n";
			txt= txt + "停车场编号：" + park.getParkName() + "\n";
			txt= txt + "                车位数：" + park.getTotalNum() + "\n";
			txt= txt + "                空位数：" + park.getEmptyNum() + "\n";
			emptyNum += park.getEmptyNum();
			totalNum += park.getTotalNum();
		}
		txt= txt +"-----------------------------------------"+"\n";
		txt= txt + "共计车位数：" + totalNum +"\n" ;
		txt= txt + "共计空位数：" + emptyNum +"\n" ;
		return txt;
	}
	
	
}