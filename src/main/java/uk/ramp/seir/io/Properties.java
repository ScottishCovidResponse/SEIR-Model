package uk.ramp.seir.io;

import uk.ramp.seir.population.SeirRecord;

public class Properties extends SeirRecord {

    private final int t0;
    private final int tMax;


    public Properties(double n, double s, double e, double i, double r, int t0, int tMax) {

        super(t0, n, s, e, i, r);
        this.t0 = t0;
        this.tMax = tMax;
    }

    public int getT0() {
        return t0;
    }

    public int gettMax() {
        return tMax;
    }


    @Override
    public String toString() {
        return "Properties{" +
                "t0=" + t0 +
                ", tMax=" + tMax +
                '}';
    }
}
