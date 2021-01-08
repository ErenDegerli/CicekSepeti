package com.ciceksepeti.core.client;

import com.ciceksepeti.core.config.ConfigParser;
import com.ciceksepeti.domains.response.ResponseObject;
import com.ciceksepeti.utils.SpecificationFactory;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestClient {

    public RestClient() {
        RestAssured.baseURI = ConfigParser.getValue("BaseUrl");
    }

    public Response get(String endpoint) {
        return given().urlEncodingEnabled(false).when().get(endpoint);
    }

    public ResponseObject getProductsAsJavaObject(String endpoint) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.
                readValue(given().spec(SpecificationFactory.log_Response_To_Allure()).when().get(endpoint).getBody().asString(),
                        ResponseObject.class);
    }
}
