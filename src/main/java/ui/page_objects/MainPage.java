package ui.page_objects;


import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.element.VehicleDataSection;

public class MainPage extends Page {
	@Getter
	@FindBy(id = "model1")
	private VehicleDataSection vehicleData;
	@Getter
	@FindBy(id = "model2")
	private VehicleDataSection clonedVehicleData;
	@FindBy(id = "vehColor")
	private WebElement cloneVehicleColorSelect;
	@FindBy(id = "cloneVehicle")
	private WebElement cloneVehicleButton;

	public MainPage selectColorForClonedVehicle(String color) {
		new Select(cloneVehicleColorSelect).selectByValue(color);
		return this;
	}

	public MainPage clickCloneButton() {
		cloneVehicleButton.click();
		initElements();
		return this;
	}
}
