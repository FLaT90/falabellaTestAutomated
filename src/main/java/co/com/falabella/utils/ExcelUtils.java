package co.com.falabella.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class ExcelUtils {


   private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        File file = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int rowNumber, int cellNumber) {
        Cell cell = sheet.getRow(rowNumber).getCell(cellNumber);

        if (cell != null) {
            cell.setCellType(CellType.STRING); // Asegura que se lea como texto
            return cell.getStringCellValue();
        } else {
            return ""; // Retorna cadena vacía si la celda está vacía
        }
    }

    public int getRowCountInSheet() {
        return sheet.getPhysicalNumberOfRows();
    }

    public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        Cell cell = row.createCell(cellNum);
        cell.setCellValue(cellValue);

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }
}
