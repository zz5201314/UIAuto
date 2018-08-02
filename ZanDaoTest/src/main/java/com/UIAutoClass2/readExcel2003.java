package com.UIAutoClass2;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017-08-15.
 */
public class readExcel2003 {
    public static void main(String[] args) throws IOException {
        File excelFile =new File("testData/SubmitTest/SubmitData.xls");
        FileInputStream in=new FileInputStream(excelFile);
        HSSFWorkbook wb= new HSSFWorkbook(in);
       //读取第一个sheet
        HSSFSheet sheet=wb.getSheetAt(0);

        //总的行数和列数
        int countRow=sheet.getLastRowNum()+1;
        System.out.println("总的行数"+countRow);
        //第三行列数
        int countColum=sheet.getRow(2).getPhysicalNumberOfCells();
        System.out.println("第三行列数"+countColum);

        //取数据
        Row row =sheet.getRow(2);
        Cell cell0 =row.getCell(0);
        Cell cell1 =row.getCell(1);
        System.out.println(cell0.getStringCellValue());
        System.out.println(cell1.getNumericCellValue());
    }
}
