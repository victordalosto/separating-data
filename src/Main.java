
package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) throws Exception {

        // Initial configs
        IOUtils.setByteArrayMaxOverride(1000000000); // File handled is too large
        String[] BRS = DNIT.getBRS(); // Gets all BRs name (Sheet files names to be created)
        int totalPontos = 0;

        // Iterate over Sheet files
        for (String BR : BRS) {

            // Main files to be handled
            Path mainSheet = Paths.get("lib\\FWD.xlsx");
            Path pathSheet = Paths.get("target\\" + BR + ".xlsx");

            // Create a new File
            Files.copy(mainSheet, pathSheet, StandardCopyOption.REPLACE_EXISTING);

            // Open the sheet to be handled
            XSSFWorkbook planilha = new XSSFWorkbook(new FileInputStream(pathSheet.toFile()));
            XSSFSheet abaPlanilha = planilha.getSheetAt(0);

            // Some initial parameters
            int qtdPontos = 0;

            // Iterate over the entire Sheet
            Iterator<Row> rowItr = abaPlanilha.iterator();
            Row row;
            row = rowItr.next();
            row = rowItr.next();

            // List to remove lines
            List<Row> toRemove = new ArrayList<>();

            // Loop that iterate over the sheet rows
            while (rowItr.hasNext()) {
                row = rowItr.next();
                // Check if row belongs to current sheet file
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(BR)) {
                    qtdPontos++;
                } else {
                    toRemove.add(row);
                }
                // System.out.println(row.getCell(0) + " " + BR + " " + (row.getCell(0).getStringCellValue().equalsIgnoreCase(BR)));
            }

            // Another Loop to remove selected sheet rows that doesn't belong to the current BR
            toRemove.forEach(rowCell -> abaPlanilha.removeRow(rowCell));

            // Stores the modifications in created Sheet
            planilha.write(new FileOutputStream(pathSheet.toFile()));
            planilha.close();

            // Print to confirm the data Output
            totalPontos += qtdPontos;
            System.out.println(BR + " = " + qtdPontos + ". Acumulado: " + totalPontos);
        }

    }
}
