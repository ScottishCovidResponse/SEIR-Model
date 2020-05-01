package uk.ramp.seir.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ramp.seir.ode.OdeBuilder;
import uk.ramp.seir.ode.OdeProperties;
import uk.ramp.seir.population.PopulationBuilder;
import uk.ramp.seir.population.SeirRecord;

import java.io.*;

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

        OdeProperties wrapper = new OdeProperties(0.2, 0.5, 0.9, 0, 0);

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
            odeProperties = readOde(ode);
            properties = readProperties(prop);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public void createDefaultProperties() throws IOException {

        Properties wrapper = new Properties(100, 99, 1, 0, 0, 0, 10);

        try (Writer w = new FileWriter(prop)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(wrapper, w);
        }
    }

    public OdeProperties readOde(File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, OdeProperties.class);
        }
    }

    public Properties readProperties(File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Reader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Properties.class);
        }
    }


    public OdeProperties getOdeProperties() {
        return new OdeBuilder().setBeta(odeProperties.getBeta()).setGamma(odeProperties.getGamma()).setSigma(odeProperties.getSigma()).setMu(odeProperties.getMu()).setNu(odeProperties.getNu()).build();
    }

    public SeirRecord getInitialPopulation() {
        return new PopulationBuilder().setTime(properties.getT0()).setPopulation(properties.getN()).setExposed(properties.getE()).setInfected(properties.getI()).setRecovered(properties.getR()).build();
    }

    public int getT0() {
        return properties.getT0();

    }

    public int gettMax() {
        return properties.gettMax();

    }
}
