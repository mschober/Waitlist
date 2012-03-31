package controllers;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import play.data.validation.Validation;
import play.libs.XPath;
import play.mvc.Http.Response;
import play.mvc.Router;
import play.test.FunctionalTest;

public class ApplicationControllerTest extends FunctionalTest {

	@Test
	public void test() {
		String fname = "Go";
		String lname = "Fuck";
		String boatType = "Power";
		String email = "yourself@dickinass.com";
		String phoneNumber = "253-468-4141";
		String postalAddress = "3706 Amalfi Way";
		String city = "Santa Barbara";
		String state = "CA";
		int zip = 93105;

		Map<String,String> params = new HashMap<String,String>();
		params.put("fname", "Michael");
		params.put("lname", "Schober");
		params.put("boatType", "Power");
		params.put("email", "mike.schober@gmail.com");
		params.put("phoneNumber", "253-468-4141");
		params.put("postalAddress", "3706 Amalfi Way");
		params.put("city", "Santa Barbara");
		params.put("state", "CA");
		
		Response response = POST(Router.reverse("Application.post").url, params);
	}

}