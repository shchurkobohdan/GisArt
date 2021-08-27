package ui.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.WebDriverFactory;
import ui.element.core.FieldDecorator;

import java.time.Duration;


public abstract class Page {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public Page() {
		this.driver = WebDriverFactory.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		initElements();
	}

	protected void initElements() {
		PageFactory.initElements(new FieldDecorator(driver), this);
	}
}
