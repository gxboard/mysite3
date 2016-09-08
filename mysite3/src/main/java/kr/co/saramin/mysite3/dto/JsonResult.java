package kr.co.saramin.mysite3.dto;

public class JsonResult {
	private String result; // success or fail
	private String message; // fail 이면 원인,
	private Object data; // 데이타 객체

	public JsonResult(Boolean result, String message, Object data) {
	    this.result = result ? "success" : "fail";
	    this.message = message;
	    this.data = data;
	}
	public JsonResult(Boolean result, String message) {
        this.result = result ? "success" : "fail";
        this.message = message;
    }
	
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	

}
