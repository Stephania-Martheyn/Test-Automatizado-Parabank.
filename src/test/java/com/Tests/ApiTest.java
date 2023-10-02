package com.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {

    @Test
    public void validateStatusCode200ForRegisterUrl() {
        RestAssured.baseURI = "https://parabank.parasoft.com";

        Response response = given()
                .when()
                .get("/parabank/register.htm")
                .then()
                .extract().response();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testCreateAccount() throws Exception {
        given().
                contentType(ContentType.JSON).with().
                queryParam("customerId", "12656").and().
                queryParam("newAccountType", "1").and().
                queryParam("fromAccountId", "14898").
                when().
                post("https://parabank.parasoft.com/parabank/services/bank/createAccount").
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void testAccountOverview() throws Exception {
        given().
                contentType(ContentType.JSON).
                pathParams("accountId", "13677").
                pathParams("month", "All").
                pathParams("type", "All").
                auth().basic("CarlosJulio777777", "12345").
                when().
                post("https://parabank.parasoft.com/parabank/services/bank/accounts/{accountId}/transactions/month/{month}/type/{type}").
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void testTransferFunds() throws Exception {
        given()
                .contentType(ContentType.JSON).with().
                queryParam("fromAccountId", "13677").
                queryParam("toAccountId", "14898").
                queryParam("amount", "100").
                when().
                post("https://parabank.parasoft.com/parabank/services/bank/transfer").
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void testAccountActivity() throws Exception {
        given().
                get("https://parabank.parasoft.com/parabank/services/bank/accounts/13677/transactions/month/All/type/All").
                then().
                assertThat().statusCode(200);
    }



}




