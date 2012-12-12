package cn.edu.buaa.park;

import java.util.ArrayList;
import java.util.List;

/**
 * 停车场管理
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkManage{
	private List<ParkManager> managerList = new ArrayList<ParkManager>();
	private List<ParkBoy> boyList = new ArrayList<ParkBoy>();
	private List<Park> parkList = new ArrayList<Park>();
	
	private ParkManage(){

	}

	/**
	 * 获取停车场经理列表
	 */
	public List<ParkManager> getManagerList() {
		return managerList;
	}

	/**
	 * 增加一个停车场经理
	 */
	public void addManager(ParkManager manager) {
		this.managerList.add(manager);
	}

	/**
	 * 获取停车BOY列表
	 */
	public List<ParkBoy> getBoyList() {
		return boyList;
	}

	/**
	 * 增加停车BOY
	 */
	public void addBoy(ParkBoy boy) {
		this.boyList.add(boy);
	}

	/**
	 * 获取停车场列表
	 */
	public List<Park> getParkList() {
		return parkList;
	}

	/**
	 * 增加停车场
	 */
	public void addPark(Park park) {
		this.parkList.add(park);
	}


	private static ParkManage main;
	
	public static ParkManage getInstance() {
		if(main == null) {
			main = new ParkManage();
		}
		return main;
	}
	
	public static void welcome() {

	}
}