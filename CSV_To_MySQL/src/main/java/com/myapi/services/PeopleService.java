package com.myapi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myapi.dao.PeopleRepository;
import com.myapi.entity.People;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeopleService {

	
	private final PeopleRepository peopleRepository;

	public Integer uploadPeople(MultipartFile file) throws IOException {
        Set<People> students = parseCsv(file);
        peopleRepository.saveAll(students);
        return students.size();
    }

    private Set<People> parseCsv(MultipartFile file) throws IOException {
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<PeopleCsvREpresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(PeopleCsvREpresentation.class);
            CsvToBean<PeopleCsvREpresentation> csvToBean =
                    new CsvToBeanBuilder<PeopleCsvREpresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> People.builder()
                            .description(csvLine.getDescription())
                            .name(csvLine.getName())
                            .num1(csvLine.getNum1())
                            .num2(csvLine.getNum2())
                            .num3(csvLine.getNum3())
                            .num4(csvLine.getNum4())
                            .place(csvLine.getPlace())
                            .category(csvLine.getCategory())
                            .rate(csvLine.getRate())
                            .build()
                    )
                    .collect(Collectors.toSet());
        }
    }
}
