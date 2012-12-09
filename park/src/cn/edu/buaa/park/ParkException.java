package cn.edu.buaa.park;


/**
 * 停车场异常类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class ParkException extends RuntimeException {
	private static final long serialVersionUID = -2323948745820049860L;

	public ParkException(String msg) {
        super(msg);
    }
}
