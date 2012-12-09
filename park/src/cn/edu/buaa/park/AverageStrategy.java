package cn.edu.buaa.park;

import java.util.List;

/**
 * 
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class AverageStrategy extends AbstractStrategy implements Strategy {
    @Override
    public Ticket in(Car car, List<Park> parkList) {
		int no = -1;
		int num = -1;
        for(int i = 0; i < parkList.size(); i ++) {
            Park park = parkList.get(i);
            if(park.isFull()) {
                continue;
            }
            if(num < 0) {
                num = park.getTotalNum() - park.getEmptyNum();
                no = i;
            }
            if((park.getTotalNum() - park.getEmptyNum()) < num) {
                num = park.getTotalNum() - park.getEmptyNum();
                no = i;
            }
        }
        if(no > -1) {
            return parkList.get(no).in(car);
        }
        throw new ParkException("没有空的停车位！");
    }
}