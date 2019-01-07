package cn.tedu.store.service.exception;
/**
 * 上传文件过大异常
 * @author Tiberius
 *
 */
public class FileSizeOutOfLimitException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5013345734371556887L;

	public FileSizeOutOfLimitException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileSizeOutOfLimitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileSizeOutOfLimitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileSizeOutOfLimitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileSizeOutOfLimitException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
