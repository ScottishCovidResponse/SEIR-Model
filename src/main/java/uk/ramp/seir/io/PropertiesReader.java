package uk.ramp.seir.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ramp.seir.ode.ImmutableOdeProperties;
import uk.ramp.seir.ode.OdeProperties;
import uk.ramp.seir.population.CompartmentRecord;
import uk.ramp.seir.population.ImmutableCompartmentRecord;
import uk.ramp.seir.population.PopulationBuilder;

import java.io.*;
import java.util.ServiceLoader;


public class PropertiesReader {
    private static final Logger LOGGER = LogManager.getLogger(PropertiesReader.class);
    private final File ode;
    private final File prop;

    private OdeProperties odeProperties;
    private Properties properties;

    public PropertiesReader(String ode, String prop) {
        this.ode = new File(ode);
        this.prop = new File(prop);
        read();
    }

    public PropertiesReader(File ode, File prop) {
        this.prop = prop;
        this.ode = ode;
        read();
    }

    public void createDefaultOde() throws IOException {

        OdeProperties wrapper = ImmutableOdeProperties.builder().alpha(0.1).beta(0.1).gamma1(0.1).gamma2(0.1).gamma3(0.1).mu(0.1).sigma1(0.1).sigma2(0.1).build();

        try (Writer w = new FileWriter(ode)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(wrapper, w);
        }
    }

    private void read() {

        try {
            if (!ode.exists()) {
                LOGGER.error("The ODE file is not present at {}, creating a default", ode);
                createDefaultOde();
            }

            if (!prop.exists()) {
                LOGGER.error("The Properties file is not present at {}, creating a default", prop);
                createDefaultProperties();
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }

        try {
            odeProperties = readOde();
            properties = readProperties();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public void createDefaultProperties() throws IOException {

        CompartmentRecord record = ImmutableCompartmentRecord.builder().
                n(100).s(99).e(1).build();


        Properties wrapper = ImmutableProperties.builder().compartmentRecord(record).t0(0).tMax(10).build();
//        Properties wrapper = new Properties(100, 99, 1, 0, 0, 0, 10);

        try (Writer w = new FileWriter(prop)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(wrapper, w);
        }
    }

    public OdeProperties readOde() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader fileReader = new FileReader(ode)) {
            return gson.fromJson(fileReader, ImmutableOdeProperties.class);
        }
    }

    public Properties readProperties() throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        ServiceLoader.load(TypeAdapterFactory.class).forEach(gsonBuilder::registerTypeAdapterFactory);
        try (Reader fileReader = new FileReader(prop)) {
            return gsonBuilder.setPrettyPrinting().create().fromJson(fileReader, Properties.class);
        }
    }


    public OdeProperties getOdeProperties() {
        return ImmutableOdeProperties.builder().from(odeProperties).build();
    }

    public CompartmentRecord getInitialPopulation() {

        return new PopulationBuilder().setTime(properties.t0()).setPopulation(properties.compartmentRecord().n()).setExposed(properties.compartmentRecord().e()).setInfected(properties.compartmentRecord().a()).setRecovered(properties.compartmentRecord().r()).build();
    }

    public int getT0() {
        return properties.t0();

    }

    public int gettMax() {
        return properties.tMax();

    }

    public Properties getProperties() {
        return properties;
    }
}
