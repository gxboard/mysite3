package kr.co.saramin.mysite3.exception;

public class UserDaoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDaoException(String message) {
		super(message);
	}
	
	public UserDaoException()
	{
		super("UserDaoException Occurs");
	}
}
