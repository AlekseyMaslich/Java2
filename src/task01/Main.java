package task01;

import java.io.*;
import java.util.Scanner;

/**
 * The {@code Main} class serves as the entry point of the application.
 * It initializes and starts the user interaction via the {@code Dialog} class.
 */
public class Main {

    /**
     * The main method that starts the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.run();
    }
}

/**
 * The {@code Dialog} class handles user interaction via the console.
 * It provides options to input a number, perform calculations,
 * save and restore results, and display the stored data.
 */
class Dialog {

    /** The name of the file used for saving and restoring serialized data. */
    private static final String FILE_NAME = "data.ser";

    /** Scanner object for reading user input. Marked as transient to avoid serialization. */
    private final transient Scanner scanner = new Scanner(System.in);

    /**
     * Starts the interactive console dialog, allowing the user to
     * perform various operations on numerical data.
     */
    public void run() {
        Calculator calculator = null;
        boolean running = true;

        while (running) {
            System.out.println("Виберіть опцію: \n1. Задати число \n2. Порахувати результат \n3. Зберегти результати \n4. Показати збережене \n5. Завершити роботу");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Введіть число у десятичній системі: ");
                    int number = scanner.nextInt();
                    CalculationData data = new CalculationData(number);
                    calculator = new Calculator(data);
                    break;
                case 2:
                    if (calculator == null) {
                        System.out.println("Задайте число перед обчисленням результату");
                        break;
                    }
                    calculator.calculate();
                    System.out.println("Результати обчислень:");
                    calculator.showData();
                    break;
                case 3:
                    try {
                        if (calculator == null) {
                            System.out.println("Задайте число перед сериалізацією");
                            break;
                        }
                        calculator.save();
                        System.out.println("Об'єкт серіалізовано у файл: " + FILE_NAME);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    if (calculator == null) {
                        System.out.println("Задайте число перед відновленням");
                        break;
                    }
                    try {
                        calculator.restore();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println("Відновлений об'єкт:");
                    calculator.showData();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Вибрано неіснуючу опцію.");
                    break;
            }
        }
    }
}
