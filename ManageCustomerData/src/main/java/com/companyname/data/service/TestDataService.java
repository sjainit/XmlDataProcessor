package com.companyname.data.service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.companyname.domain.KeyValue;


@Service
public class TestDataService {
 
	public List<KeyValue> getJson(MultipartFile File) throws IOException, JSONException {
		List<KeyValue> lhm = new ArrayList<>();
		File xml;
		xml=convert(File);
		try {
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(xml);
		System.out.println("Root element :" + document.getRootElement().getName());
		org.jdom2.Element classElement = document.getRootElement();

		List<org.jdom2.Element> children = classElement.getChildren();
		System.out.println("----------------------------");

		for (int i = 0; i < children.size(); i++) {
			org.jdom2.Element element = children.get(i);
			PrintNodes(element,lhm);
			
            
		}
		System.out.println("-----------printing----------------");
		lhm.stream().forEach(System.out::println);
		
	} catch (JDOMException e) {
		e.printStackTrace();
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}
		return lhm;
	}
public static void PrintNodes(org.jdom2.Element element,List<KeyValue> lhm) {
	
	

	List<org.jdom2.Element> elementList = element.getChildren();

	if (elementList.size() > 0) {
		
		System.out.println(element.getName());
		
		KeyValue keyValue = new KeyValue();
		
		keyValue.setKey(element.getName());
		keyValue.setValue(null);
		lhm.add(keyValue);
		
		  for (int i = 0; i <elementList.size(); i++) 
		  { 
			  org.jdom2.Element element2 = elementList.get(i);
			  PrintNodes(element2,lhm); 
		  }
		 
	} else {
		KeyValue keyValue = new KeyValue();
		
		keyValue.setKey(element.getName());
		keyValue.setValue(element.getText());
		lhm.add(keyValue);
		System.out.println(element.getName()+"\t\t"+element.getText());
	}
}

	
	public static File convert(MultipartFile file) throws IOException {

        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;

    }
	
}

