package Phase3EndToEnd;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDEndTest {
String empid;
	@Test
	public void TC01_GetAllEmployee() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get()
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	@Test
	public void TC02_GetSingleEmployee() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get("/1")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	@Test
	public void TC03_CreateEmployee() {
		HashMap<String,String> obj = new HashMap<String,String>();

		obj.put("id", "7");
		obj.put("name", "tillu");
		obj.put("salary", "20000");
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(obj)
					.when()
					.post()
					.then()
					.log()
					.all()
					.statusCode(201);
		//emp_id = path.get("id");

		System.out.println("id is"+ empid);
	}




}
