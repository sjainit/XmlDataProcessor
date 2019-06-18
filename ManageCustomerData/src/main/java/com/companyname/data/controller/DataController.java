package com.companyname.data.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.companyname.data.service.TestDataService;
import com.companyname.domain.KeyValue;

@RestController
public class DataController {
	@Autowired
	private TestDataService testDataService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/getxml")
	public Map<String, KeyValue> getJson(@RequestParam("file") MultipartFile File) throws Exception {
		Map<String, KeyValue> response = null;
		response = testDataService.getJson(File);
		System.out.println(response);
		return response;
	}
}