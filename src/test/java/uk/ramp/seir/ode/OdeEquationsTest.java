//package uk.ramp.seir.ode;
//
//import org.junit.Assert;
//import org.junit.Test;
//import uk.ramp.seir.population.CompartmentRecord;
//
//public class OdeEquationsTest {
//    private final double DELTA = 1e-6;
//    double result;
//    private final CompartmentRecord population = new CompartmentRecord(0, 100, 99, 0, 1, 0);
//    private final CompartmentRecord zeroPopulation = new CompartmentRecord(0, 1, 1, 0, 0, 0);
//    private final OdeProperties properties = new OdeProperties(0.2, 0.3, 0.2, 0, 0);
//    private final OdeProperties zeroProperties = new OdeProperties(0, 0, 0, 0, 0);
//
//    @Test
//    public void calculateDsDt() {
//
//        result = OdeEquations.calculateDsDt(zeroProperties, population);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDsDt(properties, zeroPopulation);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDsDt(properties, population);
//        Assert.assertTrue(result < 0);
//
//    }
//
//    @Test
//    public void calculateDeDt() {
//
//        result = OdeEquations.calculateDeDt(zeroProperties, population);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDeDt(properties, zeroPopulation);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDeDt(properties, population);
//        Assert.assertTrue(result > 0);
//
//    }
//
//    @Test
//    public void calculateDiDt() {
//        result = OdeEquations.calculateDiDt(zeroProperties, population);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDiDt(properties, zeroPopulation);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDiDt(properties, population);
//        Assert.assertTrue(result < 0);
//    }
//
//    @Test
//    public void calculateDrDt() {
//        result = OdeEquations.calculateDrDt(zeroProperties, population);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDrDt(properties, zeroPopulation);
//        Assert.assertEquals(0d, result, DELTA);
//
//        result = OdeEquations.calculateDrDt(properties, population);
//        Assert.assertTrue(result > 0);
//
//    }
//}