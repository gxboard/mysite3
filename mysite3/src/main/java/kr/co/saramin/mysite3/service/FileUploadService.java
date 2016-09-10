/**
 * 
 */
package kr.co.saramin.mysite3.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.saramin.mysite3.exception.FileUploadServiceException;

/**
 * @author user1
 *
 */
@Component
public class FileUploadService {
    
    @Transactional
    public String saveFile(MultipartFile multipartFile) {
        
        if (multipartFile.isEmpty()) {
            throw new FileUploadServiceException("Upload File Empty");
        }
        
        String originalFileName = multipartFile.getOriginalFilename();
        String extName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length());
        String contentType = multipartFile.getContentType();
        
        String saveFileName = genSaveFileName(extName);
        
        System.out.println(originalFileName);
        System.out.println(extName);
        System.out.println(contentType);
        System.out.println(saveFileName);
        
        writeFile(multipartFile, saveFileName);
        
        return saveFileName;
    }
    
    private void writeFile( MultipartFile file, String fileName ) {
        
        String savePath = "c:/saramin/upload" + fileName;
        
        FileOutputStream fos = null;
        try {
            byte fileData[] = file.getBytes();
            fos = new FileOutputStream(savePath );
            fos.write(fileData);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileUploadServiceException("error: " + e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }
        }
    }
    
    private String genSaveFileName( String extName ) {
        Calendar calendar = Calendar.getInstance();
        String fileName = "";
        
        fileName += calendar.get( Calendar.YEAR );
        fileName += calendar.get( Calendar.MONTH );
        fileName += calendar.get( Calendar.DATE );
        fileName += calendar.get( Calendar.HOUR );
        fileName += calendar.get( Calendar.MINUTE );
        fileName += calendar.get( Calendar.SECOND );
        fileName += calendar.get( Calendar.MILLISECOND );
        fileName += ( "." + extName );
        
        System.out.println(fileName);
        
        return fileName;
    }
    
    

}
