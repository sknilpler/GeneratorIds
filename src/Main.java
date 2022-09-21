import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    /**
     * <b>Generating random alphanumeric strings</b>
     * <br>
     * Character range:
     * 0-Z (0-9,a-z,A-Z)
     *
     * @param targetStringLength length of string
     * @param number             number of lines string
     * @return alphanumeric strings
     */
    public static String generatingRandomAlphanumericStrings(int targetStringLength, int number) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int j = 0; j < number; j++) {
            text.append(random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString()).append("\n");
        }
        return String.valueOf(text);
    }

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("result.txt", false)) {
            System.out.println("File open!");
            writer.write(generatingRandomAlphanumericStrings(32, 200));
            writer.flush();
            System.out.println("File close!");
            System.out.println("Work done!");
        } catch (IOException ex) {
            System.out.println("Error creating file!");
            System.out.println(ex.getMessage());
        }
    }
}
