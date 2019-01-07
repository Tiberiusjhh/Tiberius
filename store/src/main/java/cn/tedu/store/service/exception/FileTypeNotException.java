package cn.tedu.store.service.exception;

/**
 * 上传文件类型不匹配异常
 * @author Tiberius
 *
 */
public class FileTypeNotException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306128986753062325L;

	public FileTypeNotException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileTypeNotException(String msg, Throwable cause) {
		super(msg, cause);
		// TODO Auto-generated constructor stub
	}

	public FileTypeNotException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
