package com.codes.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codes.entity.Users;
import com.codes.repository.UserRepo;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<Users> listAll() {

		return userRepo.findAll();

	}

	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Users> listUsers = listAll();

		UserPdfExporter exporter = new UserPdfExporter(listUsers);
		exporter.export(response);

	}

	public Users createuser(Users users) {
		return userRepo.save(users);
	}
}
