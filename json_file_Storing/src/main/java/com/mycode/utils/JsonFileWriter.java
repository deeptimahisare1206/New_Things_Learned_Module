package com.mycode.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mycode.models.CoordinatorRequest;

@Component
public class JsonFileWriter {
	@Value("${json.file.path:coordinators.json}")
	private String filePath;
//    private static final String FILE_PATH = "coordinators.json";

    public synchronized void writeCoordinatorToFile(CoordinatorRequest request) {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        List<CoordinatorRequest> coordinators = new ArrayList<>();
        File file = new File(filePath);

        try {
            if (file.exists()) {
                CoordinatorRequest[] existing = mapper.readValue(file, CoordinatorRequest[].class);
                coordinators = new ArrayList<>(Arrays.asList(existing));
            }

            coordinators.add(request);
            mapper.writeValue(file, coordinators);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

