package GoogleAPITest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Requests.PostAdressRequest;
import com.qa.Requests.UpdatePlaceRequest;
import com.qa.Responses.PostAdressResponse;
import com.qa.Responses.PostPlaceResopnse;
import com.qa.RestUtils.JSONUtils;
import com.qa.ServiceAPI.GoogleAPIHTTPMethods;

import io.restassured.response.Response;

public class PostAddress extends BaseTest {
	
	public static final String testdata1 =  System.getProperty("user.dir")+"\\TestDataJSONFiles\\CreatPlace.json";
	public static final String testdata2 =  System.getProperty("user.dir")+"\\TestDataJSONFiles\\UpdatePlace.json";
	
	GoogleAPIHTTPMethods apimethods =  new GoogleAPIHTTPMethods();
	public static PostPlaceResopnse response1;
	
	@Test(priority=1)
	public void createPlaceTest() throws IOException {
		setTestDesc("Creating the place using post API");
		PostAdressRequest request = JSONUtils.createPOJOfomJSON(testdata1, PostAdressRequest.class);
		request.setName("Harish K R");
		Response response = apimethods.createAddress(request);
		apimethods.validateStatusCode(response, 200);
		response1 = response.as(PostPlaceResopnse.class);
		Assert.assertNotNull(response1.getPlaceId());
	}
	
	@Test(priority=2)
	public void getPlaceTest() throws IOException{
		setTestDesc("Get created place using get API");
		Response response = apimethods.getPlaceAPI(response1.getPlaceId().toString());
		apimethods.validateStatusCode(response, 200);
		PostAdressResponse response1 = response.as(PostAdressResponse.class);
		Assert.assertEquals(response1.getName().toString(), "Harish K R");
	}
	
	@Test(priority=3)
	public void updatePlaceTest() throws IOException{
		setTestDesc("Update the created place using put API");
		UpdatePlaceRequest request = JSONUtils.createPOJOfomJSON(testdata2, UpdatePlaceRequest.class);
		request.setPlaceId(response1.getPlaceId().toString());
		request.setAddress("Kodavathi");
		Response response = apimethods.updatePlaceAPI(response1.getPlaceId().toString(), request);
		apimethods.validateStatusCode(response, 200);
		Assert.assertEquals(response.jsonPath().get("msg"), "Address successfully updated");
	}
	
	@Test(priority=4)
	public void deletePlaceTest() throws IOException{
		setTestDesc("Delete the place using delete API");
		UpdatePlaceRequest request = JSONUtils.createPOJOfomJSON(testdata2, UpdatePlaceRequest.class);
		request.setPlaceId(response1.getPlaceId().toString());
		request.setAddress(null);
		request.setKey(null);
		Response response = apimethods.deletePlaceAPI(request);
		apimethods.validateStatusCode(response, 200);
		Assert.assertEquals(response.jsonPath().get("status"), "OK");
	}
	

}
