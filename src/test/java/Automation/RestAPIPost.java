package Automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
//import net.minidev.json.JSONObject;

/* Different Ways to create post request body 
 * 1) Post request body using Hashmap
 * 2) Post request body creation using org.JSON
 * 3) Post request body using POJO class
 * 4) Post request using externam json file data*/

public class RestAPIPost
{
	/* Using hashmap */
	//@Test (priority = 1)
	void insertuser()
	{
		HashMap<String, Object> user = new HashMap<>();
		user.put("emailid","sujata@thegamificationcompany.com");
		user.put("campaignid","99442");
	    user.put("name","Sujit");
	    user.put("phonenumber","9970089987");
	     
	    
	    given()
	    .relaxedHTTPSValidation()
	    .contentType("application/json")
	    .body(user)
	    
	    .when()
	    .post("https://skillmuni.in:8080/addPlayerDetails")
	    
	    .then()
	    .statusCode(500)
	    .log().all();
	}
	
	/* Using JSON library */
	//@Test(priority = 2)
	void adduser()
	{
		JSONObject data = new JSONObject();
		data.put("emailid","sujata@thegamificationcompany.com");
		data.put("campaignid","99442");
	    data.put("name","Sujit");
	    data.put("phonenumber","9970089987");
	     	
	   given()
	   .relaxedHTTPSValidation()
	    .contentType("application/json")
	    .body(data)
	    
	    .when()
	    .post("https://skillmuni.in:8080/addPlayerDetails")
	    
	    .then()
	    .statusCode(200)
	    .log().all();
	  }

	//3) Using POJO class means encapsulation in java (getter /setter method ) so we create the seperate the class
	//@Test()
	void addusers()
	{
		
		POJOClass data = new POJOClass();
		data.setEmailid("sujata@thegamificationcompany.com");
		data.setCampaignid("99442");
		data.setName("Sujit");
		data.setPhonenumber("9970089987");
		
		given()
		   .relaxedHTTPSValidation()
		   .contentType("application/json")
		   .body(data)
		   
		   .when()
		   .post("https://skillmuni.in:8080/addPlayerDetails")
		    
		    .then()
		    .statusCode(200)
		    .log().all();
		 }
	
	//4) Using external json file
	@Test
	void insertusers() throws FileNotFoundException
	{
		File f = new File(".\\externaldataa");
		FileReader fr = new FileReader(f);
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
		   .relaxedHTTPSValidation()
		   .contentType("application/json")
		   .body(data.toString())
		   
		   .when()
		   .post("https://skillmuni.in:8080/addPlayerDetails")
		    
		    .then()
		    .statusCode(200)
		    .log().all();
		
		
	}

 
}
