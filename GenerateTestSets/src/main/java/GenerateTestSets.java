import java.io.*;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;

public class GenerateTestSets {

    public static void main(String[] args) throws IOException {
        File excelFile = new File(GenerateTestSets.class.getClassLoader().getResource("StaffMembers.xlsx").getFile());
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIt = sheet.iterator();
        //skip title line
        Row row = rowIt.next();
        String[][] allRows = new String[1031][2];
        int i=0;
        while (rowIt.hasNext()) {
            row = rowIt.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            allRows[i][0] = cell.toString();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                //System.out.println(cell.toString() + ";");
            }
            allRows[i][1] = cell.toString();
//
            i++;
        }

        String results[] = new String[90];
        generateResultsArray(allRows, results, 30);
        writeToFile(results, "staff30_projects90.txt");

        results = new String[180];
        generateResultsArray(allRows, results, 60);
        writeToFile(results, "staff60_projects180.txt");

        results = new String[360];
        generateResultsArray(allRows, results, 120);
        writeToFile(results, "staff120_projects360.txt");

        results = new String[750];
        generateResultsArray(allRows, results, 250);
        writeToFile(results, "staff250_projects750.txt");

        workbook.close();
        fis.close();
    }

    public static void generateResultsArray(String[][] supervisors, String[] results, int numberOfSupervisors){
        Random random = new Random();
        //List used to make sure supervisors aren't used twice
        ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();;

        for(int i = 0; i<numberOfSupervisors;i++){
            int randomInt = random.nextInt(1031);
            //Check if supervisor has already been used
            while(alreadyUsed.contains(randomInt)){
                randomInt = random.nextInt(1031);
            }
            alreadyUsed.add(randomInt);
            //Create 3 results
            for (int j=0;j<3;j++){
                int index = 3*i +j;
                results[index] = supervisors[randomInt][0] + "," + index +",";
                if (supervisors[i][1].equals("Dagon Studies")){
                    results[index] += "DS\n";
                }else{
                    results[index] += (random.nextInt(3) != 0)?"CS\n":"CS+DS\n";
                }
            }

        }
    }

    private static void writeToFile(String data[], String filename) {
        File file = new File(filename);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            for(int i=0;i<data.length;i++){
                fr.write(data[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
