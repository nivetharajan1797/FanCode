package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserEndPoints extends Routes{

	public static Response getUser()
	{
		Response response = given()
				.contentType(ContentType.JSON)
                .when()
                .get(base_url+"/users");
		return response;				
	}
	public static Response getTodos(int userId)
	{
		Response response = given()
				.contentType(ContentType.JSON)
                .when()
                .get(base_url+"/todos?userId=" + userId);
		return response;
		
	}
}
