//package uk.ramp.seir.ode;
//
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import uk.ramp.seir.LogAppender;
//import uk.ramp.seir.exception.SeirException;
//
//import java.util.Random;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.containsString;
//
//public class OdeBuilderTest {
//
//    private static final double DELTA = 1e-6;
//    @Rule
//    public LogAppender appender = new LogAppender(OdeBuilder.class);
//
//    @Test(expected = SeirException.class)
//    public void emptyBuilder() {
//        try {
//            new OdeBuilder().build();
//        } catch (Exception e) {
//            assertThat(appender.getOutput(), containsString("The value for gamma cannot be zero"));
//            throw e;
//        }
//    }
//
//    @Test(expected = SeirException.class)
//    public void gammaBuilder() {
//        try {
//            new OdeBuilder().setGamma(0.1).build();
//        } catch (Exception e) {
//            assertThat(appender.getOutput(), containsString("The value for sigma cannot be zero"));
//            throw e;
//        }
//    }
//
//
//    @Test(expected = SeirException.class)
//    public void gammaSigmaBuilder() {
//        try {
//            new OdeBuilder().setGamma(0.1).setSigma(0.1).build();
//        } catch (Exception e) {
//            assertThat(appender.getOutput(), containsString("The value for beta cannot be zero"));
//            throw e;
//        }
//    }
//
//    @Test
//    public void minimalBuilder() {
//        Random r = new Random();
//        double gamma = r.nextDouble();
//        double sigma = r.nextDouble();
//        double beta = r.nextDouble();
//
//        OdeProperties var = new OdeBuilder().setGamma(gamma).setSigma(sigma).setBeta(beta).build();
//        Assert.assertEquals(gamma, var.getGamma(), DELTA);
//        Assert.assertEquals(sigma, var.getSigma(), DELTA);
//        Assert.assertEquals(beta, var.getBeta(), DELTA);
//        Assert.assertEquals(0, var.getMu(), DELTA);
//        Assert.assertEquals(0, var.getNu(), DELTA);
//    }
//
//
//    @Test
//    public void fullBuilder() {
//        Random r = new Random();
//        double gamma = r.nextDouble();
//        double sigma = r.nextDouble();
//        double beta = r.nextDouble();
//        double nu = r.nextDouble();
//        double mu = r.nextDouble();
//
//        OdeProperties var = new OdeBuilder().setGamma(gamma).setSigma(sigma).setBeta(beta).setMu(mu).setNu(nu).build();
//        Assert.assertEquals(gamma, var.getGamma(), DELTA);
//        Assert.assertEquals(sigma, var.getSigma(), DELTA);
//        Assert.assertEquals(beta, var.getBeta(), DELTA);
//        Assert.assertEquals(mu, var.getMu(), DELTA);
//        Assert.assertEquals(nu, var.getNu(), DELTA);
//    }
//
//
//}