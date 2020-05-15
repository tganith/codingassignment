package com.codeassignment.problem1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SpellNumber {

    static String one[] = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ",
            "ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ",
            "nineteen "
    };

    static String ten[] = {"", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "
    };


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please enter number: ");
            int n = scanner.nextInt();
            String words = convertToWords(n);
            System.out.printf(words);
        } catch (InputMismatchException ex) {
            System.out.println("please enter valid data");
        }
    }

    static String convertToWords(int n) {

        if(n<0){
            throw new InputMismatchException("please enter valid data");
        }

        StringBuffer output = new StringBuffer();

        output.append (numToWords((int) (n / 10000000), "crore "));
        output.append (numToWords((int) ((n / 100000) % 100), "lakh "));
        output.append (numToWords((int) ((n / 1000) % 100), "thousand "));
        output.append (numToWords((int) ((n / 100) % 10), "hundred "));

        if (n > 100 && n % 100 > 0) {
            output.append ("and ");
        }
        output.append(numToWords((int) (n % 100), ""));
        return output.toString();
    }

    static String numToWords(int n, String s) {
        StringBuffer str = new StringBuffer();

        if (n > 19) {
            str.append( ten[n / 10] + one[n % 10]);
        } else {
            str.append(one[n]);
        }

        if (n != 0) {
            str.append(s);
        }
        return str.toString();
    }
}
