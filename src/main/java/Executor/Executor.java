package Executor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;

import DriverFactory.DataSetter;
import DriverFactory.DriverFactory;
import Steps.Steps;

public class Executor {

	public static void main(String[] args) throws InterruptedException, IOException {
		HashMap <Integer, DataSetter>getmapdata=Steps.ExcelRead();
		
		//DataSetter getData=new DataSetter();
		
		Set<Integer> keys=getmapdata.keySet();
		for(int key:keys)
		{
			Steps.URLlaunch();
			Steps.loginEMI();
			Thread.sleep(2000);
			Steps.ERIReturnEntryMenu();
			Thread.sleep(5000);
			Steps.SelectDropdown(By.id("quarterending"),getmapdata.get(key).getMonth());
			Steps.SelectDropdown(By.id("quarterendingyear"), getmapdata.get(key).getYear());
            Steps.SelectDropdown(By.id("district"),getmapdata.get(key).getDistrict() );
            Steps.Textbox(By.id("employerId"),getmapdata.get(key).getEmployercode());
            Steps.Click(By.id("menemployeetotal"));
            if(Steps.Presenceofalert())
            {
            	Steps.HandleAlert();
            	Steps.ClearValues(By.id("menemployeetotal"));
            	Steps.Textbox(By.id("menemployeetotal"), Steps.getCurrentQuater(By.xpath("//*[@id=\"premenemptotal\"]")));
            	Steps.ClearValues(By.id("womenemployeetotal"));
            	Steps.Textbox(By.id("womenemployeetotal"), Steps.getCurrentQuater(By.xpath("//*[@id=\"prewomenemptotal\"]")));
                
            	
            	Steps.Textbox(By.id("reasonfordifference"),"0");
            	Thread.sleep(2000);
            	Steps.Textbox(By.id("occurence"),"0");
            	Steps.Textbox(By.id("localemployementexchangenotified"),"0");
            	Steps.Textbox(By.id("centralemploymentexchangenotified"),"0");
            	Steps.Textbox(By.id("numberofvacancyfilled"),"0");
            	Steps.Textbox(By.id("sourcedescription"),"0");
            	Steps.Textbox(By.id("reasonunderreportvide"),"0");
            	Steps.Textbox(By.id("occupationcode"),"0");
            	Steps.Textbox(By.id("essentialqualification"),"0");
            	Steps.Textbox(By.id("essentialexperience"),"0");
            	Steps.Textbox(By.id("nilexperience"),"0");
            	Steps.Textbox(By.id("otheroccupation"),"0");
            	Steps.Textbox(By.xpath("(//*[@id=\"occurred\"])[1]"),"X");
            	Steps.Textbox(By.xpath("(//*[@id=\"occurred\"])[2]"),"CBE");
            	Steps.Textbox(By.xpath("(//*[@id=\"occurred\"])[3]"),"CBE");
            	Steps.Click(By.id("addvacancydet"));
            	Steps.Click(By.id("saveorupdatbutton"));
            	Steps.HandleAlert();
                
            }
            else
            {
            	Steps.ClearValues(By.id("menemployeetotal"));
            	Steps.Textbox(By.id("menemployeetotal"), Steps.getCurrentQuater(By.xpath("//*[@id=\"premenemptotal\"]")));
            	Steps.ClearValues(By.id("womenemployeetotal"));
            	Steps.Textbox(By.id("womenemployeetotal"), Steps.getCurrentQuater(By.xpath("//*[@id=\"prewomenemptotal\"]")));
            	Steps.Textbox(By.id("reasonfordifference"),"0");
            	Thread.sleep(2000);
            	Steps.Textbox(By.id("occurence"),"0");
            	Steps.Textbox(By.id("localemployementexchangenotified"),"0");
            	Steps.Textbox(By.id("centralemploymentexchangenotified"),"0");
            	Steps.Textbox(By.id("numberofvacancyfilled"),"0");
            	Steps.Textbox(By.id("sourcedescription"),"0");
            	Steps.Textbox(By.id("reasonunderreportvide"),"0");
            	Steps.Textbox(By.id("occupationcode"),"0");
            	Steps.Textbox(By.id("essentialqualification"),"0");
            	Steps.Textbox(By.id("essentialexperience"),"0");
            	Steps.Textbox(By.id("nilexperience"),"0");
            	Steps.Textbox(By.id("otheroccupation"),"0");
            	Steps.Textbox(By.xpath("(//*[@id=\"occurred\"])[1]"),"X");
            	Steps.Textbox(By.xpath("(//*[@id=\"occurred\"])[2]"),"CBE");
            	Steps.Textbox(By.xpath("(//*[@id=\"occurred\"])[3]"),"CBE");
            	Steps.Click(By.id("addvacancydet"));
                Steps.Click(By.id("saveorupdatbutton"));
                Steps.HandleAlert();
            
            }
            Steps.CloseBrowser();
		}
		
//		System.out.println("check");

		//String s1 = null,s2 = null,s3 = null,s4 = null;
		//Steps.ExcelRead();

	}

}
