package com.hybridframework;


	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
    import java.util.Properties;
    import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class new_tours_registration 
	{
		FirefoxDriver driver;
		
		@BeforeTest
		public void setup()
		{
			driver=new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
		}
		
		@Test(priority=1)
		public void Register()
		{
	        driver.findElement(By.linkText("REGISTER")).click();
		}
		
		@Test(priority=2)
		public void Registration() throws IOException
		{
			FileInputStream file = new FileInputStream("C:\\Users\\Priya\\workspace\\SeleniumWebdriver\\locators.properties");
			  Properties pr = new Properties();
			  pr.load(file); 
			
			FileInputStream file1 = new FileInputStream("C:\\Users\\Priya\\workspace\\SeleniumWebdriver\\src\\TestDatafiles\\RegistrationTestdata.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file1);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int RowCount =sheet.getLastRowNum();
			System.out.println(RowCount);
			for (int i=1;i<=RowCount;i++)
			{
				 Row r= sheet.getRow(i);
			       
			     driver.findElement(By.name(pr.getProperty("FirstName"))).sendKeys(r.getCell(0).getStringCellValue());
			     driver.findElement(By.name(pr.getProperty("LastName"))).sendKeys(r.getCell(1).getStringCellValue());
	             double d =r.getCell(2).getNumericCellValue();
	             long x=(long)d;
	             String PhoneNumber=Long.toString(x);
	             driver.findElement(By.name(pr.getProperty("PhoneNumber"))).sendKeys(PhoneNumber);
	             driver.findElement(By.name(pr.getProperty("EmailId"))).sendKeys(r.getCell(3).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("Address"))).sendKeys(r.getCell(4).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("City"))).sendKeys(r.getCell(5).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("State"))).sendKeys(r.getCell(6).getStringCellValue());
	             
	             double p=r.getCell(7).getNumericCellValue();
	             long y=(long)p;
	             String PostalCode=Long.toString(y);
	             
	             driver.findElement(By.name(pr.getProperty("PostCode"))).sendKeys(PostalCode);
	             driver.findElement(By.name(pr.getProperty("Country"))).sendKeys(r.getCell(8).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys(r.getCell(9).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("Password"))).sendKeys(r.getCell(10).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("ConfirmPassword"))).sendKeys(r.getCell(11).getStringCellValue());
	             driver.findElement(By.name(pr.getProperty("Register"))).click();
	             
	               System.out.println(driver.getTitle());
	               System.out.println(driver.getCurrentUrl());
	               
	               String ExpectedUsername=r.getCell(9).getStringCellValue();
	               System.out.println(ExpectedUsername);
	               String ActualText=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	               if(ActualText.contains(ExpectedUsername))
	               {
	                System.out.println("User Registered with the same Name -- PASS");
	                r.createCell(12).setCellValue("User Registered-- PASS");
	               }
	               else
	               {
	                System.out.println("User Registration Failed -- FAIL");
	                r.createCell(12).setCellValue("User Registration Failed -- FAIL");
	               }
	               
	               driver.navigate().back();
	               
	               FileOutputStream file2=new FileOutputStream("C:\\Users\\Priya\\workspace\\SeleniumWebdriver\\src\\TestResults\\RegistrationTestResults2.xlsx");
	               workbook.write(file2);
	               
			}
	               
	 		 
			}
				
	    @AfterTest
	    public void tearDown()
	    {
	     driver.close();
	    }


			
			
}
