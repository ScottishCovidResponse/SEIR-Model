package uk.ramp.seir.population;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
@JsonSerialize
@JsonDeserialize
@JsonPropertyOrder({"time", "s", "e", "a", "p", "sym", "sev", "r", "d"})
public abstract class CompartmentRecord {

    public abstract int time();

    public abstract double n();

    public abstract double s();

    public abstract double e();

    @Value.Default
    public double a() {
        return 0;
    }

    @Value.Default
    public double p() {
        return 0;
    }

    @Value.Default
    public double sym() {
        return 0;
    }

    @Value.Default
    public double sev() {
        return 0;
    }

    @Value.Default
    public double r() {
        return 0;
    }

    @Value.Default
    public double d() {
        return 0;
    }
}
