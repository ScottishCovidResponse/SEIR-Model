package uk.ramp.seir.io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class PropertiesTest {

    Properties properties;
    double n;
    double s;
    double e;
    double i;
    double r;
    int tMax;
    int t0;

    @Before
    public void setup() {
        Random random = new Random();


        n = random.nextDouble() * 1000;
        s = random.nextDouble() * 1000;
        e = random.nextDouble() * 1000;
        i = random.nextDouble() * 1000;
        r = random.nextDouble() * 1000;
        tMax = random.nextInt(1000);
        t0 = random.nextInt(tMax);

        properties = new Properties(n, s, e, i, r, t0, tMax);

    }


    @Test
    public void getT0() {
        Assert.assertEquals(t0, properties.getT0());
    }

    @Test
    public void gettMax() {
        Assert.assertEquals(tMax, properties.gettMax());
    }

    @Test
    public void testToString() {
        String expected = (String.format("Properties{super=SeirRecord{ time=%d, n=%.8f, s=%.8f, e=%.8f, i=%.8f, r=%.8f},t0=%d, tMax=%d}", t0, n, s, e, i, r, t0, tMax));
        Assert.assertEquals(expected, properties.toString());
    }

    @Test
    public void testEquals() {
        Properties p = new Properties(n, s, e, i, r, t0, 0);
        Assert.assertNotEquals(properties, p);
        Assert.assertNotEquals(properties.hashCode(), p.hashCode());
        p = new Properties(n, s, e, i, r, t0, tMax);
        Assert.assertEquals(properties, p);
        Assert.assertEquals(properties, properties);
        Assert.assertEquals(properties.hashCode(), p.hashCode());
    }


    @Test
    public void testNotEquals() {

        Assert.assertNotEquals(properties, null);
        Assert.assertNotEquals(properties, "");

        // make super.equals fail
        Properties p2 = new Properties(n, s, e, 1, r, t0, tMax);
        Assert.assertNotEquals(properties, p2);

        p2 = new Properties(n, s, e, i, r, 1, tMax);
        Assert.assertNotEquals(properties, p2);

        p2 = new Properties(n, s, e, i, r, t0, 11);
        Assert.assertNotEquals(properties, p2);

    }

}