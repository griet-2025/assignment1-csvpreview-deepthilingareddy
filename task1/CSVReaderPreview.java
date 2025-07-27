package task1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String line;
        String separator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String firstLine = br.readLine();
            if (firstLine == null) {
                System.out.println("The file is empty.");
                return;
            }

            System.out.println("=== Data Preview ===\n");

            String[] headers = firstLine.split(separator);
            System.out.println("Columns:");
            for (String h : headers) {
                System.out.print(h + " ");
            }
            System.out.println("\nTotal columns: " + headers.length);
            System.out.println("\nFirst 5 Records:\n");

            int count = 0;

            while ((line = br.readLine()) != null && count < 5) {
                String[] fields = line.split(separator);
                System.out.println(String.join(" ", fields));
                count++;
            }

            while (br.readLine() != null) {
                count++;
            }

            System.out.println("\nTotal Records (excluding header): " + count);

        } catch (IOException e) {
            System.err.println("Error while reading the file:");
            e.printStackTrace();
        }
    }
}
