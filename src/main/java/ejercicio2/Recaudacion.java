package ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recaudacion {
    public static final String PERMALINK = "permalink";
    public static final String COMPANY_NAME = "company_name";
    public static final String NUMBER_EMPLOYEES = "number_employees";
    public static final String CATEGORY = "category";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String FUNDED_DATE = "funded_date";
    public static final String RAISED_AMOUNT = "raised_amount";
    public static final String RAISED_CURRENCY = "raised_currency";
    public static final String ROUND = "round";
    public static final int INDICE_PERMALINK = 0;
    public static final int INDICE_COMPANY_NAME = 1;
    public static final int INDICE_NUMBER_EMPLOYEES = 2;
    public static final int INDICE_CATEGORY = 3;
    public static final int INDICE_CITY = 4;
    public static final int INDICE_STATE = 5;
    public static final int INDICE_FUNDED_DATE = 6;
    public static final int INDICE_RAISED_AMOUNT = 7;
    public static final int INDICE_RAISED_CURRENCY = 8;
    public static final int INDICE_ROUND = 9;
    private List<String[]> csvData;
    private Map<String, String> options;
    private final Map<String, Integer> mapNombreIndice;

    public Recaudacion(FuenteDeDatos fuenteDeDatos){
        this.csvData = fuenteDeDatos.toList();
        this.mapNombreIndice = Map.of(
                PERMALINK, INDICE_PERMALINK,
                COMPANY_NAME, INDICE_COMPANY_NAME,
                NUMBER_EMPLOYEES, INDICE_NUMBER_EMPLOYEES,
                CATEGORY, INDICE_CATEGORY,
                CITY, INDICE_CITY,
                STATE, INDICE_STATE,
                FUNDED_DATE, INDICE_FUNDED_DATE,
                RAISED_AMOUNT, INDICE_RAISED_AMOUNT,
                RAISED_CURRENCY, INDICE_RAISED_CURRENCY,
                ROUND, INDICE_ROUND);
    }

    public List<Map<String, String>> where(Map<String, String> filtrosDeBusqueda) throws IOException {

        inizializarFiltros(filtrosDeBusqueda);
        filtrarPor(COMPANY_NAME);
        filtrarPor(CITY);
        filtrarPor(STATE);
        filtrarPor(ROUND);
        return crearResultadoFiltrado();
    }

    private void inizializarFiltros(Map<String, String> options) {
        this.options = options;
    }

    private List<Map<String, String>> crearResultadoFiltrado() {
        List<Map<String, String>> output = new ArrayList<>();

        for (String[] csvDatum : csvData) {
            Map<String, String> mapped = new HashMap<>();
            mapped.put(PERMALINK, csvDatum[INDICE_PERMALINK]);
            mapped.put(COMPANY_NAME, csvDatum[INDICE_COMPANY_NAME]);
            mapped.put(NUMBER_EMPLOYEES, csvDatum[INDICE_NUMBER_EMPLOYEES]);
            mapped.put(CATEGORY, csvDatum[INDICE_CATEGORY]);
            mapped.put(CITY, csvDatum[INDICE_CITY]);
            mapped.put(STATE, csvDatum[INDICE_STATE]);
            mapped.put(FUNDED_DATE, csvDatum[INDICE_FUNDED_DATE]);
            mapped.put(RAISED_AMOUNT, csvDatum[INDICE_RAISED_AMOUNT]);
            mapped.put(RAISED_CURRENCY, csvDatum[INDICE_RAISED_CURRENCY]);
            mapped.put(ROUND, csvDatum[INDICE_ROUND]);
            output.add(mapped);
        }
        return output;
    }

    private void filtrarPor(String nombreColumna) {
        if (options.containsKey(nombreColumna)) {
            csvData = csvData.stream()
                    .filter(csvDatum ->
                            csvDatum[this.mapNombreIndice.get(nombreColumna)].equals(options.get(nombreColumna)))
                    .collect(Collectors.toList());
        }
    }
}
