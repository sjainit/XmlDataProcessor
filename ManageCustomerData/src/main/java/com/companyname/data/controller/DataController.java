package com.companyname.data.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.companyname.crudXml.crudXml;
import com.companyname.data.service.TestDataService;
import com.companyname.domain.KeyValue;

@RestController
public class DataController {
	File filetemp;
	int temp = 0;
	@Autowired
	private TestDataService testDataService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/getxml")
	public Map<String, KeyValue> getJson(@RequestParam("file") MultipartFile File) throws Exception {
		temp = 0;

		Map<String, KeyValue> response = null;
		filetemp = TestDataService.convert(File);

		response = testDataService.getJson(File);
//		System.out.println(response);
		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/update")
	public void updateController(@RequestBody ArrayList<String> response)
			throws XPathExpressionException, TransformerFactoryConfigurationError, SAXException, IOException,
			ParserConfigurationException, TransformerException

	{

		crudXml.Update(response.get(0), response.get(1), filetemp, temp++);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/delete")
	public void deleteController(@RequestBody String response) throws TransformerFactoryConfigurationError, Exception

	{
		crudXml.Delete(response, filetemp, temp++);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/generate")
	public Map<String, KeyValue> generateController() throws TransformerFactoryConfigurationError, Exception

	{
		Map<String, KeyValue> response = null;
		response = testDataService.getJson(new File("C:\\ProjectM1\\FINAL\\newest.xml"));
		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/saveChild")
	public void addChildController(@RequestBody ArrayList<String> response)
			throws TransformerFactoryConfigurationError, Exception

	{

		String tagName = response.get(1);
		String tagValue = response.get(2);
		String xPath = response.get(0);
		crudXml.saveChild(xPath, tagName, tagValue, temp++, filetemp);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/saveObject")
	public void addObjectController(@RequestBody ArrayList<String> response) {
		int length = response.size();

	}

}