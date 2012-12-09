package cn.edu.buaa.park;


/**
 * 策略工厂类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class StrategyFactory {
    public static Strategy getStrategy(String strategyName) {
        if("average".equals(strategyName)) {
            return new AverageStrategy();
        } else if("vacancyRate".equals(strategyName)) {
            return new VacancyRateStrategy();
        } else {
            return new DefaultStrategy();
        }
    }
}
