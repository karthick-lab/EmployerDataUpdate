package Steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DataSetter;
import DriverFactory.DriverFactory;

public class Steps extends DriverFactory {
	
	public static void URLlaunch()
	{
	    DriverFactory.getChromeDriver();
	    driver.get("https://employmentexchange.tn.gov.in/Empower/");
	    driver.manage().window().maximize();
	}
	
	public static void loginEMI()
	{
	    driver.findElement(By.id("userid")).sendKeys("emicbeuser");
	    driver.findElement(By.id("password")).sendKeys("abcd1234");
	    driver.findElement(By.id("canLogin")).click();
	}
	
	public static void loginCandidate()
	{
	    driver.findElement(By.id("userid")).sendKeys("emicbeuser");
	    driver.findElement(By.id("password")).sendKeys("abcd1234");
	    driver.findElement(By.id("canLogin")).click();
	}
	
	public static void ERIReturnEntryMenu() throws InterruptedException
	{
	    driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a/span")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/div/ul/li[3]/a/span")).click();
	}

	public static HashMap<Integer,DataSetter> ExcelRead() throws IOException
	{
		
		HashMap<Integer,DataSetter> mapdata=new HashMap<Integer,DataSetter>();
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Employment data.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fis);
    	HSSFSheet sh=wb.getSheet("Sheet1");
    	String data=null;
		String Employercode = "hi";
		String Month = "hi";
		String Year = "hi";
		String District = "hi";
    	DataSetter datalog =new DataSetter(Employercode,Month,Year,District);
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			for(int j=0;j<sh.getRow(0).getLastCellNum();j++)
					
			{
				
				Cell cell=sh.getRow(i).getCell(j);
				if(j==0)
				{
				
				
				if(cell.getCellType()==CellType.STRING)
				{
					data=cell.getStringCellValue();
					datalog.setEmployercode(data);
					
//					System.out.println(data);
				}
				}
				else if(j==1)
				{
					if(cell.getCellType()==CellType.STRING)
					{
						data=cell.getStringCellValue();
						datalog.setMonth(data);
						
//						System.out.println(data);
					}
				}	
				
				else if(j==2)
				{
					if(cell.getCellType()==CellType.STRING)
					{
						data=cell.getStringCellValue();
						datalog.setYear(data);
						
//						System.out.println(data);
					}
					else if(cell.getCellType()==CellType.NUMERIC)
					{
						{
							data=Integer.toString((int)((double)cell.getNumericCellValue()));
							datalog.setYear(data);
							
//							System.out.println(data);
						}
					}
				}
				
				else if(j==3)
				{
				if(cell.getCellType()==CellType.STRING)
					{
						data=cell.getStringCellValue();
						datalog.setDistrict(data);
						
//						System.out.println(data);
					}
					
				}
				
				}
			
			mapdata.put(i,datalog);
			datalog=new DataSetter(Employercode,Month,Year,District);
			//key=key++;
			
		}
		
//		Set<Integer> keys= mapdata.keySet();	
//		System.out.println(keys);
//		for(int k:keys)
//		{
//			System.out.println(mapdata.get(k).getYear());
//		}
//		
		
		return mapdata;
	}
	
	
	public static void SelectDropdown(By by,String visibletext)
	{
		WebElement dropdown=driver.findElement(by);
		Select select=new Select(dropdown);
		select.selectByVisibleText(visibletext);
	}
	
	public static void Textbox(By by,String text)
	{
		driver.findElement(by).sendKeys(text);
	}
	
	public static void Click(By by)
	{
		driver.findElement(by).click();
	}
	
	
	public static void HandleAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static boolean Presenceofalert()
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,5);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static void CloseBrowser()
	{
		driver.close();
	}
	
	public static String getCurrentQuater(By by) 
	{
		String CurrentQuater=driver.findElement(by).getAttribute("value");
		//System.out.println("check"+CurrentQuater);
		return CurrentQuater;
	}
	
	public static void ClearValues(By by)
	{
		driver.findElement(by).sendKeys(Keys.CONTROL+"A");
		driver.findElement(by).sendKeys(Keys.BACK_SPACE );
	}
	
	public static void excelwrite(String writevalue) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\EmploymentPhoneNumberExtractor.xls");
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sh=wb.getSheet("Sheet1");
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			HSSFRow row=sh.getRow(i);
			HSSFCell cell=row.createCell(1);
			cell.setCellValue(writevalue);
			System.out.println("write completed");
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Desktop\\EmploymentPhoneNumberExtractor.xls");
			wb.write(fos);
		}
		
	}
}

