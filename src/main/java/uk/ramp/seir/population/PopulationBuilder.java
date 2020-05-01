package uk.ramp.seir.population;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public SeirRecord build() {

        if (time == -1) {
            LOGGER.error("Nope!!");
            throw new RuntimeException();
        }

        if (population == 0) {
            LOGGER.error("Nope!!");
            throw new RuntimeException();
        }

        if (susceptible + exposed + infected + recovered > population) {
            LOGGER.error("Nope!!");
            throw new RuntimeException();
        }

        if (exposed + infected == 0d) {
            LOGGER.error("Nope!!");
            throw new RuntimeException();
        }

        susceptible = population - exposed - infected - recovered;

        return new SeirRecord(0, population, susceptible, exposed, infected, recovered);
    }

}
