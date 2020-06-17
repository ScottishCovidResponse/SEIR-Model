package uk.ramp.seir.io;

import uk.ramp.seir.population.CompartmentRecord;
import uk.ramp.seir.population.ImmutableCompartmentRecord;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

public class CompartmentWriter {
    public void write(Writer writer, List<CompartmentRecord> records) throws IOException {
        List<ImmutableCompartmentRecord> wrappedImmutableRecords = records.stream()
                .map(r -> ImmutableCompartmentRecord.builder().from(r).build())
                .collect(Collectors.toList());
        new CsvWriter().write(writer, wrappedImmutableRecords, ImmutableCompartmentRecord.class);
    }
}
