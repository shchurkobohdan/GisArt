package ui.element.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class Element {
	private ElementHolder elementHolder;

	public Element(WebElement webElement) {
		elementHolder = new ElementHolder(webElement);
	}

	public WebElement getWebElement() {
		return elementHolder.getWebElement();
	}

	public boolean isDisplayed() {
		try {
			return getWebElement().isDisplayed();
		} catch (Exception ignored) {
			return false;
		}
	}

	public boolean isEnabled() {
		try {
			return getWebElement().isEnabled();
		} catch (Exception ignored) {
			return false;
		}
	}

	public boolean isClickable() {
		return isDisplayed() && isEnabled();
	}

	public String getAttribute(String attributeName) {
		return getWebElement().getAttribute(attributeName);
	}

	public void refreshInnerElements() {
		PageFactory.initElements(new FieldDecorator(getWebElement()), this);
	}
}
