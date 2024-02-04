import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * @author YOUR NAME 
 *
 */
import java.io.*;

public class FileIOMethods {

    public static void writeLargeIntegerArray(LargeInteger[] array, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (LargeInteger num : array) {
                oos.writeObject(num);
            }
        }
    }

    public static LargeInteger[] readLargeIntegerArray(String fileName) throws IOException {
        ArrayList<LargeInteger> list = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    LargeInteger num = (LargeInteger) ois.readObject();
                    list.add(num);
                } catch (EOFException e) {
                    break; // End of file reached
                } catch (ClassNotFoundException e) {
                    throw new IOException("Error reading LargeInteger array from file", e);
                }
            }
        }

        return list.toArray(new LargeInteger[0]);
    }

    public static LargeInteger addLargeIntegersFromFile(String fileName) throws IOException {
        LargeInteger totalSum = new LargeInteger();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    LargeInteger num = new LargeInteger(line);
                    totalSum = totalSum.add(num);
                } catch (LargeIntegerNumberFormatException | LargeIntegerOverflowException ignored) {
                    // Ignore and skip the corrupted data
                }
            }
        }

        return totalSum;
    }
}