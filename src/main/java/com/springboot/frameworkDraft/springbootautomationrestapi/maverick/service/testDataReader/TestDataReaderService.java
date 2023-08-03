package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.testDataReader;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.common.CommonService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TestDataReaderService {
    String filename;
    FileOutputStream fileOut = null;
    FileInputStream fis = null;

    String sheetPath;
    String sheetName;
    ArrayList<List<String>> testData;

    /**
     * Use this constructor when writing data to excel
     */
    public TestDataReaderService(){
    }

    public TestDataReaderService(String sheetName){
        String testDataWorkbookPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "aut", "reqResDotIn", "testData", "TestDataFile.xlsx").toString();
        readExcelFile(sheetName, testDataWorkbookPath);
    }

    public TestDataReaderService(String sheetName, String fileName){
        String testDataWorkbookPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "aut", "reqResDotIn", "testData", fileName+".xlsx").toString();
        readExcelFile(sheetName, testDataWorkbookPath);
    }

    public TestDataReaderService(String sheetName, String sheetPath, String fileName){
        String testDataWorkbookPath = Paths.get(sheetPath , fileName+".xlsx").toString();
        System.out.println(testDataWorkbookPath);
        readExcelFile(sheetName, testDataWorkbookPath);
    }


    public void readExcelFile(String sheetName, String sheetPath){
        try {
            filename = sheetPath;
            testData = new ArrayList<>();

            XSSFWorkbook workbook = null;
            XSSFSheet sheet = null;

            fis = new FileInputStream(filename);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            Iterator<Row> rows = sheet.rowIterator();

            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                List<String> data = new ArrayList<>();

                for (int i = 0; i < row.getLastCellNum(); i++) {
                    String str = convertXSSFCellToString(row.getCell(i));
                    data.add(str);
                }

                testData.add(data);
            }
            this.sheetName = sheetName;

        }
        catch (IOException e){
            System.out.println("Exception while reading file");
        }
        finally {
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public String convertXSSFCellToString(XSSFCell cell){
        String value = null;

        try{
            if(cell.getCellType() == CellType.NUMERIC)
                // value = Double.toString(cell.getNumericCellValue());
                value = new BigDecimal(cell.getNumericCellValue()).toPlainString();
            else if(cell.getCellType()== CellType.STRING)
                value = cell.getRichStringCellValue().toString();
            else if(cell.getCellType()== CellType.BOOLEAN)
                value = Boolean.toString(cell.getBooleanCellValue());
            else if(cell.getCellType() == CellType.BLANK)
                value = "";
            else if(cell.getCellType() == CellType.ERROR)
                value = "";

        }
        catch (NullPointerException e){
            value="";
        }

        return value;
    }

    public String fetchData(int row, String column){
        return fetchData(row, column, true);
    }
    public String fetchData(int row, String column, boolean isTrim){

        String data = "";
        List<String> headerRow = testData.get(0);
        List<String> dataRow = testData.get(row);
        for(int i=0; i<headerRow.size(); i++){
            if(headerRow.get(i).equalsIgnoreCase(column)){
                System.out.println(dataRow.get(i));
                data = dataRow.get(i);
                break;
            }
        }

        if(isTrim)
            data = data.trim();

        if(data.equalsIgnoreCase("")) {
            data = "{skip}";
            return data;
        }else {
            if(data.contains("{empty}"))
                data = data.replace("{empty}", "");
            if(data.contains("{space}"))
                data = data.replace("{space}", " ");
            while(data.contains("{random")){
                try {
                    int start = data.indexOf("Num:") + 4;
                    int end = data.indexOf("}");

                    int len = Integer.parseInt(data.substring(start, end));

                    if (data.contains("{randomAlphaNum:" + len + "}"))
                        data = data.replace("{randomAlphaNum:" + len + "}", CommonService.generateRandomAlphaNumericString(len));
                    if (data.contains("{randomAlphabetsNum:" + len + "}"))
                        data = data.replace("{randomAlphabetsNum:" + len + "}", CommonService.generateRandomAlphabetString(len));
                    if (data.contains("{randomNum:" + len + "}"))
                        data = data.replace("{randomNum:" + len + "}", Long.toString(CommonService.generateRandomNumber(len)));

                }catch (NumberFormatException e){
                    System.out.println("Exception: Random Number entry is not accurate in excel file. Setting value to empty string");
                    data = "";
                }
            }
        }
        if(data.contains("{null}"))
            data = null;
        return data;
    }

    public List<String> fetchRow(int rowNum){
        List<String> dataRow = testData.get(rowNum);
        return dataRow;
    }
    public List<String> getRowValues(int row) {
        return testData.get(row);

    }


    /**
     * Not in use currently
     * @param filenamePrefix
     * @param dataSet
     */
    public void createExcelForArticleData(String filenamePrefix, List<HashMap<String, String>> dataSet){
        String currentDateTime = CommonService.currentDateTime();
        String filename = filenamePrefix + "_" + currentDateTime + ".xlsx";
        String testDataWorkbookPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "storefrontAPI", "articles", filename).toString();
        createExcelFile(testDataWorkbookPath, dataSet);
    }

    private void createExcelFile(String filename, List<HashMap<String, String>> dataSet) {


        try{
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("InvData");
            XSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("S.No.");
            rowhead.createCell(1).setCellValue("Desc");
            rowhead.createCell(2).setCellValue("styleJioCode");
            rowhead.createCell(3).setCellValue("jioCode");
            rowhead.createCell(4).setCellValue("qty");
            rowhead.createCell(5).setCellValue("styleCode");
            rowhead.createCell(6).setCellValue("serviceable");
            rowhead.createCell(7).setCellValue("inventoryCount");
            rowhead.createCell(8).setCellValue("nodeId");

            int i = 1;
            // Updating date in sheet
            for(HashMap<String, String> hmap : dataSet){
                XSSFRow row = sheet.createRow((short)i);
                row.createCell(0).setCellValue(""+i);
                row.createCell(1).setCellValue(hmap.get("fulfillmentType"));
                row.createCell(2).setCellValue(hmap.get("styleJioCode"));
                row.createCell(3).setCellValue(hmap.get("jioCode"));
                row.createCell(4).setCellValue("10");
                row.createCell(5).setCellValue(hmap.get("styleCode"));

                row.createCell(6).setCellValue(hmap.get("serviceable"));
                row.createCell(7).setCellValue(hmap.get("inventoryCount"));
                row.createCell(8).setCellValue(hmap.get("nodeId"));
                i++;
            }

            FileOutputStream fileOutput = new FileOutputStream(filename);
            workbook.write(fileOutput);
            fileOutput.close();
            workbook.close();
            System.out.println("Excel file has been generated successfully.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
