package md.vnastasi.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public final class Console {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Console() {}

    public static int readInt(String message) {
        System.out.print(message + ": ");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int[] readIntArray(String message) {
        System.out.print(message + " (values must be separated by space): ");
        return Arrays.stream(SCANNER.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static String readString(String message) {
        System.out.print(message + ": ");
        return SCANNER.nextLine();
    }

    public static void write(String format, Object... args) {
        System.out.printf(format, args).println();
    }
}
