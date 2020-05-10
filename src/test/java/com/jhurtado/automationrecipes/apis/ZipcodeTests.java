package com.jhurtado.automationrecipes.apis;

import com.jhurtado.automationrecipes.models.Location;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ZipcodeTests {

    @Test
    public void testBeverlyHills(){

        var la = new Location();


        var location = given()
                .get("http://api.zippopotam.us/us/90210")
                .as(Location.class);


        System.out.println(location.getCountry());

        //response.prettyPrint();

    }
}
