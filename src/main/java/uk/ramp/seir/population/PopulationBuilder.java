package uk.ramp.seir.population;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.ramp.seir.exception.SeirException;

public class PopulationBuilder {
    private static final Logger LOGGER = LogManager.getLogger(PopulationBuilder.class);
    private int time = -1;
    private double population;
    private double susceptible;
    private double exposed;
    private double infected;
    private double recovered;


    public PopulationBuilder setTime(int time) {
        this.time = time;
        return this;
    }

    public PopulationBuilder setPopulation(double population) {
        this.population = population;
        return this;
    }

    public PopulationBuilder setExposed(double exposed) {
        this.exposed = exposed;
        return this;
    }

    public PopulationBuilder setInfected(double infected) {
        this.infected = infected;
        return this;
    }

    public PopulationBuilder setRecovered(double recovered) {
        this.recovered = recovered;
        return this;
    }

    public CompartmentRecord build() {

        if (time == -1) {
            String message = "The initial time value must be 0 or greater.";
            LOGGER.error(message);
            throw new SeirException(message);
        }

        if (population == 0) {
            String message = "The population cannot be zero.";
            LOGGER.error(message);
            throw new SeirException(message);
        }

        if (susceptible + exposed + infected + recovered > population) {
            String message = "The sum of SEIR values must equal the population.";
            LOGGER.error(message);
            throw new SeirException(message);
        }

        if (exposed + infected == 0d) {
            String message = "The sum of exposed and infected cannot equal zero for start conditions.";
            LOGGER.error(message);
            throw new SeirException(message);
        }

        susceptible = population - exposed - infected - recovered;

        return ImmutableCompartmentRecord.builder().time(0).n(population).s(susceptible).e(exposed).build();
    }

}
