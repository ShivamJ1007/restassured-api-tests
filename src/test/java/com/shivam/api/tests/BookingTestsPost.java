package com.shivam.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingTestsPost {
    
    @Test 
    public void createBooking(){
        String requestBody = """
            {
                "firstname":"Shivam",
                "lastname":"Sharma",
                "totalprice":1500,
                "depositpaid":true,
                "bookingdates":{
                    "checkin":"2026-12-01",
                    "checkout":"2026-12-05"
                    },
                "additionalneeds":"Breakfast"
                }
                """;
        int bookingId=
            given()        
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(requestBody)
            .when()
                .post("/booking")
            .then()
                .log().all()
                .statusCode(200)
                .body("booking.firstname",equalTo("Shivam"))
                .body("booking.lastname",equalTo("Sharma"))
                .body("booking.totalprice",equalTo(1500))
                .body("booking.depositpaid",equalTo(true))
                .body("booking.bookingdates.checkin",equalTo("2026-12-01"))
                .body("booking.bookingdates.checkout",equalTo("2026-12-05"))
                .body("booking.additionalneeds",equalTo("Breakfast"))
                .extract()
                .jsonPath()
                .getInt("bookingid");
        System.out.println("The Booking ID is "+ bookingId);     
        
        given()
            .baseUri("https://restful-booker.herokuapp.com")
            .pathParam("id", bookingId)
        .when()
            .get("/booking/{id}")
        .then()
            .log().all()
            .statusCode(200)
            .contentType("application/json")
            .body("firstname",equalTo("Shivam"))
            .body("lastname",equalTo("Sharma"))
            .body("totalprice",equalTo(1500))
            .body("depositpaid",equalTo(true))
            .body("bookingdates.checkin",equalTo("2026-12-01"))
            .body("bookingdates.checkout",equalTo("2026-12-05"))
            .body("additionalneeds",equalTo("Breakfast"));
    }
}