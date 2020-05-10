package com.jhurtado.automationrecipes.apis;

import com.jhurtado.automationrecipes.models.Location;
import com.jhurtado.automationrecipes.models.Places;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipcodeTests {

    @Test
    public void testBeverlyHills(){

        var la = new Location(
             "90210",
             "United States",
             "US",
             List.of(new Places(
                     "Beverly Hills",
                     "-118.4065",
                     "California",
                     "CA",
                     "34.0901"
             ))
        );

        var expectedLocation = given()
                .get("http://api.zippopotam.us/us/90210")
                .as(Location.class);


        assertEquals(la,expectedLocation);

        //System.out.println(location);


          //response.prettyPrint();

    }
}
