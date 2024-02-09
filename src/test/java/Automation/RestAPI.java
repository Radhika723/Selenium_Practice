package Automation;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
/* given() - content type, set cookies, add auth, add param, set headers info etc ...
   when() - get,put,post,delete
   then() - validate status, extract response, extract header cookies and response body
   ** To run the above methods we need to download the stati packages manually - Go to the rest assured website -  static important*/

public class RestAPI 
{
	@Test
	
	public void getuserdetail()
	{
	  given()
	  
	  .when()	
	    //.get("https://www.m2ost.in/M2OST_Api_PriME/api/Translate/GetAllLanguagesDropdown?_=1707132725189")
	    //.get("https://www.playtolearn.in/Mini_games/api/UserDetail?OrgId=15&Email=bata501_BA")
	    .get("https://www.playtolearn.in/CubicallGameNewApi_test/api/GetRoles?OrgId=1&RoleId=1")
	  
	    .then()
	    .statusCode(200)
	    .body("[0].functions[0].functionName", equalTo("Create Batches and assign games."))
	    .body("[0].functions[1].description", equalTo("Create CMS Role"))
	    .body("[0].functions[7].isActive",equalTo("A"))
	   
	    .log().all();
	  
	  
	  when()
	    .get("https://www.playtolearn.in/CubicallGameNewApi_test/api/GetCMSUsers?oid=1&uid=1")
	    
	  .then()
	    .body("[0].userName",equalTo("Rajat"))
	    .log().all();
	  
	  
	  }

}
    

