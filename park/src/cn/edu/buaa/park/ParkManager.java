package cn.edu.buaa.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 停车场经理类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkManager {
	// 停车场
	private Park park;
	// 所管理的停车BOY列表
	private List<ParkBoy> parkBoyList = new ArrayList<ParkBoy>();
	// 经理编号
	private String code;
	
	//经理名称
	private String name;
	

	/**
	 * 停车场经理构造器
	 * @param code
	 */
	public ParkManager(String code,String name) {
		this.code = code;
		this.name = name;
		
	}

	/**
	 * 默认构造器
	 */
	public ParkManager() {
		
	}

	/**
	 * 管理停车场
	 * @param park	停车场
	 */
	public void handlePark(Park park) {
		park.setManaged(true);
		this.park = park;
	}
	
	/**
	 * 获取管理的停车场
	 * @return
	 */
	public Park getPark(){
		return this.park;
	}

	/**
	 * 管理停车BOY
	 * @param boy	停车BOY
	 */
	public void handleBoy(ParkBoy boy) {
		boy.setManaged(true);
		this.parkBoyList.add(boy);
	}
	
	/**
     * 停车
     * @param car   车
     * @return  停车票据
     */
	public Ticket in(Car car) {
		if(isFull()) {
			throw new ParkException("停车场已满，不能停车了。");
		}
		int num = this.parkBoyList.size();
		if(this.park != null) {
			num += 1;
		}
		Random random = new Random();
		while(true) {
			int i = random.nextInt(num);
			if(i == 0 && !this.park.isFull()) {
				return park.in(car);
			} else if(i > 0) {
				ParkBoy boy = this.parkBoyList.get(i - 1);
				if(!boy.isFull()) {
					return boy.in(car);
				} else {
					continue;
				}
			} else {
				continue;
			}
		}
	}
	
	/**
	 * 取车
	 * @param ticket	停车票据
	 * @return	车
	 */
	public Car out(Ticket ticket) {
		if(!parkIsNull() && this.park.contain(ticket)) {
			return this.park.out(ticket);
		}
		for(ParkBoy boy : this.parkBoyList) {
			if(boy.contain(ticket)) {
				return boy.out(ticket);
			}
		}
		throw new ParkException("没有你要取的车。");
	}
	
	/**
	 * 判断停车经理所管理的停车场是否已满
	 * @return true-已满 false-未满
	 */
	public boolean isFull() {
		if(!parkIsNull() && !park.isFull()) {
			return false;
		}
		for(ParkBoy boy : this.parkBoyList) {
			if(!boy.isFull()) {
				return false;
			}
		}
		return true;
	}
	
	/**
     * 根据停车票据判断是否停在这
     * @param ticket	票据ID
     * @return	true-是 false-否
     */
    public boolean contain(Ticket ticket) {
    	if(!parkIsNull() && park.contain(ticket)) {
			return true;
		}
		for(ParkBoy boy : this.parkBoyList) {
			if(boy.contain(ticket)) {
				return true;
			}
		}
		return false;
    }
	
	/**
	 * 获取所有停车场的空车位数量
	 * @return	空车位数量
	 */
	public int getEmptyNum() {
		int num = 0;
		for(ParkBoy boy : this.parkBoyList) {
			num += boy.getEmptyNum();
		}
		if(this.park != null) {
			num += this.park.getEmptyNum();
		}
		return num;
	}
	
	/**
	 * 获取所有停车场的车位总数
	 * @return	车位总数
	 */
	public int getTotalNum() {
		int num = 0;
		for(ParkBoy boy : this.parkBoyList) {
			num += boy.getTotalNum();
		}
		if(this.park != null) {
			num += this.park.getTotalNum();
		}
		return num;
	}

	/**
	 * 获取经理编号
	 * @return	经理编号
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * 停车场经理名字
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * 判断所管理的停车场是否为空
	 * @return	true空 false非空
	 */
	public boolean parkIsNull() {
		return this.park == null;
	}
	
	/**
	 * 判断停车BOY是否为该经理所管理
	 * @return	true空 false非空
	 */
	public boolean containBoy(ParkBoy boy) {
		return this.parkBoyList.contains(boy);
	}
	
	/**
	 * 获取所管理的停车BOY列表
	 * @return	所管理的停车BOY列表
	 */
	public List<ParkBoy> getParkBoyList() {
		return parkBoyList;
	}


	
	/**
	 * 停车
	 */
	public String inCar(String carID) {
		String msg="";
		if(isFull()) {
			msg = "对不起，停车场已满！";
			return msg;
		}
		if(carID.equals("")){
			msg = "请输入你停的车的车牌号!";
			return msg;
		}
		
		if(contain(new Ticket(carID))) {
			msg = "你要停的车已经停在我们的停车场里了!";
			return msg;
		}
		Ticket ticket = in(new Car(carID));
		msg= "OK，请记住你的取车票据号[" + ticket.getCode() + "]。";
		return msg;
	}
	
	/**
	 * 取车
	 */
	public String outCar(String ticket) {
		if(ticket.equals("")){
			return "请输入你的取车票据号!";
		}
		
		
		if(!contain(new Ticket(ticket))) {
			return "我们这没有停你的车。";
			
		}
		Car car = out(new Ticket(ticket));
		return "OK，车牌是[" + car.getCode() + "]，欢迎下次光临。";
	}
	
	/**
	 * 打印停车场信息
	 */
	public String printParkInfo() {
		String text="";

		if(park == null && getParkBoyList().size() == 0) {
			text="目前没有管理任何停车场！" ;
			
			return text;
			
		}
		int emptyNum = 0;
		int totalNum = 0;
		
		if(park != null) {
			text= "        停车场编号：" + park.getCode() +"\n";
			text=text+ "        停车场名称：" + park.getParkName() +"\n";
			text=text+"                车位数：" + park.getTotalNum()+"\n";
			text=text+"                空位数：" + park.getEmptyNum()+"\n";
			emptyNum += park.getEmptyNum();
			totalNum += park.getTotalNum();
		}
		for(int i = 0; i < getParkBoyList().size(); i ++) {
			ParkBoy boy = getParkBoyList().get(i);
			text=text+"        停车BOY编号：" + boy.getCode()+"\n";
			text=text+"        停车BOY名称：" + boy.getName()+"\n";
			text =text + boy.printParkInfo();
			emptyNum += boy.getEmptyNum();
			totalNum += boy.getTotalNum();
		}
		text =text + "        共计车位数：" + totalNum+"\n";
		text =text + "        共计空位数：" + emptyNum+"\n";
		return text;
	}
	/**
	 * 仅打印停车场信息
	 * @return
	 */
	public String printParkInfoBySingle(){
		String text="";

		if(park == null && getParkBoyList().size() == 0) {
			text="目前没有管理任何停车场！" ;
			
			return text;
			
		}
		int emptyNum = 0;
		int totalNum = 0;
		
		if(park != null) {
			text= "        停车场编号：" + park.getCode() +"\n";
			text=text+ "        停车场名称：" + park.getParkName() +"\n";
			text=text+"                车位数：" + park.getTotalNum()+"\n";
			text=text+"                空位数：" + park.getEmptyNum()+"\n";
			emptyNum += park.getEmptyNum();
			totalNum += park.getTotalNum();
		}
		
		text =text + "        共计车位数：" + totalNum+"\n";
		text =text + "        共计空位数：" + emptyNum+"\n";
		return text;
	}
}