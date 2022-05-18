
package src;

import java.util.Arrays;

public class DNIT {

    private static String[] BRS = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", 
                                   "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", 
                                   "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
    
    public static String[] getBRS() {
        return Arrays.copyOf(BRS, BRS.length);
    }
    
}
