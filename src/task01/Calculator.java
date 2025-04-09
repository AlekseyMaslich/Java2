package task01;

import java.io.*;

/**
 * The {@code Calculator} class provides functionality to perform calculations
 * and convert a given number into various numeral system representations
 * (binary, octal, and hexadecimal). It also supports saving and restoring
 * the calculation data from a file.
 */
public class Calculator {

    /** The name of the file used to store serialized calculation data. */
    private static final String FILE_NAME = "data.ser";

    /** The calculation data object storing the number and its numeral representations. */
    private CalculationData data;

    /**
     * Constructs a {@code Calculator} object with the given calculation data.
     *
     * @param data The {@link CalculationData} object containing the number to be processed.
     */
    public Calculator(CalculationData data) {
        this.data = data;
    }

    /**
     * Performs the conversion of the stored number into binary, octal,
     * and hexadecimal representations and stores the results.
     */
    public void calculate() {
        int number = data.getNumber();
        data.setBinary(Integer.toBinaryString(number));
        data.setOctal(Integer.toOctalString(number));
        data.setHexadecimal(Integer.toHexString(number).toUpperCase());
    }

    /**
     * Returns the {@link CalculationData} object containing the number and its conversions.
     *
     * @return The calculation data with numeral system representations.
     */
    public CalculationData getResult() {
        return data;
    }

    /**
     * Saves the calculation data to a file using serialization.
     *
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(data);
        }
    }

    /**
     * Restores the calculation data from a file using deserialization.
     *
     * @throws IOException If an I/O error occurs while reading the file.
     * @throws ClassNotFoundException If the class definition of the serialized object is not found.
     */
    public void restore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            this.data = (CalculationData) in.readObject();
        }
    }

    /**
     * Displays the stored calculation data in the console.
     */
    public void showData() {
        System.out.println(data);
    }
}
