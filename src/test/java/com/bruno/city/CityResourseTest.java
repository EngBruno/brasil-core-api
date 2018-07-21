package com.bruno.city;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class CityResourseTest {

	@BeforeClass
	 public static void setup() {
//		 RestAssured.baseURI = "http://localhost";
//	     RestAssured.port = 8080;
	 }
	
	@Test
	public void getCity() {
		
	}
	
}
