package Phase3EndToEnd;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class EndToEndTest {
String empid;
	@Test
	public void GetAllEmployees_01() {
		
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
	public void GetSingleEmployee_02() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get("2")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	@Test
	public void CreateEmpmployee_03() {
HashMap<String,String> obj = new HashMap<String,String>();
		
		obj.put("id", "6");
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


		System.out.println(empid);
		
	}
	@Test
	public void DeleteEmployee_04() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees"+empid)
		.when()
		.delete()
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	@Test
	public void TestDeletedEmployee05() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees"+empid)
		.when()
		.get()
		.then()
		.log()
		.all()
		.statusCode(401);
	}
}
