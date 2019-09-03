package stepDefinition;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToFavourite {

	public WebDriver driver = null;

	String FirstVideo, SecondVideo, MyFavFirstVideo, MyFavSecondVideo;

	@Given("^Open a ChromeBrowser$")
	public void open_a_ChromeBrowser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@When("^Enter the URL \"([^\"]*)\"$")
	public void enter_the_URL(String arg1) {

		driver.get("https://www.discovery.com/");

	}

	@When("^Click on More$")
	public void click_on_More() {

		driver.findElement(By.xpath("(//span[contains(text(),'More')])[1]/..")).click();

	}

	@When("^Hover And Select the My Video Dropdown$")
	public void Hover_And_Select_the_My_Video_Dropdown() throws InterruptedException {

		Actions Act1 = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		WebElement myVideosLink = driver
				.findElement(By.xpath("((//div[@class='o-Header__m-DropdownMenu'])[2]/ul/li[2]/a)[1]"));
		Act1.moveToElement(myVideosLink).build().perform();
		myVideosLink.click();

		System.out.println("My Current URL is " + driver.getCurrentUrl());

	}

	@Then("^User Navigate to Child Window$")
	public void user_Navigate_to_Child_Window() {

		Set<String> List = driver.getWindowHandles();
		int count = List.size();
		System.out.println("Number of Active Windows " + count);
		Iterator<String> it = List.iterator();
		String parentid = it.next();
		String childid = it.next();

		System.out.println("Parent id =" + parentid);
		System.out.println("Child id =" + childid);

		driver.switchTo().window(childid);

		System.out.println("My Current URL is " + driver.getCurrentUrl());

	}

	@When("^User click on Home screenicon$")
	public void user_click_on_Home_screenicon() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[2]/header/div[2]/div/a/picture/img"))
				.click();

	}

	@When("^Navigate to Home screen$")
	public void navigate_to_Home_screen() {

		System.out.println("User is at Homescreen of Child Window");

	}

	@When("^Scroll down to Recommended for you$")
	public void scroll_down_to_Recommended_for_you() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 2000)");

	}

	@When("^Select one Video from recommended for you section$")
	public void select_one_Video_from_recommended_for_you_section() {

		Actions act2 = new Actions(driver);

		WebElement Recommendedforyou1 = driver.findElement(By
				.xpath("//div[@class='page-wrapper app__pageWrapper']/section[8]/div/div/div/div/div/section/div[3]"));

		act2.moveToElement(Recommendedforyou1).build().perform();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		FirstVideo = driver.findElement(By.xpath(
				"//div[@class='page-wrapper app__pageWrapper']/section[8]/div/div/div/div/div/section/div[3]/a/div/h3/div"))
				.getText();

		System.out.println("First Selected Video Name is " + FirstVideo);

		WebElement AddToFav1 = driver.findElement(By.xpath(
				"//div[@class='page-wrapper app__pageWrapper']/section[8]/div/div/div/div/div/section/div[3]/a/div/div[2]/div/span/i"));

		AddToFav1.click();
	}

	@When("^Select another Video from recommended for you section$")
	public void select_another_Video_from_recommended_for_you_section() {
		Actions act3 = new Actions(driver);

		WebElement Recommendedforyou2 = driver.findElement(By.xpath(
				"//div[@class='page-wrapper app__pageWrapper']/section[8]/div/div/div/div/div[2]/section/div[3]"));

		act3.moveToElement(Recommendedforyou2).build().perform();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		SecondVideo = driver.findElement(By.xpath(
				"//div[@class='page-wrapper app__pageWrapper']/section[8]/div/div/div/div/div[2]/section/div[3]/a/div/h3/div"))
				.getText();

		System.out.println("First Selected Video Name is " + SecondVideo);

		WebElement AddToFav2 = driver.findElement(By.xpath(
				"//div[@class='page-wrapper app__pageWrapper']/section[8]/div/div/div/div/div[2]/section/div[3]/a/div/div[2]/div/span/i"));

		AddToFav2.click();
	}

	@When("^Click on My Videos from the menu icon$")
	public void click_on_My_Videos_from_the_menu_icon() {

		driver.findElement(By.xpath("//nav[@class='dscHeaderMain__topLinks dscHeaderMain__mainTopLinks']/ul/li[6]"))
				.click();

		Actions act4 = new Actions(driver);

		WebElement myVideos = driver.findElement(By.xpath("//span[text()='My Videos']"));
		act4.moveToElement(myVideos).build().perform();

		myVideos.click();
	}

	@When("^Navigate to Favorite Section$")
	public void navigate_to_Favorite_Section() throws InterruptedException {

		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("window.scrollTo(0, 400)");

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		Actions act5 = new Actions(driver);

		WebElement myFav1 = driver.findElement(By.xpath(
				"//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']/div/div/div/div/div/div/section/div[3]"));
		act5.moveToElement(myFav1).build().perform();

		MyFavFirstVideo = driver.findElement(By.xpath(
				"//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']/div/div/div/div/div/div/section/div[3]/a/div/h3/div"))
				.getText();

		System.out.println("My Favourite = " + MyFavFirstVideo);

		Actions act6 = new Actions(driver);

		WebElement myFav2 = driver.findElement(By.xpath(
				"//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']/div/div/div/div/div/div[2]/section/div[3]"));
		act6.moveToElement(myFav2).build().perform();

		MyFavSecondVideo = driver.findElement(By.xpath(
				"//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']/div/div/div/div/div/div[2]/section/div[3]/a/div/h3/div"))
				.getText();

		System.out.println("My Favourite = " + MyFavSecondVideo);

	}

	@Then("^Verify the Name of the Added Videos and Close the browser$")
	public void verify_the_Name_of_the_Added_Videos_and_Close_the_browser() {

		if (FirstVideo.equalsIgnoreCase(MyFavSecondVideo) && SecondVideo.equalsIgnoreCase(MyFavFirstVideo)) {

			System.out.println("Video Selected is present in My Favourite section");
		} else {
			System.out.println("Video Selected is not present in My Favourite section");
		}

		driver.quit();

	}

}
