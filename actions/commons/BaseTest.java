package commons;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import reportConfig.VerificationFailures;

public class BaseTest {
	private WebDriver driver;
	protected final Log log; //ngan can khoi tao lai, chi dc dung
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass()); //khoi tao log
	}
	
	private enum BROWSER { CHROME, FIREFOX, IE, SAFARI, EDGE_CHROMIUM}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		if(browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSER.EDGE_CHROMIUM){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser == BROWSER.SAFARI){
			driver = new SafariDriver();
		} else {
			throw new RuntimeException ("Please enter correct browser name!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	public WebDriver getWebDriver() {
		return this.driver;
	}
	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" +rand.nextInt(99999) + "@live.com";
	}
	public String getRandomNumber() {
		Random rand = new Random();
		return "0" +rand.nextInt(9999);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED ----------------------- ");
			} else {
				log.info(" -------------------------- FAILED ----------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED ----------------------- ");
			} else {
				log.info(" -------------------------- FAILED ----------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED ----------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED ----------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	
	@BeforeTest 
	public void deleteAllFilesInReportNGScreenshot() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "/reportNGScreenshot";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if(listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		log.info("------ END delete file in folder -----");
	}
	
	public void cleanDriverInstance() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);
			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + osName);
			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
					}
				} else if (driverInstanceName.contains("internetexplorer")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					}
				} else if (driverInstanceName.contains("firefox")) {
					if (osName.contains("windows")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
					} else {
						cmd = "pkill geckodriver";
					}
				} else if (driverInstanceName.contains("edge")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
					} else {
						cmd = "pkill msedgedriver";
					}
				} else if (driverInstanceName.contains("opera")) {
					if (osName.contains("window")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
					} else {
						cmd = "pkill operadriver";
						}
					} else if (driverInstanceName.contains("safari")) {
						if (osName.contains("mac")) {
						cmd = "pkill safaridriver";
						}
					}
					if (driver != null) {
						driver.manage().deleteAllCookies();
						driver.quit();
					}
				} catch (Exception e) {
					log.info(e.getMessage());
					} finally {
						try {
							Process process = Runtime.getRuntime().exec(cmd);
							process.waitFor();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
}