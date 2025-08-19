package marathon3_integration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData_Integration {
	
	public static String[][] readdata() throws IOException {
		FileInputStream file = new FileInputStream("./data/LoginData_Integration.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount= sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		System.out.println("Num of Rows : " + rowcount);
		System.out.println("Num of Cells : " + colcount);
		
		String[][] data = new String[rowcount][colcount];
		
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(stringCellValue);
				data[i-1][j] = stringCellValue;
			}
		}
		workbook.close();
		return data;
		
	}

	

}
