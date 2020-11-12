package Action;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;


public class Api_Actions {

    String baseURI;
    String apiPath;
    int expectedStatusCode;
    String accessToken;
    int shelfId;


    RequestSpecBuilder requestSpecBuilder;
    RequestSpecification requestSpecification;
    ResponseSpecBuilder responseSpecBuilder;
    ResponseSpecification responseSpecification;
    Response apiResponse;

    public Api_Actions(String baseURI) {
        this.baseURI=baseURI;
        requestSpecBuilder=new RequestSpecBuilder();
        responseSpecBuilder=new ResponseSpecBuilder();
    }

    public void setExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    public Response getApiResponse() {
        return apiResponse;
    }

    private void createRequest(){
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.addPathParam("shelfId",shelfId);
        requestSpecBuilder.build();
    }

    private void executeRequest(){
        apiResponse = given().spec(requestSpecification).auth().oauth2(accessToken).get();
    }

    private void validateResponse(){
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification = responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }

    public void perform(){
        createRequest();
        executeRequest();
        validateResponse();
    }

}
