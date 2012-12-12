package cn.edu.buaa.park;

import java.util.List;


/**
 * 空置率策略，优先停在空置率高的停车场
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class VacancyRateStrategy extends AbstractStrategy implements Strategy {

	@Override
	public Ticket in(Car car, List<Park> parkList) {
		int no = -1;
		double num = -1d;
        for(int i = 0; i < parkList.size(); i ++) {
            Park park = parkList.get(i);
            if(park.isFull()) {
                continue;
            }
            double _rate = Math.round((float)park.getEmptyNum() / (float)park.getTotalNum() * 10000) / 10000.0;
            if(num < 0d) {
                num = _rate;
                no = i;
            }
            if(_rate > num) {
            	num = _rate;
                no = i;
            }
        }
        if(no > -1) {
            return parkList.get(no).in(car);
        }
        throw new ParkException("没有空的停车位！");
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "空置率策略";
	}
}
