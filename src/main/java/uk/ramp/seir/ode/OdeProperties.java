package uk.ramp.seir.ode;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
@JsonSerialize
@JsonDeserialize
public interface OdeProperties {

    double gamma1();

    double gamma2();

    double gamma3();

    double sigma1();

    double sigma2();

    double sigma3();

    double beta();

    double mu();

    double alpha();

}
