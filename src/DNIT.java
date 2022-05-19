
package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DNIT {

    private static final String[] BRS = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", 
                                         "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", 
                                         "RO", "RR", "RS", "SC", "SE", "SP", "TO"};

    private static final Map<String, Integer> MapLoteBR = new HashMap<>();

    static {
        MapLoteBR.put("AC", 1); MapLoteBR.put("AM", 1); MapLoteBR.put("AP", 1); MapLoteBR.put("DF", 1); MapLoteBR.put("GO", 1); MapLoteBR.put("MS", 1); MapLoteBR.put("MT", 1); MapLoteBR.put("PA", 1); MapLoteBR.put("RO", 1); MapLoteBR.put("RR", 1); MapLoteBR.put("TO", 1);
        MapLoteBR.put("AL", 2); MapLoteBR.put("BA", 2); MapLoteBR.put("CE", 2); MapLoteBR.put("MA", 2); MapLoteBR.put("PB", 2); MapLoteBR.put("PE", 2); MapLoteBR.put("PI", 2); MapLoteBR.put("RN", 2); MapLoteBR.put("SE", 2);
        MapLoteBR.put("ES", 3); MapLoteBR.put("MG", 3); MapLoteBR.put("PR", 3); MapLoteBR.put("RJ", 3); MapLoteBR.put("RS", 3); MapLoteBR.put("SC", 3); MapLoteBR.put("SP", 3);
    }
    

    public static String[] getBRS() {
        return Arrays.copyOf(BRS, BRS.length);
    }


    public static Map<String, Integer> getLoteBR() {
        return Collections.unmodifiableMap(MapLoteBR);
    }
    
}
