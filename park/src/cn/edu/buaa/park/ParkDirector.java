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
	
	/**
	 * 打印员工信息
	 */
	private void printEmployee() {
		if(ParkManage.getInstance().getManagerList().size() == 0 && ParkManage.getInstance().getBoyList().size() == 0) {
			System.out.println("目前没有创建任何员工！");
			return;
		}
		for(int i = 0; i < ParkManage.getInstance().getManagerList().size(); i ++) {
			ParkManager manager = ParkManage.getInstance().getManagerList().get(i);
			List<ParkBoy> boyList = manager.getParkBoyList();
			String boyCodes = "";
			if(boyList != null && boyList.size() > 0) {
				for(ParkBoy boy : boyList) {
					boyCodes += boy.getCode() + "  ";
				}
			} else {
				boyCodes = "暂时没有管理的停车BOY";
			}
			
			System.out.println("   经理编号：" + manager.getCode());
			System.out.println("      管理的停车BOY编号：" + boyCodes);
		}
		for(int i = 0; i < ParkManage.getInstance().getBoyList().size(); i ++) {
			ParkBoy boy = ParkManage.getInstance().getBoyList().get(i);
			Strategy strategy = boy.getStrategy();
			String strategyName = "";
			if(strategy instanceof DefaultStrategy) {
				strategyName = "默认策略";
			} else if(strategy instanceof AverageStrategy) {
				strategyName = "平均策略";
			} else if(strategy instanceof VacancyRateStrategy) {
				strategyName = "空置率策略";
			}
			System.out.println("   停车BOY编号：" + boy.getCode() + "  停车策略：" + strategyName);
		}
		System.out.println("-----------------------------------------");
	}
}