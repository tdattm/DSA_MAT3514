package Hw3_22000081_NguyenTienDat.Ex1;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class testFraction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phân số: ");
        int n = scanner.nextInt();

        List<Fraction> fractions = generateRandomFractions(n);
        printFractionAtPosition(fractions);
        System.out.println("totalFractions is " + totalFractions(fractions).toString());
        System.out.println("differrenceFractions is " + differrenceFractions(fractions).toString());
        System.out.println("productFractions is " + productFractions(fractions).toString());
        System.out.println("quotientFractions is " + quotientFractions(fractions).toString());
        System.out.println("averageFractions is " + averageFractions(fractions).toString());

        scanner.close();
    }

    private static List<Fraction> generateRandomFractions(int n) {
        Random random = new Random();
        List<Fraction> fractions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            float numerator = random.nextInt(10) + 1; // Tử số ngẫu nhiên từ 1 đến 10
            float denominator = random.nextInt(9) + 1; // Mẫu số ngẫu nhiên từ 1 đến 9 (không có mẫu số 0)
            fractions.add(new Fraction(numerator, denominator));
        }
        return fractions;
    }

    private static void printFractionAtPosition(List<Fraction> fractions) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vị trí cần in (1 đến " + fractions.size() + "): ");
        int v = scanner.nextInt();
        if (v > 0 && v <= fractions.size()) {
            System.out.println("Phân số ở vị trí thứ " + v + " là: " + fractions.get(v - 1));
        } else {
            System.out.println("Vị trí không hợp lệ.");
        }
    }

    private static Fraction totalFractions(List<Fraction> fractions) {
        Fraction totalFraction = new Fraction(0,1);
        for (Fraction f : fractions) {
            totalFraction = totalFraction.add(f);
        }
        return totalFraction;
    }

    private static Fraction differrenceFractions(List<Fraction> fractions) {
        Fraction differrenceFractions = new Fraction(0,1);
        for (Fraction f : fractions) {
            differrenceFractions = differrenceFractions.minus(f);
        }
        return differrenceFractions;
    }

    private static Fraction productFractions(List<Fraction> fractions) {
        Fraction productFractions = new Fraction(1,1);
        for (Fraction f : fractions) {
            productFractions = productFractions.multi(f);
        }
        return productFractions;
    }

    private static Fraction quotientFractions(List<Fraction> fractions) {
        Fraction quotientFractions = new Fraction(1,1);
        for (Fraction f : fractions) {
            quotientFractions = quotientFractions.divi(f);
        }
        return quotientFractions;
    }


    private static Fraction averageFractions(List<Fraction> fractions) {
        Fraction averageFractions = totalFractions(fractions);
        averageFractions = averageFractions.divi(new Fraction(fractions.size(), 1));
        return averageFractions;
    }


}
