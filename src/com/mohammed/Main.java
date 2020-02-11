package com.mohammed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
	    File file = new File("C:\\Users\\Mohammed\\Development\\DATA3");
        Scanner scanner = new Scanner(file);
        int numberOfStudent = scanner.nextInt();
        String[] names = new String[numberOfStudent];
        double[] heights =  new double[numberOfStudent];
        for (int i = 0; i < numberOfStudent; i++) {
            String name = scanner.next();
            double height = scanner.nextDouble();
            String unit = scanner.next();
            if (unit.equals("m"))
                unit = "xxx";
            switch (unit.charAt(0)) {
                case 'c':
                    height = height / 100;
                    break;

                case 'd':
                    height = height / 10;
                    break;
                case 'm':
                    height = height / 1000;
                    break;
                default:
                    break;
            }
            names[i] = name;
            heights[i] = height;
        }
        int top = 0;

        if (numberOfStudent < 5) {
            top = numberOfStudent;
        } else {
            top = 5;
        }

        Object[] objects = sort(heights, names);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Mohammed\\Development\\OUT3");
        PrintStream ps = new PrintStream(fos);
        for (int i = names.length-1; i >= names.length - top; i--) {
            String[] n = (String[])objects[1];
            ps.println(n[i]);
        }

    }

    public static Object[] sort(double[] heights, String[] names) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] > heights[i]) {
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                    double temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                }
            }
        }
        Object[] objects = {heights, names};
        return objects;
    }

}
