package CSVReader;

public class CsvMain {
    public static void main(String[] args) {
        String csvFile = "O:\\Kuliah\\TUGAS KULIAH SEMESTER 2\\SDL\\Project\\Muter-muter.csv";
        String csvSplitBy = ";"; // Changed from "," to ";"

        CsvProcess csvProcessor = new CsvProcess(csvFile, csvSplitBy);
        csvProcessor.DataProses();


    }
}