package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ISBN: ");
        String isbn = scanner.nextLine();


        if (isbn.length() != 10) {
            System.out.println("Số ISBN phải có 10 chữ số.");
            return;
        }


        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("Số ISBN không hợp lệ.");
                return;
            }
            int digit = Character.getNumericValue(c);
            stack.push(digit);
            sum += (i + 1) * digit;
        }


        if (sum % 11 == 0) {
            System.out.println("Số ISBN hợp lệ.");
        } else {
            System.out.println("Số ISBN không hợp lệ.");
        }
    }
}
