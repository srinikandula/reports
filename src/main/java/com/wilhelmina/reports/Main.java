package com.wilhelmina.reports;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

/**
 * Created by skandula on 2/3/16.
 */
@SpringBootApplication
public class Main {
    @Autowired
    private static AppConfig appConfig;

    public static void main(String args[]) {
        Calendar cal = new GregorianCalendar();
        String reportName = "modelResources";
        appConfig.getProperty(reportName+".row.size");
        //getConnection();
        /*List<List<Object>> data = new ArrayList<>();
        for(int i=0; i< 10;i++){
            List<Object> row = new ArrayList<>();
            for(int j=0;j< 3;j++){

            }
        }*/


    }

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://52.73.53.64;databasename=CDS_NY";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String userName = "srini";
        String password = "Joseki-123";
        Statement stmt;
        Connection conn = null;
        try
        {

            Class.forName(driver);//.newInstance();
            System.out.println("Attempting connection");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Got connection");
            String query = "select * from dbo.Employee";
            stmt = conn.createStatement();
            int flag = stmt.executeUpdate(query);
            System.out.println("flag = "+flag);
            conn.close();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void writeToExcelReport(String reportFileName, int startRow, Map<String, Object> data) {
        try {
            FileInputStream file = new FileInputStream(new File(reportFileName));

            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

           /* for(int i=0; i<data.keySet().size();i++) {
                HSSFRow row = sheet.getRow(i);
                row.getCell()
            }*/
            Cell cell = null;

            //Update the value of cell
            cell = sheet.getRow(1).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(2).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);
            cell = sheet.getRow(3).getCell(2);
            cell.setCellValue(cell.getNumericCellValue() * 2);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("C:\\update.xls"));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
