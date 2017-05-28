package com.github.frankkwok.tij4.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Frank Kwok on 2017/5/28.
 */
public class ResourceUtils {
    private static ClassLoader classLoader;

    static {
        classLoader = ResourceUtils.class.getClassLoader();
    }

    public static List<String> readLines(String resourceName) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(classLoader.getResourceAsStream(resourceName), "UTF-8")) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }
}
