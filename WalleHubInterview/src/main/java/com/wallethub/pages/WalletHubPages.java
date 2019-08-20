package com.wallethub.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.base.TestBase;

public class WalletHubPages extends TestBase {

	public void signUp(String usNme, String pwd) {
		WebElement emailId = driver.findElement(By.name("em"));

		WebElement passWord = driver.findElement(By.name("pw1"));

		WebElement confirmPassWord = driver.findElement(By.name("pw2"));

		WebElement joinButton = driver.findElement(By.cssSelector(".blue.touch-element-cl"));

		WebElement chkBx = driver.findElement(By.xpath("//input[@type='checkbox']"));

		emailId.clear();
		emailId.sendKeys(usNme);

		passWord.clear();
		passWord.sendKeys(pwd);

		confirmPassWord.clear();
		confirmPassWord.sendKeys(pwd);

		// CheckBox button throws an "element not intractable" error, So used javascript
		// extractor to find the element directly in dom

		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", chkBx);

		joinButton.click();

	}

	public void navigateUrl(String url) {

		driver.navigate().to(url);
	}

	public void login(String usNme, String pwd) throws InterruptedException {

		WebElement loginTab = driver
				.findElement(By.xpath("//nav[@class='ng-animate-enabled basic-trans enter join']//a[text()='Login']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(loginTab));
		loginTab.click();
		WebElement loginEmail = driver.findElement(By.name("em"));

		WebElement loginPassword = driver.findElement(By.name("pw1"));

		loginEmail.clear();
		loginEmail.sendKeys(usNme);
		loginPassword.clear();
		loginPassword.sendKeys(pwd);
		WebElement loginButton = driver
				.findElement(By.xpath("//button[@type='button' and @class='btn blue touch-element-cl']"));
		loginButton.click();
		// Thread.sleep(millis);
		wait.until(ExpectedConditions.invisibilityOf(loginButton));
	}

	public boolean mouseHoverStarLitUp() throws InterruptedException {
		WebElement star = driver
				.findElement(By.cssSelector(".review-action .rvs-svg .rating-box-wrapper .rvs-star-svg"));
		List<WebElement> stars = driver
				.findElements(By.cssSelector(".review-action .rvs-svg .rating-box-wrapper .rvs-star-svg"));
		List<WebElement> beforeMouseHohover = driver.findElements(By
				.xpath("//div[@class='review-action ng-enter-element']//*[@class='rvs-star-svg']//*[@fill='#4ae0e1']"));
		int beforeMouseHohoverCount = beforeMouseHohover.size();
		System.out.println(beforeMouseHohoverCount);
		Actions actions = new Actions(driver);
		actions.moveToElement(star).build().perform();
		WebElement afterMouseHohover = driver.findElement(By.xpath(
				"//div[@class='review-action ng-enter-element']//*[@class='rvs-star-svg']//*[@fill='#4ae0e1']//following-sibling::*[@fill='none']"));
		if (afterMouseHohover.isDisplayed()) {
			System.out.println(afterMouseHohover.isDisplayed());
			return true;
		} else {
			System.out.println(afterMouseHohover.isDisplayed());
			return false;
		}
	}

	public void clickMouseHoverStar(String url, int starCount) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List<WebElement> stars = driver
				.findElements(By.cssSelector(".review-action .rvs-svg .rating-box-wrapper .rvs-star-svg"));
		System.out.println(stars.size());

		stars.get(starCount).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Submit']"))));
		
	}

	public void dropDownSelection(String dropDownValue) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement dropDown = driver.findElement(By.cssSelector(".wrev-drp .dropdown.second .dropdown-placeholder"));
		dropDown.click();
		List<WebElement> dropDownLists = driver
				.findElements(By.cssSelector(".wrev-drp .dropdown.second .dropdown-list .dropdown-item"));
		System.out.println(dropDownLists.size());
		for (int i = 0; i < dropDownLists.size(); i++) {
			if (dropDownLists.get(i).getText().equals(dropDownValue)) {
				dropDownLists.get(i).click();
				break;
			}
		}
		// Thread.sleep(5000);

	}

	public void reviewText(String reviewText) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement reviewTextArea = driver.findElement(By.cssSelector(".textarea.wrev-user-input.validate"));
		reviewTextArea.sendKeys(reviewText);

	}

	public void clickSubmitButton() throws InterruptedException {
		WebElement submitButton = driver.findElement(By.xpath("//div[text()='Submit']"));
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Continue']"))));

	}

	public void clickContinueButton() throws InterruptedException {
		WebElement continueButton = driver.findElement(By.xpath("//div[text()='Continue']"));
		continueButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Continue']"))));

	}

	public void clickUserMenu(String userItem) throws InterruptedException {
		WebElement userMenu = driver.findElement(By.cssSelector(".brgm-user.brgm-list-box"));
		Actions actions = new Actions(driver);
		actions.moveToElement(userMenu).build().perform();
		List<WebElement> userMenuList = driver.findElements(By.cssSelector(".brgm-list.brgm-user-list .brgm-list-it"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(userMenuList));
		for (int i = 0; i < userMenuList.size(); i++) {
			System.out.println("Outside IF Loop" + userMenuList.get(0).getText());
			if (userMenuList.get(i).getText().contains(userItem)) {

				System.out.println("Inside IF Loop" + userMenuList.get(i).getText());
				userMenuList.get(i).click();
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.cssSelector(".activities .feed-content .feeddesc"))));
				break;
			}
		}

	}

	public void tabSelection(String userItem)

	{
		WebElement userMenuList = driver
				.findElement(By.xpath("//div[@id='wh-body-inner']//ul//li//a[contains(.,\'" + userItem + "\')]"));
		System.out.println(userMenuList.getText());
		userMenuList.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public String reviewGetTextInActivityTab() {
		WebElement feedContent = driver.findElement(By.cssSelector(".activities .feed-content .feeddesc"));
		System.out.println(feedContent.getText());
		return feedContent.getText();

	}

	public String reviewGetTextInReviewsTab() {
		WebElement feedContent = driver.findElement(By.xpath("//div[@class='reviews']//p[2]"));
		System.out.println(feedContent.getText());
		return feedContent.getText();

	}

	public Boolean reviewsTabIsDiplayedContent(String reviewTextValue) {
		WebElement feedContent = driver.findElement(By.xpath("//div[@class='reviews']//p[2]"));
		System.out.println(feedContent.getText());
		if (feedContent.getText().equals(reviewTextValue)) {
			return true;
		} else {
			return false;
		}

	}
	
	public void removeReviews()

	{
		WebElement remove = driver.findElement(By.cssSelector(".content-reviews .remove"));
		remove.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.invisibilityOf(driver.findElement(By.xpath("//div[@class='reviews']//p[2]"))));
		
		
	}
}
