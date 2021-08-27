package ui.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.element.core.Element;

public class VehicleDataSection extends Element {
	@FindBy(css = ".js-name")
	private WebElement nameInput;
	@FindBy(css = ".js-model")
	private WebElement modelSelect;
	@FindBy(css = ".js-color")
	private WebElement colorInput;
	@FindBy(css = ".js-year")
	private WebElement yearInput;

	public VehicleDataSection(WebElement webElement) {
		super(webElement);
	}

	public String getName() {
		return nameInput.getAttribute("value");
	}

	public VehicleDataSection setName(String name) {
		nameInput.clear();
		nameInput.sendKeys(name);
		return this;
	}

	public String getModel() {
		return new Select(modelSelect).getFirstSelectedOption().getText();
	}

	public VehicleDataSection setModel(String model) {
		new Select(modelSelect).selectByValue(model);
		return this;
	}

	public String getColor() {
		return colorInput.getAttribute("value");
	}

	public VehicleDataSection setColor(String color) {
		colorInput.clear();
		colorInput.sendKeys(color);
		return this;
	}

	public String getYear() {
		return yearInput.getAttribute("value");
	}

	public VehicleDataSection setYear(String year) {
		yearInput.clear();
		yearInput.sendKeys(year);
		return this;
	}
}
