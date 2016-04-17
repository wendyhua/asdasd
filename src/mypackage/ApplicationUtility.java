package com.cisco.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ApplicationUtility {
	
		
	Report report=new Report();
	WrapperActionTest test=new WrapperActionTest();
	String ScreenshotName="";
	public WebDriver driver=null;
	public BufferedWriter writer=null;
	public AppTestDTO appDto=null;
	private final static Logger LOGGER = Logger.getLogger(ApplicationUtility.class.getName());
	
	/********************************************************************************************
	 *  
	 * @Function_Name :  ApplicationUtility
	 * @Description : Initialization the Report LocalDriverFactory and AppTestDTO
	 * @version 1.0
	 ********************************************************************************************/
	public ApplicationUtility(Report r,LocalDriverFactory localDriverFactory,AppTestDTO appDto)
	{
		try{
			this.appDto=appDto;
			this.writer=r.createlogfile(appDto.getTestMethodName(),appDto.getDataId());
			this.driver =localDriverFactory.getDriver(appDto.getBrowserType());
		}
		catch(Exception e)
		{	LOGGER.log(Level.SEVERE, "Exception found in Initialization of ApplicationUtility class :",e);
		}
	}
	/********************************************************************************************
	 *  
	 * @Function_Name :  logMessage
	 * @Description : This method is used write the steps into html report
	 * @version 1.0
	 ********************************************************************************************/
	
	public void logMessage(String strDescr,String strExpected,String Actual,String status)
	{
		try{
			ScreenshotName=appDto.getTestClassName()+"_"+appDto.getTestMethodName()+"-"+appDto.getDataId();
			report.logMessage(driver,writer,ScreenshotName,strDescr,strExpected,Actual, status);
		}
		catch(Exception e){
			LOGGER.log(Level.SEVERE, "Exception found in Initialization of ApplicationUtility class for report log message :",e);
		}
	}
}
