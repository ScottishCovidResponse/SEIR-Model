package uk.ramp.seir.population;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class SeirRecordTest {

    private static final double DELTA = 1e-6;

    @Test
    public void seirTest() {

        Random rand = new Random();


        int time = 0;
        double s = rand.nextDouble() * 1000;
        double e = rand.nextDouble() * 1000;
        double i = rand.nextDouble() * 1000;
        double r = rand.nextDouble() * 1000;

        double n = s + e + i + r;


        SeirRecord seirRecord = new SeirRecord(time, n, s, e, i, r);
        String exp = String.format("SeirRecord{ time=%d, n=%.8f, s=%.8f, e=%.8f, i=%.8f, r=%.8f}", time, n, s, e, i, r);

        Assert.assertEquals(exp, seirRecord.toString());
        Assert.assertEquals(n, seirRecord.getN(), DELTA);
        Assert.assertEquals(s, seirRecord.getS(), DELTA);
        Assert.assertEquals(e, seirRecord.getE(), DELTA);
        Assert.assertEquals(i, seirRecord.getI(), DELTA);
        Assert.assertEquals(r, seirRecord.getR(), DELTA);
        Assert.assertEquals(time, seirRecord.getTime());


    }


}