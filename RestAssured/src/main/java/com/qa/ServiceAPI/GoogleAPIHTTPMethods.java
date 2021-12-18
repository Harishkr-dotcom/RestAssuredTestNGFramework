package com.qa.ServiceAPI;

import java.io.IOException;

import org.testng.Assert;

import com.qa.BaseService.BaseStep;
import com.qa.Requests.PostAdressRequest;
import com.qa.Requests.UpdatePlaceRequest;
import com.qa.RestUtils.RequestSpecification;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GoogleAPIHTTPMethods {
	
	 private BaseStep baseStep = new BaseStep();
	 private String postAPI =  baseStep.CREAT_PLACE;
	 private String getAPI =  baseStep.GET_PLACE;
	 private String putAPI = baseStep.UPDATE_PLACE;
	 private String deleteAPI = baseStep.DELET_PLACE;
	 
	 public Response createAddress(PostAdressRequest postAdress){
		  Response response = RestAssured.given().queryParam("key", "qaclick123")
		  .header("Content-Type","application/json")
		  .body(postAdress).log().all()
		  .when()
		  .post(postAPI);
		  response.then().log().all();
		 return response;
	 }
	 
	 public Response getPlaceAPI(String Place_Id){
		  Response response = RestAssured.given().queryParam("key", "qaclick123")
		  .queryParam("place_id", Place_Id)
		  .header("Content-Type","application/json")
		  .log().all()
		  .when()
		  .get(getAPI);
		  response.then().log().all();
		 return response;
	 }
	 
	 public Response updatePlaceAPI(String Place_Id, UpdatePlaceRequest updatePlaceRequest){
		  Response response = RestAssured.given().queryParam("key", "qaclick123")
		  .queryParam("place_id", Place_Id)
		  .header("Content-Type","application/json")
		  .body(updatePlaceRequest)
		  .log().all()
		  .when()
		  .put(putAPI);
		  response.then().log().all();
		 return response;
	 }
	 
	 public Response deletePlaceAPI(UpdatePlaceRequest updatePlaceRequest){
		  Response response = RestAssured.given().queryParam("key", "qaclick123")
		  .header("Content-Type","application/json")
		  .body(updatePlaceRequest)
		  .log().all()
		  .when()
		  .put(deleteAPI);
		  response.then().log().all();
		 return response;
	 }
	 
	 //Using request specification
	 public Response getPlaceAPIusingRequestSpecificattion(String Place_Id) throws IOException{
		  Response response = RestAssured.given().spec(RequestSpecification.requestSpecifications())
		  .queryParam("place_id", Place_Id)
		  .log().all()
		  .when()
		  .get(getAPI);
		  response.then().log().all();
		 return response;
	 }
	  
	 public void validateStatusCode(Response response, int StatusCode){
		 Assert.assertEquals(response.getStatusCode(), StatusCode);
	 }

}
