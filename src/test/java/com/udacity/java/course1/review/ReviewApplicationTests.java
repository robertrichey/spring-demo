package com.udacity.java.course1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private SignUpPage signUpPage;
	private ChatPage chatPage;
	private LoginPage loginPage;
	private String baseUrl;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@Test
	public void signUpLoginPost() {
		baseUrl = "http://localhost:" + port;
		String credential = "r";

		signUpPage = new SignUpPage(driver);
		driver.get(baseUrl + "/signup");

		signUpPage.inputFirstName(credential);
		signUpPage.inputLastName(credential);
		signUpPage.inputUsername(credential);
		signUpPage.inputPassword(credential);
		signUpPage.clickSubmit();

		loginPage = new LoginPage(driver);
		driver.get(baseUrl + "/login");

		loginPage.inputUsername(credential);
		loginPage.inputPassword(credential);
		loginPage.clickLogin();

		chatPage = new ChatPage(driver);

		chatPage.enterText(credential);
		chatPage.clickSubmit();

		String expectedMessage = credential + ": " + credential;
		assertEquals(expectedMessage, chatPage.getChat());
	}
}
