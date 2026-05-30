package Testng_practice;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// access file(read file)
//sheet
//row
//column
public class ExcelData {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String path = "C:\\Users\\umesh\\OneDrive\\Desktop\\LoginData.xlsx";
	String path1 = "C:\\Users\\umesh\\OneDrive\\Desktop\\NewLoginData.xlsx";
	
	
//	public void addData(String username, String password) throws Exception {
//
//		FileInputStream file = new FileInputStream(path);
//		workbook = new XSSFWorkbook(file);
//		sheet = workbook.getSheet("Sheet1");
//
//		int rowCount = sheet.getLastRowNum();
//
//		sheet.createRow(rowCount + 1).createCell(0).setCellValue(username);
//		sheet.getRow(rowCount + 1).createCell(1).setCellValue(password);
//
//		file.close();
//
//		FileOutputStream output = new FileOutputStream(path);
//		workbook.write(output);
//
//		output.close();
//		workbook.close();
//
//		System.out.println("Added: " + username + " | " + password);
//	}
//
//	// ---------------- WRITE FIRST ----------------
//
//	@Test(priority = 1)
//	public void writeTestData() throws Exception {
//
////		addData("abcd", "efgh");
//		addData("user5", "pass456");
////		addData("test3", "test789");
//		Thread.sleep(3000);
//
//	}
	
	
	@DataProvider(name = "userdata")
	public Object[][] dp() {

		return new Object[][] {
			{"admin", "admin123"},
			{"user1", "pass123"},
			{"testuser", "test123"},
			{"abcd", "efgh"}
		};
	}
	
	@Test(dataProvider = "userdata")
	public void writeExcel(String username, String password) throws Exception {

		// Create workbook only once
		if (workbook == null) {

			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Sheet1");

			// Header
			sheet.createRow(0).createCell(0).setCellValue("Username");
			sheet.getRow(0).createCell(1).setCellValue("Password");
		}

		// Get next row
		int rowCount = sheet.getLastRowNum() + 1;

		sheet.createRow(rowCount).createCell(0).setCellValue(username);
		sheet.getRow(rowCount).createCell(1).setCellValue(password);

		System.out.println("Added : " + username);
	}

	// -------- SAVE FILE LAST --------

	@Test(dependsOnMethods = "writeExcel")
	public void saveExcel() throws Exception {

		FileOutputStream output = new FileOutputStream(path1);

		workbook.write(output);

		output.close();
		workbook.close();

		System.out.println("Excel file saved");
	}

	// DataProvider Method

	@DataProvider(name = "loginData")

	public Object[][] getData() throws Exception {

		FileInputStream file = new FileInputStream(path1);

		workbook = new XSSFWorkbook(file);

		sheet = workbook.getSheet("Sheet1");

		int rows = sheet.getPhysicalNumberOfRows();// total rpws count=4
		int cols = sheet.getRow(0).getLastCellNum();// 0....4

		Object[][] data = new Object[rows - 1][cols];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		workbook.close();

		return data;
	}

	// Test Method

	@Test(priority = 2, dataProvider = "loginData")

	public void loginTest(String user1, String pass1) throws InterruptedException {

        System.out.println("Username : " + user1);
 
        System.out.println("Password : " + pass1);
 
        System.out.println("Login Successful");

//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://zero.webappsecurity.com/login.html");
//
//		// for normal
//		WebElement user = driver.findElement(By.id("user_login"));
//		user.sendKeys(user1);
//		WebElement pass = driver.findElement(By.id("user_password"));
//		pass.sendKeys(pass1);
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(1000);

	}
}
