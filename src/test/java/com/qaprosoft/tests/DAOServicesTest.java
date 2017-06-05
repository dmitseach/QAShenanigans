package com.qaprosoft.tests;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.dao.*;
import com.qaprosoft.objects.*;

import java.util.List;

import org.testng.annotations.Test;

@Test(description = "ServicesTest")
public class DAOServicesTest extends UITest {

	private static PhoneDAO phoneService;
	private static FridgeDAO fridgeService;

	public void testGetPhoneById() {
		Phone phone = phoneService.getPhoneById(1);
		System.out.println(phone);
	}

	public void testGetFridgeById() {
		Fridge fridge = fridgeService.getFridgeById(1);
		System.out.println(fridge);
	}

	public void testGetPhones() {
		List<Phone> phones = phoneService.getPhones();
		for (Phone phone : phones) {
			System.out.println(phone);
		}
	}

	public void testGetFridges() {
		List<Fridge> fridges = fridgeService.getFridges();
		for (Fridge fridge : fridges) {
			System.out.println(fridge);
		}
	}
}
