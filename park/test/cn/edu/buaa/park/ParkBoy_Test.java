package cn.edu.buaa.park;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkBoy_Test {
    private final int FIRST_PARK_SIZE = 5;
    private final int SECOND_PARK_SIZE = 10;
    private ParkBoy parkBoy;

    @Before
    public void init() {
        parkBoy = new ParkBoy();
        parkBoy.handlePark(new Park(this.FIRST_PARK_SIZE));
        parkBoy.handlePark(new Park(this.SECOND_PARK_SIZE));
    }

    /*
     * 测试每停一辆车后两个停车场的空车位
     */
    @Test
    public void in_a_car_when_first_park_is_not_full() {
        parkBoy.in(new Car());
        Assert.assertEquals(parkBoy.getParkSize(0), this.FIRST_PARK_SIZE - 1);
        Assert.assertEquals(parkBoy.getParkSize(1), this.SECOND_PARK_SIZE);
    }

    /*
     * 测试停多辆车后两个停车场的空车位
     */
    @Test
    public void in_a_car_when_first_park_is_full() {
        for(int i = 0; i <= 5; i ++) {
            parkBoy.in(new Car(String.valueOf(i)));
        }

        Assert.assertEquals(parkBoy.getParkSize(1), this.SECOND_PARK_SIZE-1 );
    }

    /*
     * 	当停一辆车在第一个停车场时，通过停车票据取出原来的车
     */
    @Test
    public void out_a_car_when_it_parking_first_park() {
        Car car = new Car();
        Ticket ticket = parkBoy.in(car);
        Assert.assertSame(car, parkBoy.out(ticket));
    }

    /*
     * 	当停一辆车在第二个停车场时，通过停车票据取出原来的车；
     */
    @Test
    public void out_a_car_when_it_parking_second_park() {
        for(int i = 0; i < 5; i ++) {
            parkBoy.in(new Car(String.valueOf(i)));
        }
        Car car = new Car();
        Ticket ticket = parkBoy.in(car);
        Assert.assertEquals(parkBoy.getParkSize(1), this.SECOND_PARK_SIZE - 1);
        Assert.assertSame(car, parkBoy.out(ticket));
    }

    
    /*
     * 	当所有停车场没有车时，进行取车失败；
     */
    @Test(expected = ParkException.class)
    public void out_a_car_when_all_park_is_empty() {
        parkBoy.out(new Ticket());
    }

    /*
     * 	当所有停车场已停满车时，进行停车失败
     */
    @Test(expected = ParkException.class)
    public void in_a_car_when_all_park_is_full() {
        for(int i = 0; i <= 15; i ++) {
            parkBoy.in(new Car(String.valueOf(i)));
        }
    }

    /*
     * 平均策略停车测试
     */
    @Test
    public void every_park_stop_five_car_when_in_ten_car_and_average_strategy() {
        parkBoy = new ParkBoy(new AverageStrategy());
        parkBoy.handlePark(new Park(this.FIRST_PARK_SIZE));
        parkBoy.handlePark(new Park(this.SECOND_PARK_SIZE));
        for(int i = 0; i < 10; i ++) {
            parkBoy.in(new Car(String.valueOf(i)));
            Assert.assertEquals(parkBoy.getParkSize(0), this.FIRST_PARK_SIZE - (i / 2 + 1));
            Assert.assertEquals(parkBoy.getParkSize(1), this.SECOND_PARK_SIZE - (i + 1) / 2);
        }
    }

    /*
     * 	使用空置率策略停15辆车时，测试每停一辆车后两个停车场的空车位
     */
    @Test
    public void VacancyRateStrategy() {
        parkBoy = new ParkBoy(new VacancyRateStrategy());
        parkBoy.handlePark(new Park(this.FIRST_PARK_SIZE));
        parkBoy.handlePark(new Park(this.SECOND_PARK_SIZE));
        for(int i = 0; i < 15; i ++) {
            parkBoy.in(new Car(String.valueOf(i)));
            if(i==0){
            	Assert.assertEquals(parkBoy.getParkSize(0), 4);
            }else if(i==1){
            	Assert.assertEquals(parkBoy.getParkSize(1), 9);
            }else if(i==2){
            	Assert.assertEquals(parkBoy.getParkSize(1), 8);
            }else if(i==3){
            	Assert.assertEquals(parkBoy.getParkSize(0), 3);
            }else if(i==4){
            	Assert.assertEquals(parkBoy.getParkSize(1), 7);
            }else if(i==5){
            	Assert.assertEquals(parkBoy.getParkSize(1), 6);
            }else if(i==6){
            	Assert.assertEquals(parkBoy.getParkSize(0), 2);
            }else if(i==7){
            	Assert.assertEquals(parkBoy.getParkSize(1), 5);
            }else if(i==8){
            	Assert.assertEquals(parkBoy.getParkSize(1), 4);
            }else if(i==9){
            	Assert.assertEquals(parkBoy.getParkSize(0), 1);
            }else if(i==10){
            	Assert.assertEquals(parkBoy.getParkSize(1), 3);
            }else if(i==11){
            	Assert.assertEquals(parkBoy.getParkSize(1), 2);
            }else if(i==12){
            	Assert.assertEquals(parkBoy.getParkSize(0), 0);
            }else if(i==13){
            	Assert.assertEquals(parkBoy.getParkSize(1), 1);
            }else if(i==14){
            	Assert.assertEquals(parkBoy.getParkSize(1), 0);
            }
        }
    }
    
    
    

}
