package com.github.frankkwok.tij4.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * Page 688
 * Exercise 7: Open a text file so that you can read the file one line at a time. Read each line as a String and place
 * that String object into a LinkedList. Print all of the lines in the LinkedList in reverse order.
 * Exercise 8: Modify Exercise 7 so that the name of the file you read is provided as a command-line argument.
 * Exercise 9: Modify Exercise 8 to force all the lines in the LinkedList to uppercase and send the results to
 * System.out.
 * Exercise 10: Modify Exercise 8 to take additional command-line arguments of words to find in the file. Print all
 * lines in which any of the words match.
 * <p>
 * Page 691
 * Exercise 12: Modify Exercise 8 to also open a text file so you can write text into it. Write the lines in the
 * LinkedList, along with line numbers (do not attempt to use the "LineNumber" classes), out to the file.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class ReadFileByLine {
    private static final String OUT_NAME = "ReadFileByLine.out";
    /*package*/ static final String GIT_IGNORE = ".gitignore";

    public static void main(String[] args) {
        UnaryOperator<String> upperCase = String::toUpperCase;
        if (args.length == 0) {
            printReverseOrder(GIT_IGNORE, upperCase);
        } else if (args.length == 1) {
            printReverseOrder(args[0], upperCase);
        } else if (args.length > 2) {
            String filename = args[0];
            Pattern[] patterns = new Pattern[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                patterns[i - 1] = Pattern.compile(args[i]);
            }
            Predicate<String> predicate = s -> {
                boolean result = false;
                for (Pattern p : patterns) {
                    result |= p.matcher(s).matches();
                }
                return result;
            };
            printReverseOrder(filename, predicate);
        }

        // Exercise 12
        List<String> lines = readLines(GIT_IGNORE);
        try (PrintWriter out = new PrintWriter(OUT_NAME)) {
            for (int i = 0; i < lines.size(); i++) {
                out.print(i + 1);
                out.print(": ");
                out.println(lines.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static LinkedList<String> readLines(String filename) {
        LinkedList<String> lines = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filename), "UTF-8")) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void printReverseOrder(String filename) {
        LinkedList<String> lines = readLines(filename);
        ListIterator<String> iterator = lines.listIterator(lines.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    private static void printReverseOrder(String filename, Predicate<String> predicate) {
        LinkedList<String> lines = readLines(filename);
        ListIterator<String> iterator = lines.listIterator(lines.size());
        while (iterator.hasPrevious()) {
            String line = iterator.previous();
            if (predicate.test(line)) {
                System.out.println(line);
            }
        }
    }

    private static void printReverseOrder(String filename, UnaryOperator<String> unaryOperator) {
        LinkedList<String> lines = readLines(filename);
        ListIterator<String> iterator = lines.listIterator(lines.size());
        while (iterator.hasPrevious()) {
            String line = iterator.previous();
            System.out.println(unaryOperator.apply(line));
        }
    }
}
