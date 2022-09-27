package studentmanager.controller;

import java.util.Scanner;

public class ValidationController {
    private final static Scanner sc = new Scanner(System.in);

    //check user input number limit
    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + "," + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInteger() {
        int id;
        while (true) {
            String value = checkInputString();
            if (checkIntegerNumber(value)) {
                id = Integer.parseInt(value);
                return id;
            } else {
                System.out.println("Input must be an integer!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIntegerNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //check user input yes/no
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }

            System.err.println("Please input y/Y or n/N");
            System.out.print("Enter again: ");


        }
    }

    //check user input u/D
    public static boolean checkInputUD() {
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }

            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }

            System.err.println("Please input u/D or d/D!");
            System.out.print("Enter again: ");
        }
    }


    //check user input course
    public static String checkInputCourse() {
        while (true) {
            String result = checkInputString();
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")) {
                return result;
            }

            System.err.println("There are only three course: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }


}
