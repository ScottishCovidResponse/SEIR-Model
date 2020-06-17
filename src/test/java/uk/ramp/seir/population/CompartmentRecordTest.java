package uk.ramp.seir.population;

import org.junit.Test;

import java.util.Random;

public class CompartmentRecordTest {

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


//        CompartmentRecord CompartmentRecord = new CompartmentRecord(time, n, s, e, i, r);
//        String exp = String.format("CompartmentRecord{ time=%d, n=%.8f, s=%.8f, e=%.8f, i=%.8f, r=%.8f}", time, n, s, e, i, r);
//
//        Assert.assertEquals(exp, CompartmentRecord.toString());
//        Assert.assertEquals(n, CompartmentRecord.getN(), DELTA);
//        Assert.assertEquals(s, CompartmentRecord.getS(), DELTA);
//        Assert.assertEquals(e, CompartmentRecord.getE(), DELTA);
//        Assert.assertEquals(i, CompartmentRecord.getI(), DELTA);
//        Assert.assertEquals(r, CompartmentRecord.getR(), DELTA);
//        Assert.assertEquals(time, CompartmentRecord.getTime());


    }


}