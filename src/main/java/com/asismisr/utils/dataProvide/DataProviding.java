package com.asismisr.utils.dataProvide;

import com.asismisr.pojo.ContactForm;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.*;

public final class DataProviding {


    @DataProvider(name = "ContactformInput")
    public Object[] sendingContactFormInput() throws IOException {
        InputStream inputStream=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\test-data\\contactform\\datas.xlsx"));
        Workbook workbook=WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("LoginDetails");
        int maxRow=sheet.getLastRowNum();
        int maxCell=sheet.getRow(0).getLastCellNum();
        DataFormatter dataFormatter=new DataFormatter();
        Object[] inputs=new Object[maxRow];
        for (int i=1;i<=maxRow;i++)
        {
            Row row=sheet.getRow(i);
            String username;
            String password;
            if (row==null)
            {
                username="";
                password="";
            }
            else {
                username=dataFormatter.formatCellValue(row.getCell(0));
                password=dataFormatter.formatCellValue(row.getCell(1));
            }
            ContactForm contactForm=new ContactForm(username,password);
            inputs[i-1]=contactForm;
        }
        return inputs;
    }

}
