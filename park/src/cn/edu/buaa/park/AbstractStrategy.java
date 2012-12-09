package cn.edu.buaa.park;

import java.util.List;

/**
 * 
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public abstract class AbstractStrategy implements Strategy {
    @Override
    public abstract Ticket in(Car car, List<Park> parkList);
}
