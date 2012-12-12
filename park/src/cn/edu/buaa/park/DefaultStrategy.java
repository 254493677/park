package cn.edu.buaa.park;

import java.util.List;


/**
 * 默认策略，先将第一个停车场停满再停第二个停车场
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class DefaultStrategy extends AbstractStrategy implements Strategy {
    @Override
    public Ticket in(Car car, List<Park> parkList) {
        for(Park park : parkList) {
            if (!park.isFull()) {
                return park.in(car);
            }
        }
        throw new ParkException("没有空的停车位！");
    }

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "默认策略";
	}
}
