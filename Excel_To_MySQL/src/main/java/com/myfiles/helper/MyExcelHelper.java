package com.myfiles.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.myfiles.entity.Product;

public class MyExcelHelper {

	// check the file for excel format
	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();
		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	// Convert excel to ist of products

	public static List<Product> convertExcelToListOfProduct(InputStream is) {

		List<Product> list = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowNumber = 0;

			Iterator<Row> itertor = sheet.iterator();

			while (itertor.hasNext()) {
				Row row = itertor.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;
				Product p = new Product();
				while (cells.hasNext()) {

					Cell cell = cells.next();

					switch (cid) {
					case 0: {

						p.setProductId((int) cell.getNumericCellValue());
						break;
					}
					case 1: {

						p.setProductName(cell.getStringCellValue());
						break;
					}
					case 2: {

						p.setTaskName(cell.getStringCellValue());
						break;
					}
					case 3: {

						p.setAssignedTo(cell.getStringCellValue());
						break;
					}
					case 4: {

						p.setStartDate(cell.getDateCellValue());
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + cid);

					}
					cid++;
				}
				list.add(p);
workbook.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}
}
