package com.mycode.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycode.models.Coordinator;

@Component
public class CoordinatorJsonFile {

	@Value("${json.file.path:coordinators.json}")
	private String filePath;
	
	
	public synchronized void writeCoordinatorsList(Coordinator request) {
		
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		
		List<Coordinator> coordinators = new ArrayList<>();
		File file = new File(filePath);
		
		try {
			if(file.exists()) {
				Coordinator[] existing = mapper.readValue(file, Coordinator[].class);
				coordinators = new ArrayList<>(Arrays.asList(existing));
			}
			coordinators.add(request);
			mapper.writeValue(file, coordinators);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
