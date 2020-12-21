package com.example.demo.controller;

public class CompileLog {
	public boolean compileStatus;
	public String compileErrors;
	public String codeOutput;
	
	public CompileLog(boolean compileStatus, String compileErrors, String codeOutput) {
		super();
		this.compileStatus = compileStatus;
		this.compileErrors = compileErrors;
		this.codeOutput = codeOutput;
	}
	public boolean getCompileStatus() {
		return compileStatus;
	}
	public void setCompileStatus(boolean compileStatus) {
		this.compileStatus = compileStatus;
	}
	public String getCompileErrors() {
		return compileErrors;
	}
	public void setCompileErrors(String compileErrors) {
		this.compileErrors = compileErrors;
	}
	public String getCodeOutput() {
		return codeOutput;
	}
	public void setCodeOutput(String codeOutput) {
		this.codeOutput = codeOutput;
	}
	
}
