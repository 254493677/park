package cn.edu.buaa.park;

import java.util.List;


/**
 * 停车策略接口类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public interface Strategy {
    /**
     * 停车
     * @param car	车
     * @param parkList	停车场列表
     * @return	停车票据
     */
    public Ticket in(Car car, List<Park> parkList);
    
    public String getStrategyName();
}
