package cn.edu.buaa.park;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * 停车场经理测试类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkManager_Test {
	private ParkManager manager;
	
	@Before
	public void init() {
		this.manager = new ParkManager();
		this.manager.handlePark(new Park(8));
		ParkBoy boyA = new ParkBoy();
		boyA.handlePark(new Park(5));
		boyA.handlePark(new Park(9));
		this.manager.handleBoy(boyA);
		ParkBoy boyB = new ParkBoy();
		boyB.handlePark(new Park(4));
		boyB.handlePark(new Park(7));
		this.manager.handleBoy(boyB);
	}
	
	/*
	 * 	当停33辆车时，测试每停一辆车时停车场经理的空车位数量；
	 */
	@Test
	public void test_empty_num_when_in_thirty_three_car() {
        for(int i = 0; i < 33; i ++) {
            manager.in(new Car(String.valueOf(i)));
            Assert.assertEquals(manager.getEmptyNum(), 33 - i - 1);
        }
    }
	
	/*
	 * 	当所有停车场已满，再进行停车时失败；
	 */
	@Test(expected = ParkException.class)
	public void in_a_car_when_all_park_is_full() {
        for(int i = 0; i < 34; i ++) {
            manager.in(new Car(String.valueOf(i)));
        }
    }
	
	
	/*
	 * 	停一辆车时，根据票据取出来的车还是原来停的那辆车。
	 */
	@Test
	public void out_a_car_when_in_a_car() {
		Car car = new Car();
		Ticket ticket = manager.in(car);
		Assert.assertSame(manager.out(ticket), car);
	}
}