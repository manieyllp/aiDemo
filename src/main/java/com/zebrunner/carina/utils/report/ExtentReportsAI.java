package com.zebrunner.carina.utils.report;
 
 
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
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
import com.zebrunner.carina.core.AbstractTest1;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
 
 
 
public class ExtentReportsAI extends AbstractPage{
 
    
    public ExtentReportsAI(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected static Logger LOGGER = LogManager.getLogger(ExtentReportsAI.class.getName());
    		//Logger.ExtentReportsAI.class;
 
    private static ExtentReports extentReport;
    public static ExtentTest extentTest = null;
    static String methodName="";
    static String reportPath;
    String reportPath1;
    static String fileName, reportfileName;
 
 
    
    public File captureScreenshot(String filename) {
    	TakesScreenshot takeScrenshot=(TakesScreenshot)getDriver();
    	File sourceFile=takeScrenshot.getScreenshotAs(OutputType.FILE);
    	File destFile=new File("./Screenshots/"+ filename);
    	try {
    		FileUtils.copyFile(sourceFile, destFile);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	System.out.println("Screenshot saved successfully");
    	return destFile;
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
    public static void startReportTest() {
        try {
            System.out.println("*********BeforeSuite*******************");
            LOGGER.debug("Starting extent report");
            startReport();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String currentDateAndTime = dateFormat.format(new Date());
 
           
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());}
 
        
    }
    @BeforeMethod(alwaysRun =true)
    public static void createTest(Method testMethod,ITestResult result) throws IOException {
    	System.out.println("*********BeforeMethod*******************");
         methodName=testMethod.getName();
 
        Test test = testMethod.getAnnotation(Test.class);
        String suiteName = test.suiteName();
      //  System.out.println("VFDGFD"+suiteName);
        extentTest = extentReport.createTest(testMethod.getName()).assignCategory(suiteName).assignDevice(R.CONFIG.get("capabilities.deviceName"));                        
        reportPath = ReportContext.getTestDirectory().toString();
        //reportPath1 = ReportContext.getTestDirectory().toString();
        System.out.println("Report path: "+ reportPath);
        //ExtentManager.setExtentTest(extentReport.createTest(methodName));
    }
 
 
    @AfterMethod(alwaysRun = true)
    public static void settingResultTest(ITestContext ctx, Method testMethod,ITestResult result,Object[] obj) {
        try {
        //  ITestContext, XmlTest, Method, Object[], ITestResult
        	System.out.println("*********AfterMethod*******************");
            LOGGER.debug("Setting up result in report");        
            getResult(result);
 
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }
 
    
    public static void startReport() {
    	try {
    		if(Objects.isNull(extentReport)) {
		        String reportFolder = createReportDir();
		        fileName = new SimpleDateFormat("hh_mm_ss").format(new Date());
		        extentReport = new ExtentReports();
		        reportfileName = reportFolder + "/" + fileName + ".html";
		        ExtentSparkReporter spark = new ExtentSparkReporter(reportfileName);
		        extentReport.attachReporter(spark);
		        spark.config().setTheme(Theme.STANDARD)  ;
		        spark.config().setDocumentTitle("Automation Test Suite Report"); //Need to include suite name

		        extentReport.setSystemInfo("Host Name", R.CONFIG.get("localhost"));
		        extentReport.setSystemInfo("Environment", R.CONFIG.get("env"));
		        extentReport.setSystemInfo("User", R.CONFIG.get("user"));
    		}
        }catch(Exception e) {
        	LOGGER.error(e.getMessage());
        }      
 
    }
    public static void getResult(ITestResult result) throws IOException {
        System.out.println("******************InsideGetResuls**********************");

        File directoryPath = new File(reportPath);
        File filesList[] = directoryPath.listFiles();
        for (File file : filesList) {
            if (file.getName().contains(".png")) {
//                String comments = ReportContext.getScreenshotComment(file.getName());
//                if (comments.contains("PASS")) {
//                    extentTest.log(Status.PASS, comments + extentTest.addScreenCaptureFromPath(file.getAbsolutePath()));
//                 }
            	//extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(fileToBase64(captureScreenshot("Open HomePage"))).build());
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
            extentTest.log(Status.FAIL, "Failed test case is: " + result.getName());
            extentTest.log(Status.FAIL, "Result of failed test: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test case skipped: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test case passed: " + result.getName());
            //extentTest.log(LogStatus.PASS, "Test case passed: " + result.getAttribute("Pre-requisite").toString());
        }
 
    }
    @AfterSuite
    public void endReport() throws IOException {
    	if(Objects.nonNull(extentReport)) {
    		extentReport.flush();
    	}
        Desktop	.getDesktop().browse(new File(reportfileName).toURI()); //To directly open report file on desktop

    }

 
    public static String createReportDir() {
        String extentReportFolder = null;
        try {
            String workingDir = System.getProperty("user.dir");
            String date = new SimpleDateFormat("yyyMMdd").format(new Date());
            String reportPath = R.CONFIG.get("extent_report_directory");
            extentReportFolder = workingDir + reportPath + "/" + date;
            //System.out.println("extentReportFolder: "+extentReportFolder);
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

