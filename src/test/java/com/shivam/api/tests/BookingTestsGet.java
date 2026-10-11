package com.shivam.api.tests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class BookingTestsGet {
    
    @Test 
    public void getBookings(){
        int bookingId=
            given()        
                .baseUri("https://restful-booker.herokuapp.com")
            .when()
                .get("/booking")
            .then()
                .log().all()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .jsonPath()
                .getInt("[0].bookingid");
        System.out.println("First Booking ID is "+ bookingId);

        given()
            .baseUri("https://restful-booker.herokuapp.com")
            .pathParam("id",bookingId)
        .when()
            .get("/booking/{id}")
        .then()
            .log().all()
            .statusCode(200)
            .contentType("application/json")
            .body("firstname",notNullValue())
            .body("lastname",notNullValue())
            .body("totalprice",notNullValue())
            .body("bookingdates.checkin",notNullValue())
            .body("bookingdates.checkout",notNullValue());
    }
}