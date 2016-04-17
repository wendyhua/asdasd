package com.cisco.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Report {
	
	int value=1;
	String path12 = System.getProperty("user.dir");
	String projectName = path12.substring(path12.lastIndexOf("\\") + 1);
	String fileName = null;
	private static String reportsDirectoryPath = null;
	static String errorMsg = "";
	static String logMsg = "";
	protected static int count1 = 1;
	static int imageCounter=1;
	static String dateTime="";
	//New variables
	static String errorSummary=null;
	static String errorMsgCode=null;
	static String errorStepToRep=null;
	static double totalTimeTaken = 0.00;
	static String imageName;
	private static int count = 1;
	static int passedcount=0;
	static int failedcount=0;
	private static final Logger LOGGER = Logger.getLogger(Report.class.getName());
	public Report() {
		
	}
	public void setReportDirPath(String path){
		reportsDirectoryPath = path;
	}
	
	public static void clearErrorSumm(){
		errorMsgCode="";
		errorStepToRep="";
		errorMsgCode="";
	}
	public String getReportDirPath(){
		return reportsDirectoryPath;
	}
	
	public static void clearErrorMsg(){
		errorMsg = "";
		logMsg = "";
	}
	public static String getErrorMsgCode() {
		return errorMsgCode;
	}
	public static void setErrorMsgCode(String errMsgcode) {
		errorMsgCode = errMsgcode;
	}
	public static String getErrorStepToRep() {
		return errorStepToRep;
	}
	public static void setErrorStepToRep(String errStepToRep) {
		errorStepToRep = errStepToRep;
	}
	public static String getErrorSummary() {
		return errorSummary;
	}
	public static  void setErrorSummary(String errSummary) {
		errorSummary = errSummary;
	}
	public static String getErrorMsg(){
		return errorMsg;
	}
	
	public static void setErrorMsg(String error) {
		errorMsg = error;
	}
	
	public static String getDateTime() {
		return dateTime;
	}
	public static void setDateTime(String dateTime) {
		Report.dateTime = dateTime;
	}
	
	public void createReportFolders(){
		createFolders();
	}
	
	public BufferedWriter createlogfile(String Filename,String dataId) {
		BufferedWriter writer = null;
		int count=1;
		
		boolean flag = false;
		try {
			File dir = new File(reportsDirectoryPath);

			String logsDirectoryPath = reportsDirectoryPath+ System.getProperty("file.separator")+"Reports("+getDateTime()+")"+ System.getProperty("file.separator")+"logs";
			dir = new File(logsDirectoryPath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			
			String path=logsDirectoryPath+ System.getProperty("file.separator") + Filename + "_"+ "DataId" + "_" + dataId +"_"+count+ ".html";
			File file = new File(path);
			if (file.exists()) {
				//file.delete();
				count=count+1;
				path=logsDirectoryPath+ System.getProperty("file.separator") + Filename + "_"+ "DataId" + "_" + dataId +"_"+count+ ".html";
				file=new File(path);
			}
			
			flag = file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("<html><head><link href='http://fdk-author-stage.cisco.com/content/dam/en/i/test/style.css' rel='stylesheet' type='text/css' /></head><hr class='divline'>"   
			//writer.write("<html><head><link href='" + System.getProperty("user.dir")+ "\\css\\style.css' rel='stylesheet' type='text/css' /></head><hr class='divline'>"//modified
					+ "<table class='reportheader' width=100%><TR>"
					+ "<td height=50px align=left>"
					+ "<Table class='developer'>"
					+ "<TR><td class='desc1'><Center><table>"
					+ "<TR><TD class='desccpy'>Automation Test Execution Report</TD></TR><TR>"
					+ "<TD class='dev'>Tool Used : Selenium WebDriver </TD></TR></Table>"
					+ "</TD></TR></Table></TD><BR><td height=50px align=right><img src = 'http://fdk-stage.cisco.com/content/dam/en/i/test/cisco_logo.jpg'></td><BR></tr></table>"
					//"</TD></TR></Table></TD><BR><td height=50px align=right><img src = '" + System.getProperty("user.dir")+ "\\Images\\cisco_logo.jpg'></td><BR></tr></table>"
					+ "<hr class='divline'><BR><table class='subheader' width=100%><tr><tr><td width=100% class='subheader'>Test Case Desription - "+Filename+"</td></tr><tr><td width=100% class='subcontents'></td></tr></tr></table> <hr class='divline'><BR>");
			writer.write("<table class='teststeps' width=100%><tr><td class='tsheader' width=75px>Step #</td><TD class='tsheader' width=155px>Step Description</TD><TD class='tsheader' width=285px>Expected Result</TD><TD class='tsheader' width=285px>Actual Result</TD><TD class='tsheader' width=50px>Status</TD><TD class='tsheader' width=50px>Screen shot</TD></tr>");
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Exception :",e);
			}
		imageCounter = 1;
		return writer;
	}
	public void createFolders(){
		try{
			Date Now = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("dd MMM yyyy hh mm ss a zzz");
			//Returns Current Data and Time
			String currentDateTime = ft.format(Now);
			System.out.println("Execution Date & Time :" + currentDateTime);
			setDateTime(currentDateTime);
			String path = System.getProperty("user.dir")+ System.getProperty("file.separator") + "Reports";
			File file = new File(path);
			if (file.exists()) {
				setReportDirPath(path);
			} else {
				file.mkdir();	
				setReportDirPath(path);
			}
			countExecution(currentDateTime);
		}catch(Exception e){
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}
	}
	public void countExecution(String currentDateTime) {
		try {
			count = 1;
			String reportsDirectoryPath = getReportDirPath();
			File dir = new File(reportsDirectoryPath+System.getProperty("file.separator")+"Reports("+currentDateTime+")");
			if (!dir.exists()) {
				//create reports folder
				dir.mkdir();
				//Create logs folder
				String directoryPath = reportsDirectoryPath+ System.getProperty("file.separator")+"Reports("+currentDateTime+")"+ System.getProperty("file.separator")+"logs";
				dir = new File(directoryPath);
				dir.mkdir();
				
				//Create images folder
				directoryPath = reportsDirectoryPath+ System.getProperty("file.separator")+"Reports("+currentDateTime+")" + System.getProperty("file.separator")+"images";
				dir = new File(directoryPath);
				dir.mkdir();
				
				directoryPath = reportsDirectoryPath+ System.getProperty("file.separator") + "images";
				dir = new File(directoryPath);
				dir.mkdir();
				//copy logo
				String surFile =  System.getProperty("user.dir")+ System.getProperty("file.separator")
									+ "images"+System.getProperty("file.separator")+"cisco_logo.jpg";
				String desFile = reportsDirectoryPath+ System.getProperty("file.separator")+ "images"+System.getProperty("file.separator")+"cisco_logo.jpg";
				copyFile(surFile,desFile);
				
				surFile =  System.getProperty("user.dir")+ System.getProperty("file.separator")+ "images"+System.getProperty("file.separator")+"cross.png";
				desFile = reportsDirectoryPath+ System.getProperty("file.separator") + "images"+System.getProperty("file.separator")+"cross.png";
				copyFile(surFile,desFile);
				
				surFile =  System.getProperty("user.dir")+ System.getProperty("file.separator")+ "images"+System.getProperty("file.separator")+"tick.png";
				desFile = reportsDirectoryPath+ System.getProperty("file.separator") + "images"+System.getProperty("file.separator")+"tick.png";
				copyFile(surFile,desFile);
				
				surFile =  System.getProperty("user.dir")+ System.getProperty("file.separator")+ "images"+System.getProperty("file.separator")+"Screenshot.jpg";
				desFile = reportsDirectoryPath+ System.getProperty("file.separator") + "images"+System.getProperty("file.separator")+"Screenshot.jpg";
				copyFile(surFile,desFile);
				
				//Create css folder
				directoryPath = reportsDirectoryPath+ System.getProperty("file.separator") + "css";
				dir = new File(directoryPath);
				dir.mkdir();
				//copy css template
				surFile =  System.getProperty("user.dir")+ System.getProperty("file.separator")+ "css"+System.getProperty("file.separator")+"style.css";
				desFile = reportsDirectoryPath+ System.getProperty("file.separator") + "css"+System.getProperty("file.separator")+"style.css";;
				copyFile(surFile,desFile);
			}
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :",e);
			
		}
	}
	
	public void copyFile(String sourceFile, String targetFile) {
		File f = new File(sourceFile);
		try {
			if(f.exists()){
				InputStream in = new FileInputStream(f);
				OutputStream out = new FileOutputStream(targetFile);
				int c;

				while ((c = in.read()) != -1)
					out.write(c);

				in.close();
				out.close();
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}
	}
	
	public void logMessage(WebDriver driver,BufferedWriter writer,String ScreenshotName,String stepDesc,String expectedMsg,String actualMsg,String status){
        if(status.equalsIgnoreCase("Passed")){
              log(driver,writer,ScreenshotName,stepDesc+";"+expectedMsg+";"+actualMsg,"Passed");
        }else{
              log(driver,writer,ScreenshotName,stepDesc+";"+expectedMsg+";"+actualMsg,"Failed");
        }
        System.out.println("Status : "+status+" :: "+actualMsg);
    }
	
	public void videologMessage(WebDriver driver,BufferedWriter writer,String ScreenshotName,String stepDesc,String expectedMsg,String actualMsg,String status){
        if(status.equalsIgnoreCase("Passed")){
        	videoLog(driver,writer,ScreenshotName,stepDesc+";"+expectedMsg+";"+actualMsg,"Passed");
        }else{
        	videoLog(driver,writer,ScreenshotName,stepDesc+";"+expectedMsg+";"+actualMsg,"Failed");
        }
        System.out.println("Status : "+status+" :: "+actualMsg);
    }
	
	public void videoLog(WebDriver driver,BufferedWriter writer,String ScreenshotName,String msg, String status){
		//Get the 2 messages
		int counter=1;
		if(writer !=null){
			counter=value;
		}
		String[] messages = msg.split(";");
		String stepDesc = ".";
		String expectedMsg = ".";
		String actualMsg = ".";

		stepDesc= messages[0];
		if(messages.length > 1){
			expectedMsg= messages[1];
			actualMsg= messages[2];
		}
		logMsg = actualMsg;
		addVideoLogToFile(driver,writer,ScreenshotName,counter, stepDesc, expectedMsg,actualMsg,status,false);
		value=counter+1;
	}
	
	public void log(WebDriver driver,BufferedWriter writer,String ScreenshotName,String msg, String status){
		//Get the 2 messages
		int counter=1;
		if(writer !=null){
			counter=value;
		}
		String[] messages = msg.split(";");
		String stepDesc = ".";
		String expectedMsg = ".";
		String actualMsg = ".";

		stepDesc= messages[0];
		if(messages.length > 1){
			expectedMsg= messages[1];
			actualMsg= messages[2];
		}
		logMsg = actualMsg;
		addLogToFile(driver,writer,ScreenshotName,counter, stepDesc, expectedMsg,actualMsg,status);
		value=counter+1;
	}
	public void addLogToFile(WebDriver driver,BufferedWriter writer,String ScreenshotName,int stepNum,String stepDesc,String expectedMsg,String actualMsg,String status){
		try {
			writer.write("<tr>");
			writer.write("<TD class='tsindlevel1' width=75px>" + stepNum);
			writer.write("</TD>");
			writer.write("<TD class='tsgen' width=155px>"+stepDesc+"</TD>");
			writer.write("<TD class='tsgen' width=285px>");
			writer.write(expectedMsg);
			writer.write("</td>");
			writer.write("<TD class='tsgen' width=285px>");
			writer.write(actualMsg);
			writer.write("</td>");
			if ("Passed".equalsIgnoreCase(status)) {
				if(writer !=null)
					passedcount++;
				//writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = '..\\..\\images\\tick.png'></TD>");//modified
				writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = 'http://fdk-author-stage.cisco.com/c/dam/en/i/test/tick.png'></TD>");
			} else {
				//writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = '..\\..\\images\\cross.png'></TD>");//modified
				writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = 'http://fdk-author-stage.cisco.com/c/dam/en/i/test/cross.png'></TD>");
				setErrorMsg(actualMsg);
				failedcount++;
			}
			if("Passed".equalsIgnoreCase(status)){
				writer.write("<TD class='tsgen' width=50px></TD>");
			}else{
				takeScreenShot(driver,stepDesc,ScreenshotName);
				screenShotHyperLink(writer);
			}
			writer.write("</tr>");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}
	}
	
	public void addVideoLogToFile(WebDriver driver,BufferedWriter writer,String ScreenshotName,int stepNum,String stepDesc,String expectedMsg,String actualMsg,String status,boolean isMultipart){
		try {
			writer.write("<tr>");
			writer.write("<TD class='tsindlevel1' width=75px>" + stepNum);
			writer.write("</TD>");
			writer.write("<TD class='tsgen' width=155px>"+stepDesc+"</TD>");
			writer.write("<TD class='tsgen' width=285px>");
			writer.write(expectedMsg);
			writer.write("</td>");
			writer.write("<TD class='tsgen' width=285px>");
			writer.write(actualMsg);
			writer.write("</td>");
			if (status.equalsIgnoreCase("passed")) {
				if(writer !=null)
					passedcount++;
				writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = 'http://fdk-author-stage.cisco.com/c/dam/en/i/test/tick.png'></TD>");
				//writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = '" + System.getProperty("user.dir")+ "\\Images\\tick.png'></TD>");
			} else {
				writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = 'http://fdk-author-stage.cisco.com/c/dam/en/i/test/cross.png'></TD>");
				//writer.write("<TD class='tsgen' width=50px align=center><img class='screen' src = '" + System.getProperty("user.dir")+ "\\Images\\cross.png'></TD>");
				errorMsg = logMsg;
				failedcount++;
			}
			if(status.equalsIgnoreCase("passed")){
				takeScreenShot(driver,stepDesc,ScreenshotName);
				screenShotHyperLink(writer);
			}else{
				System.out.println("");
//				takeScreenShot(driver,stepDesc,ScreenshotName);
//				screenShotHyperLink(writer);
			}
			writer.write("</tr>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	int imgcount=1;
	public void takeScreenShot(WebDriver driver,String stepDesc,String ScreenshotName) {
		String imgName="";
		String imgpath="";
		 File scrFile=null;
		 //int imgcount=1;//modified
		 failedcount++;
        try {
	        if (driver != null) {
	        	System.out.println("ScreenshotName=="+ScreenshotName);
	        	scrFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
              if(!"".equalsIgnoreCase(ScreenshotName))
            	  imgName=ScreenshotName;
              else{
            	  imgName=stepDesc;
              }
              imgpath=getReportDirPath()+System.getProperty("file.separator")+"Reports("+getDateTime()+")" + System.getProperty("file.separator")+"images"+System.getProperty("file.separator");
              imageName =imgName + imgcount + ".png";
              if(new File(imgpath+imageName) .exists()){
            	  //imageCounter=imageCounter+1;
            	  imgcount=imgcount+1;
              }
              //imageName =getReportDirPath()+System.getProperty("file.separator")+"images"+ System.getProperty("file.separator")+ imgName + imgcount + ".png";
              imageName =imgName + imgcount + ".png";
              FileUtils.copyFile(scrFile,   new File(imgpath+imageName));
              imageCounter++;
	        }
	        
	  } catch (Exception e) {
	        LOGGER.log(Level.SEVERE, "Exception :",e);
	  }
 }
	
	public void screenShotHyperLink(BufferedWriter writer) {
		try {
			//String name = fileName;
			//name = name.substring(0, name.lastIndexOf("."));
			writer.write("<TD class='tsgen' width=50px align=center>");
			writer.write("<a href='..\\images\\" + imageName + "' ><img class='screen' src = 'http://fdk-stage.cisco.com/c/dam/en/i/test/Screenshot.jpg'></a>");
			writer.write("</td>");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}
	}
	
	public void after(BufferedWriter writer,long tcStartTime,long tcEndTime,String osType,String browserType,String browserVersion) {
		try{
			addTestCaseDetailsToLogfile(writer,tcStartTime,tcEndTime,osType,browserType,browserVersion);
		}catch(Exception e){
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}
	}
	
	
	public void closewriter(BufferedWriter writer) {
		try {
			writer.close();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}
	}
	public void addTestCaseDetailsToLogfile(BufferedWriter writer,long tcStartTime,long tcEndTime,String osType,String browserType,String browserVersion){
		try {
			writer.write("</table>");
			Date d1=new Date(tcStartTime);
			Date d2=new Date(tcEndTime);
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm:ss a");
	        String date = DATE_FORMAT.format(d1);
	        String date1 = DATE_FORMAT.format(d2);
	        System.out.println("Start time==="+date);
	        System.out.println("endTime==="+date1);
	        Date today = new Date();
	        SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("dd-MM-yyyy");
	        String todayDate = DATE_FORMAT1.format(today);
	        long timeMillis = tcEndTime - tcStartTime;
			long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
			
			String status="Passed";
			if(failedcount >0){
				status ="Failed";
			}
			writer.write("<hr class='divline'><br><table class='subheader' width=100%><tr><tr><td width=100% class='subheader'>Test Execution Summary</td></tr><tr><td width=100% class='subcontents'></td></tr></tr></table>"
					+ "<hr class='divline'><br><table><tr><td><table class = 'releasesummary'><tr><td class='summaryheader' colspan=2>Execution Time Summary</td></tr><tr><td class ='summaryelement' width=100>Test Executed On</td><td class ='summarybody' width=450>"+todayDate+"</td></tr><tr><td class ='summaryelement' width=100>Test Execution Start Time</td><td class ='summarybody' width=450>"+date+"</td></tr><tr><td class ='summaryelement'>Test Execution End Time</td><td class ='summarybody'>"+date1+"</td></tr><tr><td class ='summaryelement'>Total Execution Time</td><td class ='summarybody'>"+timeSeconds+" secs</td></tr></table></td><td></td>"
					+ "<td><table class = 'releasesummary'><tr><td class='summaryheader' colspan=2>Execution Details Summary</td></tr><tr><td class ='summaryelement' width=100>Operating System</td><td class ='summarybody'width=450>"+osType+"</td></tr><tr><td class ='summaryelement'>Browser Type</td><td class ='summarybody'>"+browserType+"</td></tr><tr><td class ='summaryelement'>Browser Version</td><td class ='summarybody'>"+browserVersion+"</td></tr><tr><td class ='summaryelement'>System User</td><td class ='summarybody'>"+System.getProperty("user.name")+"</td></tr></table></td></tr></table>"
					+ "<hr class='divline'><hr class='divline'><br><table class='subheader' width=100%><tr><tr><td width=100% class='subheader' align='center'>Overall Test Status : ");
			if("Passed".equalsIgnoreCase(status)){
				writer.write("<span class = 'testpassed'>PASSED</span>");
			}else{
				writer.write("<span class = 'testfailed'>FAILED</span>");
			}
			writer.write("</td></tr></tr></table><hr class='divline'><br><center><span>CISCO CONFIDENTIAL - Copyright &copy; www.cisco.com </span></center></body></html>");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception :",e);
		}finally{
			value=1;
			failedcount=0;
		}
	}
	
	public static String getCurrentTime(long tcStartTime){
		String todayTime="";
		SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("dd-MM-yyyy");
        String todayDate = DATE_FORMAT1.format(new Date());
        Date d1=new Date(tcStartTime);
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh-mm-ss");
        String time = DATE_FORMAT.format(d1);
        todayTime=todayDate+"-"+time;
        
        return todayTime;
	}
}
