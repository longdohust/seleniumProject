package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
    public static ExtentReports getReportObject(){
        String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
        //Config for the report file using ExtentSparkReporter class
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Test 1");
        reporter.config().setDocumentTitle("Demo");

        //Attach the report to the ExtentReports class, which create and consolidate all test execution
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", " Long");
        extent.createTest(reportPath);
        return extent;
    }
}

