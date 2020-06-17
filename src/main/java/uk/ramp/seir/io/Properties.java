package uk.ramp.seir.io;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;
import uk.ramp.seir.population.CompartmentRecord;

@Value.Immutable
@Gson.TypeAdapters
@JsonSerialize
@JsonDeserialize
public interface Properties {

    int t0();

    int tMax();

    CompartmentRecord compartmentRecord();

}
