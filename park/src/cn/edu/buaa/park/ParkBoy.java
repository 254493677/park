package cn.edu.buaa.park;

import java.util.ArrayList;
import java.util.List;

/**
 * 停车BOY类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkBoy{
    // 管理的停车场列表
    private List<Park> parkList = new ArrayList<Park>();
    // 停车策略
    private Strategy strategy;
    // 停车BOY的编码
    private String code;
    //停车boy名称
    private String name;
    // 是否被管理
    private boolean managed = false;
    
    /**
     * 停车BOY构造器
     * @param code  停车BOY的编码
     */
    public ParkBoy(String code,String name) {
        this.code = code;
        this.name =name;
    }

    /**
     * 停车BOY构造器
     * @param strategy  停车策略
     */
    public ParkBoy(Strategy strategy) {
        setStrategy(strategy);
      
    }

    /**
     * 停车BOY构造器
     */
    public ParkBoy() {
        setStrategy(new DefaultStrategy());
      
    }

    /**
     * 设置停车BOY的停车策略
     * @param strategy  停车策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 管理一个停车场
     * @param park  停车场
     */
    public void handlePark(Park park) {
    	park.setManaged(true);
        this.parkList.add(park);
    }

    /**
     * 停车
     * @param car   车
     * @return  停车票据
     */
    public Ticket in(Car car) {
        return strategy.in(car, getParkList());
    }

    /**
     * 取车
     * @param ticket    停车票据
     * @return  车
     */
    public Car out(Ticket ticket) {
        Car car = null;
        for(Park park : this.parkList) {
            try{
                if((car = park.out(ticket)) != null) {
                    return car;
                }
            } catch (ParkException e) {
            }
            if(car != null) {
                break;
            }
        }
        throw new ParkException("没有您要取的车！");
    }

	/**
	 * 判断所管理的停车场是否已满
	 * @return true-已满 false-未满
	 */
	public boolean isFull() {
		for(Park park : this.parkList) {
			if(!park.isFull()) {
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
    	for(Park park : this.parkList) {
			if(park.contain(ticket)) {
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
		List<Park> list = getParkList();
		int num = 0;
		for(Park park : list) {
			num += park.getEmptyNum();
		}
		return num;
	}
	
	public String getName(){
		return this.name;
	}
	/**
	 * 获取所有停车场的车位总数
	 * @return	车位总数
	 */
	public int getTotalNum() {
		List<Park> list = getParkList();
		int num = 0;
		for(Park park : list) {
			num += park.getTotalNum();
		}
		return num;
	}
	
	/**
     * 获取指定停车场的空车位（该方法为测试专用，其他地方不要使用）
     * @param no    停车场序号
     * @return  停车场空车位
     */
    public int getParkSize(int no) {
        if(no >= this.parkList.size()) {
            throw new ParkException("找不到你需要的停车场！");
        }
        return this.parkList.get(no).getEmptyNum();
    }
	
	/**
     * 获取停车场列表
     * @return  停车场列表
     */
    public List<Park> getParkList() {
    	List<Park> list = new ArrayList<Park>();
    	list.addAll(this.parkList);
        return list;
    }

	/**
	 * 获取停车BOY的编码
	 * @return	停车BOY的编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 判断停车场是否为该停车BOY所管理
	 * @return	true空 false非空
	 */
	public boolean containPark(Park park) {
		return this.parkList.contains(park);
	}
	
	/**
	 * 设置停车BOY是否被管理
	 * @param managed	true是 false否
	 */
	public void setManaged(boolean managed) {
		this.managed = managed;
	}

	/**
	 * 判断停车BOY是否被管理了
	 * @return	true是 false否
	 */
	public boolean isManaged() {
		return managed;
	}
	
	/**
	 * 获取停车BOY的停车策略
	 * @return	停车策略
	 */
	public Strategy getStrategy() {
		return strategy;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkBoy other = (ParkBoy) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	/**
	 * 停车
	 */
	public String inCar(String carID) {
		
		String txt="";
		if(isFull()) {
			txt="对不起，停车场已满。";
			return txt;
		}
		if(carID.equals("")){
			txt="请输入你停的车的车牌号：";
			return txt;
		}
		
		if(contain(new Ticket(carID))) {
			txt="你要停的车已经停在我们的停车场里了。";
			return txt;
		}
		Ticket ticket = in(new Car(carID));
		txt = "OK，请记住你的取车票据号[" + ticket.getCode() + "]，";
		return txt;
	}
	
	/**
	 * 取车
	 */
	public String outCar(String ticketnum) {
		if(ticketnum.equals("")){
			return "请输入你的取车票据号";
		}
		
		if(!contain(new Ticket(ticketnum))) {
		
			return "我们这没有停你的车。";
		}
		Car car = out(new Ticket(ticketnum));
		return "OK，车牌是[" + car.getCode() + "]，欢迎下次光临。";
	}
	
	/**
	 * 打印停车场信息
	 */
	public String printParkInfo() {
		String text="";
		if(getParkList().size() == 0) {
			text="目前没有管理任何停车场！";
			
		}
		int emptyNum = 0;
		int totalNum = 0;
		for(int i = 0; i < getParkList().size(); i ++) {
			Park park = getParkList().get(i);
			text = text + "                停车场编号：" + park.getCode() + "\n";
			text = text+ "                停车场名称：" + park.getParkName() + "\n";
			text = text+"                车位数：" + park.getTotalNum()+ "\n";
			text = text+"                空位数：" + park.getEmptyNum()+ "\n";
			emptyNum += park.getEmptyNum();
			totalNum += park.getTotalNum();
		}
		text = text+"                共计车位数：" + totalNum + "\n";
		text = text+"                共计空位数：" + emptyNum + "\n";
		return text;
	}
	/**
	 * 打印停车场信息
	 */
	public String printParkInfoForBoy() {
		String text="";
		if(getParkList().size() == 0) {
			text="目前没有管理任何停车场！";
			
		}
		int emptyNum = 0;
		int totalNum = 0;
		
		text=text+"-----------------------------------------------" + "\n";
		for(int i = 0; i < getParkList().size(); i ++) {
			Park park = getParkList().get(i);
			text = text + "停车场编号：" + park.getCode() + "\n";
			text = text+ "停车场名称：" + park.getParkName() + "\n";
			text = text+"        车位数：" + park.getTotalNum()+ "\n";
			text = text+"        空位数：" + park.getEmptyNum()+ "\n";
			
			text=text+"-----------------------------------------------" + "\n";
			emptyNum += park.getEmptyNum();
			totalNum += park.getTotalNum();
		}
		text = text+"共计车位数：" + totalNum + "\n";
		text = text+"共计空位数：" + emptyNum + "\n";
		return text;
	}
}