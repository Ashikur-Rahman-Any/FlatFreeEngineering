import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilename = "src/main/java/input.txt";
        String outputFilename = "output.txt";

        File inputFile = new File(inputFilename);
        File outputFile = new File(outputFilename);

        Scanner scanner = new Scanner(inputFile);
        FileWriter fileWriter = new FileWriter(outputFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] dimensions = line.split(" ");

            // Validate dimensions:
            if (dimensions.length != 3) {
                throw new IllegalArgumentException("Invalid line format: expect 3 numbers");
            }

            // Parse dimensions and calculate:
            double width = Double.parseDouble(dimensions[0]);
            double height = Double.parseDouble(dimensions[1]);
            double length = Double.parseDouble(dimensions[2]);

            double surfaceArea = 2 * (width * height + height * length + length * width);
            double volume = width * height * length;

            // Use FileWriter to write to the file
            fileWriter.write(surfaceArea + " " + volume + "\n");
        }

        // Close resources
        scanner.close();
        fileWriter.close();
    }
}
