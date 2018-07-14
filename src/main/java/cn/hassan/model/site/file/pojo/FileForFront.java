package cn.hassan.model.site.file.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**  
 * 文件上传时,用到该pojo
 * @author 
 * @version 1.0  
 * @created 2013-03-29 15:34:28
 */
@Data
public class FileForFront {
	//private String id;
	/**
	 * 文件名称，带扩展名，必传
	 */
	private String  name;
	/*
	*文件类型
	*/
	private String type;
	/**
	 * 文件md5值，必传
	 */
	private String md5;
	//private Date lastModifiedDate;
	private Long size;
	private Integer chunks;
	private Integer chunk;
	private MultipartFile file;
	private final Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
	private String fileUUID;

	public String getName(){
		String fileName = name;
      	Matcher matcher = pattern.matcher(fileName);
      	fileName = matcher.replaceAll("");
      	return fileName;
	}

}
