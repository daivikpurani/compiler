package com.example.demo.controller;

import java.io.*;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;


public class Compiler {
	private String fileName;
	private String language;
	private String code;
	private String compileOutput;
	private String input;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	private boolean status = true;
	
	public String getCompileOutput() {
		return compileOutput;
	}
	public void setCompileOutput(String compileOutput) {
		this.compileOutput = compileOutput;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String compileProcess() throws IOException, InterruptedException
	{
		if(language.equals("python"))
		{
		
		//create fileName.py file
		File saveFile = new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\python\\" + fileName);

		// write code in the fileName.py file
		FileWriter myWriter = new FileWriter(saveFile);
		myWriter.write(code);
		myWriter.close(); 
		
		//create input.txt file
		File saveInputFile = new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\python\\input.txt");

		// write input in input.txt file
		FileWriter myWriterInput = new FileWriter(saveInputFile);
		myWriterInput.write(input);
		myWriterInput.close(); 
		
		//compile
			//commands
		String[] command = {language, "C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\python\\" + fileName, "<", "input.txt"};
			//process builder
        ProcessBuilder builder = new ProcessBuilder(command);
        builder = builder.directory(new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\python\\"));
        Process proc = builder.start();
        
        //read errors
    	BufferedReader stdError = new BufferedReader(new 
       	     InputStreamReader(proc.getErrorStream()));
        
        try
        {
        	System.out.println(stdError.readLine());	
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
        
        String s = "";
        
    	// Read any errors from the attempted command
    	while ((s = stdError.readLine()) != null) 
    	{
    		compileOutput += s;
    	}
    	
    	// if errors return log
    	if(compileOutput != null &&  !compileOutput.equals(""))
    	{
    		status = false;
    		return compileOutput;
    	}
        
    
    	// read output
//        String[] inputCommand = {input};
//        ProcessBuilder inputBuilder = new ProcessBuilder(inputCommand);
//        builder = builder.directory(new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\python\\"));
//        Process inputProc = inputBuilder.start();
//        builder.redirectInput(Redirect.from("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\python\\input.txt"));
        
        
        BufferedReader stdInput = new BufferedReader(new 
        	     InputStreamReader(proc.getInputStream()));

        s = "";
    	while ((s = stdInput.readLine()) != null) {
    	    compileOutput += s;
    	}
    	
    		
    
        	
        return compileOutput;	
        	
  
		}
		
		else if(language.equals("cpp"))
		{
			WritetoFile wt = new WritetoFile(fileName, code, "C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\");
			wt.setFileName(fileName);
			wt.setPath("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\");
			wt.setContent(code);
			
			wt.write();
			
			WritetoFile inputwt = new WritetoFile("input.txt", input, "C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\");
			inputwt.setContent(input);
			inputwt.setFileName("input.txt");
			inputwt.setPath("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\");
			inputwt.write();

			//compile
			String[] compileCommand = {"g++", fileName};
	        ProcessBuilder compileBuilder = new ProcessBuilder(compileCommand);
	        compileBuilder = compileBuilder.directory(new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\"));
	        String compileOutput = "";
	        Process proc = compileBuilder.start();
	        
	        TimeUnit.SECONDS.sleep(3);
	        File temp = new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\a.exe");
	        if(temp.exists())
	        
	        {String s = "";
	        BufferedReader stdError = new BufferedReader(new 
	        	     InputStreamReader(proc.getErrorStream()));
	        
	        
	        while ((s = stdError.readLine()) != null) {
        		compileOutput += s;
        	}
	        
	        if(compileOutput.equals("") && compileOutput != null)
        		status = true;
	        else
	        {
	        	status = false;
	        	return compileOutput;
	        }
	        
	        TimeUnit.SECONDS.sleep(3);
	        
	        String[] inputCommand = {"C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\a.exe", "<", "input.txt"};
	        ProcessBuilder inputBuilder = new ProcessBuilder(inputCommand);
	        inputBuilder = inputBuilder.directory(new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\"));
	        Process inputProc = inputBuilder.start();
	        
	        
	        
//	        String[] outputCommand = {"C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\a.exe", "<", "input.txt"};
//	        ProcessBuilder outputBuilder = new ProcessBuilder(outputCommand);
//	        outputBuilder = outputBuilder.directory(new File("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\cpp\\" ));
//	   
//	        Process outputProc = outputBuilder.start();  
	        
	        s = "";
	        BufferedReader stdInput = new BufferedReader(new 
	        	     InputStreamReader(inputProc.getInputStream()));
	        	// Read the output from the command
	        	while ((s = stdInput.readLine()) != null) {
	        	    compileOutput += s;
	        	}
	        	
	        	return compileOutput;}
	        else
	        	System.out.println("Not found");
		}
		else if(language.equals("java"))
		{
			WritetoFile wt = new WritetoFile(fileName, code, "C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\java\\");
			wt.setFileName(fileName);
			wt.setPath("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\java\\");
			wt.setContent(code);
			
			wt.write();
			
			WritetoFile inputwt = new WritetoFile("input.txt", input, "C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\java\\");
			inputwt.setContent(input);
			inputwt.setFileName("input.txt");
			inputwt.setPath("C:\\Users\\purani\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\CodeFiles\\java\\");
			inputwt.write();

			ProcessBuilder pb = new ProcessBuilder();
			File commands = new File("commands.txt");
			File error = new File("error.txt");
			File output = new File("output.txt");
			
			 pb.redirectInput(commands); 
	         pb.redirectOutput(output); 
	         pb.redirectError(error); 
	  
			
		}
		
		return "";
		
		
	}
	
	public boolean Status()
	{
		return status;	
	}
	
	
	
}
