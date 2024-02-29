package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet worksheet;
    public XSSFRow row;
    public XSSFCell cell;

    public XSSFCellStyle cellStyle;
    String path = null;

    public ExcelUtils(String path) {
        this.path = path;
    }

    public int getRowCount(String xlsheet) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);
        int rowCount = worksheet.getLastRowNum();
        workbook.close();
        fi.close();

        return rowCount;
    }

    public int getCellCount(String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);
        row = worksheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();

        return cellCount;
    }

    public String getCellData(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);
        row = worksheet.getRow(rownum);
        cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String ...
        } catch (Exception e) {
            data = "";
        }
        workbook.close();
        fi.close();
        return data;
    }

    public void setCellData(String xlsheet, int rownum, int colnum, String data) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);

        row = worksheet.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);

        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    public void fillGreenColor(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);

        row = worksheet.getRow(rownum);
        cell = row.getCell(colnum);

        cellStyle = workbook.createCellStyle();

        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(cellStyle);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

    public void fillResColor(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        worksheet = workbook.getSheet(xlsheet);

        row = worksheet.getRow(rownum);
        cell = row.getCell(colnum);

        cellStyle = workbook.createCellStyle();

        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(cellStyle);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }


//
//    public static FileInputStream fi;
//    public static FileOutputStream fo;
//    public static XSSFWorkbook workbook;
//    public static XSSFSheet worksheet;
//    public static XSSFRow row;
//    public static XSSFCell cell;
//
//
//    public static int getRowCount(String xlfile,String xlsheet) throws IOException {
//        fi = new FileInputStream(xlfile);
//        workbook = new XSSFWorkbook(fi);
//        worksheet = workbook.getSheet(xlsheet);
//        int rowsCount = worksheet.getLastRowNum();
//        workbook.close();
//        fi.close();
//
//        return rowsCount;
//    }
//
//    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
//        fi = new FileInputStream(xlfile);
//        workbook = new XSSFWorkbook(fi);
//        worksheet = workbook.getSheet(xlsheet);
//        row = worksheet.getRow(rownum);
//        int cellCount = row.getLastCellNum();
//        workbook.close();
//        fi.close();
//
//        return cellCount;
//    }
//
//    public static String getCellData(String xlfile, String xlsheet, int rownum,int colnumber) throws IOException {
//        fi = new FileInputStream(xlfile);
//        workbook = new XSSFWorkbook(fi);
//        worksheet = workbook.getSheet(xlsheet);
//        row = worksheet.getRow(rownum);
//        cell = row.getCell(colnumber);
//        String data;
//        try {
//            DataFormatter formatter = new DataFormatter();
//            String cellData = formatter.formatCellValue(cell);
//            return cellData;
//        }catch (Exception e){
//            data="";
//        }
//        workbook.close();
//        fi.close();
//        return data;
//    }
//
//    public static void setCellData(String xlfile, String xlsheet, int rownum,int colnumber, String data) throws IOException {
//        fi = new FileInputStream(xlfile);
//        workbook = new XSSFWorkbook(xlsheet);
//        worksheet = workbook.getSheet(xlsheet);
//        row = worksheet.getRow(rownum);
//        cell = row.createCell(colnumber);
//        cell.setCellValue(data);
//
//        fo =new FileOutputStream(xlfile);
//        workbook.write(fo);
//        workbook.close();
//        fi.close();
//        fo.close();
//    }
}
