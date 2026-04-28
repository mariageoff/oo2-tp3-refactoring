package ejercicio2;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecaudacionTest {

    public static final String CSV_PATH = "src/main/resources/data.csv";

    @Test
    public void testWhereGivenCompany() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        assertEquals(7, r1.where(options).size());
    }

    @Test
    public void testWhereGivenCity() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("city", "Tempe");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        assertEquals(3, r1.where(options).size());
    }

    @Test
    public void testWhereGivenState() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("state", "CA");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        assertEquals(873, r1.where(options).size());
    }

    @Test
    public void testWhereGivenRound() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        assertEquals(582, r1.where(options).size());
    }

    @Test
    public void testMultipleOptions() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        options.put("company_name", "Facebook");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        assertEquals(1, r1.where(options).size());
    }

    @Test
    public void testWhereNotExists() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "NotFacebook");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        assertEquals(0, r1.where(options).size());
    }

    @Test
    public void testWhereCorrectKeys() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        var r1 = new Recaudacion(new LectorCSV(CSV_PATH));
        Map<String, String> row = r1.where(options).getFirst();

        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("450", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Sep-04", row.get("funded_date"));
        assertEquals("500000", row.get("raised_amount"));
        assertEquals("angel", row.get("round"));

    }
}
