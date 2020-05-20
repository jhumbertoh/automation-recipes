package com.jhurtado.automationrecipes.geolocation;

import com.jhurtado.automationrecipes.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

public class LocationTest extends BaseTest {

    @Test
    public void goShoppingInAustin(){

        Map coordinates = Map.of(
                "latitude",30.3076863,
                "longitude",-97.8934846,
                "accuracy",1
        );

        driver.executeCdpCommand("Emulation.setGeolocationOverride",
                coordinates);

        driver.navigate().to("https://oldnavy.gap.com/stores");

        var addresses = driver.findElementsByClassName("address");
         assertTrue(addresses.size() >0, "No addresses found");
         assertTrue(addresses.
                 stream()
                 .allMatch(a -> a.getText().contains(", TX ")),
                 "Some addresses listed are not in Texas");
    }

}
