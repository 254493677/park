package cn.edu.buaa.park;


/**
 * 票据类
 * @author 巩晓冬
 * @date 2012-12-9
 * @version 1.0
 */
public class Ticket {
	// 票据编码
	private String code;
	
	/**
	 * 构造器
	 */
	public Ticket(String code) {
		this.code = code;
	}

	/**
	 * 构造器
	 */
	public Ticket() {
	}

	/**
	 * 获取票据编号
	 */
	public String getCode() {
		return code;
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
		Ticket other = (Ticket) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}