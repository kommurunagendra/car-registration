package com.kommuru.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The class is used to to read input/output files
 *
 * @author Nagendra Kommuru
 */
public class FileHelper {
    public static List<String> getRegNumber(String input) throws IOException {
        BufferedReader bufferedReader = null;
        String[] numbers = null;
        List<String> regNumbers = new ArrayList<String>();
        try {
            File inputFile = getFile(input);
            bufferedReader = new BufferedReader(new FileReader(inputFile.getAbsolutePath()));
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                String regExp = "(^[A-Z]{2}[0-9]{2}([A-Z]{3}|\\s[A-Z]{3})$)";
                numbers = strLine.split(" ");
                for (String number : numbers) {
                    if (Pattern.matches(regExp, number)) {
                        regNumbers.add(number);
                    }
                }

            }

        } catch (Exception exception) {
            exception.getStackTrace();
        } finally {
            bufferedReader.close();
        }
        return regNumbers;
    }

    public static Map<String, List<String>> expectedRecords(String name) throws IOException {
        BufferedReader bufferedReader = null;
        String outLine = " ";
        List<String> expectedList = new ArrayList<String>();
        Map<String, List<String>> expectedResults = new HashMap<String, List<String>>();
        try {
            File inputFile = getFile(name);
            bufferedReader = new BufferedReader(new FileReader(inputFile.getAbsolutePath()));
            while ((outLine = bufferedReader.readLine()) != null) {
                expectedList.add(outLine);
            }
            //This will removed first record(header values)
            expectedList.remove(0);

            for (String expectedRecord : expectedList) {
                String[] exp = expectedRecord.split(",");
                List<String> record = Arrays.asList(exp);
                expectedResults.put(record.get(0), record);
            }

        } catch (Exception exception) {
            exception.getStackTrace();
        } finally {
            bufferedReader.close();
        }

        return expectedResults;
    }

    private static File getFile(String filepath) {
        ClassLoader classLoader = FileHelper.class.getClassLoader();
        return new File(classLoader.getResource(filepath).getFile());
    }
}

