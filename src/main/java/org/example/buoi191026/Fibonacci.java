package org.example.buoi191026;

public class Fibonacci {

    public static void main(String[] args) {
        int count = 20;
        long a = 0;
        long b = 1;

        System.out.println("20 số Fibonacci đầu tiên:");
        for (int i = 1; i <= count; i++) {
            System.out.print(a + (i < count ? ", " : "\n"));
            long next = a + b;
            a = b;
            b = next;
        }
    }
}
