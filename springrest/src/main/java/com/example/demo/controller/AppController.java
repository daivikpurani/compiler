package com.example.demo.controller;


import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import java.util.Map;


//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@RequestMapping(value = "/process", 
		    method = RequestMethod.POST)
	public CompileLog process(@RequestBody JSONObject jsonData) throws Exception
	{
		//storing json data
		String fileName = jsonData.getJSONObject("body").getJSONObject("file1").getString("fileName");
		String language = jsonData.get("language").toString();
		String testInput = jsonData.get("input").toString();
		
		String file1
		
		
		
//		LinkedHashMap mp = new LinkedHashMap();
//		mp = (LinkedHashMap) jsonData.get("body");
		
		
		
		String encodedCode = jsonData.getJSONObject("body").get("file1")toString();
		java.util.Base64.Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encodedCode);
		String code = new String(bytes);
		
		
		// Compiler object
		Compiler comp = new Compiler();
		comp.setLanguage(language);
		comp.setFileName(fileName);
		comp.setCode(code);
		comp.setInput(testInput);
		
		String output = comp.compileProcess();
		System.out.println(output);
		
		boolean status = comp.Status();
		 
		if(status)
		{
			return new CompileLog(status, "", output);
		}
		else
		{
			return new CompileLog(status, output, "");
		}
	}
}
