package task01.test;

import org.junit.jupiter.api.Test;
import task01.CalculationData;
import task01.Calculator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@code TestMain} class contains unit tests for the {@link Calculator} class.
 * It verifies the correctness of calculations and serialization/deserialization processes.
 */
public class TestMain {

    /**
     * Tests the calculation functionality of the {@link Calculator} class.
     * It checks whether the binary, octal, and hexadecimal representations of the given number are correctly computed.
     */
    @Test
    public void testCalculatorFunctionality() {
        CalculationData data = new CalculationData(30);
        Calculator calculator = new Calculator(data);
        calculator.calculate();

        assertEquals("11110", data.getBinary());
        assertEquals("36", data.getOctal());
        assertEquals("1E", data.getHexadecimal());
    }

    /**
     * Tests the serialization and deserialization functionality of the {@link Calculator} class.
     * It ensures that the data remains consistent after saving and restoring the object.
     *
     * @throws Exception if an error occurs during serialization or deserialization.
     */
    @Test
    public void testSerializationDeserialization() throws Exception {
        CalculationData originalData = new CalculationData(30);
        Calculator calculator = new Calculator(originalData);
        calculator.calculate();

        String fileName = "test_data.ser";
        calculator.save();

        calculator.restore();
        CalculationData restoredData = calculator.getResult();

        assertNotNull(restoredData);
        assertEquals(originalData.getNumber(), restoredData.getNumber());
        assertEquals(originalData.getBinary(), restoredData.getBinary());
        assertEquals(originalData.getOctal(), restoredData.getOctal());
        assertEquals(originalData.getHexadecimal(), restoredData.getHexadecimal());
    }
}
