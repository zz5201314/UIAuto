package com.first.utils;

/**
 * Created by Administrator on 2017-08-21.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.first.uiframework.TestCase;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    public static void checkExcelVaild(File file) throws Exception{
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }

    public static Workbook getWorkbook(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
       if(file.getName().endsWith(EXCEL_XLS)){
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    @SuppressWarnings("deprecation")
    public static String convertCellValveToString(Cell cell){
        int cellType = cell.getCellType();
        String cellValue = "";
        switch (cellType) {
            case Cell.CELL_TYPE_STRING:     // 文本
                cellValue = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:    // 数字、日期
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = fmt.format(cell.getDateCellValue());
                } else {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:    // 布尔型
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK: // 空白
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_ERROR: // 错误
                cellValue = "错误";
                break;
            case Cell.CELL_TYPE_FORMULA:    // 公式
                // 得到对应单元格的公式
                //cellValue = cell.getCellFormula() + "#";
                // 得到对应单元格的字符串
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                break;
            default:
                cellValue = cell.getStringCellValue().toString();
        }
        return cellValue;
    }

    public static List<TestCase> getUITestData(String fileName){
        List<com.first.uiframework.TestCase> testCases = new ArrayList<TestCase>();
        try{
            String filePath=System.getProperty("user.dir")+"/testcasedata/"+fileName;

            File excelFile = new File(filePath); // 创建文件对象
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Row firstRow = sheet.getRow(0);
            int count = 0;
            for(Row row:sheet){
                if(count == 0){
                    count++;
                    continue;
                }
                if(row.getCell(0).toString().equals("") || row.getCell(1).toString().equals("notRun")){
                    continue;
                }
                String caseName = convertCellValveToString(row.getCell(0));
                String isCheck = convertCellValveToString(row.getCell(2));
                String expectedResult = convertCellValveToString(row.getCell(3));
                Map<String,String> testData = new HashMap<String,String>();
                int skipNum = 0;  //跳过用例必需字段标识，键值对能对应的下标
                for(Cell cell : row){
                    if(skipNum < 4){
                        skipNum++;
                        continue;
                    }
                    if(cell.toString() == null){
                        continue;
                    }
                    testData.put(convertCellValveToString(firstRow.getCell(skipNum++)), convertCellValveToString(cell));
                }
                testCases.add(new TestCase(caseName,isCheck,expectedResult,testData));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return testCases;
    }

//	public static Map<String,UITestCase> getUITestData(String filepath) throws IOException{
//		Map<String,UITestCase> testcasesmap = new HashMap<String,UITestCase>();
//		File execlfile = new File(filepath);
//		FileInputStream is = new FileInputStream(execlfile);
//		Workbook workbook = new HSSFWorkbook(is);
//		Sheet sheet = workbook.getSheetAt(0);
//		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
//			Row row = sheet.getRow(i);
//			UITestCase uc = null;
//			String casename = row.getCell(0).toString();
//			String modelname = row.getCell(1).toString();
//			String[] testdata = row.getCell(2).toString().split(",");
//			String result = row.getCell(3).toString();
//			String isnot = row.getCell(4).toString();
//			uc = new UITestCase(casename,modelname,testdata,result,isnot);
//			testcasesmap.put(casename, uc);
//		}
//		return testcasesmap;
//	}

}
