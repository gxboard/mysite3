/**
 * 
 */
package kr.co.saramin.mysite3.exception;


/**
 * @author user1
 *
 */
public class FileUploadServiceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -5454223483222727250L;
    
    public FileUploadServiceException(String message) {
        super(message);
    }
    
    public FileUploadServiceException()
    {
        super();
    }

}
