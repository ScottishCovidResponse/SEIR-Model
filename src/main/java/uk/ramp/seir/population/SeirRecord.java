package uk.ramp.seir.population;


public class SeirRecord {

    private final int time;
    private final double n;
    private final double s;
    private final double e;
    private final double i;
    private final double r;


    public SeirRecord(final int time, final double n, final double s, final double e, final double i, final double r) {

        this.time = time;
        this.n = n;
        this.s = s;
        this.e = e;
        this.i = i;
        this.r = r;

    }

    public int getTime() {
        return time;
    }

    public double getN() {
        return n;
    }

    public double getS() {
        return s;
    }

    public double getE() {
        return e;
    }

    public double getI() {
        return i;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "SeirRecord{" +
                "time=" + time +
                ", n=" + n +
                ", s=" + s +
                ", e=" + e +
                ", i=" + i +
                ", r=" + r +
                '}';
    }
}
