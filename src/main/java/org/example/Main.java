package org.example;

/**
 * A class containing the main method to demonstrate the FourBitBinaryCounter.
 * The main method iterates through clock cycles and displays the binary count and its decimal equivalent.
 */
public class Main {

    /**
     * The main method to demonstrate the FourBitBinaryCounter.
     * Prints the binary count and its decimal equivalent for every even cycle (Rising edge).
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        boolean clk = false;
        FourBitBinaryCounter fourBitBinaryCounter = new FourBitBinaryCounter();
        for (int i = 0; i < 32; i++) {
            if (i % 2 == 0) {
                System.out.print(booleanArrayToString(fourBitBinaryCounter.getCount()) + " : ");
                System.out.println(booleanArrayToDecimal(fourBitBinaryCounter.getCount()));
            }
            fourBitBinaryCounter.setInCLK(clk);
            clk = !clk;
        }
    }

    /**
     * Converts a boolean array to its string representation.
     *
     * @param array The boolean array to be converted.
     * @return The string representation of the boolean array.
     */
    public static String booleanArrayToString(boolean[] array) {
        StringBuilder result = new StringBuilder();

        for (boolean value : array) {
            result.append(value ? "1" : "0");
        }
        return result.toString();
    }

    /**
     * Converts a boolean array to its decimal equivalent.
     *
     * @param array The boolean array to be converted.
     * @return The decimal equivalent of the boolean array.
     */
    public static int booleanArrayToDecimal(boolean[] array) {
        int result = 0;
        int power = 1;

        for (boolean value : array) {
            if (value) {
                result += power;
            }
            power *= 2;
        }
        return result;
    }
}