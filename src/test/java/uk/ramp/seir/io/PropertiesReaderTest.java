//package uk.ramp.seir.io;
//
//import org.junit.*;
//import uk.ramp.seir.LogAppender;
//import uk.ramp.seir.ode.OdeProperties;
//import uk.ramp.seir.population.CompartmentRecord;
//
//import java.io.File;
//import java.io.IOException;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class PropertiesReaderTest {
//
//    @Rule
//    public LogAppender appender = new LogAppender(PropertiesReader.class);
//
//
//    PropertiesReader pr;
//
//    OdeProperties odeExpected;
//    Properties propertiesExpected;
//    CompartmentRecord CompartmentRecord;
//
//    File odeFile = new File(PropertiesReaderTest.class.getResource("ode.json").getFile());
//    File propFile = new File(PropertiesReaderTest.class.getResource("properties.json").getFile());
//
//    @Before
//    public void setUp() {
//        pr = new PropertiesReader(odeFile, propFile);
//
//        odeExpected = new OdeProperties(0.1, 0.2, 0.3, 0.4, 0.5);
//        propertiesExpected = new Properties(100, 99, 1, 0, 0, 0, 10);
//        CompartmentRecord = new CompartmentRecord(0, 100, 99, 1, 0, 0);
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void createDefaultOde() {
//
//        String newFile = "missingODEFile.json";
//        File tempFile = new File(newFile);
//
//        if (tempFile.exists()) tempFile.delete();
//        pr = new PropertiesReader(tempFile, propFile);
//        assertThat(appender.getOutput(), containsString("The ODE file is not present at missingODEFile.json, creating a default"));
//        OdeProperties odeProps = pr.getOdeProperties();
//        Assert.assertEquals(odeExpected, odeProps);
//        tempFile.delete();
//    }
//
//    @Test
//    public void createDefaultProperties() {
//
//        String newFile = "missingPropsFile.json";
//        File tempFile = new File(newFile);
//
//        if (tempFile.exists()) tempFile.delete();
//        pr = new PropertiesReader(odeFile, tempFile);
//        assertThat(appender.getOutput(), containsString("The Properties file is not present at missingPropsFile.json, creating a default"));
//        Properties properties = pr.getProperties();
//        Assert.assertEquals(propertiesExpected, properties);
//
//        tempFile.delete();
//
//
//    }
//
//
//    @Test
//    public void readProperties() {
//        try {
//            OdeProperties var = pr.readOde();
//            Assert.assertEquals(odeExpected, var);
//
//            var = pr.getOdeProperties();
//            Assert.assertEquals(odeExpected, var);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test
//    public void getInitialPopulation() {
//        Properties p = pr.getProperties();
//
//        CompartmentRecord init = pr.getInitialPopulation();
//        Assert.assertEquals(CompartmentRecord, init);
//
//    }
//
//    @Test
//    public void getT0() {
//
//        Assert.assertEquals(0, pr.getT0());
//
//    }
//
//    @Test
//    public void gettMax() {
//        Assert.assertEquals(100, pr.gettMax());
//    }
//}