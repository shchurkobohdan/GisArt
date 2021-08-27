package main_page;

import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.driver.WebDriverFactory;
import ui.page_objects.MainPage;


public class MainPageTest {
	private MainPage mainPage;

	@BeforeTest
	public void setup() {
		var driver = WebDriverFactory.getDriver();
//		driver.get("some url");
		mainPage = new MainPage();
	}

	@AfterTest
	public void tearDown() {
		WebDriverFactory.getDriver().quit();
	}

	@Test
	public void testCase1() {
		mainPage.getVehicleData()
				.setName("Vehicle 1")
				.setModel("BMW")
				.setYear("2020");
		mainPage.selectColorForClonedVehicle("Red")
				.clickCloneButton();

		var clonedVehicleData = mainPage.getClonedVehicleData();
		Assertions.assertThat(clonedVehicleData.getName()).isEqualTo("Vehicle 1");
		Assertions.assertThat(clonedVehicleData.getModel()).isEqualTo("BMW");
		Assertions.assertThat(clonedVehicleData.getColor()).isEqualTo("Red");
		Assertions.assertThat(clonedVehicleData.getYear()).isEqualTo("2020");
	}

	@Test
	public void testCase2() {
		mainPage.getVehicleData()
				.setName("Vehicle 1")
				.setModel("Mazda")
				.setYear("2020");
		mainPage.selectColorForClonedVehicle("Red")
				.clickCloneButton();

		var clonedVehicleData = mainPage.getClonedVehicleData();
		Assertions.assertThat(clonedVehicleData.getName()).isEqualTo("Vehicle 1");
		Assertions.assertThat(clonedVehicleData.getModel()).isEqualTo("Mazda");
		Assertions.assertThat(clonedVehicleData.getColor()).isEqualTo("Red");
		Assertions.assertThat(clonedVehicleData.getYear()).isEqualTo("2020");
	}
}
