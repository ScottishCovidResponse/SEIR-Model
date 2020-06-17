package uk.ramp.seir.population;

public class InvalidStatusTransitionException extends RuntimeException {


    public InvalidStatusTransitionException(String message) {
        super(message);
    }
}
