package com.cf;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cf.model.Hotel;
 
public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Hotel> listHotels;
     
    public ExcelExporter(List<Hotel> listHotels)
    {
        this.listHotels = listHotels;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Hotels");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Hotels ID", style);      
        createCell(row, 1, "Hotels Name", style);       
        createCell(row, 2, "Open Timings", style);    
        createCell(row, 3, "Close Timings", style);
        createCell(row, 4, "Contact Numbers", style);
        createCell(row, 5, "Classification", style);
        createCell(row, 6, "Street Name", style);
        createCell(row, 7, "Area", style);
        createCell(row, 8, "City", style);
        createCell(row, 9, "Pincode", style);
        
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) 
    {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Hotel hotel : listHotels) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, hotel.getHotelId(), style);
            createCell(row, columnCount++, hotel.getName(), style);
            createCell(row, columnCount++, hotel.getOpenTiming(), style);
            createCell(row, columnCount++, hotel.getCloseTiming().toString(), style);
            createCell(row, columnCount++, hotel.getContactNumber(), style);
            createCell(row, columnCount++, hotel.getClassification(), style);
            createCell(row, columnCount++, hotel.getStreetName(), style);
            createCell(row, columnCount++, hotel.getArea(), style);
            createCell(row, columnCount++, hotel.getCity(), style);
            createCell(row, columnCount++, hotel.getPincode(), style);
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}