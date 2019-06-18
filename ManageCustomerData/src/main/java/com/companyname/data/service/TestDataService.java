package com.companyname.data.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.companyname.domain.KeyValue;;

@Service
public class TestDataService {

	public Map<String, KeyValue> getJson(MultipartFile File) throws Exception {
		File file = convert(File);
		return FragmentControlHandler.passfile(file);
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
