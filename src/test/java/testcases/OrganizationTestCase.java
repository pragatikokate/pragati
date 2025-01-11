package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.VTigerBase;
import com.crm.JavaUtility.GenerateRandomNumber;
import com.crm.fileUtility.ReadFromExcelFile;
import com.crm.pom.HomePage;
import com.crm.pom.Organization;

public class OrganizationTestCase extends VTigerBase {
	@Test
	public void testCase1() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		assertTrue(hp.home().isDisplayed(), "iam not in vtiger home page");
		Reporter.log("iam in vtiger home page");
		hp.organization();
		Organization org= new Organization(driver);
		org.plusOrg();
		String org_name =ReadFromExcelFile.readexcel("Organization",0,0);
		int dynamicNumbers = GenerateRandomNumber.random();
		String expected_org = org_name+dynamicNumbers;
		org.accountName(org_name+dynamicNumbers);
		org.save();
		String actual_org= org.header().getText();
		assertTrue(actual_org.contains(expected_org));
		Thread.sleep(4000);		
		
	}
	

}
