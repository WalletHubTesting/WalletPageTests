package com.wallethub.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wallethub.base.TestBase;
import com.wallethub.pages.WalletHubPages;

public class WalletHubPagesTests extends TestBase {
	WalletHubPages walletHubPages;
	 SoftAssert softAssertion;
	
	
	
	
	public WalletHubPagesTests() 
	{
		super(); 
		
	}
	
	@BeforeClass
	public void baseSetUp()
	{
		
		 initilization();
		 walletHubPages =new WalletHubPages();
		 softAssertion= new SoftAssert();
		 
	}
	
	@BeforeMethod
	public void preSetUp() throws InterruptedException
	{
		walletHubPages.login(prop.getProperty("username"),prop.getProperty("password"));
		walletHubPages.navigateUrl(prop.getProperty("testUrl"));
				 
	}
	
	@AfterMethod
	public void postSetUp() throws InterruptedException
	{
		// delete the post
		walletHubPages.removeReviews();
		//String userItem = "Logout";
		//walletHubPages.clickUserMenu(userItem);
		//logout
				 
	}
	
	@AfterClass
	public void tearDown()

	{
		driver.quit();
	}
	
	
	
	@Test(priority = 1, description = " Scenario 1 : Wallet Hub Test 2")
	public void walletHub() throws InterruptedException
	{
		String reviewTextValue = "On the right part of the page, On the right part of the pageOn the right part of the pageOn the right part of the pagehover over the stars and click on redirecting the WebDriver to the next page isn’t an option.";
		int starCount = 4;
		String dropDownvalue="Health Insurance";
		String userItem = "Profile";
		String userTab = "Reviews";
		Assert.assertTrue(walletHubPages.mouseHoverStarLitUp(), "Mouse Hover Success");;
		walletHubPages.clickMouseHoverStar(prop.getProperty("testUrl"),starCount);
		walletHubPages.dropDownSelection(dropDownvalue);
		walletHubPages.reviewText(reviewTextValue);
		walletHubPages.clickSubmitButton();
		walletHubPages.clickUserMenu(userItem);
		Assert.assertEquals(walletHubPages.reviewGetTextInActivityTab(), reviewTextValue);
		walletHubPages.tabSelection(userTab);
		Assert.assertEquals(walletHubPages.reviewGetTextInReviewsTab(), reviewTextValue);
		Assert.assertTrue(walletHubPages.reviewsTabIsDiplayedContent(reviewTextValue), "Both Values are matching");
		softAssertion.assertAll();
	}
	
	
	
	
}
