package uk.ramp.seir.population;

import org.junit.Assert;
import org.junit.Test;

import static uk.ramp.seir.population.VirusStatus.*;


public class VirusStatusTest {

    @Test
    public void ranking() {
        Assert.assertTrue(INFECTED.getVal() > SUSCEPTIBLE.getVal());
        Assert.assertTrue(INFECTED.getVal() > EXPOSED.getVal());
        Assert.assertTrue(INFECTED.getVal() > RECOVERED.getVal());

        Assert.assertTrue(EXPOSED.getVal() > SUSCEPTIBLE.getVal());
        Assert.assertTrue(EXPOSED.getVal() > RECOVERED.getVal());

        Assert.assertTrue(RECOVERED.getVal() > SUSCEPTIBLE.getVal());

    }


}