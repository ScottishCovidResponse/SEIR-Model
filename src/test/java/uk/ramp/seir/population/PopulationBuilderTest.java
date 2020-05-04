package uk.ramp.seir.population;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import uk.ramp.seir.LogAppender;
import uk.ramp.seir.exception.SeirException;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class PopulationBuilderTest {

    @Rule
    public LogAppender appender = new LogAppender(PopulationBuilder.class);

    @Test
    public void test() {
        Assert.assertTrue(true);
    }

    @Test(expected = SeirException.class)
    public void testEmptyBuilder() {

        try {
            new PopulationBuilder().build();
        } catch (SeirException e) {
            assertThat(appender.getOutput(), containsString("The initial time value must be 0 or greater"));
            throw e;
        }
    }

    @Test(expected = SeirException.class)
    public void testTimeBuilder() {

        try {
            new PopulationBuilder().setTime(0).build();
        } catch (SeirException e) {

            assertThat(appender.getOutput(), containsString("The population cannot be zero."));
            throw e;
        }
    }


    @Test(expected = SeirException.class)
    public void testInvalidStartBuilder() {

        try {
            new PopulationBuilder().setTime(0).setPopulation(10).build();
        } catch (SeirException e) {

            assertThat(appender.getOutput(), containsString("The sum of exposed and infected cannot equal zero for start conditions"));
            throw e;
        }
    }

    @Test(expected = SeirException.class)
    public void testPopulationExceededBuilder() {

        try {
            new PopulationBuilder().setTime(0).setPopulation(10).setInfected(100).build();
        } catch (SeirException e) {

            assertThat(appender.getOutput(), containsString("The sum of SEIR values must equal the population"));
            throw e;
        }
    }

    @Test
    public void testRandomPopulationsBuilder() {

        Random r = new Random();

        int time = -1;
        int n = 1000;
        for (int i = 0; i < 100; i++) {
            // will not be explicitly set in builder
            double expectedSusceptible = r.nextInt(n);

            double exposed = r.nextInt(n);
            double infected = r.nextInt(n);
            double recovered = r.nextInt(n);
            double population = exposed + infected + recovered + expectedSusceptible;

            SeirRecord s = new PopulationBuilder().setTime(0).setPopulation(population).setInfected(infected).setRecovered(recovered).setExposed(exposed).build();
            Assert.assertEquals(expectedSusceptible, s.getS(), 1e-6);

        }


    }


}