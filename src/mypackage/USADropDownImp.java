package com.cisco.commonclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cisco.util.ApplicationUtility;

import static com.cisco.util.DBConnectionManager.commonProperties;
public class USADropDownImp {
	//TC4195 from regression suite
	WebDriver driver;
	WebElement countrylist;
	public void dropdownfunctionality(ApplicationUtility appUtility) throws InterruptedException
	{
		driver=appUtility.driver;
		Thread.sleep(5000);
		Map<String,String> mapOfLangCodes=readLangFromProp();
		WebElement usaList =driver.findElement(By.xpath("//div[@class='countryselector section']//a[@id='country-selector']"));
		usaList.click();
		List<WebElement> alllist =driver.findElements(By.xpath("//div[@class='countryselector section']//dl//dt/a"));
		List<String> list1=new ArrayList<String>();
		for(int j=0;j<alllist.size();j++){	
			list1.add(alllist.get(j).getText());
		}
		Thread.sleep(3000);	
	for(int i=0;i<list1.size();i++){	
		Thread.sleep(2000);
		String afterNavigation=clickLang(list1.get(i));
		
		if(i<list1.size()-1){
			usaList =driver.findElement(By.xpath("//div[@class='countryselector section']//a[@id='country-selector']"));
			usaList.click();	
			Thread.sleep(3000);
				
	}
		if(mapOfLangCodes.size()>i){
			String tmp=list1.get(i);
			System.out.println("Temp value::"+tmp);
		if(afterNavigation.contains(mapOfLangCodes.get(tmp))){
			appUtility.logMessage("USA Drop Down", "Page should be navigated to required url for "+list1.get(i),"Page is navigated to "+afterNavigation+" for "+list1.get(i), "Passed");
	}
		else{
			appUtility.logMessage("USA Drop Down", "Page should be navigated to required url for "+list1.get(i),"Page is not navigated to required url instead navigated to "+afterNavigation+" for "+list1.get(i), "Failed");
		}
	}
	}

	}
	
	
	public String clickLang(String lang) throws InterruptedException{
		WebElement ele=driver.findElement(By.xpath("//div[@class='countryselector section']//dl//dt/a[text()='"+lang+"']"));
		ele.click();
		Thread.sleep(3000);
		String afternavigation = driver.getCurrentUrl();
		Thread.sleep(2000);
			driver.navigate().back();	
			Thread.sleep(5000);
			return afternavigation;
	}
	
	
	
	public Map<String,String> readLangFromProp(){
		Map<String,String> languageCodes=new LinkedHashMap<String,String>();
		String[] langCodes=commonProperties.getProperty("langCodes").split(",");
		for(int i=0;i<langCodes.length;i++){
			String[] langAndCode=langCodes[i].split(":");
			languageCodes.put(langAndCode[0], langAndCode[1]);
		}
		System.out.println("Size of Map:"+languageCodes.size());
		return languageCodes;
		
	}
	
	
	
	
	
}

