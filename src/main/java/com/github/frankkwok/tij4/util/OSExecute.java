package com.github.frankkwok.tij4.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OSExecute {
    public static List<String> command(String command) {
        List<String> result = new ArrayList<>();
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            try (BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                String s;
                while ((s = results.readLine()) != null) {
                    result.add(s);
                }
                while ((s = errors.readLine()) != null) {
                    System.err.println(s);
                    err = true;
                }
            }
        } catch (Exception e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
        }
        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }
        return result;
    }
}
