package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MobilePage;
import TestComponents.BaseTest;

public class VerifySortBy extends BaseTest {
	@Test
	public void sortByName() {
		String sortBy = "Name";

		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.goToLandingPage();
		mobilePage.getTitlePage();
		mobilePage.goToMobilePage();
		List<String> initialNames = mobilePage.getProductNames();

		for (String name : initialNames) {
			System.out.print("- " + name);
		};

		mobilePage.selectSortBy(sortBy);
		List<String> actualNames = mobilePage.getProductNames();

		System.out.print(actualNames);
		List<String> expectedNames = new ArrayList<>(actualNames);
		Collections.sort(expectedNames);
		System.out.print(expectedNames);

		Assert.assertEquals(actualNames, expectedNames,
				"La lista de productos no está ordenada alfabéticamente por nombre.");

	};

}
