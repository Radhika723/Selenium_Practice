package Automation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class ResrQueryParameters 
{
	//https://www.playtolearn.in/Mini_games_beta/api/UserDetail?OrgId=15&Email=bata501
	@Test
	void queryparameters()
	{
		given()
		.pathParam("Users", "UserDetail")
		.queryParam("orgID", 15)
		.queryParam("Email", "bata501")
		
		.when()
		.get("https://www.playtolearn.in/Mini_games_beta/api/{Users}")
		
		.then()
		.statusCode(200)
		.log().all();	
		
	}

}
