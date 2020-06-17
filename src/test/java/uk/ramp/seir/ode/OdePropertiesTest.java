//package uk.ramp.seir.ode;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Random;
//
//public class OdePropertiesTest {
//
//
//    @Test
//    public void testToString() {
//        Random r = new Random();
//        double gamma = r.nextDouble();
//        double sigma = r.nextDouble();
//        double beta = r.nextDouble();
//        double nu = r.nextDouble();
//        double mu = r.nextDouble();
//
//        OdeProperties var = new OdeBuilder().setGamma(gamma).setSigma(sigma).setBeta(beta).setMu(mu).setNu(nu).build();
//
//        String exp = String.format("OdeProperties{gamma=%.8f, sigma=%.8f, beta=%.8f, mu=%.8f, nu=%.8f}", gamma, sigma, beta, mu, nu);
//        Assert.assertEquals(exp, var.toString());
//
//    }
//}