//package uk.ramp.seir.io;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import uk.ramp.seir.population.CompartmentRecord;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//public class OutputTest {
//    Map<Integer, CompartmentRecord> records;
//    String fileName = "test.csv";
//
//    @Before
//    public void setUp() throws Exception {
//
//        records = new HashMap<>();
//        Random rand = new Random();
//
//        for (int time = 0; time < 5; time++) {
//            double s = rand.nextDouble() * 1000;
//            double e = rand.nextDouble() * 1000;
//            double i = rand.nextDouble() * 1000;
//            double r = rand.nextDouble() * 1000;
//
//            double n = s + e + i + r;
//            records.put(time, new CompartmentRecord(time, n, s, e, i, r));
//        }
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//        File f = new File(fileName);
//        if (f.exists()) {
//            f.deleteOnExit();
//        }
//    }
//
//    @Test
//    public void printSeirCSV() throws IOException {
//
//        Output.printSeirCSV(records, fileName);
//        Map<Integer, CompartmentRecord> inputRecs = readCSVBack();
//
//        for (int i : records.keySet()) {
//
//            CompartmentRecord s1 = records.get(i);
//            CompartmentRecord s2 = inputRecs.get(i);
//            Assert.assertEquals(s1, s2);
//
//        }
//    }
//
//
//    private Map<Integer, CompartmentRecord> readCSVBack() throws IOException {
//
//        Map<Integer, CompartmentRecord> input = new HashMap<>();
//
//        Iterable<CSVRecord> records;
//        File file = new File(fileName);
//        Reader in = new FileReader(file);
//        records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
//
////        /String[] headers = {"Day", "S", "E", "I", "R"};
//
//        for (CSVRecord record : records) {
//            int t = Integer.parseInt(record.get("Day"));
//            double s = Double.parseDouble(record.get("S"));
//            double e = Double.parseDouble(record.get("E"));
//            double i = Double.parseDouble(record.get("I"));
//            double r = Double.parseDouble(record.get("R"));
//            double n = s + e + i + r;
//            input.put(t, new CompartmentRecord(t, n, s, e, i, r));
//        }
//
//        return input;
//
//    }
//
//}