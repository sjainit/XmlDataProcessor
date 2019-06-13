package com.companyname.data.controller;
import com.companyname.domain.KeyValue;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.companyname.data.service.TestDataService;

@RestController
public class DataController {
	@Autowired
	private TestDataService testDataService;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/getxml")
	public List<KeyValue> getJson(@RequestParam("file") MultipartFile File) throws IOException, JSONException {
		List<KeyValue> response=null;
		response = testDataService.getJson(File);
		System.out.println("file content : " + response);
		return response;
	}
}