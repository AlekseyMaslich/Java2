package task01;

import java.io.Serializable;

/**
 * The {@code CalculationData} class stores a numerical value and its
 * representations in different numeral systems (binary, octal, and hexadecimal).
 * It implements {@link Serializable} to allow object serialization.
 */
public class CalculationData implements Serializable {

    /** The decimal number to be converted. */
    private final int number;
    /** The binary representation of the number. */
    private String binary;
    /** The octal representation of the number. */
    private String octal;
    /** The hexadecimal representation of the number. */
    private String hexadecimal;

    /**
     * Constructs a {@code CalculationData} object with a given number.
     *
     * @param number The decimal number to be stored and converted.
     */
    public CalculationData(int number) {
        this.number = number;
    }

    /**
     * Returns the stored decimal number.
     *
     * @return The decimal number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the binary representation of the number.
     *
     * @param binary The binary string representation.
     */
    public void setBinary(String binary) {
        this.binary = binary;
    }

    /**
     * Sets the octal representation of the number.
     *
     * @param octal The octal string representation.
     */
    public void setOctal(String octal) {
        this.octal = octal;
    }

    /**
     * Sets the hexadecimal representation of the number.
     *
     * @param hexadecimal The hexadecimal string representation.
     */
    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    /**
     * Returns the binary representation of the number.
     *
     * @return The binary string representation.
     */
    public String getBinary() {
        return binary;
    }

    /**
     * Returns the octal representation of the number.
     *
     * @return The octal string representation.
     */
    public String getOctal() {
        return octal;
    }

    /**
     * Returns the hexadecimal representation of the number.
     *
     * @return The hexadecimal string representation.
     */
    public String getHexadecimal() {
        return hexadecimal;
    }

    /**
     * Returns a string representation of the object, displaying the number
     * and its different numeral system representations.
     *
     * @return A formatted string containing the number and its representations.
     */
    @Override
    public String toString() {
        return "Number: " + number +
                "\nBinary: " + binary +
                "\nOctal: " + octal +
                "\nHexadecimal: " + hexadecimal;
    }
}
