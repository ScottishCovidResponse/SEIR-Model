package uk.ramp.seir.io;

public class Properties {

    private final double n;
    private final double s;
    private final double e;
    private final double i;
    private final double r;
    private final int t0;
    private final int tMax;


    public Properties(double n, double s, double e, double i, double r, int t0, int tMax) {
        this.n = n;
        this.s = s;
        this.e = e;
        this.i = i;
        this.r = r;
        this.t0 = t0;
        this.tMax = tMax;
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

    public int getT0() {
        return t0;
    }

    public int gettMax() {
        return tMax;
    }


    @Override
    public String toString() {
        return "Properties{" +
                "n=" + n +
                ", s=" + s +
                ", e=" + e +
                ", i=" + i +
                ", r=" + r +
                ", t0=" + t0 +
                ", tMax=" + tMax +
                '}';
    }
}
