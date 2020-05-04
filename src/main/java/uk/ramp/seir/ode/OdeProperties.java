package uk.ramp.seir.ode;

public class OdeProperties {

    private final double gamma;
    private final double sigma;
    private final double beta;
    private final double nu;
    private final double mu;


    public OdeProperties(double gamma, double sigma, double beta, double mu, double nu) {
        this.gamma = gamma;
        this.sigma = sigma;
        this.beta = beta;
        this.nu = nu;
        this.mu = mu;
    }

    public double getGamma() {
        return gamma;
    }

    public double getSigma() {
        return sigma;
    }

    public double getBeta() {
        return beta;
    }

    public double getMu() {
        return mu;
    }

    public double getNu() {
        return nu;
    }

    @Override
    public String toString() {

        return String.format("OdeProperties{gamma=%.8f, sigma=%.8f, beta=%.8f, nu=%.8f, mu=%.8f}", gamma, sigma, beta, nu, mu);

    }
}
