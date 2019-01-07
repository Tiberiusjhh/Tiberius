package cn.tedu.store.service.exception;

/**
 * 父类异常
 * 
 * @author Tiberius
 *
 */
public class SeviceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3985251940488175731L;

	public SeviceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SeviceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeviceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SeviceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
