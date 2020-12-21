package com.example.demo.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritetoFile {
	String fileName;
	String content;
	String path;
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path = path; 
	}
	
	public WritetoFile(String fileName, String content, String path) {
		super();
		this.fileName = fileName;
		this.content = content;
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void write() throws IOException
	{
		File saveFile = new File(path + fileName);

		// write code in the fileName.cpp file
		FileWriter myWriter = new FileWriter(saveFile);
		myWriter.write(content);
		myWriter.close(); 
	}
}
