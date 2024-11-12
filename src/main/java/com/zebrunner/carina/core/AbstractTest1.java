package com.zebrunner.carina.core;
 
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
 
 
 
 
public class AbstractTest1 extends AbstractTest {
 
    
    protected Logger LOGGER = LogManager.getLogger(AbstractTest1 .class.getName());
    		//Logger.ExtentReportsAI.class;
    
    private static ExtentSparkReporter spark;
    protected static ExtentReports extentReport;
 
    public static ExtentTest extentTest = null;

    
    static WebDriver driver;
    static String methodName="";
    
    String reportPath;
    String browser;
    String reportPath1;
    String screenshotsPath;
    public static String extentReportFolder = null;
    HashMap<String, String> args = new HashMap<String, String>();  
  
 
    public File captureScreenshot(String filename) {
    	TakesScreenshot takeScrenshot=(TakesScreenshot)getDriver();
    	return takeScrenshot.getScreenshotAs(OutputType.FILE);

    }
    
    public String addcaptureScreenshotInReport() throws IOException {
    	TakesScreenshot takeScrenshot=(TakesScreenshot)getDriver();
    	File s=takeScrenshot.getScreenshotAs(OutputType.FILE);
    	// String reportFolder = createReportDir();
          String date = new SimpleDateFormat("HHmmss").format(new Date());


          screenshotsPath = extentReportFolder+ "/" + "screenShots"+"/"+date+".png";
          
          System.out.println(screenshotsPath);
    	 FileUtils.copyFile(s, new File(screenshotsPath));
 
    	 
    	 return screenshotsPath;
    }
    
    public String captureScreenshot1() {
    	TakesScreenshot takeScrenshot=(TakesScreenshot)getDriver();
    	return takeScrenshot.getScreenshotAs(OutputType.BASE64);

    }
    
    public static String fileToBase64(File file) throws IOException {
        // Read the content of the file into a byte array
        byte[] fileContent = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(fileContent);
        fileInputStream.close();
        // Encode the byte array to Base64
        return Base64.getEncoder().encodeToString(fileContent);
    }
    
    
    @BeforeSuite(alwaysRun = true)
    public void startReportTest() {
        try {
            System.out.println("*********BeforeSuite*******************");
            System.out.println(R.CONFIG.get("selenium_url"));
            LOGGER.debug("Starting extent report");
            startReport();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String currentDateAndTime = dateFormat.format(new Date());
 
           
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());}
 
        
    }
    
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method testMethod,ITestResult result) throws IOException {
    	System.out.println("*********BeforeMethod*******************");
    	System.out.println(R.CONFIG.get("selenium_url"));
         methodName=testMethod.getName();
 
        Test test = testMethod.getAnnotation(Test.class);
        String suiteName = test.suiteName();
        //extentTest = extentReport.createTest(testMethod.getName()).assignCategory("Regression").assignDevice(R.CONFIG.get("capabilities.deviceName"));                        
        extentTest = extentReport.createTest(testMethod.getName()).assignDevice(R.CONFIG.get("capabilities.deviceName"));                        

        reportPath = ReportContext.getTestDir().getAbsolutePath();
        reportPath1 = ReportContext.getTestDir().getAbsolutePath();
        System.out.println("Report path: "+ reportPath);
    }
 
 
    @AfterMethod(alwaysRun = true)
    public void settingResultTest(ITestContext ctx, Method testMethod,ITestResult result,Object[] obj) {
        try {
        //  ITestContext, XmlTest, Method, Object[], ITestResult
        	System.out.println("*********AfterMethod*******************");
            LOGGER.debug("Setting up result in report");        
            getResult(result);
 
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }
 
    
    
    public void startReport() {
        try {
        String reportFolder = createReportDir();
      //  String fileName = new SimpleDateFormat("hh_mm_ss").format(new Date());
        extentReport = new ExtentReports();
      //  spark = new ExtentSparkReporter(reportFolder + "/" + fileName + ".html");
        spark = new ExtentSparkReporter(reportFolder + "/" +"extendReport.html");
        spark.config().setTheme(Theme.STANDARD)  ;
        spark.config().setDocumentTitle("Automation Report"); //Need to include suite name
        spark.config().setCss(".img-icon { display: none; }");
        extentReport.attachReporter(spark);
        
        //extentReport = new ExtentReports();
 
        //String currentDateAndTime = dateFormat.format(new Date());
        
 
        extentReport.setSystemInfo("Host Name", R.CONFIG.get("localhost"));
        extentReport.setSystemInfo("Environment", R.CONFIG.get("env"));
        extentReport.setSystemInfo("User", R.CONFIG.get("user"));
        
        }catch(Exception e) {
        	LOGGER.error(e.getMessage());
        }
        
 
    }
    
 
    
 
    public void getResult(ITestResult result) throws IOException {
        System.out.println("******************InsideGetResuls**********************");
        System.out.println(R.CONFIG.get("selenium_url"));
        File directoryPath = new File(reportPath);
        
        File filesList[] = directoryPath.listFiles();
        
        for (File file : filesList) {
            if (file.getName().contains(".png")) {
//                String comments = ReportContext.getScreenshotComment(file.getName());
//                if (comments.contains("PASS")) {
//                    extentTest.log(Status.PASS, comments + extentTest.addScreenCaptureFromPath(file.getAbsolutePath()));
//                 }
                extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(fileToBase64(captureScreenshot(result.getName()))).build());
            }
        }
 
        if (result.getStatus() == ITestResult.FAILURE) {
        	for (File file : filesList) {
                if (file.getName().contains(".png")) {
//                    String comments = ReportContext.getScreenshotComment(file.getName());
//                    if (comments.contains("FAIL")) {    
//                        extentTest.log(Status.FAIL, comments + extentTest.addScreenCaptureFromPath(file.getAbsolutePath()));
//                    }
                    extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(file.getAbsolutePath()).build());
                }
            }
        	
            //extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshotNew(), "New Success").build());
          //  extentTest.log(Status.FAIL, addcaptureScreenshotInReport());
         //   extentTest.log(Status.FAIL, "Failed test case is: " + result.getName());
            
            String screenshotLink="<div style='overflow: hidden;'>"
                    + "<span style='float: left;'>Failed test case is: '" + result.getName()+"'</span>"
                    + "<span style='float: right;'><a href='" + addcaptureScreenshotInReport() + "' target='_blank'>Click here to view screenshot</a></span>"
                    + "</div>";
   		    extentTest.log(Status.FAIL, screenshotLink);
            
            
           // extentTest.log(Status.FAIL, "Result of failed test: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test case skipped: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
        	
        	String screenshotLink="<div style='overflow: hidden;'>"
                    + "<span style='float: left;'>Test case passed: '" + result.getName()+"'</span>"
                    + "<span style='float: right;'><a href='" + addcaptureScreenshotInReport() + "' target='_blank'>Click here to view screenshot</a></span>"
                    + "</div>";
   		    extentTest.log(Status.PASS, screenshotLink);
        	      
        }
 
 
        //extentReport.endTest(extentTest);
    }
    
    @AfterSuite
    public void endReport() throws IOException {
 
        extentReport.flush();
    }
    
 
    public String createReportDir() {
        
        try {
            String workingDir = System.getProperty("user.dir");
         //   String date = new SimpleDateFormat("yyyMMdd").format(new Date());
            String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
            String reportFolderDate = new SimpleDateFormat("ddMMyyyy HHmmss").format(new Date());
            String reportPath = R.CONFIG.get("extent_report_directory");
            extentReportFolder = workingDir + reportPath +"/"+date+ "/"+"Build_Mobile_"+reportFolderDate+"_"+R.CONFIG.get("capabilities.platformName").toUpperCase();
            System.out.println(extentReportFolder);
            File file = new File(extentReportFolder);
            if (file.mkdirs())
                LOGGER.debug("New report folder created.");
            else
                LOGGER.debug("Report folder already exist.");
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("Unable to create directory.");
        }
        return extentReportFolder;
    }
}
 