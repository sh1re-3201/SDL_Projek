package CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvProcess {
    private String csvFile;
    private String csvSplitBy;

    public CsvProcess(String csvFile, String csvSplitBy) {
        this.csvFile = csvFile;
        this.csvSplitBy = csvSplitBy;
    }

    public void DataProses() {
        int lineCount = countLines();
        String[][] lines = new String[lineCount][];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int index = 0;

            while ((line = br.readLine()) != null) {
                lines[index++] = line.split(csvSplitBy);
            }

        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            return; // Stop the execution of the method
        }

        selectionSort(lines);

        for (String[] sortedLine : lines) {
            if (sortedLine.length >= 3) {
                System.out.println(sortedLine[0] + "\t" + sortedLine[1] + "\t" + sortedLine[2]);
            }
        }
    }

    public void selectionSort(String[][] lines) {
        int smallest;
        String[] swap;

        for (int start = 0; start < lines.length; start++) {
            smallest = start;
            for (int next = start + 1; next < lines.length; next++) {
                if (Integer.parseInt(lines[next][0]) < Integer.parseInt(lines[smallest][0])) {
                    smallest = next;
                }
            }
            swap = lines[start];
            lines[start] = lines[smallest];
            lines[smallest] = swap;
        }
    }

    private int countLines() {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("Error counting lines in the CSV file: " + e.getMessage());
        }
        return lineCount;
    }
}