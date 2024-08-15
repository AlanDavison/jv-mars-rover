package mars_rover.input.helpers;

import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleInput {
    public static String getConsoleInput(String printMessage, String invalidMessage, Scanner scanner, Predicate<String> predicate) {
        String input = "";

        while (!predicate.test(input)) {
            System.out.print(printMessage);
            input = scanner.nextLine();

            if (!predicate.test(input))
                System.out.println(invalidMessage);
        }

        return input;
    }
}
