package com.asismisr.utils.dataProvide;

import com.asismisr.pojo.sauceDemo.SauceDemoLoginCredantials;
import com.asismisr.pojo.wfm.MilestoneUpdationPojo;
import com.influxdb.client.domain.User;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataSender {

    @DataProvider(name = "dataproviding")
    public Object[] dataSending() throws IOException {
        MilestoneUpdationPojo milestoneCreationPojo;
//        Path filePath = Paths.get("src", "test", "resources", "test-data", "cargoRunner", "DataCreation.xlsx");
//        File file = filePath.toFile();
        Path filePath1 = Paths.get("src", "test", "resources", "test-data", "cargoRunner", "UpdateMilestoneData.xlsx");
        File file1 = filePath1.toFile();
        InputStream inputStream=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+file1.getPath()));
        Workbook workbook=WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);
        int rowNum=sheet.getLastRowNum();
        int cellNum=sheet.getRow(0).getLastCellNum();
        String[][] field=new String[rowNum][cellNum];
        DataFormatter dataFormatter=new DataFormatter();
        Object[] objectArray = new Object[rowNum];
        for (int i=1;i<=rowNum;i++)
        {
            for (int j=0;j<cellNum;j++)
            {
                field[i-1][j]=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
            milestoneCreationPojo = new MilestoneUpdationPojo();
            milestoneCreationPojo.setMileStoneName(field[i-1][0]);
            milestoneCreationPojo.setMileStoneCode(field[i-1][1]);
            milestoneCreationPojo.setMileStoneWorkflowType(field[i-1][2]);
            milestoneCreationPojo.setMileStoneDescription(field[i-1][3]);
            milestoneCreationPojo.setMileStoneCustomerPortalFlag(field[i-1][4]);
            milestoneCreationPojo.setMileStoneDynamicFlag(field[i-1][5]);
            objectArray[i-1] = milestoneCreationPojo;
        }

        return objectArray;
    }

    @DataProvider(name = "updatingMilestoneDatasInListing")
    public Object[] updatingMilestoneData() throws IOException {
        MilestoneUpdationPojo milestoneUpdationPojo;
        Path filePath1 = Paths.get("src", "test", "resources", "test-data", "cargoRunner", "UpdateMilestoneData.xlsx");
        File file1 = filePath1.toFile();
        InputStream inputStream=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+file1.getPath()));
        Workbook workbook=WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("MilestoneUpdateTestData");
        int rowNum=sheet.getLastRowNum();
        int cellNum=sheet.getRow(0).getLastCellNum();
        String[][] field=new String[rowNum][cellNum];
        DataFormatter dataFormatter=new DataFormatter();
        Object[] objectArray = new Object[rowNum];
        for (int i=1;i<=rowNum;i++)
        {
            for (int j=0;j<cellNum;j++)
            {
                field[i-1][j]=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
            milestoneUpdationPojo = new MilestoneUpdationPojo();
            milestoneUpdationPojo.setMileStoneName(field[i-1][0]);
            milestoneUpdationPojo.setMileStoneCode(field[i-1][1]);
            milestoneUpdationPojo.setMileStoneWorkflowType(field[i-1][2]);
            milestoneUpdationPojo.setMileStoneDescription(field[i-1][3]);
            milestoneUpdationPojo.setMileStoneCustomerPortalFlag(field[i-1][4]);
            milestoneUpdationPojo.setMileStoneDynamicFlag(field[i-1][5]);
            milestoneUpdationPojo.setEditMilestoneName(field[i-1][6]);
            milestoneUpdationPojo.setEditMilestoneCode(field[i-1][7]);
            milestoneUpdationPojo.setEditWorkflowType(field[i-1][8]);
            milestoneUpdationPojo.setEditMilestoneDiscription(field[i-1][9]);
            milestoneUpdationPojo.setEditShowCustomerPortalFlag(field[i-1][10]);
            milestoneUpdationPojo.setEditDynamicFlag(field[i-1][11]);
            objectArray[i-1] = milestoneUpdationPojo;
        }

        return objectArray;


    }

    @DataProvider(name = "LoginData")
    public Object[] loginCredantialsData() throws IOException {
        SauceDemoLoginCredantials sauceDemoLoginCredantials;
        InputStream inputStream=new FileInputStream(new File(System.getProperty("user.dir") +"\\src\\test\\resources\\test-data\\sauceDemoManual\\TestData.xlsx"));
        Workbook workbook=WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);
        int rowNum=sheet.getLastRowNum();
        int cellNum=sheet.getRow(0).getLastCellNum();
        String[][] excelData=new String[rowNum][cellNum];
        Object[] objectArray=new Object[rowNum];
        DataFormatter dataFormatter=new DataFormatter();
        for (int i=1;i<=rowNum;i++)
        {
            for (int j=0;j<cellNum;j++)
            {
                excelData[i-1][j]=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));

            }
            sauceDemoLoginCredantials=new SauceDemoLoginCredantials();
            sauceDemoLoginCredantials.setUsername(excelData[i-1][0]);
            sauceDemoLoginCredantials.setPassword(excelData[i-1][1]);
            objectArray[i-1]=sauceDemoLoginCredantials;

        }
        return objectArray;



    }
}
