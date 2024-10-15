package Hw2_22000081_NguyenTienDat.Exercise_3;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Tạo bộ bài 52 lá
        Card[] deck = Card.createDeck();

        // Sắp xếp bộ bài bằng Comparator
        Arrays.sort(deck, Card.compareCards);
        System.out.println("Deck sorted using Comparator:");
        for (Card card : deck) {
            System.out.println(card);
        }

        // Sắp xếp bộ bài bằng Comparable
        Arrays.sort(deck); // sử dụng compareTo của Card
        System.out.println("\nDeck sorted using Comparable:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}

