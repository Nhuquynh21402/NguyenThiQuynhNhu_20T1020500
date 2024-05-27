package com.fpt.ojtstem.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;

public class  UpdateMovieAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HttpServletRequest request;
	private File imgFile;
	private String fileName;
	private String fileContent;
	
	
	public String UploadFile() {
		try {
			String Path=request.getContextPath();
			File myFile= new File(Path,fileName);
			FileUtils.copyFile(imgFile, myFile);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public File getImgFile() {
		return imgFile;
	}


	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileContent() {
		return fileContent;
	}


	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}