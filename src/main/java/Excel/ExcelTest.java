package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelTest {

	// static HSSFRow row;
	// static HSSFCell cell;

	static XSSFRow row;
	static XSSFCell cell;

	public static void main(String[] args) {

		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/Users/JSK/Desktop/14.xlsx");

			XSSFWorkbook workbook;
			
				workbook = new XSSFWorkbook(fis);
			
			int rowindex = 0;
			int columnindex = 0;
			// 시트 수 (첫번째에만 존재하므로 0을 준다)
			// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
			XSSFSheet sheet = workbook.getSheetAt(0);
			// 행의 수
			int rows = sheet.getPhysicalNumberOfRows();
			
			
			XSSFCellStyle cs = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();
			font.setFontHeight((short)8);
			font.setFontHeightInPoints((short)8);
			font.setBoldweight((short)700);
			font.setFontName("맑은 고딕");
			cs.setFont(font);
			
			cs.setVerticalAlignment(cs.ALIGN_CENTER);
			cs.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
			cs.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			cs.setBorderTop(XSSFCellStyle.BORDER_THIN);
			cs.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			cs.setBorderRight(XSSFCellStyle.BORDER_THIN);
			
			XSSFCell cell = sheet.getRow(1).createCell(5);
			cell.setCellStyle(cs);
			cell.setCellValue(1);
			
			cell = sheet.getRow(2).createCell(5);
			cell.setCellValue("김준성");
			cell.setCellStyle(cs);
			
//			for (rowindex = 1; rowindex < rows; rowindex++) {
//				// 행을읽는다
//				XSSFRow row = sheet.getRow(rowindex);
//				if (row != null) {
//					// 셀의 수
//					int cells = row.getPhysicalNumberOfCells();
//					for (columnindex = 0; columnindex <= cells; columnindex++) {
//						// 셀값을 읽는다
//						XSSFCell cell = row.getCell(columnindex);
//						String value = "";
//						// 셀이 빈값일경우를 위한 널체크
//						if (cell == null) {
//							continue;
//						} else {
//							// 타입별로 내용 읽기
//							switch (cell.getCellType()) {
//							case XSSFCell.CELL_TYPE_FORMULA:
//								value = cell.getCellFormula();
//								break;
//							case XSSFCell.CELL_TYPE_NUMERIC:
//								value = cell.getNumericCellValue() + "";
//								break;
//							case XSSFCell.CELL_TYPE_STRING:
//								value = cell.getStringCellValue() + "";
//								break;
//							case XSSFCell.CELL_TYPE_BLANK:
//								value = cell.getBooleanCellValue() + "";
//								break;
//							case XSSFCell.CELL_TYPE_ERROR:
//								value = cell.getErrorCellValue() + "";
//								break;
//							}
//						}
//						System.out.println("각 셀 내용 :" + value);
//					}
//				}
//			}
			FileOutputStream outFile;
			outFile = new FileOutputStream("XlsWrite2.xlsx");
			workbook.write(outFile);
			outFile.close();
			
			System.out.println("파일생성 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}